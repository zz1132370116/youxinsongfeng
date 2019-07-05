package com.zl.dc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by 舍頭襘游泳 on 2018/12/12.
 */
@SpringBootApplication      //Spring boot
@EnableEurekaServer         //注册中心
public class JMYPWebEurekaServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(JMYPWebEurekaServiceApplication.class,args);
    }
}
