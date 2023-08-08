package com.yunhe.servlet;

import com.yunhe.entity.User;
import com.yunhe.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/a2")
public class Demo2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
        try {
            User user = qr.query("select * from user where username = ?", new BeanHandler<User>(User.class), username);
            if(user!=null){
                resp.getWriter().println(1);
            }
            else {
                resp.getWriter().println(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
