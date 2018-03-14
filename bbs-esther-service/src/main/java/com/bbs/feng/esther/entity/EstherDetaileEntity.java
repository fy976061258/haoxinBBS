package com.bbs.feng.esther.entity;

import lombok.Data;
import org.apache.catalina.LifecycleState;
import org.mongodb.morphia.annotations.Entity;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 *
 *  详情
 *
 * @author Marco.Feng
 * @title: haoxinBBS
 * @description:
 * @date 2018/03/12 15:48
 * @since JDK 1.8
 */
@Data
@Entity("EstherDetaile")
@Document(collection = "EstherDetaile")
@EnableMongoAuditing
public class EstherDetaileEntity {

    private String detail;

    private String url;

    private String password;

    private List<EstherImgEntity> estherImgEntities;

    private List<EstherCommentsEntity> estherCommentsEntities;

}
