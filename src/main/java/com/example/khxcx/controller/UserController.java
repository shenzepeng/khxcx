package com.example.khxcx.controller;

import com.aliyuncs.exceptions.ClientException;
import com.example.khxcx.pojo.DiscountRecord;
import com.example.khxcx.pojo.User;
import com.example.khxcx.pojo.UserIfo;
import com.example.khxcx.pojo.quvo.MobileNumber;
import com.example.khxcx.pojo.quvo.UserQueryVo;
import com.example.khxcx.service.DiscountRecordService;
import com.example.khxcx.service.UserIfoService;
import com.example.khxcx.service.UserQueryVoService;
import com.example.khxcx.service.UserService;
import com.example.khxcx.utils.*;
import com.lly835.bestpay.rest.type.Get;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Auther: SualLabel
 * @Date: 2019-03-12 20:11
 * @Description: SualLabel, Write down some description!!!
 */
@Api(value = "UserController")
@RestController
@Slf4j
public class UserController {
    @Autowired
    private DiscountRecordService discountRecordService;
    @Autowired
    private UserIfoService userIfoService;
    @Autowired
    private UserService userService;

    @Autowired
    private UserQueryVoService userQueryVoService;

    private ConcurrentHashMap<Long,Double> concurrentHashMap=new ConcurrentHashMap<>();

   // private  ExpiryMap<String, String> expiryMap=new ExpiryMap<String, String>();
    private HashMap<String,String> map=new HashMap<>();
    /**
     * default expiry time 10m
     */
    private final long EXPIRY = 1000 * 60 * 10;
    @GetMapping("/verifyByMobileNumber.action")
    public SzpJsonResult verifyByMobileNumber(HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        String openId = request.getParameter("openId");
        String phoneNumber = request.getParameter("phoneNumber");
        String code = request.getParameter("code");
        ArrayList<String> arrayList=new ArrayList<>();
        arrayList.add(openId);
        arrayList.add(phoneNumber);
        arrayList.add(code);
        log.debug("status",arrayList);
        //看map中是否有该值，没有该值，表示输入错误
        String s = map.get(phoneNumber);
        if (s.equals(code)){
            List<User> userByOpenId;
            try {
                userByOpenId = userService.findUserByOpenId(openId);
                if (userByOpenId!=null&&userByOpenId.size()!=0){
                    //通过openid找到，user
                    User userById = userService.findUserById(userByOpenId.get(0).getId());
                    log.debug("短信校验",userById);
                    //通过userId找到，userIfo
                    List<UserIfo> userIfoByUserId = userIfoService.findUserIfoByUserId(userById.getId());
                    //通过userIfo的主键更新userIfo
                    UserIfo userIfo = userIfoByUserId.get(0);
                    userIfo.setShengyugoumailaing((double)100);
                    userIfo.setPhoneNumber(phoneNumber);
                    userIfo.setType("");
                    log.debug("",map);
                    userIfoService.updateUserIfoById(userIfo);
                    map.put(phoneNumber,null);
                    return SzpJsonResult.ok(1);
                }
            }catch (Exception e){
                return SzpJsonResult.ok("");
            }

            return SzpJsonResult.ok(0);
        }
        return SzpJsonResult.ok(0);
    }
    @GetMapping("/getSmsNumber.action")
    public SzpJsonResult getSmsNumber(String phoneNumber, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        if (map.get(phoneNumber)==null){
            try {
                int numcode;  //每次调用生成一位四位数的随机数
                while (true){
                    numcode= (int)(Math.random()*9999)+100;
                    if (numcode>1000){
                        break;
                    }
                }
                String code = Integer.toString(numcode);
                AliyunSmsUtils.sendSms(phoneNumber,code);
                map.put(phoneNumber,code);
                log.debug("",map);
                return SzpJsonResult.ok("");
            } catch (ClientException e) {
                return SzpJsonResult.errorMap(e);
            }

        }else {
            return SzpJsonResult.ok(",");
        }

    }
   @PostMapping("/insertUser.action")
    public SzpJsonResult insertUser(User user, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        userService.insertUser(user);
        return SzpJsonResult.ok();
    }
    @DeleteMapping("/deleteUserById.action")
    public SzpJsonResult deleteUserById(long id, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        userService.deleteUserById(id);
        return SzpJsonResult.ok();
    }
   @PutMapping("/updateUserById.action")
    public SzpJsonResult updateUserById(User user, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        userService.updateUserById(user);
        return SzpJsonResult.ok();
    }

    @PutMapping("/discreaseMoney.action")
    public SzpJsonResult updateUserMoney(long id,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        User userById = userService.findUserById(id);
        if (userById.getMoney()!=null&&userById.getMoney()!=0){
            return SzpJsonResult.errorMsg("");
        }else {
            userService.updateUserMoney(id, 0);

            DiscountRecord discountRecord=new DiscountRecord();
            String openId = userById.getOpenId();
            String time=System.currentTimeMillis()+"";
            //id是userid，openid是微信唯一标识，time是生成时间
            discountRecord.setUserId(id);
            discountRecord.setOpenId(openId);
            discountRecord.setTime(time);
            discountRecordService.insertDiscountRecord(discountRecord);
            return SzpJsonResult.ok();
        }
    }


