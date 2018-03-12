package com.bbs.feng.video.service;

import com.bbs.feng.coom.service.BbsService;
import com.bbs.feng.video.entity.VideoEntity;

import java.util.List;

/**
 * @author Marco.Feng
 * @title: haoxinBBS
 * @description:
 * @date 2018/03/12 09:18
 * @since JDK 1.8
 */
public interface VideoService extends BbsService{

    List<VideoEntity> findAllVideo();

}
