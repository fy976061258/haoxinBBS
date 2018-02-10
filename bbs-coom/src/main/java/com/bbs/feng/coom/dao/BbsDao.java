package com.bbs.feng.coom.dao;

import com.bbs.feng.coom.entity.ApiEntity;

import java.io.Serializable;

/**
 * @author Marco.Feng
 * @title: haoxinBBS
 * @description: 标识Dao层 所有Dao层继承此接口
 * @param PK 实体主键
 * @param E 实体类
 * @date 2018/02/10 13:45
 * @since JDK 1.8
 */
public interface BbsDao<PK extends Serializable ,  E extends ApiEntity<PK>>  {
}
