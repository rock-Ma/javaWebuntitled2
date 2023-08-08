package com.yunhe.servlet;

import com.yunhe.entity.Emp;
import com.yunhe.service.EmpService;
import com.yunhe.service.impl.EmpServiceImpl;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        EmpService empService = new EmpServiceImpl();
//        List<Emp> list = empService.findAll();
//        for (Emp emp : list) {
//            System.out.println(emp);
//        }
        Emp emp = new Emp(111,"asdsa",111.0,"2023-04-22",1);
        int i = empService.addStudent(emp);
        if(i>0){
            System.out.println("添加成功");
        }
        else{
            System.out.println("添加失败！");
        }
    }

}
