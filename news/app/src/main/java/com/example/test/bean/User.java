package com.example.test.bean;

public class User {
    private int  id;
    private int  password;
    private int  sex;
    public User() {

    }
    public User(int id, int password, int sex) {
        this.id = id;
        this.password = password;
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }
}
