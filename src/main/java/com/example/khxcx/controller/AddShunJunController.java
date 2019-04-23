package com.example.khxcx.controller;

import com.example.khxcx.pojo.User;
import com.example.khxcx.pojo.UserIfo;
import com.example.khxcx.pojo.quvo.UserQueryVo;
import com.example.khxcx.service.UserIfoService;
import com.example.khxcx.service.UserQueryVoService;
import com.example.khxcx.service.UserService;
import com.example.khxcx.utils.SzpJsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class AddShunJunController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserIfoService userIfoService;
    @Autowired
    private UserQueryVoService queryVoService;

    @PostMapping("/insertShuiJun.action")
    public SzpJsonResult insertShuiJun(@RequestBody ShunJunQuVo shunJunQuVo){
        User user=new User();
        user.setNickName(shunJunQuVo.getNickName());
        user.setImgUrl(shunJunQuVo.getImgUrl());
        user.setMoney(shunJunQuVo.getMoney());
        user.setBlankSpaceOne("");
        //写死openId，没有openId无法查询
       // user.setOpenId("ogUmH5AbHhTMKMCOou6YVhWx2a0w");
        String createUserTime=System.currentTimeMillis()+"";
        user.setBlankSpaceTwo(createUserTime);
        userService.insertUser(user);
       //通过创建时间找到user
        User userByCreateTime = userService.findUserByCreateTime(createUserTime);
        //user的主键id
        Long id = userByCreateTime.getId();
        //冗余字段
        UserIfo userIfo=new UserIfo();
        userIfo.setShengyugoumailaing(shunJunQuVo.getShengyugoumailaing());
        userIfo.setPhoneNumber(shunJunQuVo.getPhoneNumber());
        userIfo.setIntroduce(shunJunQuVo.getIntroduce());
        userIfo.setUserId(id);
        userIfo.setSex(shunJunQuVo.getSex());
        userIfo.setGivenName(shunJunQuVo.getGivenName());
        userIfo.setAge(shunJunQuVo.getAge());
        userIfo.setPriece(shunJunQuVo.getPriece());
        userIfoService.insertUserIfo(userIfo);
        return SzpJsonResult.ok();
    }

    @DeleteMapping("/deleteShunJunById.action")
    public SzpJsonResult deleteShunJunById(long id){
        userService.deleteUserById(id);
        List<UserIfo> userIfoByUserId = userIfoService.findUserIfoByUserId(id);
        userIfoService.deleteUserIfoById(userIfoByUserId.get(0).getId());
        return SzpJsonResult.ok();
    }

    @GetMapping("/findAllShunJun.action")
    public SzpJsonResult findAllShunJun(){
        List<UserQueryVo> userAllQueryVo = queryVoService.findUserAllQueryVo();
        List<UserQueryVo> list=new ArrayList<>();
        for (UserQueryVo u:userAllQueryVo){
            long userId = u.getUserId();
            User userById = userService.findUserById(userId);
            if (userById.getBlankSpaceOne()!=null) {
                if (userById.getBlankSpaceOne().equals("")) {
                    list.add(u);
                }
            }
        }
        return SzpJsonResult.ok(list);
    }
}
