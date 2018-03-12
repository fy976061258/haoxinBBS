package com.bbs.feng.video.service.impl;

import com.bbs.feng.video.dao.VideoDao;
import com.bbs.feng.video.entity.VideoEntity;
import com.bbs.feng.video.service.VideoService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Marco.Feng
 * @title: haoxinBBS
 * @description:
 * @date 2018/03/12 09:20
 * @since JDK 1.8
 */
@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    private VideoDao videoDao;

    @Override
    public List<VideoEntity> findAllVideo() {
        List<VideoEntity> videoEntity = videoDao.findAll();
        return videoEntity;
    }
}
