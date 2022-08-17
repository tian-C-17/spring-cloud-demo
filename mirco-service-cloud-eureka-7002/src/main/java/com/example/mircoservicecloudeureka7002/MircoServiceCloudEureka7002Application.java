package com.example.mircoservicecloudeureka7002;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer // 开启eureka server, 接受其他微服务的注册
@SpringBootApplication
public class MircoServiceCloudEureka7002Application {

    public static void main(String[] args) {
        SpringApplication.run(MircoServiceCloudEureka7002Application.class, args);
        System.out.println("-------启动成功------");
    }

}
