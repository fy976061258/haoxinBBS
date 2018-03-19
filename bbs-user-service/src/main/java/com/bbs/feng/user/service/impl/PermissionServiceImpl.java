package com.bbs.feng.user.service.impl;

import com.bbs.feng.user.dao.PermissionDao;
import com.bbs.feng.user.entity.PermissionEntity;
import com.bbs.feng.user.service.PermissionService;
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
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionDao permissionDao;

    @Override
    public PermissionEntity savePermission(PermissionEntity permissionEntity) {
        PermissionEntity permissionEntity1 = permissionDao.save(permissionEntity);
        return permissionEntity1;
    }
}
