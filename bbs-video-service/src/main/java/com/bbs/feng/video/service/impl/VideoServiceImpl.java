package com.bbs.feng.video.service.impl;

import com.bbs.feng.video.dao.VideoDao;
import com.bbs.feng.video.entity.VideoEntity;
import com.bbs.feng.video.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
    public Page<VideoEntity> findAllVideo(Integer page,Integer size) {
        PageRequest pageRequest = new PageRequest(page,size);
        Page<VideoEntity> videos = videoDao.findAll(pageRequest);
        return videos;
    }

    @Override
    public VideoEntity saveVideo(VideoEntity videoEntity) {
        VideoEntity video =  videoDao.save(videoEntity);
        return video;
    }

    @Override
    public void uploadVideo(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }
}
