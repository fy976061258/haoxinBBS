package com.bbs.feng.ribbon.controller;

import com.bbs.feng.esther.entity.EstherEntity;
import com.bbs.feng.ribbon.service.EstherService;
import com.bbs.feng.video.entity.VideoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Marco.Feng
 * @title: haoxinBBS
 * @description:
 * @date 2018/03/14 15:11
 * @since JDK 1.8
 */
@Controller
@RequestMapping("/esther")
public class EstherController {

    @Autowired
    private EstherService estherService;

    @PostMapping(path = "/save")
    @ResponseBody
    public Object saveEsther(@RequestBody EstherEntity estherEntity){
        Object body =  estherService.saveEsther(estherEntity);
        return body;
    }

}
