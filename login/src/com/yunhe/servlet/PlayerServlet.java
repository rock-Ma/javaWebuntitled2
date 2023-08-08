package com.yunhe.servlet;

import com.yunhe.service.impl.PlayerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class PlayerServlet  extends HttpServlet {
    PlayerServiceImpl playerService = new PlayerServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String sex = req.getParameter("sex");
        String location = req.getParameter("location");
        String hobby = req.getParameter("hobby");
        String jieshao = req.getParameter("jieshao");
        System.out.println(playerService.regist(username, sex, location, hobby, jieshao) > 0 ? "注册成功！" : "注册失败");

    }
}
