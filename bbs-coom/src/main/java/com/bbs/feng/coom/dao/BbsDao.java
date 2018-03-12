package com.bbs.feng.coom.dao;


import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;


/**
 * @author Marco.Feng
 * @title: haoxinBBS
 * @description: 标识Dao层 所有Dao层继承此接口
 * @date 2018/02/10 13:45
 * @since JDK 1.8
 */

public class BbsDao<T,K extends Serializable> extends BasicDAO<T,K> {
    @Autowired
    public BbsDao(Datastore datastore) {
        super(datastore);
    }

}