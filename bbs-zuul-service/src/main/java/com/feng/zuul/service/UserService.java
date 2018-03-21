package com.feng.zuul.service;

import com.bbs.feng.user.entity.UserEntity;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Marco.Feng
 * @title: haoxinBBS
 * @description:
 * @date 2018/03/21 15:17
 * @since JDK 1.8
 */
@FeignClient(value = "bbs-user-server")
public interface UserService {

    /**
      *    根据账号查询当前用户
      *
      * @author Marce.Feng
      * @date 2018/03/21 15:27
      * @throws
      * @param null
      * @return
      */
    @RequestMapping(value = "/user/find/one",method = RequestMethod.GET)
    UserEntity findOneUserByAccount(@RequestParam(value = "accountNumber") String accountNumber);
}
