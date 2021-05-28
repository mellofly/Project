package com.it.po;

import java.util.Calendar;
import java.util.Date;

public class Account {
    public Account(int id, String wx_id, String name, String phone, String sex, Date birth, Date deFendDate, String deFendName,String password,String flag,String code,String address){
        this.id=id;
        this.wx_id=wx_id;
        this.name=name;
        this.phone=phone;
        this.sex=sex;
        this.birth=birth;
        this.deFendDate=deFendDate;
        this.deFendName=deFendName;
        this.password=password;
        this.flag=flag;
        this.code=code;
        this.address=address;
    }
    public Account(){

    }
    //用户id
    public int id;
    //微信id
    public String wx_id;
    //密码
    public String password;
    //用户名称
    public String name;
    //用户电话
    public String phone;
    //用户性别
    public String sex;
    //用户出生日期
    public Date birth;
    //用户地址
    public String address;
    //维护日期
    public Date deFendDate;
    //维护人员
    public String deFendName;
    //有效标志
    public String flag;
    //登陆使用code
    public String code;

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Date getDeFendDate() {
        return deFendDate;
    }

    public void setDeFendDate(Date deFendDate) {
        this.deFendDate = deFendDate;
    }

    public String getDeFendName() {
        return deFendName;
    }

    public void setDeFendName(String deFendName) {
        this.deFendName = deFendName;
    }

    public String toString(){
        return "this.id:"+id+"this.wx_id:"+wx_id+"this.name:"+name+"this.phone:"+phone+"this.sex:"+sex+"this.birth:"+birth+"this.deFendDate:"+deFendDate+"this.deFendName:"+deFendName+"this.password:"+password+"this.flag:"+flag+"this.code:"+code+"this.address:"+address;

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}