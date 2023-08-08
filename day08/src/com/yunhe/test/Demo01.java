package com.yunhe.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Demo01 {
    public static void main(String[] args) throws SQLException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        Connection con = comboPooledDataSource.getConnection();
        String sql = "delete from student where sname = ?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1,"猪八戒");
        System.out.println(preparedStatement.executeUpdate() > 0 ? "成功" : "失败");
        preparedStatement.close();
        con.close();
        comboPooledDataSource.close();


    }
}
