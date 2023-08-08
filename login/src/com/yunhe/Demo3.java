package com.yunhe;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/rh")
public class Demo3 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("小老弟欢迎你来到rh的直播间");
        System.out.println("你将会在刷完嘉年华后跳转到我的私人直播间");
        System.out.println("5秒后你可以看到我优美的舞姿和动人的歌声");
        resp.setHeader("Refresh","5;url=/login/ra");
    }
}
