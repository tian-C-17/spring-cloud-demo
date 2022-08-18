package com.cloud.mircoservicecloudproviderdepthystrix8004.service.impl;

import com.cloud.mircoservicecloudproviderdepthystrix8004.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service("deptService")
public class DeptServiceImpl implements DeptService {

    @Override
    public String deptInfo_OK(int id) {
        return"线程池：" + Thread.currentThread().getName() + "  deptInfo_Ok,id:   " + id;
    }

    /**
     * deptInfo_Timeout() 方法上使用 @HystrixCommand 注解，该注解说明如下：
     * 参数 fallbackMethod 属性用于指定降级方法。
     * 参数 execution.isolation.thread.timeoutInMilliseconds 用于设置自身调用超时时间的峰值，峰值内可以正常运行，否则执行降级方法
     */

    //一旦该方法失败并抛出了异常信息后，会自动调用  @HystrixCommand 注解标注的 fallbackMethod 指定的方法
    @HystrixCommand(fallbackMethod = "dept_TimeoutHandler",
    commandProperties = {
            //规定 5 秒钟以内就不报错，正常运行，超过 5 秒就报错，调用指定的方法
            @HystrixProperty(
                    name = "execution.isolation.thread.timeoutInMilliseconds",
                    value = "5000"
            )
    })
    @Override
    public String deptInfo_Timeout(int id) {
        int outTime = 4;   // 熔断使用6  --->4
        try {
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@");
            TimeUnit.SECONDS.sleep(outTime);
            System.out.println("//////////////////////////");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + "  deptInfo_Timeout,id:   " + id + "  耗时: " + outTime;
    }

    public String dept_TimeoutHandler(int id){
        return  "C语言中文网提醒您，系统繁忙请稍后再试！"+"线程池：" + Thread.currentThread().getName() + "  deptInfo_Timeout,id:   " + id;
    }

    /**
     * 熔断案例
     * @param id
     * @return
     */

    @Override
    @HystrixCommand(fallbackMethod = "deptCircuitBreaker_fallback", commandProperties = {
            //以下参数在 HystrixCommandProperties 类中有默认配置
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), //是否开启熔断器
            @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds",value = "3000"), //统计时间窗
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), //统计时间窗内请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), //休眠时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"), //在统计时间窗口期以内，请求失败率达到 60% 时进入熔断状态
    })
    public String deptCircuitBreaker(Integer id) {
        if (id < 0){
            throw new RuntimeException("id<0");
        }
        String serialNum = UUID.randomUUID().toString();
        return Thread.currentThread().getName() + "\t" + "调用成功，流水号为：" + serialNum;

    }

    //deptCircuitBreaker 的降级方法
    public String deptCircuitBreaker_fallback(Integer id) {
        return "c语言中文网提醒您，id 不能是负数,请稍后重试!\t id:" + id;
    }
}
