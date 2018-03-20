package com.bbs.feng.user.service;

import com.bbs.feng.coom.service.BbsService;
import com.bbs.feng.user.entity.ActivationCodeEntity;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author Marco.Feng
 * @title: haoxinBBS
 * @description:
 * @date 2018/03/19 17:20
 * @since JDK 1.8
 */
public interface ActivationCodeService extends BbsService {
    /**
     *    生成激活码
     *
     * @author Marce.Feng
     * @date 2018/03/19 17:22
     * @throws
     * @param null
     * @return
     */
    void generateActivationCode();

    /**
     *    查询所有的激活码
     *
     * @author Marce.Feng
     * @date 2018/03/19 17:29
     * @throws
     * @param null
     * @return
     */
    Page<ActivationCodeEntity> findAllActivationCode(Integer page,Integer size);

    /**
     *    判断激活码是否正确
     *
     * @author Marce.Feng
     * @date 2018/03/20 13:37
     * @throws
     * @param activationCode 激活码
     * @return
     */
    Integer is_true(String activationCode);
}
