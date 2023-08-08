package com.yunhe.pojo;

import java.util.ArrayList;
import java.util.List;

public class BookServiceImp implements BookService{
    //定义list数组用于存储书籍信息
    List<Book> li = new ArrayList<Book>();

    @Override
    public boolean addbook(Book book) {

        for (int i = 0; i < li.size(); i++) {
            if (li.get(i).getId() == book.id){
                System.out.println("id重复！添加失败");
                return false;
            }
        }
        li.add(book);
        System.out.println("书籍添加成功");
        return true;
    }

    @Override
    public boolean deletebook(int id) {
        int index = -1;
        for (int i = 0; i < li.size(); i++) {
            if(li.get(i).id == id){
                index = i;
            }
        }
        if(index!=-1){
            li.remove(index);
            System.out.println("书籍删除成功");
            return true;
        }
        else {
            System.out.println("书籍删除失败！");
            return false;
        }
    }

    @Override
    public boolean updatebook(int id, Book book) {
        for (int i = 0; i < li.size(); i++) {
            if(li.get(i).getId() == id){
                li.set(i,book);
                System.out.println("数据修改成功");
                return true;
            }
        }
        System.out.println("未查到该书籍，数据修改失败！");
        return false;
    }

    @Override
    public void selectbook(int id) {
        System.out.println("查找结果如下");

        for (int i = 0; i < li.size(); i++) {
            //使用字符串的equals方法比较

            if(li.get(i).getId()==id){
                System.out.println(li.get(i));
            }
        }


    }

    @Override
    public void showall() {
        for (Book b:li
             ) {
            System.out.println(b);
        }
    }
}
