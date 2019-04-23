package com.example.khxcx.controller;

import com.example.khxcx.pojo.InvestmentStatement;
import com.example.khxcx.pojo.PurchaseRecord;
import com.example.khxcx.pojo.User;
import com.example.khxcx.pojo.UserIfo;
import com.example.khxcx.pojo.quvo.InvestmentStatementQueryVo;
import com.example.khxcx.service.InvestmentStatementService;
import com.example.khxcx.service.PurchaseRecordService;
import com.example.khxcx.service.UserIfoService;
import com.example.khxcx.service.UserService;
import com.example.khxcx.utils.SzpJsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: SualLabel
 * @Date: 2019-03-12 20:11
 * @Description: SualLabel, Write down some description!!!
 */

@RestController
@Api(value = "InvestmentStatementController")
public class InvestmentStatementController {
    @Autowired
    private UserIfoService userIfoService;
    @Autowired
    private InvestmentStatementService investmentStatementService;

    @Autowired
    private UserService userService;

    @Autowired
    private PurchaseRecordService purchaseRecordService;


    @GetMapping("/findInvestmentStatementItemById.action")
    public SzpJsonResult findInvestmentStatementItemByOpenIdAnfBuyerId(long id) {
        InvestmentStatement investmentStatementById = investmentStatementService.findInvestmentStatementById(id);
        Long sellerId = investmentStatementById.getSellerId();
        List<UserIfo> userIfoByUserId = userIfoService.findUserIfoByUserId(sellerId);
        UserIfo userIfo = userIfoByUserId.get(0);
        Map<String, Object> map = new HashMap<>();
        map.put("userIfo", userIfo);
        map.put("investmentStatementById", investmentStatementById);
        return SzpJsonResult.ok(map);
    }


    @GetMapping("/openId.action")
    public SzpJsonResult whichOneGuyBuyByMe(String openId, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        List<User> userByOpenId = userService.findUserByOpenId(openId);
        Long id = userByOpenId.get(0).getId();
        List<InvestmentStatement> investmentStatementByBuyerId = investmentStatementService.findInvestmentStatementByBuyerId(id);
        return SzpJsonResult.ok(investmentStatementByBuyerId);
    }

    @PostMapping("/sellInvestmentStatement.action")
    public SzpJsonResult sellInvestmentStatement(
                                                  String buyerId,

                                                  String sellerId,

                                                  double purchaseVolume,

                                                  double purchasePrice,
                                                  HttpServletResponse response) {

        response.setHeader("Access-Control-Allow-Origin", "*");
        //找到userId
        Long setBuyerId = userService.findUserByOpenId(buyerId).get(0).getId();
        //找到sellerId
        Long setSellerId = userService.findUserByOpenId(sellerId).get(0).getId();

        InvestmentStatement investmentStatement = new InvestmentStatement();
        investmentStatement.setBuyerId(setBuyerId);
        investmentStatement.setSellerId(setSellerId);
        investmentStatement.setPurchaseVolume(purchaseVolume);
        investmentStatement.setPurchasePrice(purchasePrice);
        investmentStatementService.insertInvestmentStatement(investmentStatement);

        PurchaseRecord purchaseRecord = new PurchaseRecord();

        purchaseRecord.setBuyingTime(System.currentTimeMillis() + "");
        purchaseRecord.setBuyerId(setBuyerId);
        purchaseRecord.setSellerId(setSellerId);

        purchaseRecord.setPurchasePrice(purchasePrice);

        purchaseRecord.setPurchaseQuantity(purchaseVolume);
        purchaseRecordService.insertPurchaseRecord(purchaseRecord);

        return SzpJsonResult.ok();
    }

    @PostMapping("/buyInvestmentStatement.action")
    public SzpJsonResult buyInvestmentStatement( //买方id;
                                                 String buyerId,
                                                 //被买放id;
                                                 String sellerId,
                                                 //购入量
                                                 double purchaseVolume,
                                                 //购入价格
                                                 double purchasePrice,
                                                 HttpServletResponse response
    ) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        Long setBuyerId = userService.findUserByOpenId(buyerId).get(0).getId();

        Long setSellerId = userService.findUserByOpenId(sellerId).get(0).getId();

        InvestmentStatement investmentStatement = new InvestmentStatement();
        investmentStatement.setBuyerId(setBuyerId);
        investmentStatement.setSellerId(setSellerId);
        investmentStatement.setPurchaseVolume(purchaseVolume);
        investmentStatement.setPurchasePrice(purchasePrice);
        investmentStatementService.insertInvestmentStatement(investmentStatement);

        PurchaseRecord purchaseRecord = new PurchaseRecord();

        purchaseRecord.setBuyingTime(System.currentTimeMillis() + "");
        purchaseRecord.setBuyerId(setBuyerId);
        purchaseRecord.setSellerId(setSellerId);

        purchaseRecord.setPurchasePrice(purchasePrice);

        purchaseRecord.setPurchaseQuantity(purchaseVolume);
        purchaseRecordService.insertPurchaseRecord(purchaseRecord);

