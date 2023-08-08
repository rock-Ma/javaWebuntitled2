package com.yunhe.dao;

import com.yunhe.entity.User;

public interface UserDao {
    User FindByNameAndpwd(String username, String pwd);
}
