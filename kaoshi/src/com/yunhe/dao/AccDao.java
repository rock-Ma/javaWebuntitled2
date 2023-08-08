package com.yunhe.dao;

import com.yunhe.entity.Account;

import java.util.Collection;
import java.util.List;

public interface AccDao {
    List<Account> findByPage(int cp, int ps);

    List<Account> findAll();
}
