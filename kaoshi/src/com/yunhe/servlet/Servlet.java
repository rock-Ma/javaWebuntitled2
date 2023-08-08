package com.yunhe.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yunhe.service.AccService;
import com.yunhe.service.impl.AccServieImpl;
import com.yunhe.utils.PageBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/test")
public class Servlet extends HttpServlet {
    AccService accService =  new AccServieImpl();
    ObjectMapper mapper = new ObjectMapper();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        String method = req.getParameter("method");

        if("findPage".equals(method)){

            findPage(req,resp);
        }
    }

    private void findPage(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setContentType("text/html;charset=utf-8");

        String currentPage = req.getParameter("currentPage");

        String pageSize = req.getParameter("pageSize");

        PageBean pb = accService.findPage(currentPage,pageSize);

        String json = mapper.writeValueAsString(pb);

        resp.getWriter().println(json);
    }
}
