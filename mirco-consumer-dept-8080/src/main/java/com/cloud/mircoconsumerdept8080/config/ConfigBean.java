package com.cloud.mircoconsumerdept8080.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 配置类详解
 */
@Configuration
public class ConfigBean {

    @Bean // 将RestTemplate注入到容器中，
    @LoadBalanced // 在客户端使用 RestTemplate 请求服务端时，开启负载均衡（Ribbon）
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }


    // 更改轮询策略
//   /* @Bean
//    public IRule setRule(){
//        return new RandomRule();
//    }*/

}
