package com.yunhe.dao.impl;

import com.yunhe.dao.PlayerDao;
import com.yunhe.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

public class PlayerDaoImpl implements PlayerDao {
    QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
    @Override
    public int regist(String username, String sex, String location, String hobby, String jieshao) {
        String sql = "insert into player values(null,?,?,?,?,?)";
        try {
            int update = qr.update(sql, username, sex, location, hobby, jieshao);
            return update;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
