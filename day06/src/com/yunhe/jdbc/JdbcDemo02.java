package com.yunhe.jdbc;

import com.yunhe.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcDemo02 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入消费金额");
        double money = sc.nextDouble();
        account(money);

    }

    private static void account(double money){
        Connection con = JdbcUtils.getConnection();
        Statement st = null;
        try {
            con.setAutoCommit(false);
            st = con.createStatement();
            System.out.println(st.executeUpdate("update account set money = money+" + money + "where name = 'lxll'") > 0 ? "转账成功" : "转账失败");
            System.out.println(st.executeUpdate("update account set money = money-" + money + "where name = 'pgone'") > 0 ? "扣除成功" : "扣除失败");
            con.commit();
        } catch (Exception throwables) {

            try {
                con.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        finally {
            JdbcUtils.closeResource(null,st,con);
        }



    }
}