package com.cloud.mircoservicecloudproviderdepthystrix8004.service;

public interface DeptService {
    // hystrix 熔断器示例 ok
    String deptInfo_OK(int id);
    // hystrix 熔断器示例 ok
    String deptInfo_Timeout(int id);

    // Hystrix 熔断机制案例
    String deptCircuitBreaker(Integer id);
}
