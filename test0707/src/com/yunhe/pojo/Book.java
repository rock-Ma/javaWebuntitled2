package com.yunhe.pojo;

public class Book {
    int id;//编号
    String name;//书名
    String author;//作者
    double price;//价格
    //无参构造
    public Book() {
    }
    //set/get方法
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    //满参构造
    public Book(int id, String name, String author, double price) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
    }
    //重写toString方法

    @Override
    public String toString() {
        return "图书{" +
                "编号：" + id +
                ", 书名：='" + name + '\'' +
                ", 作者：='" + author + '\'' +
                ", 价格：=" + price +
                '}';
    }
}
