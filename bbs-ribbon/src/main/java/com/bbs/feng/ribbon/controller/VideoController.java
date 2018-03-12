package com.bbs.feng.ribbon.controller;

import com.bbs.feng.coom.result.ResultModel;
import com.bbs.feng.ribbon.service.VideoService;
import com.bbs.feng.video.entity.VideoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author Marco.Feng
 * @title: haoxinBBS
 * @description:
 * @date 2018/03/12 09:23
 * @since JDK 1.8
 */
@Controller
@RequestMapping("/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @GetMapping(path = "/find/all")
    @ResponseBody
    public Object findAllVideo(@RequestParam Integer page,
                                    @RequestParam Integer limit){
        Object body =  videoService.findAllVideo(page,limit);
        return body;
    }

    @PostMapping(path = "/save")
    @ResponseBody
    public Object saveVideo(@RequestBody VideoEntity videoEntity){
        Object body =  videoService.saveVideo(videoEntity);
        return body;
    }
}
