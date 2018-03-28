package com.bbs.feng.user.dao;

import com.bbs.feng.coom.dao.BbsDao;
import com.bbs.feng.user.entity.ActivationCodeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * @author Marco.Feng
 * @title: haoxinBBS
 * @description:
 * @date 2018/03/19 17:22
 * @since JDK 1.8
 */
public interface ActivationCodeDao extends BbsDao<ActivationCodeEntity,String> {

    ActivationCodeEntity findActivationCodeEntityByNumber(String activationCode);

    @Query("{'is_sell':?0 , 'is_use':?1}")
    Page<ActivationCodeEntity> findAvailable(Boolean is_sell, Boolean is_use , Pageable pageable);

}
