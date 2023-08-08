package com.yunhe.servlet;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yunhe.entity.Emp;
import com.yunhe.service.EmpService;
import com.yunhe.service.impl.EmpServiceImpl;
import com.yunhe.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/empadd")
public class addServlet extends HttpServlet {
    EmpService empService= new EmpServiceImpl();
    ObjectMapper mapper = new ObjectMapper();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("进来了");

        String employeeId = req.getParameter("employeeId");
        System.out.println(employeeId);
        String name = req.getParameter("name");
        System.out.println(name);
        String salary = req.getParameter("salary");
        String hireDate = req.getParameter("hireDate");
        String departmentId = req.getParameter("departmentId");
        int empId = Integer.parseInt(employeeId);
        Double sal = Double.parseDouble(salary);
        int depId = Integer.parseInt(departmentId);
        Emp emp = new Emp(empId,name,sal,hireDate,depId);
        int flag = empService.addStudent(emp);

        if(flag>0){
            System.out.println("添加成功");
            resp.getWriter().println(flag);
        }
        else {
            System.out.println("添加失败");
            resp.getWriter().println(flag);
        }
 }

}


