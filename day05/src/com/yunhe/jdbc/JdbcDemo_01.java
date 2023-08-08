package com.yunhe.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * /*
 *  *   需求向users表中添加一条记录
 *  *
 *  *   1、注册驱动
 *  *   2、获取连接
 *  *   3、获取可执行对象
 *  *   4、执行并获取结果
 *  *   5、释放资源*
 *  * */

public class JdbcDemo_01 {
    public static void main(String[] args) throws Exception {
        //1.注册驱动省略
        //2.获取连接
        Connection con = DriverManager.getConnection("jdbc:mysql:///day0705", "root", "123admin");
        //3、获取可执行对象
        Statement statement = con.createStatement();
        //4、执行并获取结果
        String sql1 = "update dept set dname = '李汉语' where deptno = 5";
        String sql2 = "delete from dept where dname = '李汉语'";
        String sql3 = "insert into dept (deptno,dname,loc)values('10','吕奉先','三国'";

        for (int i = 0; i < 100; i++) {
            System.out.println(statement.executeUpdate("insert into dept (deptno,dname,loc)values(10+i,'吕奉先'+i,'三国'") > 0 ? "执行成功" : "执行失败！");
        }
//        System.out.println(statement.executeUpdate(sql2) > 0 ? "执行成功" : "执行失败！");
        //5、释放资源*
        statement.close();
        con.close();


    }
}
