package com.it.po;

import java.util.Date;

public class User {
    //用户id
    private int id;
    //用户名称
    private String name;
    //用户密码
    private char password;
    //用户头像
    private Date picture;
    //电话
    private Date phone;
    //邮箱
    private String mail;

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

    public char getPassword() {
        return password;
    }

    public void setPassword(char password) {
        this.password = password;
    }

    public Date getPicture() {
        return picture;
    }

    public void setPicture(Date picture) {
        this.picture = picture;
    }

    public Date getPhone() {
        return phone;
    }

    public void setPhone(Date phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String toString(){
        return "编号："+id+" 姓名："+name+" 电话："+phone+" 邮箱："+mail +"头像：" +picture;

    }
}
