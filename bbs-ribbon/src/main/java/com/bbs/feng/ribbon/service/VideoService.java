package com.bbs.feng.ribbon.service;

import com.bbs.feng.coom.result.ResultModel;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Marco.Feng
 * @title: haoxinBBS
 * @description:
 * @date 2018/03/12 09:10
 * @since JDK 1.8
 */
@Service
public class VideoService {
    @Autowired
    private RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "testServiceFallback")
    public ResultModel findAllVideo(Integer page,Integer limit) {
        return restTemplate.getForEntity("http://bbs-video-server/video/find/all/video?page="+page+"&limit="+limit,
                ResultModel.class).getBody();
    }

    /**
     *    hystrix fallback方法
     *
     * @author Marce.Feng
     * @date 2018/02/04 18:59
     * @throws
     * @param null
     * @return
     */
    public String testServiceFallback(Integer page,Integer limit) {
        return "服务器发生异常";
    }


}
