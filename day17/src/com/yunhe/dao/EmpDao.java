package com.yunhe.dao;

import com.yunhe.entity.Emp;

import java.util.List;

public interface EmpDao {
    public List<Emp> findAll();

    int addStudent(Emp emp);

    int deleteById(String eId);

    int edit(String name, Double sal, String hireDate, int depId, int empId);

    List<Emp> findByPage(int cp, int ps);
}
