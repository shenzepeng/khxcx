package com.example.khxcx.service;

import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundRequest;
import com.lly835.bestpay.model.RefundResponse;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import com.lly835.bestpay.utils.JsonUtil;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Slf4j
public class PayServiceImpl implements PayService {

    private static final String ORDER_NAME = "订单";

    @Autowired
    private BestPayServiceImpl bestPayService;

    @Autowired
    private UserService userService;
    /**
     *
     * @param openId 小程序唯一id
     * @param money  钱
     * @param orderId  订单号唯一id
     * @return
     */
    @Transactional
    @Override
    public PayResponse create(String openId,Double money,String orderId) {
        PayRequest payRequest = new PayRequest();
        //获取支付的openid
        payRequest.setOpenid(openId);
        //获取支付的付款金额
        payRequest.setOrderAmount(money.doubleValue());
        //获取支付的订单id
        payRequest.setOrderId(orderId+"");
        payRequest.setOrderName(ORDER_NAME);
        payRequest.setPayTypeEnum(BestPayTypeEnum.WXPAY_H5);
        log.info("【微信支付】发起支付, request={}", JsonUtil.toJson(payRequest));

        PayResponse payResponse = bestPayService.pay(payRequest);
        log.info("【微信支付】发起支付, response={}", JsonUtil.toJson(payResponse));
        return payResponse;
    }
    @Transactional
    @Override
    public PayResponse notify(String notifyData,String opendId,String orderId) {
        //1. 验证签名
        //2. 支付的状态
        //3. 支付金额
        //4. 支付人(下单人 == 支付人)
        //异步通知
        notifyData=notifyData+","+opendId+","+orderId;
        PayResponse payResponse = bestPayService.asyncNotify(notifyData);
        log.info("【微信支付】异步通知, payResponse={}", JsonUtil.toJson(payResponse));

//        //查询订单
//        OrderDTO orderDTO = orderService.findOne(payResponse.getOrderId());
//
//        //判断订单是否存在
//        if (orderDTO == null) {
//            log.error("【微信支付】异步通知, 订单不存在, orderId={}", payResponse.getOrderId());
//            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
//        }
//
//        //判断金额是否一致(0.10   0.1)
//        if (!MathUtil.equals(payResponse.getOrderAmount(), orderDTO.getOrderAmount().doubleValue())) {
//            log.error("【微信支付】异步通知, 订单金额不一致, orderId={}, 微信通知金额={}, 系统金额={}",
//                    payResponse.getOrderId(),
//                    payResponse.getOrderAmount(),
//                    orderDTO.getOrderAmount());
//            throw new SellException(ResultEnum.WXPAY_NOTIFY_MONEY_VERIFY_ERROR);
//        }

//        //修改订单的支付状态
//        orderService.paid(orderDTO);

        return payResponse;
    }

    /**
     * 退款
     * @param
     */
    @Transactional
    @Override
    public RefundResponse refund(String orderId,Double money) {
        RefundRequest refundRequest = new RefundRequest();
        //获取订单id
        refundRequest.setOrderId(orderId+"");
        //获取退款金额
        refundRequest.setOrderAmount(money.doubleValue());
        refundRequest.setPayTypeEnum(BestPayTypeEnum.WXPAY_H5);
        log.info("【微信退款】request={}", JsonUtil.toJson(refundRequest));

        RefundResponse refundResponse = bestPayService.refund(refundRequest);
        log.info("【微信退款】response={}", JsonUtil.toJson(refundResponse));

        return refundResponse;
    }
}
