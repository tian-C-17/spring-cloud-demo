package com.cloud.demo.service;

import com.cloud.demo.config.ConfigBean;
import com.cloud.demo.entity.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

// 添加为容器内一个组件
@Component
// 为服务提供者提供的服务名称,即 spring.application.name
@FeignClient(value = "mocroServiceCloudProviderDept")
public interface DeptFeignService {

//    在 @FeignClient 注解中，value 属性的取值为：服务提供者的服务名，即服务提供者配置文件（application.yml）中 spring.application.name 的取值。
//    接口中定义的每个方法都与服务提供者（即 micro-service-cloud-provider-dept-8001 等）中 Controller 定义的服务方法对应。
//    对应服务提供者（8001、8002、8003）Controller 中定义的方法
    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    Dept get(@PathVariable("id") int id);

    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    List<Dept> list();
}
