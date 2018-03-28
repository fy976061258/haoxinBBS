package com.feng.pay;

import com.bbs.feng.coom.result.ResultModel;
import com.bbs.feng.coom.util.URLUtils;
import com.feng.pay.config.PaypalPaymentIntent;
import com.feng.pay.config.PaypalPaymentMethod;
import com.feng.pay.service.PaypalService;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PayApplicationTests {

	@Autowired
	private PaypalService paypalService;

	private Logger log = LoggerFactory.getLogger(PayApplicationTests.class);

	public static final String PAYPAL_SUCCESS_URL = "pay/success";
	public static final String PAYPAL_CANCEL_URL = "pay/cancel";

	@Test
	public void contextLoads() {
		try {
			Payment payment = paypalService.createPayment(
					500.00,
					"USD",
					PaypalPaymentMethod.paypal,
					PaypalPaymentIntent.sale,
					"payment description",
					PAYPAL_CANCEL_URL,
					PAYPAL_SUCCESS_URL);
			for(Links links : payment.getLinks()){
				if(links.getRel().equals("approval_url")){
				}
			}
		} catch (PayPalRESTException e) {
			log.error(e.getMessage());
		}
	}

}
