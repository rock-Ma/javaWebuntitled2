package com.yunhe.jdbc;

import com.yunhe.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo01 {
    public static void main(String[] args) throws SQLException {
        Connection con = JdbcUtils.getConnection();
        Statement st = con.createStatement();
        //增
        String sql = "insert into student values(1002,'吴彦祖','男')";
        //删
        String sql2 = "delete from student where sname = '吴亦凡'";
        //改
        String sql3 = "update student set sname = '彭于晏'where id = 1002";
        //查
        String sql4 = "select * from student where id = 1002";
//        System.out.println(st.executeUpdate(sql3) > 0 ? "成功" : "失败");
        ResultSet res = st.executeQuery(sql4);

        while(res.next()){
        System.out.println(res.getInt(1));
        System.out.println(res.getString(2));
        System.out.println(res.getString(3));
        }
        res.close();
        JdbcUtils.closeResource(null,st,con);
    }
}
