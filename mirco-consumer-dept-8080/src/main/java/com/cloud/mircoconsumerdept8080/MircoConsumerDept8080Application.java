package com.cloud.mircoconsumerdept8080;

import com.cloud.rule.IIORule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient //开启 Eureka 客户端功能
@RibbonClient(name = "mocroServiceCloudProviderDept",configuration = IIORule.class)
//自定义 Ribbon 负载均衡策略在主启动类上使用 RibbonClient 注解，在该微服务启动时，
// 就能自动去加载我们自定义的 Ribbon 配置类，从而是配置生效
// name 为需要定制负载均衡策略的微服务名称（application name）
// configuration 为定制的负载均衡策略的配置类，
// 且官方文档中明确提出，该配置类不能在 ComponentScan 注解（SpringBootApplication
// 注解中包含了该注解）下的包或其子包中，即自定义负载均衡配置类不能在 net.biancheng.c 包及其子包下
public class MircoConsumerDept8080Application {

    public static void main(String[] args) {
        SpringApplication.run(MircoConsumerDept8080Application.class, args);

        System.out.println("----启动成功----");
    }

}
