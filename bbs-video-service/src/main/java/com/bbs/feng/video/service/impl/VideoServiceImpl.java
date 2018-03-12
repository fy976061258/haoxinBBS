package com.bbs.feng.video.service.impl;

import com.bbs.feng.video.dao.VideoDao;
import com.bbs.feng.video.entity.VideoEntity;
import com.bbs.feng.video.service.VideoService;
import com.netflix.discovery.converters.Auto;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.QueryResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;


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
        QueryResults<VideoEntity> videoEntity = videoDao.find();
        List<VideoEntity>  videoEntities = videoEntity.asList();
        return videoEntities;
    }

    @Override
    public Key<VideoEntity> saveVideo(VideoEntity videoEntity) {
        Key<VideoEntity> key =  videoDao.save(videoEntity);
        return key;
    }

    @Override
    public void uploadVideo(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }
}
