package com.yunhe.service.impl;

import com.yunhe.dao.UserDao;
import com.yunhe.dao.impl.UserDaoImpl;
import com.yunhe.entity.User;
import com.yunhe.service.UserService;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();
    @Override
    public User login(String username, String pwd) {

        return userDao.FindByNameAndpwd(username,pwd);
    }
}
