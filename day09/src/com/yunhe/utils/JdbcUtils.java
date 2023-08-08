package com.yunhe.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {

    static DataSource dataSource;
    static {
        try {
            Properties properties = new Properties();
            InputStream resource = JdbcUtils.class.getClassLoader().getResourceAsStream("durid.properties");

            properties.load(resource);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static DataSource getDataSource(){
        return dataSource;
    }
    public static Connection getConnection(){

        try {
            return dataSource.getConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
