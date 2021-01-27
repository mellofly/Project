package com.it.tools;

import com.it.po.People;

import java.util.Calendar;

/**
 * 工具类
 */
public  class Tool {
    /**
     * 字符串截取方法
     * @param value 原始字符串
     * @param begin_num 截取起始位
     * @param end_num 截取终止位
     * @return 截取后的字符串
     */
    public static String StringSub(String value,Integer begin_num,Integer end_num){
        return value.substring(begin_num,end_num);
    }

    /**
     * 字符串打印方法（工作台）
     * @param message 需要打印的内容
     */
    public static void SPrint(String message){
        System.out.println("打印内容："+message);
    }

    /**
     * 计算用户的年龄
     * @param p
     */
    public static void computeAge(People p){
        Calendar begin = p.getBirthday();
        Calendar end = Calendar.getInstance();
        int week = begin.compareTo(end);
        p.setAge(week);
        Tool.SPrint(String.valueOf(week));
    }
}
