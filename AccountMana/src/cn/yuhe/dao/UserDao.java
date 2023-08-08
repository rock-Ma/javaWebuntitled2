package cn.yuhe.dao;

import cn.yuhe.entity.User;
import cn.yuhe.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;

public class UserDao {

    QueryRunner qr= new QueryRunner(JdbcUtils.getDataSource());
    public User findUserByUsernameAndPassword(String username,String password){
        String sql = "select * from user where username = ? and password = ?";
        try {
            User query = qr.query(sql, new BeanHandler<User>(User.class), username, password);
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
