package com.bbs.feng.esther;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.bbs.feng.esther")
@EnableDiscoveryClient
@EnableFeignClients
public class EstherApplication {
	public static void main(String[] args) {
		SpringApplication.run(EstherApplication.class, args);
	}
}
