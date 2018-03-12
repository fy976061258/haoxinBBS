package com.bbs.feng.esther.entity;

import lombok.Data;
import org.mongodb.morphia.annotations.Entity;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Marco.Feng
 * @title: haoxinBBS
 * @description:
 * @date 2018/03/12 15:50
 * @since JDK 1.8
 */
@Data
@Entity("EstherImg")
@Document(collection = "EstherImg")
@EnableMongoAuditing
public class EstherImgEntity {
}
