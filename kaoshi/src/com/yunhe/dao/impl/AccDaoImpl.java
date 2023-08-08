package com.yunhe.dao.impl;

import com.yunhe.dao.AccDao;
import com.yunhe.entity.Account;
import com.yunhe.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public class AccDaoImpl implements AccDao {
    static QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
    @Override
    public List<Account> findByPage(int cp, int ps) {
        int dangQianYe = (cp-1)*ps;
        String sql = "select * from account limit ?,?";
        try {
            return qr.query(sql, new BeanListHandler<Account>(Account.class), dangQianYe, ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Account> findAll() {
        String sql = "select * from account";
        try {
            return qr.query(sql, new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
