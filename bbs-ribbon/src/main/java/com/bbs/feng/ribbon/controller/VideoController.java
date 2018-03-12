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
    public ResultModel findAllVideo(@RequestParam Integer page,
                                    @RequestParam Integer limit){
        ResultModel resultModel =  videoService.findAllVideo(page,limit);
        return resultModel;
    }

    @PostMapping(path = "/save")
    @ResponseBody
    public ResultModel saveVideo(@RequestBody VideoEntity videoEntity){
        ResultModel resultModel =  videoService.saveVideo(videoEntity);
        return resultModel;
    }
}
