package com.feng.order.entity;

import com.bbs.feng.coom.entity.EntityModel;
import com.bbs.feng.user.entity.ActivationCodeEntity;
import com.bbs.feng.user.entity.UserEntity;
import com.feng.pay.config.PaypalPaymentIntent;
import com.feng.pay.config.PaypalPaymentMethod;
import lombok.Data;
import org.mongodb.morphia.annotations.Entity;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * @author Marco.Feng
 * @title: haoxinBBS
 * @description:
 * @date 2018/03/28 17:52
 * @since JDK 1.8
 */
@Data
@Entity("Order")
@Document(collection = "Order")
@EnableMongoAuditing
public class OrderEntity extends EntityModel {

    private UserEntity user;

    private List<ActivationCodeEntity> activationCodeEntity;

    //付款金额

    private Double total;

    //付款货币

    private String currency;

    //付款方式  credit_card, paypal

    private String method;

    //付款意图 sale, authorize, order

    private String intent = "order";
}
