package com.feng.pay.controller;



import javax.servlet.http.HttpServletRequest;


import com.feng.pay.entity.PayForm;
import com.feng.pay.service.PaypalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Marco.Feng
 * @title: haoxinBBS
 * @description:
 * @date 2018/03/28 11:24
 * @since JDK 1.8
 */
@Controller
@RequestMapping(path = "/")
public class PaymentController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private PaypalService paypalService;

    @GetMapping()
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    @PostMapping(path = "/pay")
    public ModelAndView pay(@Validated @ModelAttribute PayForm payFrom,HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        try {
            Payment payment = paypalService.createPayment(request,payFrom);
            for(Links links : payment.getLinks()){
                if(links.getRel().equals("approval_url")){
                    mv.setViewName("redirect:"+links.getHref());
                    return mv;
                }
            }
        } catch (PayPalRESTException e) {
            log.error(e.getMessage());
        }
        mv.setViewName("redirect:/");
        return mv;
    }

    @GetMapping(path = "/pay/cancel")
    public ModelAndView cancelPay(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("cancel");
        return mv;
    }

    @GetMapping(path = "/pay/success")
    public ModelAndView successPay(@RequestParam("paymentId") String paymentId,
                                   @RequestParam("PayerID") String payerId){
        ModelAndView mv = new ModelAndView();
        try {
            Payment payment = paypalService.executePayment(paymentId, payerId);
            if(payment.getState().equals("approved")){
                mv.setViewName("success");
                return mv;
            }
        } catch (PayPalRESTException e) {
            log.error(e.getMessage());
        }
        mv.setViewName("redirect:/");
        return mv;
    }
}
