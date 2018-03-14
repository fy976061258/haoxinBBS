package com.bbs.feng.esther.controller;

import com.bbs.feng.coom.result.ResultModel;
import com.bbs.feng.esther.entity.EstherEntity;
import com.bbs.feng.esther.service.EstherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author Marco.Feng
 * @title: haoxinBBS
 * @description:
 * @date 2018/03/14 15:13
 * @since JDK 1.8
 */
@Controller
@RequestMapping("/esther")
public class EstherController {

    @Autowired
    private EstherService estherService;

    @PostMapping(path = "/save")
    @ResponseBody
    public ResultModel saveEsther(@RequestBody EstherEntity estherEntity){
        EstherEntity estherEntity1 = estherService.saveEsther(estherEntity);
        return ResultModel.ok(estherEntity1);
    }

}
