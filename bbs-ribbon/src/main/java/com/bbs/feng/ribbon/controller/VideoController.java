package com.bbs.feng.ribbon.controller;

import com.bbs.feng.coom.result.ResultModel;
import com.bbs.feng.ribbon.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping(path = "/find/all",method = RequestMethod.GET)
    public ResultModel findAllVideo(@RequestParam Integer page,
                                    @RequestParam Integer limit){
        ResultModel resultModel =  videoService.findAllVideo(page,limit);
        return resultModel;
    }
}
