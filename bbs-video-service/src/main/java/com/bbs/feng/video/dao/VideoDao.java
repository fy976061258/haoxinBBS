package com.bbs.feng.video.dao;

import com.bbs.feng.coom.dao.BbsDao;
import com.bbs.feng.video.entity.VideoEntity;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @author Marco.Feng
 * @title: haoxinBBS
 * @description:
 * @date 2018/02/10 13:57
 * @since JDK 1.8
 */
@Component
public interface VideoDao extends BbsDao<VideoEntity,String> {

}
