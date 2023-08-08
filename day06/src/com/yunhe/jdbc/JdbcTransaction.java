package com.yunhe.jdbc;

import com.yunhe.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
 *   模拟 pgone与lxl的转账操作 使用jdbc事务
 *       Connnection 对象
 *           commit 提交事务
 *           rollback 回滚事务
 *           setAutoCommit(boolean)  true 自动提交 false 手动提交
 *
 * */
public class JdbcTransaction {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("老弟请输入此次的消费金额");
        double money = sc.nextDouble();
        //转账方法
        account(money);

    }

    private static void account(double money) {
        //获取连接对象
        Connection con = JdbcUtils.getConnection();

        Statement st = null;
        //获取可执行对象
        try {
            //事务的开启
            con.setAutoCommit(false);
            st = con.createStatement();
            //执行并获取结果
            System.out.println(st.executeUpdate("update account set money =money+"+money+" where name ='lxll'") > 0 ? "收钱成功" : "收钱失败");

            System.out.println(st.executeUpdate("update account set money =money-"+money+" where name='pgone' ") > 0 ? "转出成功" : "转出失败");
            //两个都成功  提交事务
            con.commit();
        } catch (Exception throwables) {
            try {
                con.rollback();//回滚事务
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throwables.printStackTrace();
        }finally {
            JdbcUtils.closeResource(null,st,con);
        }


    }
}
