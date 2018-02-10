package com.bbs.feng.video.entity;

import com.bbs.feng.coom.entity.EntityModel;
import lombok.Data;
import org.mongodb.morphia.annotations.Entity;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Marco.Feng
 * @title: haoxinBBS
 * @description:
 * @date 2018/02/10 19:52
 * @since JDK 1.8
 */
@Data
@Entity("employees")
@Document(collection = "Video")
@EnableMongoAuditing
public class VideoEntity extends EntityModel {

private String url;

private String size;

private String name;

}
