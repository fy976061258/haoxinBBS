package com.bbs.feng.ribbon.service;

import com.bbs.feng.coom.result.ResultModel;
import com.bbs.feng.video.entity.VideoEntity;
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


    @HystrixCommand(fallbackMethod = "findAllVideoFallback")
    public Object findAllVideo(Integer page,Integer limit) {
        Object body = restTemplate.getForEntity("http://bbs-video-server/video/find/all?page="+page+"&limit="+limit,
                ResultModel.class).getBody();
        return body;
    }

    @HystrixCommand(fallbackMethod = "saveVideoFallback")
    public Object saveVideo(VideoEntity videoEntity) {
        Object body = restTemplate.postForEntity("http://bbs-video-server/video/save",videoEntity,
                Object.class).getBody();
        return body;
    }

    /**
     *    hystrix fallback方法
     *
     * @author Marce.Feng
     * @date 2018/03/12 12:59
     * @throws
     * @param null
     * @return
     */
    public Object findAllVideoFallback(Integer page,Integer limit) {
        return ResultModel.error();
    }

    public Object saveVideoFallback(VideoEntity videoEntity) {
        return ResultModel.error();
    }


}
