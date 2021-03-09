package com.it.po;

import java.util.Calendar;
import java.util.Date;

public class Account {

    //用户id
    private int id;
    //用户名称
    private String name;
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
        return "编号："+id+" 姓名："+name+" 性别："+sex+" 出生日期："+birth;

    }
}
