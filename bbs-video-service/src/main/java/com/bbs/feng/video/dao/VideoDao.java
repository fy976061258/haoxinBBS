package com.bbs.feng.video.dao;

import com.bbs.feng.coom.dao.BbsDao;
import com.bbs.feng.video.entity.VideoEntity;
import org.springframework.stereotype.Component;

/**
 * @author Marco.Feng
 * @title: haoxinBBS
 * @description:
 * @date 2018/02/10 13:57
 * @since JDK 1.8
 */
@Component
public interface VideoDao extends BbsDao<VideoEntity,Long> {

}
