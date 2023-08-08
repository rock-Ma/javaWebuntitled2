package com.yunhe.demo;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
@WebFilter("/t1")
public class FilterDemo implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("开始创建了");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("我来拦截");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("老弟，今天放你一马");

    }

    @Override
    public void destroy() {
        System.out.println("我来销毁");
    }
}
