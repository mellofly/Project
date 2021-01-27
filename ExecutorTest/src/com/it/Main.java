package com.it;

import com.it.po.People;
import com.it.tools.Tool;
import com.it.work.Tools;

import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	    // write your code here
        //String value = Tool.StringSub("abcasd",1,3);
        //Tool.SPrint(value);
        //打印还款方式：

        /*Tools wkTool = new Tools();
        wkTool.setList(makeMap());
        try {
            Tool.SPrint(wkTool.getListValue("c486a973512b0"));
        }catch (Exception e){
            Tool.SPrint(e.getMessage());
        }*/
        Calendar cDate = Calendar.getInstance();
        cDate.set(2021,1,1);
        People p = new People("小明",14,cDate);
        Tool.SPrint(p.toString());
        Tool.computeAge(p);
        Tool.SPrint(p.toString());
    }

    public static Map<String,String> makeMap(){
        Map<String,String> mpValue = new Hashtable<String,String>();
        mpValue.put("0","本金");
        mpValue.put("1","应收应计利息");
        mpValue.put("2","催收应计利息");
        mpValue.put("3","应收欠息");
        mpValue.put("4","催收欠息");
        mpValue.put("5","应收应计罚息");
        mpValue.put("6","催收应计罚息");
        mpValue.put("7","应收罚息");
        mpValue.put("8","催收罚息");
        mpValue.put("9","应计复息");
        mpValue.put("a","复息");
        mpValue.put("b","罚金");
        mpValue.put("c","应收费用");
        return mpValue;
    }

}
