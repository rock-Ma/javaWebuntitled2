package com.yunhe.entity;

public class Account {
    private int id;
    private String cname;
    private double money;
    private String paytype;
    private String createtime;
    private String description;

    public Account() {
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", cname='" + cname + '\'' +
                ", money=" + money +
                ", paytype='" + paytype + '\'' +
                ", createtime='" + createtime + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getPaytype() {
        return paytype;
    }

    public void setPaytype(String paytype) {
        this.paytype = paytype;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Account(int id, String cname, double money, String paytype, String createtime, String description) {
        this.id = id;
        this.cname = cname;
        this.money = money;
        this.paytype = paytype;
        this.createtime = createtime;
        this.description = description;
    }
}
