package com.feng.zuul.config.redis;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Marco.Feng
 * @title: haoxinBBS
 * @description:
 * @date 2018/03/28 09:27
 * @since JDK 1.8
 */
@Data
@Component
@ConfigurationProperties(prefix = "spring.redis")
public class RedisConn {

    private String host;

    //prefix+参数名  对应于配置文件config.properties中的spring.redis.*信息

    private int port;

    private int timeout;
}
