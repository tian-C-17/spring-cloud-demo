package com.cloud.demo.service;

import com.cloud.demo.service.impl.DeptHystrixServicwImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 服务降级，与 micro-service-cloud-provider-dept-hystrix-8004 中提供的服务接口进行绑定
 *
 *
 * 降级解耦， 就是给service搞个实现类， service中 注解内添加
 * fallback = DeptHystrixServicwImpl.class

 */
@Component
@FeignClient(value = "microServiceCloudProviderDeptHystrix",
fallback = DeptHystrixServicwImpl.class)
public interface DeptHystrixService {

    @RequestMapping(value = "/dept/hystrix/ok/{id}")
    public String deptInfo_Ok(@PathVariable("id") Integer id);

    @RequestMapping(value = "/dept/hystrix/timeout/{id}")
    public String deptInfo_Timeout(@PathVariable("id") Integer id);

}
