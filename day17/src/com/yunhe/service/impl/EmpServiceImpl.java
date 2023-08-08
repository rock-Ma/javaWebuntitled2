package com.yunhe.service.impl;

import com.yunhe.dao.EmpDao;
import com.yunhe.dao.impl.EmpDaoImpl;
import com.yunhe.entity.Emp;
import com.yunhe.service.EmpService;
import com.yunhe.utils.PageBean;

import java.util.List;

public class EmpServiceImpl implements EmpService {
    EmpDao empDao =  new EmpDaoImpl();
    @Override
    public List<Emp> findAll() {
        return empDao.findAll();
    }

    @Override
    public int addStudent(Emp emp) {
        return empDao.addStudent(emp);
    }

    @Override
    public int deleteById(String eId) {
        return empDao.deleteById(eId);
    }

    @Override
    public int edit(String name, Double sal, String hireDate, int depId, int empId) {
        return empDao.edit(name,sal,hireDate,depId,empId);
    }

    @Override
    public PageBean findPage(String currentPage, String pageSize) {
        int cp = Integer.parseInt(currentPage);
        int ps = Integer.parseInt(pageSize);
        PageBean pageBean = new PageBean();
        pageBean.setCurrentPage(cp);
        pageBean.setPageSize(ps);
        List<Emp> list = empDao.findByPage(cp,ps);
        pageBean.setList(list);
        pageBean.setTotalCount(empDao.findAll().size());
        return pageBean;
    }
}
