package com.feng.pay.entity;

import com.feng.pay.config.PaypalPaymentIntent;
import com.feng.pay.config.PaypalPaymentMethod;
import lombok.Data;

/**
 * @author Marco.Feng
 * @title: haoxinBBS
 * @description:
 * @date 2018/03/28 16:46
 * @since JDK 1.8
 */
@Data
public class PayForm {

    public static final String PAYPAL_SUCCESS_URL = "pay/success";
    public static final String PAYPAL_CANCEL_URL = "pay/cancel";


    //付款金额

    private Double total;

    //付款货币

    private String currency;

    //付款方式

    private PaypalPaymentMethod method = PaypalPaymentMethod.paypal;

    //付款意图

    private PaypalPaymentIntent intent = PaypalPaymentIntent.order;

    //付款描述

    private String description;

    //取消付款地址

    private String cancelUrl = PAYPAL_CANCEL_URL;

    //付款成功地址

    private String successUrl = PAYPAL_SUCCESS_URL;
}