        return SzpJsonResult.ok();
    }


    @GetMapping("/getSellerByOpenId.action")
    public SzpJsonResult getSellerByOpenId(String openId, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        List<User> userByOpenId = userService.findUserByOpenId(openId);
        User user = userByOpenId.get(0);
        List<InvestmentStatement> investmentStatementBySellerId =
                investmentStatementService.findInvestmentStatementBySellerId(user.getId());
        return SzpJsonResult.ok(investmentStatementBySellerId);
    }


    @GetMapping("/getBuyerByOpenId.action")
    public SzpJsonResult getBuyerByOpenId(String openId, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        List<User> userByOpenId = userService.findUserByOpenId(openId);
        User user = userByOpenId.get(0);

        List<InvestmentStatement> investmentStatementBySellerId = investmentStatementService.findInvestmentStatementByBuyerId(user.getId());
        for (int i=0;i<investmentStatementBySellerId.size();i++){
            System.out.println(investmentStatementBySellerId.get(i));
        }
        System.out.println(1);
        ArrayList<InvestmentStatementQueryVo> arrayList = new ArrayList();

        for (int i = 0; i < investmentStatementBySellerId.size(); i++) {
            Long sellerId1 = investmentStatementBySellerId.get(i).getSellerId();

            List<UserIfo> userIfoByUserId = userIfoService.findUserIfoByUserId(sellerId1);
            InvestmentStatement  investmentStatement =  investmentStatementBySellerId.get(i);
           // if (userIfoByUserId.get(0).getUserId().equals(investmentStatementBySellerId.get(i).getSellerId())) {
                System.out.println(userByOpenId);
                InvestmentStatementQueryVo investmentStatementQueryVo = new InvestmentStatementQueryVo();

                UserIfo userIfo = userIfoByUserId.get(investmentStatementBySellerId.get(i).getSellerId().intValue());
//                InvestmentStatement investmentStatement = investmentStatementBySellerId.get(i);

//
                long id = investmentStatementBySellerId.get(i).getId();
//                userID
                long userId = sellerId1;
//
                User userById = userService.findUserById(sellerId1);
                String imgUrl=userById.getImgUrl();
//                //用户类型
               String type = userIfo.getType();
//                //真实姓名
               String givenName = userIfo.getGivenName();
//                //年龄
                String age = userIfo.getAge();
//                //性别
                String sex = userIfo.getSex();
                //自我介绍
               String introduce = userIfo.getIntroduce();
//                //价值
                double priece = userIfo.getPriece();
//                //上一次的价值
                double lastPriece = userIfo.getLastPriece();
//                //剩余购买量
                double shengyugoumailaing = userIfo.getShengyugoumailaing();
//                //手机号
                String phoneNumber = userIfo.getPhoneNumber();
//                //主键id
                long investmentStatementId = investmentStatement.getId();

                long buyerId = investmentStatement.getBuyerId();

                long sellerId = investmentStatement.getSellerId();

                double purchaseVolume = investmentStatement.getPurchaseVolume();

                double purchasePrice = investmentStatement.getPurchasePrice();
                String yimaichu="";
                if (investmentStatement.getBlankSpaceOne()!=null){
                    yimaichu=investmentStatement.getBlankSpaceOne();
                }
//
                InvestmentStatementQueryVo investmentStatementQueryVo1 = new InvestmentStatementQueryVo(id, userId, type, givenName, age, sex, introduce, priece, lastPriece, shengyugoumailaing, phoneNumber, investmentStatementId, buyerId, sellerId, purchaseVolume, purchasePrice,imgUrl,yimaichu);

                arrayList.add(investmentStatementQueryVo1);
                //arrayList.add(userIfoByUserId);
            }


        return SzpJsonResult.ok(investmentStatementBySellerId);
    }


    @PostMapping("/insertInvestmentStatement.action")
    public SzpJsonResult insertInvestmentStatement(@RequestParam("sellerOpenId") String sellerOpenId,
                                                   @RequestParam("buyerOpenId") String buyerOpenId,
                                                   @RequestParam("purchaseVolume") double purchaseVolume,
                                                   @RequestParam("purchasePrice") double purchasePrice,
                                                   HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        //通过openId找到user
        List<User> sellerByOpenId = userService.findUserByOpenId(sellerOpenId);
        List<User> buyerByOpenId = userService.findUserByOpenId(buyerOpenId);
        User sellerByOpenIdUser = sellerByOpenId.get(0);
        User buyerByOpenIdUser = buyerByOpenId.get(0);
        InvestmentStatement investmentStatement = new InvestmentStatement();
        investmentStatement.setBuyerId(buyerByOpenIdUser.getId());
        investmentStatement.setSellerId(sellerByOpenIdUser.getId());
        investmentStatement.setPurchasePrice(purchasePrice);
        investmentStatement.setPurchaseVolume(purchaseVolume);
        investmentStatementService.insertInvestmentStatement(investmentStatement);
        return SzpJsonResult.ok();
    }


    @DeleteMapping("/deleteInvestmentStatementById.action")
    public SzpJsonResult deleteInvestmentStatementById(long id, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        investmentStatementService.deleteInvestmentStatementById(id);
        return SzpJsonResult.ok();
    }


    @PutMapping("/updateInvestmentStatementById.action")
    public SzpJsonResult updateInvestmentStatementById(InvestmentStatement investmentStatement, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        investmentStatementService.updateInvestmentStatementById(investmentStatement);
        return SzpJsonResult.ok();
    }


    @GetMapping("/findInvestmentStatementById.action")
    public SzpJsonResult findInvestmentStatementById(long id, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        InvestmentStatement investmentStatementById = investmentStatementService.findInvestmentStatementById(id);
        return SzpJsonResult.ok(investmentStatementById);
    }


    @GetMapping("/findInvestmentStatementByBuyerId.action")
    public SzpJsonResult findInvestmentStatementByBuyerId(long buyId, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        List<InvestmentStatement> investmentStatementByBuyerId = investmentStatementService.findInvestmentStatementByBuyerId(buyId);
        return SzpJsonResult.ok(investmentStatementByBuyerId);
    }


    @GetMapping("/findInvestmentStatementBySellerId.action")
    public SzpJsonResult findInvestmentStatementBySellerId(long sellerId, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        List<InvestmentStatement> investmentStatementBySellerId = investmentStatementService.findInvestmentStatementBySellerId(sellerId);
        return SzpJsonResult.ok(investmentStatementBySellerId);
    }
}
