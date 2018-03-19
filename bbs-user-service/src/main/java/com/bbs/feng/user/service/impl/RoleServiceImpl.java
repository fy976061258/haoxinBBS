package com.bbs.feng.user.service.impl;

import com.bbs.feng.user.dao.RoleDao;
import com.bbs.feng.user.entity.RoleEntity;
import com.bbs.feng.user.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Marco.Feng
 * @title: haoxinBBS
 * @description:
 * @date 2018/03/19 16:19
 * @since JDK 1.8
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;
    @Override
    public RoleEntity saveRole(RoleEntity roleEntity) {
        RoleEntity roleEntity1 = roleDao.save(roleEntity);
        return roleEntity1;
    }
}
