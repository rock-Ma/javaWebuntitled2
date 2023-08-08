package com.yunhe;


import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/download")
public class Hmwk extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fileName = req.getParameter("fileName");
//        fileName = "kobe.jpg";
        resp.setHeader("content-disposition","attachment;fileName="+URLEncoder.encode(fileName, "utf-8"));
        String realPath = req.getServletContext().getRealPath("/img/" + fileName);
//        System.out.println(realPath);
        FileInputStream fis = new FileInputStream(realPath);
        ServletOutputStream fos = resp.getOutputStream();
        byte arr[] = new byte[1024 * 1024];
        int len;
        while ((len=fis.read(arr))!=-1) {
            fos.write(arr,0,len);
        }
        fos.close();
        fis.close();
    }
}
