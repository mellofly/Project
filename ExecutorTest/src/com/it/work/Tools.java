package com.it.work;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

public class Tools {
    private Hashtable<String,String> mapValue= new Hashtable<String,String>();
    public  void setList(Map<String,String> value){
        mapValue.putAll(value);
    }
    public String getListValue(String indexvalue){
        ArrayList<String> reValue = new ArrayList<String>();
        reValue.add("操作方式为：indexvalue"+indexvalue+";");
        for(int i=0; i<indexvalue.length();i++){
            reValue.add(mapValue.get(indexvalue.substring(i,i+1)));
        }
        return reValue.toString();
    }
}
