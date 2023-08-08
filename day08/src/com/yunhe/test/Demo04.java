package com.yunhe.test;

import com.yunhe.entity.Student;
import com.yunhe.utils.DatasourceUtils;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Demo04 {
    public static void main(String[] args) throws SQLException {
        findAll();
//        findOne();
//        findOneMap();
//        findAllMap();
    }

    private static void findAllMap() throws SQLException {
        DataSource dataSource = DatasourceUtils.getDataSource();
        QueryRunner qr = new QueryRunner(dataSource);
        String sql = "select * from student";
        List<Map<String, Object>> query = qr.query(sql, new MapListHandler());
        for (Map<String, Object> q:query
             ) {
            System.out.println(q);
            Set<Map.Entry<String, Object>> entries = q.entrySet();
            for (Map.Entry<String, Object> e:entries
                 ) {
                System.out.println(e.getKey()+"\t\t"+e.getValue());
            }
        }
    }

    private static void findOneMap() throws SQLException {
        DataSource dataSource = DatasourceUtils.getDataSource();
        QueryRunner qr = new QueryRunner(dataSource);
        String sql = "select * from student where id = ?";
        Map<String, Object> ma = qr.query(sql, new MapHandler(), 1);
        Set<Map.Entry<String, Object>> entries = ma.entrySet();
        for (Map.Entry<String, Object> e :entries
             ) {
            System.out.println(e.getKey()+"\t"+e.getValue());
        }



    }

    private static void findOne() throws SQLException {
        DataSource dataSource = DatasourceUtils.getDataSource();
        QueryRunner qr = new QueryRunner(dataSource);
        String sql = "select * from student where id = ?";
        Student stu = qr.query(sql, new BeanHandler<Student>(Student.class), 1);
        System.out.println(stu);

    }

    private static void findAll() throws SQLException {
        DataSource dataSource = DatasourceUtils.getDataSource();
        QueryRunner qr = new QueryRunner(dataSource);
        String sql = "select * from student";
        List<Student> list = qr.query(sql, new BeanListHandler<Student>(Student.class));
        list.forEach(System.out::println);

    }
}
