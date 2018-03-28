package com.feng.pay.service;

import com.bbs.feng.coom.service.BbsService;
import com.feng.pay.config.PaypalPaymentIntent;
import com.feng.pay.config.PaypalPaymentMethod;
import com.feng.pay.entity.PayForm;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Marco.Feng
 * @title: haoxinBBS
 * @description:
 * @date 2018/03/28 11:24
 * @since JDK 1.8
 */
public interface PaypalService extends BbsService {

    /**
     *    创建订单
     *
     * @author Marce.Feng
     * @date 2018/03/28 11:30
     * @throws
     * @param total  金额
     * @param currency  货币
     * @param method  支付方式
     * @param intent  付款意图
     * @param description  描述
     * @param cancelUrl  取消支付Url
     * @param successUrl  支付成功Url
     * @return
     */
    Payment createPayment(HttpServletRequest request, PayForm payFrom) throws PayPalRESTException;


    /**
     *    执行付款
     *
     * @author Marce.Feng
     * @date 2018/03/28 11:31
     * @throws
     * @param null
     * @return
     */
    Payment executePayment(String paymentId, String payerId) throws PayPalRESTException;
}
