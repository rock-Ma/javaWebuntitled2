package com.yunhe.service;

import com.yunhe.utils.PageBean;

public interface AccService {
    PageBean findPage(String currentPage, String pageSize);
}
