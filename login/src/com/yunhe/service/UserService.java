package com.yunhe.service;

import com.yunhe.entity.User;

public interface UserService {
    User login(String username, String pwd);
}
