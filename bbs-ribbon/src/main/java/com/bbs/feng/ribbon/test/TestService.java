package com.bbs.feng.ribbon.test;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

/**
 * @author Marco.Feng
 * @title: haoxinBBS
 * @description:
 * @date 2018/02/04 18:43
 * @since JDK 1.8
 */
@Service
public class TestService {

    @Autowired
    private RestTemplate restTemplate;
    private static final Logger LOGGER = LoggerFactory.getLogger(TestService.class);


    /**
     *    使用@HystrixCommand注解指定当该方法发生异常时调用的方法
     *
     * @author Marce.Feng
     * @date 2018/02/04 18:59
     * @throws
     * @param null
     * @return
     */
    @HystrixCommand(fallbackMethod = "testServiceFallback")
    public String testService() {
        return restTemplate.getForEntity("http://bbs-user-consumer/test", String.class).getBody();
    }




    /**
     *    hystrix fallback方法
     *
     * @author Marce.Feng
     * @date 2018/02/04 18:59
     * @throws
     * @param null
     * @return
     */
    public String testServiceFallback() {
        TestService.LOGGER.info("异常发生，进入fallback方法，接收的参数：id = {}", "qqq");
        return "出错了";
    }

}
