package com.yunhe.filter;

import com.yunhe.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

//@WebFilter("/*")
public class Filter1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        System.out.println("开始创建了");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        //请求乱码
        request.setCharacterEncoding("UTF-8");
        //相应乱码
        response.setContentType("text/html;charset=utf-8");
        String uri = request.getRequestURI();
        String method = request.getParameter("method");


        ArrayList<String> list = new ArrayList<>();
        list.add("login.html");
        //需要放行的路径 //day19_emp/user
        list.add("user");
        list.add("index.jsp");

        for (String url : list) {
            if (uri.contains(url)) {
                //不需要拦截的路径
                filterChain.doFilter(request,response);
                return;
            }
        }
        User user = (User)request.getSession().getAttribute("user");if (user!=null) {
            //已经登录了
            //放行
            filterChain.doFilter(request,response);
        }else{
            //3秒后跳转到登录页面
            response.getWriter().println("小老弟你没有权限操作,请登录后重试！");
            response.setHeader("refresh","3;url=/day17/html/login.html");
        }


    }

    @Override
    public void destroy() {
//        System.out.println("我来销毁");
    }
}
