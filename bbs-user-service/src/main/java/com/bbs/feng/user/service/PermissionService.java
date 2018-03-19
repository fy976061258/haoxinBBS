package com.bbs.feng.user.service;

import com.bbs.feng.coom.service.BbsService;
import com.bbs.feng.user.entity.PermissionEntity;

/**
 * @author Marco.Feng
 * @title: haoxinBBS
 * @description:
 * @date 2018/03/19 16:17
 * @since JDK 1.8
 */
public interface PermissionService extends BbsService {

    PermissionEntity savePermission(PermissionEntity permissionEntity);
}
