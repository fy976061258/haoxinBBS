package com.bbs.feng.user.test;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Marco.Feng
 * @title: haoxinBBS
 * @description:
 * @date 2018/02/04 18:19
 * @since JDK 1.8
 */
@FeignClient(value = "bbs-user-server")
public interface TestService {

    @RequestMapping("/test")
    String test();
}
