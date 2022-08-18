package com.cloud.mircoservicecloudproviderdepthystrix8004;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableCircuitBreaker//激活熔断器功能
@EnableEurekaClient //开启 Eureka 客户端功能
public class MircoServiceCloudProviderDeptHystrix8004Application {

    public static void main(String[] args) {
        SpringApplication.run(MircoServiceCloudProviderDeptHystrix8004Application.class, args);
        System.out.println("------success------");
    }

}
