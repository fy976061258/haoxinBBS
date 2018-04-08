package com.feng.pay.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.bbs.feng.coom.util.URLUtils;
import com.feng.pay.entity.PayForm;
import com.feng.pay.service.PaypalService;
import org.springframework.beans.factory.annotation.Autowired;
import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentExecution;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Marco.Feng
 * @title: haoxinBBS
 * @description:
 * @date 2018/03/28 11:25
 * @since JDK 1.8
 */
@Service
public class PaypalServiceImpl implements PaypalService {
    @Autowired
    private APIContext apiContext;

    @Override
    public Payment createPayment(HttpServletRequest request,PayForm payFrom) throws PayPalRESTException{
        Amount amount = new Amount();
        amount.setCurrency(payFrom.getCurrency());
        amount.setTotal(String.format("%.2f", payFrom.getTotal()));

        Transaction transaction = new Transaction();
        transaction.setDescription(payFrom.getDescription());
        transaction.setAmount(amount);

        List<Transaction> transactions = new ArrayList<>();
        transactions.add(transaction);

        Payer payer = new Payer();
        payer.setPaymentMethod(payFrom.getMethod().toString());

        Payment payment = new Payment();
        payment.setIntent(payFrom.getIntent().toString());
        payment.setPayer(payer);
        payment.setTransactions(transactions);
        RedirectUrls redirectUrls = new RedirectUrls();
        String url = URLUtils.getBaseURl(request) + "/";
        redirectUrls.setCancelUrl(url + payFrom.getCancelUrl());
        redirectUrls.setReturnUrl(url + payFrom.getSuccessUrl());
        payment.setRedirectUrls(redirectUrls);
        return payment.create(apiContext);
    }

    @Override
    public Payment executePayment(String paymentId, String payerId) throws PayPalRESTException{
        Payment payment = new Payment();
        payment.setId(paymentId);
        PaymentExecution paymentExecute = new PaymentExecution();
        paymentExecute.setPayerId(payerId);
        return payment.execute(apiContext, paymentExecute);
    }
}
