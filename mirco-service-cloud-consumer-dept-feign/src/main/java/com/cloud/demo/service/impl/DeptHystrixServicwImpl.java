package com.cloud.demo.service.impl;

import com.cloud.demo.service.DeptHystrixService;
import org.springframework.stereotype.Component;

/**
 * 解耦降级逻辑
 * 该类必须以组件的形式添加 Spring 容器中才能生效，最常用的方式就是在类上标注 @Component 注解。
 */
@Component
public class DeptHystrixServicwImpl implements DeptHystrixService {


    @Override
    public String deptInfo_Ok(Integer id) {
        return "----------------C语言中文网提醒您，系统繁忙，请稍后重试！（解耦回退方法触发）-------------";
    }

    @Override
    public String deptInfo_Timeout(Integer id) {
        return "-----C语言中文网提醒您，系统繁忙，请稍后重试！（解耦回退方法触发）---------------------";
    }
}
