package com.bbs.feng.esther.entity;

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
 * @date 2018/03/12 15:47
 * @since JDK 1.8
 */
@Data
@Entity("Esther")
@Document(collection = "Esther")
@EnableMongoAuditing
public class EstherEntity extends EntityModel {

    private String title;

    private Long watch;

    private Long praise;

    private EstherDetaileEntity estherDetaileEntity;

    private List<EstherImgEntity> estherImgEntities;


}
