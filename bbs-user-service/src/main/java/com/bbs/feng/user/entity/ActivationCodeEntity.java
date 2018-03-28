package com.bbs.feng.user.entity;

import com.bbs.feng.coom.entity.EntityModel;
import lombok.Data;
import org.mongodb.morphia.annotations.Entity;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Marco.Feng
 * @title: haoxinBBS
 * @description:
 * @date 2018/03/19 17:19
 * @since JDK 1.8
 */
@Data
@Entity("ActivationCode")
@Document(collection = "ActivationCode")
@EnableMongoAuditing
public class ActivationCodeEntity extends EntityModel {

    private String number;

    //激活此注册码的Ip地址

    private String theActivationIp;

    //是否使用

    private Boolean is_use;

    //是否售出

    private Boolean is_sell;

}
