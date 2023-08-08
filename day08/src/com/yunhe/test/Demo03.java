package com.yunhe.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Demo03 {
    static ComboPooledDataSource dataSource = new ComboPooledDataSource();
    //        Connection con = dataSource.getConnection();
    static QueryRunner qr = new QueryRunner(dataSource);
    public static void main(String[] args) throws SQLException {
        //增
        add();
        //删
//        delete();
        //改
//        change();
        //查
//        cha();
    }

    private static void cha() {

    }

    private static void change() throws SQLException {
        String sql = "update student set sname = ? where id = ?";
        System.out.println(qr.update(sql, "李汉玉", 4) > 0 ? "更改成功" : "更改失败");
    }

    private static void delete() throws SQLException {
        String sql = "delete from student where id = ?";
        System.out.println(qr.update(sql, 1002) > 0 ? "删除成功" : "删除失败");
    }

    private static void add() throws SQLException {
        String sql = "insert into student values(?,?,?)";
        System.out.println(qr.update(sql, 5, "曹操", "男") > 0 ? "添加成功" : "添加失败");
    }

}
