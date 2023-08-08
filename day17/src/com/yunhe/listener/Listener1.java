package com.yunhe.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
@WebListener
public class Listener1 implements HttpSessionListener {
    int count = 0;
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext context = se.getSession().getServletContext();
        Integer count = (Integer)context.getAttribute("count");
        if(count == null){
            count = 1;
            context.setAttribute("count",count);
        }else {
            count++;
            context.setAttribute("count",count);
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext context = se.getSession().getServletContext();
        Integer count = (Integer)context.getAttribute("count");
        count--;
        context.setAttribute("count",count);
    }


}
