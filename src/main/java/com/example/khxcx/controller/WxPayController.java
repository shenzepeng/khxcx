package com.example.khxcx.controller;

import com.example.khxcx.pojo.InvestmentStatement;
import com.example.khxcx.pojo.MakeSurePayIdOk;
import com.example.khxcx.pojo.User;
import com.example.khxcx.pojo.UserIfo;
import com.example.khxcx.service.*;
import com.example.khxcx.utils.ExpiryMap;
import com.example.khxcx.utils.KeyUtil;
import com.example.khxcx.utils.SzpJsonResult;
import com.lly835.bestpay.model.PayResponse;
import io.swagger.annotations.ApiOperation;
import jdk.nashorn.internal.ir.RuntimeNode;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;

/**
 * @Auther: SualLabel
 * @Date: 2019-03-16 20:53
 * @Description: SualLabel, Write down some description!!!
 */
@RestController
@Slf4j
public class WxPayController {
    @Autowired
    private PayService payService;
    @Autowired
    private UserService userService;
    @Autowired
    private MakeSurePayIdOkService makeSurePayIdOkService;
    @Autowired
    private UserIfoService userIfoService;
    @Autowired
    private InvestmentStatementService investmentStatementService;
    private ExpiryMap<String,Double> expiryMap=new ExpiryMap<String,Double>();

    /**
     * default expiry time 30 second
     */
    private final long EXPIRY = 1000 * 30;
    /**
     * 微信支付
     */

    @PostMapping("/create.action")
    public SzpJsonResult create(
           @RequestParam("openId") String openId,
           @RequestParam("money") double money,
           @RequestParam("beSellId") String beSellId,
           @RequestParam("shengyugoumailaing")String shengyugoumailaing,
           @RequestParam("purchaseVolume") double purchaseVolume,
                   //购入价格
           @RequestParam("purchasePrice")  double purchasePrice
    ){



       //订单id
       String orderId= KeyUtil.genUniqueKey();
       //创建支付
       PayResponse payResponse = payService.create(openId, money, orderId);
       //System.out.println(payResponse);
       expiryMap.put(openId,money,EXPIRY);

       //创建微信支付记录
        MakeSurePayIdOk makeSurePayIdOk=new MakeSurePayIdOk();
        makeSurePayIdOk.setOpendId(openId);
        makeSurePayIdOk.setCreateTime(System.currentTimeMillis()+"");
        //1.未支付成功或待支付，0支付成功
        makeSurePayIdOk.setStatus(1);
        makeSurePayIdOk.setOrderId(orderId);
        //付款多少
        makeSurePayIdOk.setBlankSpaceOne(money+"");
        makeSurePayIdOkService.insertMakeSurePayIdOk(makeSurePayIdOk);
        log.debug("发起支付是的信息",makeSurePayIdOk);
        HashMap<String,Object> hashMap=new HashMap<>();
        hashMap.put("orderId",orderId);
        hashMap.put("payResponse",payResponse);
        log.info("payStatus",hashMap);

        //更新user表中的money信息，同过beSellId（openid）找到user表中money，将原本的钱取出来在加上新的钱，并赋值
        List<User> userByOpenId = userService.findUserByOpenId(beSellId);
        User user = userByOpenId.get(0);
        Double money1 = user.getMoney();
        user.setMoney(money1+money);
        //通过主键更新不为null的字段
        userService.updateUserById(user);

        //同过userId找到userIfo,更改剩余购买量，原有的值减去穿过来的剩余购买量
        List<UserIfo> userIfoByUserId = userIfoService.findUserIfoByUserId(user.getId());
        UserIfo userIfo = userIfoByUserId.get(0);
        Double shengyugoumailaing1 = userIfo.getShengyugoumailaing();
        double value = Double.valueOf(shengyugoumailaing.toString());
        System.out.println(shengyugoumailaing1);
        System.out.println(shengyugoumailaing);
        userIfo.setShengyugoumailaing(value);
        userIfoService.updateUserIfoById(userIfo);


        //添加投资记录，通过买的人的openId找到user，通过被买的openId找到user，
        User u1=userService.findUserByOpenId(openId).get(0);

        User u2=userService.findUserByOpenId(beSellId).get(0);
        InvestmentStatement investmentStatement=new InvestmentStatement();
        investmentStatement.setBuyerId(u1.getId());
        investmentStatement.setSellerId(u2.getId());
        investmentStatement.setPurchasePrice(purchasePrice);
        investmentStatement.setPurchaseVolume(purchaseVolume);
        investmentStatementService.insertInvestmentStatement(investmentStatement);
        return SzpJsonResult.ok(hashMap);
   }
    /**
     * 微信异步通知
     *
     */
    @PostMapping("/notify")
    public SzpJsonResult remind(String notifyData){
        String notifyDataString=notifyData.split(",")[0];
        String openId=notifyData.split(",")[1];
        String orderId=notifyData.split(",")[2];
        PayResponse notify = payService.notify(notifyDataString,openId,orderId);
        System.out.println(notify);
        /**
         * 更新钱包
         */
        List<User> userByOpenId = userService.findUserByOpenId(openId);
        User user = userByOpenId.get(0);
        userService.updateUserMoney(user.getId(),expiryMap.get(openId));
        /**
         * 更新微信支付表
         */
        //通过orderid 订单id找到支付记录
        MakeSurePayIdOk makeSurePayIdOkByOrderId = makeSurePayIdOkService.findMakeSurePayIdOkByOrderId(orderId);
        //1.未支付成功或待支付，0支付成功
        makeSurePayIdOkByOrderId.setStatus(0);
        makeSurePayIdOkService.updataMakeSurePayIdOkById(makeSurePayIdOkByOrderId);
        Map<String,Object> map=new HashMap<>();
        map.put("notify",notify);
        map.put("orderId",orderId);
        log.debug("异步回调的信息",map.toString());
        return SzpJsonResult.ok(notify);
    }
    @ApiOperation(" 验证付款是否成功（通过订单id看）---//1.未支付成功或待支付，0支付成功")
    @GetMapping("/makeSurePayIdOk.action")
    public SzpJsonResult makeSurePayIdOk(String orderId){
        MakeSurePayIdOk makeSurePayIdOkByOrderId = makeSurePayIdOkService.findMakeSurePayIdOkByOrderId(orderId);
        return SzpJsonResult.ok(makeSurePayIdOkByOrderId);
    }


}
