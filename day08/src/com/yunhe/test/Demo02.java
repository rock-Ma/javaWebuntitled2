package com.yunhe.test;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class Demo02 {
    public static void main(String[] args) throws Exception {
//        InputStream ipt = Demo02.class.getClassLoader().getResourceAsStream("src\\durid.properties");
        FileInputStream ipt = new FileInputStream("D:\\javaWebuntitled1\\day08\\src\\durid.properties");
        Properties properties = new Properties();
        properties.load(ipt);
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        Connection con = dataSource.getConnection();
        String sql = "select * from student";
        String sql_add = "insert into student values(?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        PreparedStatement ps2 = con.prepareStatement(sql_add);
        ps2.setInt(1,1003);
        ps2.setString(2,"胡歌");
        ps2.setString(3,"男");
        System.out.println(ps2.executeUpdate() > 0 ? "添加成功" : "添加失败");
//        ps.setString(1,"吕布");
        ResultSet res = ps.executeQuery();
        while(res.next()){
            int id = res.getInt(1);
            String name = res.getString(2);
            String sex = res.getString(3);
            System.out.println(id+"\t"+name+"\t"+sex);
        }
        ps.close();
        ps2.close();
//        con.close();
//        ipt.close();

    }
}
