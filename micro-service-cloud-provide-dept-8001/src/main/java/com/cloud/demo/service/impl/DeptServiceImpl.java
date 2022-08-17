package com.cloud.demo.service.impl;

import com.cloud.demo.entity.Dept;
import com.cloud.demo.service.DeptService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("deptService")
public class DeptServiceImpl implements DeptService {

    @Override
    public Dept get(Integer deptNo) {
        Dept dept = new Dept();
        dept.setDeptNo(1);
        dept.setDeptName("管理");
        return dept;
    }

    @Override
    public List<Dept> selectAll() {
        List<Dept> list = new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            Dept dept = new Dept();
            dept.setDeptNo(i);
            dept.setDeptName("管理"+i+"部");
            list.add(dept);
        }
        return list;
    }
}
