package cn.yuhe.service;

import cn.yuhe.dao.UserDao;
import cn.yuhe.entity.User;

public class UserService {
    UserDao userDao = new UserDao();

    public User login(String username, String password){
        return userDao.findUserByUsernameAndPassword(username,password);
    }

}
