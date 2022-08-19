package com.cloud.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient //开启 Eureka 客户端功能
public class MircoServiceCloudConfigClient8008Application {

    public static void main(String[] args) {
        SpringApplication.run(MircoServiceCloudConfigClient8008Application.class, args);
        System.out.println("------success------");
    }

}
