package com.yunhe.service.impl;

import com.yunhe.dao.AccDao;
import com.yunhe.dao.impl.AccDaoImpl;
import com.yunhe.entity.Account;
import com.yunhe.service.AccService;
import com.yunhe.utils.PageBean;

import java.util.List;

public class AccServieImpl implements AccService {
    AccDao accDao = new AccDaoImpl();
    @Override
    public PageBean findPage(String currentPage, String pageSize) {
        int cp = Integer.parseInt(currentPage);
        int ps = Integer.parseInt(pageSize);
        PageBean pageBean = new PageBean();
        pageBean.setCurrentPage(cp);
        pageBean.setPageSize(ps);
        List<Account> list = accDao.findByPage(cp,ps);
        pageBean.setList(list);
        pageBean.setTotalCount(accDao.findAll().size());
        return pageBean;
    }
}
