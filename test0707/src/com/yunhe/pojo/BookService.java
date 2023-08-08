package com.yunhe.pojo;

public interface BookService {
    //增
    boolean addbook(Book book);
    //删
    boolean deletebook(int id);
    //改
    boolean updatebook(int id,Book book);
    //查
    void selectbook(int id);
    void showall();

}
