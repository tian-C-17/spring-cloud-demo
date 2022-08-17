package com.cloud.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient // 开启Eureka 客户端功能，将服务注册到服务注册中心（Eureka Server）
@EnableDiscoveryClient
@SpringBootApplication
public class MicroServiceCloudProvideDept8001Application {

    public static void main(String[] args) {
        SpringApplication.run(MicroServiceCloudProvideDept8001Application.class, args);
        System.out.println("--------启动成功--");
    }

}
