package com.tensquare.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import com.tensquare.util.IdWorker;

/**
 * @Classname BaseApplication
 * @Description 标签启动类
 * @Date 2020/4/11 0011 17:35
 * @Created by Administrator
 * @author haoyang
 */
@SpringBootApplication
@EnableEurekaClient
public class BaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(BaseApplication.class);
    }

    /**
     * 启动注册到spring容器当中去
     */
    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1,1);
    }
}
