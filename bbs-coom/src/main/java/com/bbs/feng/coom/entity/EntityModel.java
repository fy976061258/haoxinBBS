package com.bbs.feng.coom.entity;


import lombok.Data;
import org.mongodb.morphia.annotations.Id;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Marco.Feng
 * @title: haoxinBBS
 * @description: 实体类基类
 * @date 2018/02/10 19:57
 * @since JDK 1.8
 */

@Data
public class EntityModel implements Serializable {

    @Id
    private Long id;

    private Date creatDate = new Date();

    private Date updateDate = new Date();

}
