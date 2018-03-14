package com.bbs.feng.esther.service.impl;

import com.bbs.feng.esther.dao.EstherDao;
import com.bbs.feng.esther.entity.EstherEntity;
import com.bbs.feng.esther.service.EstherService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Marco.Feng
 * @title: haoxinBBS
 * @description:
 * @date 2018/03/13 09:15
 * @since JDK 1.8
 */
public class EstherServiceImpl implements EstherService {

    @Autowired
    private EstherDao estherDao;

    @Override
    public EstherEntity saveEsther(EstherEntity estherEntity) {
        if (estherEntity !=null){
            return estherDao.save(estherEntity);
        }else {
            return null;
        }
    }

}
