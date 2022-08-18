package com.cloud.demo.controller;

import com.cloud.demo.service.DeptHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 降级（FallBack）方法必须与其对应的业务方法在同一个类中，否则无法生效。
 */
@Slf4j
@RestController
// 全局降级
@DefaultProperties(defaultFallback = "dept_Global_FallbackMethod")
public class DeptHystrixController_Consumer {

    @Resource
    private DeptHystrixService deptHystrixService;

    @RequestMapping(value = "/dept/hystrix/ok/{id}")
    public String deptInfo_Ok(@PathVariable("id") Integer id){
        return deptHystrixService.deptInfo_Ok(id);
    }

    /**
     * 全局降级方法的优先级较低，只有业务方法没有指定其降级方法时，
     * 服务降级时才会触发全局回退方法。
     * 若业务方法指定它自己的回退方法，那么在服务降级时，
     * 就只会直接触发它自己的回退方法，而非全局回退方法。
     */
    // 客户端进行降级
    @RequestMapping(value = "/dept/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "dept_TimeoutHandler")
    //   单独降级方法
 //   @HystrixCommand    // 全局降级，必须在方法上使用 此注解
    public String deptInfo_Timeout(@PathVariable("id") Integer id){
        String s = deptHystrixService.deptInfo_Timeout(id);
        System.out.println(s);
        return s;
    }

    // deptInfo_Timeout方法的 专用 fallback 方法
    public String dept_TimeoutHandler(@PathVariable("id") Integer id) {
        System.out.println("deptInfo_Timeout 出错，服务已被降级！");
        return "BBBBBBBBBB提醒您：服务端系统繁忙，请稍后再试！（客户端 deptInfo_Timeout 专属的回退方法触发）";
    }

    /**
     * 全局的 fallback 方法，
     * 回退方法必须和 hystrix 的执行方法在相同类中
     * @DefaultProperties(defaultFallback = "dept_Global_FallbackMethod") 类上注解，请求方法上使用 @HystrixCommand 注解
     */
    public String dept_Global_FallbackMethod(){
        System.out.println("我是全局降级回退方法啦!!!!!");
        return "我是全局降级回退方法啦！！！！";
    }



}
