package com.example.khxcx.controller;

import com.aliyuncs.exceptions.ClientException;
import com.example.khxcx.pojo.DiscountRecord;
import com.example.khxcx.pojo.ShenQingTiXian;
import com.example.khxcx.pojo.User;
import com.example.khxcx.pojo.UserIfo;
import com.example.khxcx.service.DiscountRecordService;
import com.example.khxcx.service.ShenQingTiXianService;
import com.example.khxcx.service.UserIfoService;
import com.example.khxcx.service.UserService;
import com.example.khxcx.utils.AliyunSmsRemindUtils;
import com.example.khxcx.utils.SzpJsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Auther: SualLabel
 * @Date: 2019-03-12 20:11
 * @Description: SualLabel, Write down some description!!!
 */

@RestController
@Api(value = "DiscountRecordController")
public class DiscountRecordController {
    @Value("${remindPhoneNumber}")
    private String remindPhoneNumber;
    @Autowired
    private DiscountRecordService discountRecordService;
    @Autowired
    private UserIfoService userIfoService;
    @Autowired
    private UserService userService;
    @Autowired
    private ShenQingTiXianService shenQingTiXianService;

    @PostMapping("/insertDiscountRecord.action")
    public SzpJsonResult insertDiscountRecord(String openId, HttpServletResponse response) throws ClientException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        List<User> userByOpenId = userService.findUserByOpenId(openId);
        User user = userByOpenId.get(0);
        //userId,
        long userId=user.getId();

        double money=user.getMoney();

        String time=System.currentTimeMillis()+"";
        DiscountRecord discountRecord=new DiscountRecord();
        discountRecord.setTime(time);
        discountRecord.setOpenId(openId);
        discountRecord.setMoney(money);
        discountRecord.setUserId(userId);
        discountRecordService.insertDiscountRecord(discountRecord);
        //添加数据
        ShenQingTiXian shenQingTiXian=new ShenQingTiXian();
        shenQingTiXian.setMoney(user.getMoney());
        shenQingTiXian.setOpenId(openId);
        //通过user主键 在userIfo中找phonenumber
        List<UserIfo> userIfoByUserId = userIfoService.findUserIfoByUserId(userId);
        if (userIfoByUserId.size()!=0&&userIfoByUserId!=null){
            shenQingTiXian.setPhoneNumber(userIfoByUserId.get(0).getPhoneNumber());
        }
        System.out.println(shenQingTiXian);
        shenQingTiXian.setStatus("");
        shenQingTiXianService.insertShenQingTiXian(shenQingTiXian);
        AliyunSmsRemindUtils.sendSms(remindPhoneNumber,"SQTX");
        return SzpJsonResult.ok();
    }

    @DeleteMapping("/deleteDiscountRecordById.action")
    public SzpJsonResult deleteDiscountRecordById(long id, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        discountRecordService.deleteDiscountRecordById(id);
        return SzpJsonResult.ok();
    }

    @PutMapping("/updateDiscountRecordById.action")
    public SzpJsonResult updateDiscountRecordById(DiscountRecord discountRecord, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        discountRecordService.updateDiscountRecordById(discountRecord);
        return SzpJsonResult.ok();
    }
)
    @GetMapping("/findDiscountRecordById.action")
    public SzpJsonResult findDiscountRecordById(long id, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        DiscountRecord discountRecordById = discountRecordService.findDiscountRecordById(id);
        return SzpJsonResult.ok(discountRecordById);
    }

    @GetMapping("/findDiscountRecordByUserId.action")
    public SzpJsonResult findDiscountRecordByUserId(long userId, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        List<DiscountRecord> discountRecordByUserId = discountRecordService.findDiscountRecordByUserId(userId);
        return SzpJsonResult.ok(discountRecordByUserId);
    }
}
