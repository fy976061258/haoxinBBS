package com.feng.pay.controller;



import javax.servlet.http.HttpServletRequest;

import com.bbs.feng.coom.util.URLUtils;
import com.feng.pay.config.PaypalPaymentIntent;
import com.feng.pay.config.PaypalPaymentMethod;
import com.feng.pay.service.PaypalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
@RequestMapping("/")
public class PaymentController {

    public static final String PAYPAL_SUCCESS_URL = "pay/success";
    public static final String PAYPAL_CANCEL_URL = "pay/cancel";

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private PaypalService paypalService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("templates/index.html");
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST, value = "pay")
    public ModelAndView pay(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        String cancelUrl = URLUtils.getBaseURl(request) + "/" + PAYPAL_CANCEL_URL;
        String successUrl = URLUtils.getBaseURl(request) + "/" + PAYPAL_SUCCESS_URL;
        try {
            Payment payment = paypalService.createPayment(
                    500.00,
                    "USD",
                    PaypalPaymentMethod.paypal,
                    PaypalPaymentIntent.sale,
                    "payment description",
                    cancelUrl,
                    successUrl);
            mv.setViewName("redirect:/");
            for(Links links : payment.getLinks()){
                if(links.getRel().equals("approval_url")){
                    mv.setViewName("redirect:"+links.getHref());
                    return mv;
                }
            }
        } catch (PayPalRESTException e) {
            log.error(e.getMessage());
        }
        return mv;
    }

    @RequestMapping(method = RequestMethod.GET, value = PAYPAL_CANCEL_URL)
    public ModelAndView cancelPay(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("templates/cancel.html");
        return mv;
    }

    @RequestMapping(method = RequestMethod.GET, value = PAYPAL_SUCCESS_URL)
    public ModelAndView successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId){
        ModelAndView mv = new ModelAndView();
        try {
            Payment payment = paypalService.executePayment(paymentId, payerId);
            if(payment.getState().equals("approved")){
                mv.setViewName("templates/success.html");
                return mv;
            }
        } catch (PayPalRESTException e) {
            log.error(e.getMessage());
        }
        mv.setViewName("redirect:/");
        return mv;
    }
}
