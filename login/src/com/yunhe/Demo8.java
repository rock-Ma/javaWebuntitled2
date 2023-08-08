package com.yunhe;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/s8")
//获取mime类型
public class Demo8 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String s = "hello.txt";
        ServletContext servletContext = req.getServletContext();
        String realPath = servletContext.getRealPath(s);
        System.out.println(realPath);
    }
}
