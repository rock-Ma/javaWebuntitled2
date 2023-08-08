package com.yunhe.test;

import com.yunhe.utils.DatasourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.Scanner;

public class Hmwk01 {
    public static void main(String[] args) throws SQLException {
        //1-1使用dbutils向表中添加登录帐号信息
//        tianjia();
        //1-2 使用dbutils根据用户录入的登录信息匹配完成登录
        pipei();
    }
    private static void pipei() throws SQLException {
        System.out.println("请输入您的账号");
        Scanner sc = new Scanner(System.in);
        //记录用户输入的账号
        String s_ipt_zh = sc.nextLine();
        System.out.println("请输入您的密码");
        String s_ipt_mm = sc.nextLine();
        Connection con = DatasourceUtils.getConnection();
        QueryRunner qr = new QueryRunner();
        String sql = "select * from users where username = ? and password = ?";
        try {
            Map<String, Object> query = qr.query(con, sql, new MapHandler(), s_ipt_zh, s_ipt_mm);
            if(query == null){
                System.out.println("登录失败！");
            }
            else {
                System.out.println("登陆成功！");
                System.out.println("您的信息如下：");
                System.out.println(query);
            }
        }catch (NullPointerException e){
            System.err.println("登录失败！");
        }
    }
    private static void tianjia() throws SQLException {
        Connection con = DatasourceUtils.getConnection();
        QueryRunner qr = new QueryRunner();
        //插入语句
        String sql = "insert into users values(?,?,?)";
        System.out.println(qr.update(con, sql, 1, "宋凡平", "6666") > 0 ? "添加成功" : "添加失败");
    }
}
