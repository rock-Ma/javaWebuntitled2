package com.yunhe.servlet;

import com.yunhe.entity.User;
import com.yunhe.service.UserService;
import com.yunhe.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if("login".equals(method)){
            login(req,resp);
        }

    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String pwd = req.getParameter("password");
        User user = userService.login(username, pwd);
        System.out.println(user);
        if (user == null){
            //user为null，账号或密码错误
            req.setAttribute("mess","登录失败，请检查账号密码");
            req.getRequestDispatcher("/html/login.html").forward(req,resp);
        }
        else {
            //检查是否勾选remember记住密码
            String r = req.getParameter("remember");
            if(r!=null){
                //勾选了
                HttpSession session = req.getSession();
                session.setAttribute("user",user);
                resp.sendRedirect(req.getContextPath()+"/index.jsp");
            }
            else{
                HttpSession session = req.getSession();
                session.setAttribute("user",user);
                resp.sendRedirect(req.getContextPath()+"/index.jsp");

            }


        }
    }
}
