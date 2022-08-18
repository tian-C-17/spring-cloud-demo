package com.cloud.rule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 定制ribbon 负载均衡配置类，
 * 该自定义 Ribbon 负载均衡策略配置类 不能在 mircoconsumerdept8080 包及其子包下
 * * 否则所有的 Ribbon 客户端都会采用特该策略，无法达到殊化定制的目的
 */
@Configuration
public class MySelfRibbonRuleConfig {

    @Bean
    public IRule myRule(){
        return new IIORule();
    }
}
