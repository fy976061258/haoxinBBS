package com.bbs.feng.ribbon.service;

import com.bbs.feng.coom.result.ResultModel;
import com.bbs.feng.user.entity.UserEntity;
import com.bbs.feng.video.entity.VideoEntity;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Marco.Feng
 * @title: haoxinBBS
 * @description:
 * @date 2018/03/19 15:57
 * @since JDK 1.8
 */
@Service
public class UserService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "saveUserFallback")
    public Object saveUser(UserEntity userEntity) {
        Object body = restTemplate.postForEntity("http://bbs-user-server/user/save",userEntity,
                Object.class).getBody();
        return body;
    }

    public Object saveUserFallback(VideoEntity videoEntity) {
        return ResultModel.error();
    }
}
