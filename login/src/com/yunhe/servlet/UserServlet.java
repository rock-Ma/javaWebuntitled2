package com.yunhe.servlet;

import com.yunhe.entity.User;
import com.yunhe.service.UserService;
import com.yunhe.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/login")
public class UserServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String pwd = req.getParameter("password");
        User user = userService.login(username, pwd);
        System.out.println(user);
        if (user == null){
            //user为null，账号或密码错误
            req.setAttribute("mess","登录失败，请检查账号密码");
            req.getRequestDispatcher("/jsp/login.jsp").forward(req,resp);
        }
        else {
            //检查是否勾选remember记住密码
            String r = req.getParameter("remember");
            if(r!=null){
                //勾选了
                Cookie c1 = new Cookie("uname",username);
                Cookie c2 = new Cookie("pwd",pwd);
                //设置生存周期
                c1.setMaxAge(3600);
                c2.setMaxAge(3600);
                resp.addCookie(c1);
                resp.addCookie(c2);
            }
            else{
                //没有勾选，清空Cookie
                Cookie c1 = new Cookie("uname","");
                Cookie c2 = new Cookie("pwd","");
                c1.setMaxAge(0);
                c2.setMaxAge(0);
                resp.addCookie(c1);
                resp.addCookie(c2);

            }
            //请求转发
            req.setAttribute("user",user);
            req.getRequestDispatcher("index.jsp").forward(req,resp);


        }
    }
}
