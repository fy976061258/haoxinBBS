package com.bbs.feng.esther.service;

import com.bbs.feng.coom.service.BbsService;
import com.bbs.feng.esther.entity.EstherEntity;

/**
 * @author Marco.Feng
 * @title: haoxinBBS
 * @description:
 * @date 2018/03/13 09:15
 * @since JDK 1.8
 */
public interface EstherService extends BbsService {
    /**
     *    保存帖子
     *
     * @author Marce.Feng
     * @date 2018/03/13 14:37
     * @throws
     * @param estherEntity
     * @return
     */
    EstherEntity saveEsther(EstherEntity estherEntity);
}
