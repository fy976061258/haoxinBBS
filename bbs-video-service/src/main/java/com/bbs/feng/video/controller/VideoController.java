package com.bbs.feng.video.controller;

import com.bbs.feng.coom.result.ResultModel;
import com.bbs.feng.video.dao.VideoDao;
import com.bbs.feng.video.entity.VideoEntity;
import com.bbs.feng.video.service.VideoService;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.QueryResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.POST;
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
    @GetMapping(path = "/find/all")
    @ResponseBody
    public ResultModel findAllVideo(@RequestParam Integer page,
                                    @RequestParam Integer size){
        Page<VideoEntity> videoEntities = videoService.findAllVideo(page,size);
        Long count = Long.valueOf(videoEntities.getTotalElements());
        return ResultModel.ok(videoEntities,count);
    }


    /**
     *    保存视频信息
     *
     * @author Marce.Feng
     * @date 2018/03/12 13:40
     * @throws
     * @param null
     * @return
     */
    @PostMapping(path = "/save")
    @ResponseBody
    public ResultModel saveVideo(@RequestBody VideoEntity videoEntity){
        VideoEntity videoEntities = videoService.saveVideo(videoEntity);
        return ResultModel.ok(videoEntities);
    }

}
