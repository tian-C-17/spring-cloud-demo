package com.cloud.demo.controller;

import com.cloud.demo.entity.Dept;
import com.cloud.demo.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private DeptService deptService;


    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    public Dept get(@PathVariable("id") int id) {
        System.out.println("----------------8080808080-----------");
        return deptService.get(id);
    }
    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public List<Dept> list() {
//        try{
        // 测试openfeign 超时添加
//            Thread.sleep(2000);
//        }catch (Exception e){
//            e.printStackTrace();
//        }

        return deptService.selectAll();
    }
}
