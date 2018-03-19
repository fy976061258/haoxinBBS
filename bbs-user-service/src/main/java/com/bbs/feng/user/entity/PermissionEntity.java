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
 * @date 2018/03/19 13:26
 * @since JDK 1.8
 */
@Data
@Entity("Permission")
@Document(collection = "Permission")
@EnableMongoAuditing
public class PermissionEntity extends EntityModel{
    private String name;

    private Integer code;

    private String detail;

    private List<RoleEntity> roles;


}
