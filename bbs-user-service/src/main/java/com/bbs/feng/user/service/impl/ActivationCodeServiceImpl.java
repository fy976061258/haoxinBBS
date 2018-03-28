package com.bbs.feng.user.service.impl;

import com.bbs.feng.coom.util.MD5Util;
import com.bbs.feng.user.dao.ActivationCodeDao;
import com.bbs.feng.user.entity.ActivationCodeEntity;
import com.bbs.feng.user.service.ActivationCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Marco.Feng
 * @title: haoxinBBS
 * @description:
 * @date 2018/03/19 17:22
 * @since JDK 1.8
 */
@Service
public class ActivationCodeServiceImpl implements ActivationCodeService {

    @Autowired
    private ActivationCodeDao activationCodeDao;


    @Override
    public List<ActivationCodeEntity> generateActivationCode(Integer size) {
        List<ActivationCodeEntity> activationCodeEntities = new ArrayList<>();
        for (int j = 0; j < size ; j++){
            ActivationCodeEntity activationCodeEntity = new ActivationCodeEntity();
            String val = "";
            Random random = new Random();
            //参数length，表示生成几位随机数
            for(int i = 0 ; i < 66 ; i++) {
                String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
                //输出字母还是数字
                if( "char".equalsIgnoreCase(charOrNum) ) {
                    //输出是大写字母还是小写字母
                    int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                    val += (char)(random.nextInt(26) + temp);
                } else if( "num".equalsIgnoreCase(charOrNum) ) {
                    val += String.valueOf(random.nextInt(10));
                }
            }
            String md5Val = MD5Util.encode(val);
            activationCodeEntity.setNumber(md5Val);
            activationCodeEntity.setIs_use(false);
            activationCodeEntity.setIs_sell(false);
            ActivationCodeEntity activationCode = activationCodeDao.save(activationCodeEntity);
            activationCode.setNumber(val);
            activationCodeEntities.add(activationCode);
        }
        return activationCodeEntities;
    }

    @Override
    public Page<ActivationCodeEntity> findAllActivationCode(Integer page, Integer size) {
        PageRequest pageRequest = new PageRequest(page,size);
        Page<ActivationCodeEntity> ActivationCodes = activationCodeDao.findAll(pageRequest);
        return ActivationCodes;
    }

    @Override
    public Integer is_true(String activationCode) {
        String val = MD5Util.encode(activationCode);
        ActivationCodeEntity activationCodeEntity =
                activationCodeDao.findActivationCodeEntityByNumber(val);
        if (activationCodeEntity != null){
            //判断是否使用
            if (activationCodeEntity.getIs_use()){
                return 1;
            }
            return 0;
        }
        return null;
    }

    @Override
    public Page<ActivationCodeEntity> findUnsoldActivationCode(Boolean is_sell,Boolean is_use,Integer page, Integer size) {
        PageRequest pageRequest = new PageRequest(page,size);
        Page<ActivationCodeEntity> activationCode = activationCodeDao.findAvailable(is_sell,is_use,pageRequest);
        return activationCode;
    }
}
