package com.bbs.feng.user.service;

import com.bbs.feng.coom.enums.RoleEnums;
import com.bbs.feng.coom.service.BbsService;
import com.bbs.feng.user.entity.RoleEntity;

import java.util.List;

/**
 * @author Marco.Feng
 * @title: haoxinBBS
 * @description:
 * @date 2018/03/19 16:17
 * @since JDK 1.8
 */
public interface RoleService extends BbsService {
    /**
     *    保存角色信息
     *
     * @author Marce.Feng
     * @date 2018/03/20 13:34
     * @throws
     * @param null
     * @return
     */
    RoleEntity saveRole(RoleEntity roleEntity);

    /**
     *    查询所有角色
     *
     * @author Marce.Feng
     * @date 2018/03/20 13:34
     * @throws
     * @param null
     * @return
     */
    List<RoleEntity> findAll();
}
