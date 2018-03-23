package com.bbs.feng.user.service;

import com.bbs.feng.coom.service.BbsService;
import com.bbs.feng.user.entity.UserEntity;
import org.springframework.data.domain.Page;


/**
 * @author Marco.Feng
 * @title: haoxinBBS
 * @description:
 * @date 2018/03/19 15:32
 * @since JDK 1.8
 */
public interface UserService extends BbsService {
    /**
     *    保存用户信息
     *
     * @author Marce.Feng
     * @date 2018/03/19 15:34
     * @throws
     * @param userEntity 用户信息
     * @return
     */
    UserEntity saveUser(UserEntity userEntity);

    /**
     *    查询所有用户
     *
     * @author Marce.Feng
     * @date 2018/03/19 15:35
     * @throws
     * @param page 当前页
     * @param size 每页条数
     * @return
     */
    Page<UserEntity> findAllUser(Integer page, Integer size);

    /**
     *    根据账号查询用户
     *
     * @author Marce.Feng
     * @date 2018/03/19 15:35
     * @throws
     * @param Account 账号
     * @return
     */
    UserEntity findOneUserByAccount(String account);


    /**
     *    判断用户明是否重复
     *
     * @author Marce.Feng
     * @date 2018/03/21 16:08
     * @throws
     * @param null
     * @return
     */
    Boolean isUserExist(UserEntity userEntity);

    /**
     *    判断用户信息是否完整
     *
     * @author Marce.Feng
     * @date 2018/03/23 10:04
     * @throws
     * @param userEntity 用户
     * @return
     */
    String is_user(UserEntity userEntity);
}
