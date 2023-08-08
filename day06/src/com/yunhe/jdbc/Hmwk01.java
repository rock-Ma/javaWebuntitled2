package com.yunhe.jdbc;

/**
 *  1、使用preparedStatement对象完成mysql事务转账操作（实现用户之间的转账）
 * */
import com.yunhe.utils.JdbcUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
public class Hmwk01 {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入此次的消费金额");
        double money = sc.nextDouble();
        //转账方法
        account(money);
    }
    private static void account(double money) throws SQLException {
        //获取连接对象
        Connection con = JdbcUtils.getConnection();
        PreparedStatement ps   = null;
        PreparedStatement ps2   = null;

        //获取可执行对象
        try {
            //事务的开启
            con.setAutoCommit(false);
             ps2 = con.prepareStatement("update account set money = money - ? where name ='pgone1'");
            ps = con.prepareStatement("update account set money = money + ? where name ='lxl'");
            ps.setDouble(1,money);
            ps2.setDouble(1,money);
            System.out.println(ps2.executeUpdate() > 0 ? "转账成功" : "转账失败");
            System.out.println(ps.executeUpdate() > 0 ? "收款成功" : "收款失败");
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
            JdbcUtils.closeResource(null,ps,con);
            JdbcUtils.closeResource(null,ps2,null);
        }
    }
}
