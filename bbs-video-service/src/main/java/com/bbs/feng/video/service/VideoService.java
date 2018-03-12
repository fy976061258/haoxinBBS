package com.bbs.feng.video.service;

import com.bbs.feng.coom.service.BbsService;
import com.bbs.feng.video.entity.VideoEntity;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.QueryResults;

import java.util.List;

/**
 * @author Marco.Feng
 * @title: haoxinBBS
 * @description:
 * @date 2018/03/12 09:18
 * @since JDK 1.8
 */
public interface VideoService extends BbsService{
    /**
     *    查询所有视频
     *
     * @author Marce.Feng
     * @date 2018/03/12 13:37
     * @throws
     * @param null
     * @return
     */
    List<VideoEntity> findAllVideo();


    /**
     *    添加视频
     *
     * @author Marce.Feng
     * @date 2018/03/12 13:37
     * @throws
     * @param null
     * @return
     */

    Key<VideoEntity> saveVideo(VideoEntity videoEntity);
}
