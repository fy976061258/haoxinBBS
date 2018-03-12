package com.bbs.feng.video.controller;

import com.bbs.feng.coom.result.ResultModel;
import com.bbs.feng.video.dao.VideoDao;
import com.bbs.feng.video.entity.VideoEntity;
import com.bbs.feng.video.service.VideoService;
import org.mongodb.morphia.query.QueryResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Marco.Feng
 * @title: haoxinBBS
 * @description:
 * @date 2018/02/10 20:34
 * @since JDK 1.8
 */
@RestController
@RequestMapping (value = "/video")
public class VideoController {
    @Autowired
    private VideoService videoService;

    /**
      *    获取所有视频
      *
      * @author Marce.Feng
      * @date 2018/02/10 20:57
      * @throws
      * @param null
      * @return
      */
    @GetMapping(path = "/find/all/video")
    public ResultModel findAllVideo(@RequestParam Integer page,
                                    @RequestParam Integer limit){
        List<VideoEntity> videoEntities = videoService.findAllVideo();
        return ResultModel.ok(videoEntities,Long.valueOf(videoEntities.size()));
    }

}
