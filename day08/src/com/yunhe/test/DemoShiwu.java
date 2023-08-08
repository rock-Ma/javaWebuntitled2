package com.yunhe.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.yunhe.utils.DatasourceUtils;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class DemoShiwu {
    public static void main(String[] args) throws SQLException {
        System.out.println("请输入您此次要消费的金额：");
        Scanner sc = new Scanner(System.in);
        double v = sc.nextDouble();
        account(v);
    }

    private static void account(double v) throws SQLException {
        Connection con = DatasourceUtils.getConnection();
        DataSource dataSource = DatasourceUtils.getDataSource();
        try {
            con.setAutoCommit(false);
            QueryRunner qr = new QueryRunner(dataSource);
            String sql = "update account set money = money - ? where name = 'pgone'";
            System.out.println(qr.update(sql, v) > 0 ? "转出成功" : "转出失败");
            sql = "update account set money = money + ? where name = 'lxl'";
            System.out.println(qr.update(sql, v) > 0 ? "转出成功" : "转出失败");
            con.commit();

        } catch (Exception e) {
            con.rollback();
            e.printStackTrace();
        }
    }
}
