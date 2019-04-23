package com.example.khxcx.controller;

import com.example.khxcx.pojo.User;
import com.example.khxcx.pojo.UserIfo;
import com.example.khxcx.pojo.quvo.UserQueryVo;
import com.example.khxcx.service.UserIfoService;
import com.example.khxcx.service.UserService;
import com.example.khxcx.utils.SzpJsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: SualLabel
 * @Date: 2019-03-12 20:12
 * @Description: SualLabel, Write down some description!!!
 */
@Api(value = "UserIfoController")
@RestController
public class UserIfoController {
    @Autowired
    private UserIfoService userIfoService;
    @Autowired
    private UserService userService;
    @GetMapping("/updateUserIfoByOpenId.action")
    public SzpJsonResult updateUserIfoByOpenId(
            String openId,
            UserIfo userIfo, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        //通过openId找到User
        List<User> userByOpenId = userService.findUserByOpenId(openId);
        //得到userID
        Long id = userByOpenId.get(0).getId();
        //通过userId找到UserIfo
        List<UserIfo> userIfoByUserId = userIfoService.findUserIfoByUserId(id);
        //获得userIfo的主键
        UserIfo userIfo1 = userIfoByUserId.get(0);
        //给传来的参数设置userId
        userIfo.setId(userIfo1.getId());
        userIfo.setUserId(id);
        //通过主键更新userIfo
        userIfoService.updateUserIfoById(userIfo);
        return SzpJsonResult.ok();
    }

//    //增加
//    @ApiOperation("增加useifo")
//    @PostMapping("/insertUserIfo.action")
//    public SzpJsonResult insertUserIfo(UserIfo userIfo, HttpServletResponse response){
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        userIfoService.insertUserIfo(userIfo);
//        return SzpJsonResult.ok();
//    }ok

    @DeleteMapping("/deleteUserIfoById.action")
    public SzpJsonResult deleteUserIfoById(long id, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        userIfoService.deleteUserIfoById(id);
        return SzpJsonResult.ok();
    }
     @PutMapping("/updateUserIfoById.action")
    public SzpJsonResult updateUserIfoById(UserIfo userIfo, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        userIfoService.updateUserIfoById(userIfo);
        return SzpJsonResult.ok();
    }
    @GetMapping("/findUserIfoById.action")
    public SzpJsonResult findUserIfoById(long id, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        UserIfo userIfoById = userIfoService.findUserIfoById(id);
        return SzpJsonResult.ok(userIfoById);
    }
    @GetMapping("/findUserIfoByUserId.action")
    public SzpJsonResult findUserIfoByUserId(long userId, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        List<UserIfo> userIfoByUserId = userIfoService.findUserIfoByUserId(userId);
        return SzpJsonResult.ok(userIfoByUserId);
    }
    @GetMapping("/findUserIfoByGivenName.action")
    public SzpJsonResult findUserIfoByGivenName(String giveName, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        List<UserIfo> userIfoByGivenName = userIfoService.findUserIfoByGivenName(giveName);
        return SzpJsonResult.ok(userIfoByGivenName);
    }
     @GetMapping("/findUserIfoByString.action")
    public SzpJsonResult findUserIfoByString(String string, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        List<UserIfo> byZiDuan = userIfoService.findByZiDuan(string);
        System.out.println(byZiDuan.size());
        ArrayList<UserQueryVo> arrayList=new ArrayList();
        if (byZiDuan!=null&&byZiDuan.size()!=0) {
            for (int i = 0; i < byZiDuan.size(); i++) {
                UserIfo userIfo = byZiDuan.get(i);
                User user = userService.findUserById(userIfo.getUserId());
                UserQueryVo userQueryVo = new UserQueryVo();
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
                arrayList.add(userQueryVo);
            }
        }
        return SzpJsonResult.ok(arrayList);
    }
}
