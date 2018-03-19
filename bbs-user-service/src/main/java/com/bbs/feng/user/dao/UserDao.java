package com.bbs.feng.user.dao;

import com.bbs.feng.coom.dao.BbsDao;
import com.bbs.feng.user.entity.UserEntity;

/**
 * @author Marco.Feng
 * @title: haoxinBBS
 * @description:
 * @date 2018/03/19 15:38
 * @since JDK 1.8
 */
public interface UserDao extends BbsDao<UserEntity,Long> {

    UserEntity findUserEntityByAccount(String account);

}
