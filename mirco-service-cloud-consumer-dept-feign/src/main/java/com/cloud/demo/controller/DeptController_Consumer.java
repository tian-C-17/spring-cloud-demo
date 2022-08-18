package com.cloud.demo.controller;

import com.cloud.demo.entity.Dept;
import com.cloud.demo.service.DeptFeignService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class DeptController_Consumer {

    @Resource
    private DeptFeignService deptFeignService;

    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    public Dept get(@PathVariable("id") int id) {
        System.out.println("-------------------------");
        return deptFeignService.get(id);
    }
    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public List<Dept> list() {
        System.out.println("-------------------------");
        return deptFeignService.list();
    }
}
