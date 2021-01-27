package com.it.po;

import java.util.Calendar;
import java.util.Date;

/**
 * 人员基础类
 */
public class People {
    public People(String name ,int age,Calendar birthday){
        this.name=name;
        this.age=age;
        this.birthday=birthday;
    }
    /**
     * 姓名
     */
    public String name;
    /**
     * 年龄
     */
    public int age;
    /**
     * 生日
     */
    public Calendar birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Calendar getBirthday() {
        return birthday;
    }

    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }
    public String toString(){
        return "name:"+name+"  age:"+age+ " birthday:"+birthday;
    }
}
