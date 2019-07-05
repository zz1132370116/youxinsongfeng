package com.zl.dc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by 舍頭襘游泳 on 2018/12/12.
 */
@SpringBootApplication
@EnableEurekaClient
public class JMYPWebServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(JMYPWebServiceApplication.class,args);
    }
}
