package com.yunhe.servlet;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yunhe.entity.Emp;
import com.yunhe.service.EmpService;
import com.yunhe.service.impl.EmpServiceImpl;
import com.yunhe.utils.JdbcUtils;
import com.yunhe.utils.PageBean;
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

@WebServlet("/emp")
public class Servlet extends HttpServlet {
    EmpService empService= new EmpServiceImpl();
    ObjectMapper mapper = new ObjectMapper();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String method = req.getParameter("method");
        System.out.println(method);
        if ("findAll".equals(method)) {
            findAll(req,resp);
        }else if("post".equals(method)){
            addStudent(req,resp);
        }else if("deleteById".equals(method)){
            String eId = req.getParameter("eId");
            System.out.println(eId);
            deleteById(req,resp,eId);
        }
        else if("edit".equals(method)){
            edit(req,resp);
        }else if("findPage".equals(method)){
            findPage(req,resp);
        }
    }

    private void findPage(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=utf-8");
        String currentPage = req.getParameter("currentPage");
        String pageSize = req.getParameter("pageSize");
        PageBean pb = empService.findPage(currentPage,pageSize);
        String json = mapper.writeValueAsString(pb);
        resp.getWriter().println(json);

    }

    private void edit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String employeeId = req.getParameter("employeeId");
        String name = req.getParameter("name");
        String salary = req.getParameter("salary");
        String hireDate = req.getParameter("hireDate");
        String departmentId = req.getParameter("departmentId");


        int empId = Integer.parseInt(employeeId);
        Double sal = Double.parseDouble(salary);
        int depId = Integer.parseInt(departmentId);
        int flag = empService.edit(name,sal,hireDate,depId,empId);
        resp.getWriter().println(flag);
    }

    private void deleteById(HttpServletRequest req, HttpServletResponse resp, String eId) throws IOException {
        int flag = empService.deleteById(eId);
        if(flag>0){
            System.out.println("删除成功");
            resp.getWriter().println(flag);
        }
        else {
            System.out.println("删除失败");
            resp.getWriter().println(flag);
        }
    }

    private void findAll(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=utf-8");
        List<Emp> list = empService.findAll();
        String json = mapper.writeValueAsString(list);
        resp.getWriter().println(json);
        System.out.println(json);
    }


    private void addStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("进来了");

        String employeeId = req.getParameter("employeeId");
        String name = req.getParameter("name");
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


