package com.cloud.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient // 开启Eureka 客户端功能，将服务注册到服务注册中心（Eureka Server）
public class MicroServiceCloudProvideDept8002Application {

    public static void main(String[] args) {
        SpringApplication.run(MicroServiceCloudProvideDept8002Application.class, args);
        System.out.println("--------启动成功--");
    }

}
