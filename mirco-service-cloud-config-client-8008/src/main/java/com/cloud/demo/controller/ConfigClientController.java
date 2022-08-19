package com.cloud.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 通过该类获取配置文件中的配置
 * 读取配置中心指定配置文件的内容，并展示到页面
 */
@RestController
@RefreshScope
//为了让动态（手动）的获取最新的git 配置，在添加 actuator 监控加载 RefreshScope，
public class ConfigClientController {

    @Value("${server.port}")
    private String serverPort;
    @Value("${config.info}")
    private String configInfo;
    @Value("${config.version}")
    private String version;

    @GetMapping(value = "/getConfig")
    public String getConfig(){
        return "info：" + configInfo + "<br/>version：" + version + "<br/>port：" + serverPort;
    }

}
