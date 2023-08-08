package com.yunhe.dao.impl;


import com.yunhe.entity.Student;
import com.yunhe.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class BaseDao<T> {
    static QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());

    public List<T> findall(String sql, Class cls, Object... obj) {

        try {
            List<T> list = qr.query(sql,new BeanListHandler<T>(cls),obj);
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public T findone(String sql, Class cls, Object... obj) {

        try {
            return qr.query(sql, new BeanHandler<T>(cls), obj);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int updateT(String sql,Object... obj){
        try {
            return qr.update(sql,obj);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

}