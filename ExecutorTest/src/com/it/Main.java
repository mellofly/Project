package com.it;

import com.it.tools.Tool;
import com.it.work.Tools;

import java.util.Hashtable;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	    // write your code here
        //String value = Tool.StringSub("abcasd",1,3);
        //Tool.SPrint(value);
        //打印还款方式：
        Tools wkTool = new Tools();
        wkTool.setList(makeMap());
        Tool.SPrint(wkTool.getListValue("c486a973512b0"));

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
