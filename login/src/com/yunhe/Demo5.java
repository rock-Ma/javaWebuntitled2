package com.yunhe;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
@WebServlet("/ri")
public class Demo5  extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Content-Type","image/jpg");
        String path = req.getServletContext().getRealPath("/img/kobe.jpg");
        FileInputStream fis = new FileInputStream(path);
        byte arr[] = new byte[1024 * 8];
        //获取到字节输出流对象
        ServletOutputStream fos = resp.getOutputStream();
        int len;//读取到的有效字符个数
        while ((len=fis.read(arr))!=-1) {
            //将读到内容响应回页面
            fos.write(arr,0,len);
        }

        fos.close();
        fis.close();
    }
}
