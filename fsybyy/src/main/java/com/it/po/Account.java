package com.it.po;

import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
public class Account {
    /*public Account(int id, String wx_id, String name, String phone, char sex, Calendar birth, Calendar deFendDate, String deFendName){
        this.id=id;
        this.wx_id=wx_id;
        this.name=name;
        this.phone=phone;
        this.sex=sex;
        this.birth=birth;
        this.deFendDate=deFendDate;
        this.deFendName=deFendName;
    }*/
    //用户id
    private int id;
    //微信id
    private String wx_id;
    //用户名称
    private String name;
    //用户电话
    private String phone;
    //用户性别
    private char sex;
    //用户出生日期
    private Calendar birth;
    //维护日期
    private Calendar deFendDate;
    //维护人员
    private String deFendName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWx_id() {
        return wx_id;
    }

    public void setWx_id(String wx_id) {
        this.wx_id = wx_id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public Calendar getBirth() {
        return birth;
    }

    public void setBirth(Calendar birth) {
        this.birth = birth;
    }

    public Calendar getDeFendDate() {
        return deFendDate;
    }

    public void setDeFendDate(Calendar deFendDate) {
        this.deFendDate = deFendDate;
    }

    public String getDeFendName() {
        return deFendName;
    }

    public void setDeFendName(String deFendName) {
        this.deFendName = deFendName;
    }

    public String toString(){
        return "编号："+id+" 姓名："+name+"电话"+phone+" 性别："+sex+" 出生日期："+birth;

    }
}
