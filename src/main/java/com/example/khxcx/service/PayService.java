package com.example.khxcx.service;

import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundResponse;


public interface PayService {

    PayResponse create(String openId,Double money,String orderId);

    PayResponse notify(String notifyData,String openId,String orderId);

    RefundResponse refund(String orderId,Double money);
}
