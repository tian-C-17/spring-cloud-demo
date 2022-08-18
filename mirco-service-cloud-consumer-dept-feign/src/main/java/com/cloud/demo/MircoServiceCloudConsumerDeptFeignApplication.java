package com.cloud.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients // 开启 OpenFeign 功能
@EnableHystrix  //启用 Hystrix
public class MircoServiceCloudConsumerDeptFeignApplication {

//    Spring Cloud 应用在启动时，OpenFeign 会扫描标有
//    @FeignClient 注解的接口生成代理，并注人到 Spring 容器中。
    public static void main(String[] args) {
        SpringApplication.run(MircoServiceCloudConsumerDeptFeignApplication.class, args);
        System.out.println("------启动成功-------");
    }

}
