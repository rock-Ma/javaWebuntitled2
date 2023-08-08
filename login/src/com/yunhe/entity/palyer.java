package com.yunhe.entity;

public class palyer {
    private int id;
    private String username;
    private String sex;
    private String location;
    private String hobby;
    private String jieshao;

    public palyer() {
    }

    @Override
    public String toString() {
        return "palyer{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", location='" + location + '\'' +
                ", hobby='" + hobby + '\'' +
                ", jieshao='" + jieshao + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getJieshao() {
        return jieshao;
    }

    public void setJieshao(String jieshao) {
        this.jieshao = jieshao;
    }

    public palyer(int id, String username, String sex, String location, String hobby, String jieshao) {
        this.id = id;
        this.username = username;
        this.sex = sex;
        this.location = location;
        this.hobby = hobby;
        this.jieshao = jieshao;
    }
}
