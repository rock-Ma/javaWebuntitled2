package com.yunhe.dao.impl;

import com.yunhe.dao.UserDao;
import com.yunhe.entity.User;
import com.yunhe.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

public class UserDaoImpl implements UserDao {
      QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
      public User FindByNameAndpwd(String username, String pwd){
          try {
              //根据用户输入的信息查询数据库，若有返回一个user对象
              return qr.query("select * from user where username = ? and pwd = ?",new BeanHandler<User>(User.class),username,pwd);
          } catch (Exception e) {
              e.printStackTrace();
          }
          //若无，返回null
          return null;
      }
}
