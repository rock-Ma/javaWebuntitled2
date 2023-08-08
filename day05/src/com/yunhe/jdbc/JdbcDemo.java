package com.yunhe.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 *   需求向users表中添加一条记录
 *
 *   1、注册驱动
 *   2、获取连接
 *   3、获取可执行对象
 *   4、执行并获取结果
 *   5、释放资源*
 * */
public class JdbcDemo {

    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/day0705", "root", "123admin");
        Statement st = con.createStatement();
        String sql = "insert into dept (deptno,dname,loc)values('10','吕奉先','三国')";
        //查询表
        String sql2 = "select * from dept ";
        ResultSet set = st.executeQuery(sql2);
//        int row = st.executeUpdate(sql);
//        System.out.println(row > 0?"添加成功":"添加失败！");
//        System.out.println(set);
//        System.out.println(set.first());
//        System.out.println(set.getInt(1));

        while(set.next()){
            int deptno = set.getInt("deptno");
            String dname = set.getString("dname");
            String loc = set.getString("loc");
            System.out.println(deptno + "--" + dname + "--" + loc);
        }


        st.close();
        con.close();



    }

}
