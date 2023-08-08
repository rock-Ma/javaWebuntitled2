package com.yunhe.dao.impl;

import com.yunhe.dao.EmpDao;
import com.yunhe.entity.Emp;
import com.yunhe.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class EmpDaoImpl implements EmpDao {
    static QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
    @Override
    public List<Emp> findAll() {
        String sql = "select * from employees";

        try {
            return qr.query(sql, new BeanListHandler<Emp>(Emp.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int addStudent(Emp emp) {
        String sql = "insert into employees values(?,?,?,?,?)";
        try {
            return qr.update(sql, emp.getEmployeeId(), emp.getName(), emp.getSalary(), emp.getHireDate(), emp.getDepartmentId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteById(String eId) {
        String sql = "delete from employees where employeeId = ?";
        try {
            return qr.update(sql, eId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int edit(String name, Double sal, String hireDate, int depId, int empId) {
        String sql = "update employees set name=?,salary=?,hireDate=?,departmentId=? where employeeId=? ";
        try {
            return qr.update(sql, name, sal, hireDate, depId, empId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Emp> findByPage(int cp, int ps) {
        int dangQianYe = (cp-1)*ps;
        String sql = "select * from employees limit ?,?";
        try {
            return qr.query(sql, new BeanListHandler<Emp>(Emp.class), dangQianYe, ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
