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
     * @param size 生成条数
     * @return
     */
    List<ActivationCodeEntity> generateActivationCode(Integer size);

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
     * @return 0：激活码未使用
     *         1：激活码已使用
     */
    Integer is_true(String activationCode);

    /**
     *    查询未售出的激活码
     *
     * @author Marce.Feng
     * @date 2018/03/26 17:41
     * @throws
     * @param is_sell 是否出售
     * @param is_use 是否使用
     * @param page 页数
     * @param size 显示条数
     * @return
     */
    Page<ActivationCodeEntity> findUnsoldActivationCode(Boolean is_sell,Boolean is_use,Integer page, Integer size);
}
