package com.yunhe.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DatasourceUtils {
    static DataSource dataSource;
    static {
        try {
            Properties pro = new Properties();
            pro.load(DatasourceUtils.class.getClassLoader().getResourceAsStream("durid.properties"));
            dataSource = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    //返回连接池
    public static DataSource getDataSource(){
        return dataSource;
    }
    //返回连接对象
    public static Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
