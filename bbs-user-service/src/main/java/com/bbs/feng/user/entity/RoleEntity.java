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
 * @date 2018/03/19 13:25
 * @since JDK 1.8
 */
@Data
@Entity("Role")
@Document(collection = "Role")
@EnableMongoAuditing
public class RoleEntity extends EntityModel {

    private Integer code;

    private String name;

    private String detail;

    private String videoNumber;

    private List<UserEntity> users;

    private List<PermissionEntity> permissions;
}
