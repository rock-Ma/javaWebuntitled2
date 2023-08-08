package com.yunhe.utils;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * 1.获取文件中的数据
 * 2.编写通用方法获取连接
 * 3.编写通用方法释放资源
 * **/
public class JdbcUtils {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;
    static {
        ResourceBundle db = ResourceBundle.getBundle("db");
        driver = db.getString("jdbc.driver");
        url = db.getString("jdbc.url");
        username = db.getString("jdbc.username");
        password = db.getString("jdbc.password");

    }
    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;

    }
    public static void closeResource(ResultSet rs, Statement st,Connection con){

        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(st!=null){
            try {
                st.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(con!=null){
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        System.out.println(getConnection());
    }
}
