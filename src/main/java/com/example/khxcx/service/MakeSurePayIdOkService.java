package com.example.khxcx.service;

import com.example.khxcx.pojo.MakeSurePayIdOk;

import java.util.List;


//微信支付，通过该service判断是否支付成功
public interface MakeSurePayIdOkService {
    //添加支付
    void insertMakeSurePayIdOk(MakeSurePayIdOk makeSurePayIdOk);
    //通过id找到支付记录
    MakeSurePayIdOk findMakeSurePayIdOkById(long id);
    //通过order找到支付记录
    MakeSurePayIdOk findMakeSurePayIdOkByOrderId(String orderId);
    //通过openId找到支付记录
    List<MakeSurePayIdOk> findMakeMakeSurePayIdOkByOpenId(String openId);
    //通过主键id更新支付记录，更新值不为null的字段
    void updataMakeSurePayIdOkById(MakeSurePayIdOk makeSurePayIdOk);
}
