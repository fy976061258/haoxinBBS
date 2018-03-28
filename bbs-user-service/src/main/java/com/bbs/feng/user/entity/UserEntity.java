package com.bbs.feng.user.entity;

import com.bbs.feng.coom.entity.EntityModel;
import lombok.Data;
import org.mongodb.morphia.annotations.Entity;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * @author Marco.Feng
 * @title: haoxinBBS
 * @description:
 * @date 2018/03/19 13:23
 * @since JDK 1.8
 */
@Data
@Entity("User")
@Document(collection = "User")
@EnableMongoAuditing
public class UserEntity extends EntityModel {

    private String name;

    //账号

    private String account;

    //登录Ip

    private String loginIp;

    private String password;

    private String idCard;

    //是否禁用

    private Boolean is_disable;

    private String e_mail;

    private String phoneNumber;

    private String activationCode;

    private RoleEntity roles;


}
