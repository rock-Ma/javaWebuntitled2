package com.yunhe.service;

import com.yunhe.entity.Emp;
import com.yunhe.utils.PageBean;

import java.util.List;

public interface EmpService {
    List<Emp> findAll();

    int addStudent(Emp emp);

    int deleteById(String eId);

    int edit(String name, Double sal, String hireDate, int depId, int empId);

    PageBean findPage(String currentPage, String pageSize);
}
