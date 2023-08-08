package com.yunhe.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;
import java.util.LinkedList;
@WebListener
public class Lisenter01 implements ServletContextListener, HttpSessionListener,HttpSessionAttributeListener {
    ServletContext context;

    //服务器启动，创建ServletContext对象应用域
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //创建容器
        LinkedList<String> list = new LinkedList<>();
        //获取ServletContext应用域
        context = servletContextEvent.getServletContext();
        //将容器存入对象应用域
        context.setAttribute("list",list);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
    //监听session中添加值
    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        if("username".equals(httpSessionBindingEvent.getName())){
            HttpSession session = httpSessionBindingEvent.getSession();
            String username = (String) session.getAttribute("username");
            LinkedList<String> list = (LinkedList<String>) context.getAttribute("list");
            list.add(username);
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {

    }
    //创建
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {

    }
    //销毁
    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        String username = (String) session.getAttribute("username");
        LinkedList<String> list = (LinkedList<String>) context.getAttribute("list");
        list.remove(username);
    }
}
