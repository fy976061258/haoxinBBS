package com.bbs.feng.user.service.impl;

import com.bbs.feng.user.dao.UserDao;
import com.bbs.feng.user.entity.UserEntity;
import com.bbs.feng.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * @author Marco.Feng
 * @title: haoxinBBS
 * @description:
 * @date 2018/03/19 15:36
 * @since JDK 1.8
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public UserEntity saveUser(UserEntity userEntity) {
        UserEntity user = userDao.save(userEntity);
        return user;
    }

    @Override
    public Page<UserEntity> findAllUser(Integer page, Integer size) {
        PageRequest pageRequest = new PageRequest(page,size);
        Page<UserEntity> users = userDao.findAll(pageRequest);
        return users;
    }

    @Override
    public UserEntity findOneUserByAccount(String account) {
        UserEntity user = userDao.findUserEntityByAccount(account);
        return user;
    }
}