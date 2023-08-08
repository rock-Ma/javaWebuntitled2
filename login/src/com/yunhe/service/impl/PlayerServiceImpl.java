package com.yunhe.service.impl;

import com.yunhe.dao.PlayerDao;
import com.yunhe.dao.impl.PlayerDaoImpl;
import com.yunhe.service.PlayerService;

public class PlayerServiceImpl implements PlayerService {
    PlayerDao playerDao = new PlayerDaoImpl();
    @Override
    public int regist(String username, String sex, String location, String hobby, String jieshao) {

        return playerDao.regist(username,sex,location,hobby,jieshao);
    }
}
