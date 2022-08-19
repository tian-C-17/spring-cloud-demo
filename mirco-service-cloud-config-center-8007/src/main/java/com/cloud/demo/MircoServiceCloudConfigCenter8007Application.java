package com.cloud.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableConfigServer //开启 Spring Cloud Config 配置中心功能
@EnableEurekaClient
public class MircoServiceCloudConfigCenter8007Application {

    public static void main(String[] args) {
        SpringApplication.run(MircoServiceCloudConfigCenter8007Application.class, args);
        System.out.println("-------success----------");
    }

}
