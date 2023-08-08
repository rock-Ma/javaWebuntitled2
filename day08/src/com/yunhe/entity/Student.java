package com.yunhe.entity;

public class Student {
    private int id;
    private String sname;
    private String sex;

    @Override
    public String toString() {
        return "学生{" +
                "编号=" + id +
                ", 姓名='" + sname + '\'' +
                ", 性别='" + sex + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Student() {
    }

    public Student(int id, String sname, String sex) {
        this.id = id;
        this.sname = sname;
        this.sex = sex;
    }
}
