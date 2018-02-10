package com.bbs.feng.coom.entity;

import java.io.Serializable;

/**
 * @author Marco.Feng
 * @title: haoxinBBS
 * @description:
 * @date 2018/02/10 15:10
 * @param PK 实体主键
 * @since JDK 1.8
 */
public interface ApiEntity<Pk extends Serializable> extends Entity{

    /**
     * @return 实体的主键。
     */
    Pk getId();
}
