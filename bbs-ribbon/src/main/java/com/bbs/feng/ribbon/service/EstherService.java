package com.bbs.feng.ribbon.service;

import com.bbs.feng.coom.result.ResultModel;
import com.bbs.feng.esther.entity.EstherEntity;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Marco.Feng
 * @title: haoxinBBS
 * @description:
 * @date 2018/03/14 15:12
 * @since JDK 1.8
 */
@Service
public class EstherService {
    @Autowired
    private RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "saveEstherFallback")
    public Object saveEsther(EstherEntity estherEntity) {
        Object body = restTemplate.postForEntity(
                "http://bbs-esther-server/esther/save",
                estherEntity,
                Object.class).getBody();
        return body;
    }

    public Object saveEstherFallback(EstherEntity estherEntity) {
        return ResultModel.error();
    }

}
