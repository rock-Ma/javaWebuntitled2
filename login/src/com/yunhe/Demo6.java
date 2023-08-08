package com.yunhe;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/rc")
public class Demo6 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("下雨了！！！！！！！");
        //向请求域存值
        req.setAttribute("msg","没有");
        //重定向到rd
        resp.sendRedirect("/login/rd");
    }
}