    @GetMapping("/findUserById.action")
    public SzpJsonResult findUserById(long id, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        User userById = userService.findUserById(id);
        return SzpJsonResult.ok(userById);
    }

    @GetMapping("/findUserByNickName.action")
    public SzpJsonResult findUserByNickName(String nickname, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        List<User> userByNickName = userService.findUserByNickName(nickname);
        return SzpJsonResult.ok(userByNickName);
    }

    @GetMapping("/findAllUser.action")
    public SzpJsonResult findAllUser(HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        List<UserQueryVo> userAllQueryVo = userQueryVoService.findUserAllQueryVo();
        //        List<User> allUser = userService.findAllUser();
//        List<UserIfo> allUserIfo = userIfoService.findAllUserIfo();
//        System.out.println(allUser);
//        System.out.println(allUserIfo);
//        ArrayList<UserQueryVo> arrayList=new ArrayList();
//        for (int i=0;i<allUser.size();i++) {
//            User user=allUser.get(i);
//            UserIfo userIfo = allUserIfo.get(i);
//            if (user.getId().equals(userIfo.getUserId())) {
//                UserQueryVo userQueryVo=new UserQueryVo(user.getId(),
//                user.getUninId(),user.getOpenId(),user.getNickName(),user.getImgUrl(),
//                user.getMoney(),userIfo.getId(),userIfo.getType(),userIfo.getGivenName(),
//                        userIfo.getAge(),userIfo.getAge(),userIfo.getIntroduce(),userIfo.getPriece(),
//                userIfo.getLastPriece(),userIfo.getShengyugoumailaing(),userIfo.getPhoneNumber());
//                arrayList.add(userQueryVo);
//            }
//        }
//        ArrayList<UserQueryVo> returnUserQueryVo=new ArrayList<>();
//        for (UserQueryVo u:arrayList
//             ) {
//            if (u.getPhoneNumber().equals("")||u.getPhoneNumber()==null){
//
//            }else {
//                returnUserQueryVo.add(u);
//            }
//        }
        List<UserQueryVo> list=new ArrayList<>();
        for (UserQueryVo u:userAllQueryVo
             ) {
            if (u.getType()!=null) {
                list.add(u);
            }
        }

        for (UserQueryVo u:userAllQueryVo
        ) {
            long userId = u.getUserId();
            User userById = userService.findUserById(userId);
            if (userById.getBlankSpaceOne()!=null){
                userById.getBlankSpaceOne().equals("水军");
                list.add(u);
            }

        }
        return SzpJsonResult.ok(list);
    }

    @GetMapping("/findUserByOpenId.action")
    public SzpJsonResult findUserByOpenId(String openId,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        List<User> userByOpenId = userService.findUserByOpenId(openId);
        User user = userByOpenId.get(0);
        Long id = user.getId();
        List<UserIfo> userIfoByUserId = userIfoService.findUserIfoByUserId(id);
        UserIfo userIfo = userIfoByUserId.get(0);
        System.out.println(userIfo.toString());
        //包装类
        UserQueryVo userQueryVo=new UserQueryVo();
        userQueryVo.setId(userIfo.getId());
        userQueryVo.setAge(userIfo.getAge());
        userQueryVo.setSex(userIfo.getSex());
        userQueryVo.setGivenName(userIfo.getGivenName());
        userQueryVo.setImgUrl(userIfo.getIntroduce());
        userQueryVo.setIntroduce(userIfo.getIntroduce());
        userQueryVo.setMoney(user.getMoney());
        userQueryVo.setUninId(user.getUninId());
        userQueryVo.setOpenId(user.getOpenId());
        userQueryVo.setNickName(user.getNickName());
        userQueryVo.setPhoneNumber(userIfo.getPhoneNumber());
        userQueryVo.setType(userIfo.getType());
        userQueryVo.setImgUrl(user.getImgUrl());
        userQueryVo.setLastPriece(userIfo.getLastPriece());
        userQueryVo.setPriece(userIfo.getPriece());
        userQueryVo.setShengyugoumailaing(userIfo.getShengyugoumailaing());
        log.info("userQueryVo",userIfo);
        System.out.println(userQueryVo.toString());
        return SzpJsonResult.ok(userQueryVo);

    }
    @GetMapping("/updateUserByOpenId.action")
    public SzpJsonResult updateUserByOpenId(User user, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        //取到openID
        String openId=user.getOpenId();
        //通过opendId找到User
        List<User> userByOpenId = userService.findUserByOpenId(openId);
        //找到user表中的主键
        Long id = userByOpenId.get(0).getId();
        double money = userByOpenId.get(0).getMoney();
        //设置传过来的user 主键id为id
        user.setId(id);
        user.setMoney(money);
        //通过主键更新user
        userService.updateUserById(user);
        return SzpJsonResult.ok();
    }
}
