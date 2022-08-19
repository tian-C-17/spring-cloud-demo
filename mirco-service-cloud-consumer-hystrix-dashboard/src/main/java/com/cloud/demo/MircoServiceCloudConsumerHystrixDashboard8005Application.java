package com.cloud.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard // 开启 Hystrix 监控功能
public class MircoServiceCloudConsumerHystrixDashboard8005Application {

    public static void main(String[] args) {
        SpringApplication.run(MircoServiceCloudConsumerHystrixDashboard8005Application.class, args);
        System.out.println("------------success------------");
    }

}
