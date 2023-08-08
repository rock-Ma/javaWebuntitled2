package com.yunhe.login;

import com.yunhe.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Demo03 {
    public static void main(String[] args) throws SQLException {
        System.out.println("please input your username :");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        System.out.println("please input your password:");
        String password = scanner.nextLine();
        Connection con = JdbcUtils.getConnection();
        Statement st = con.createStatement();
        String sql1 = "select * from user where username = '"+username+"'and password = '"+password+"'";
        ResultSet res = st.executeQuery(sql1);
        if (res.next()){
            System.out.println("OK！！");
        }
        else{
            System.out.println("No!");
        }


    }

}
