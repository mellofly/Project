package com.it.po;
/**
 * 
 * <p>Title:Cvalue.java</p>
 * <p>Description:章节的内容 </p>
 * @author mellofly
 * @date 2017年5月11日下午10:35:03
 */
public class Cvalue {
    private Integer id;

    private String chapter_value;

    private String valueflag;

    private String value;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChapterValue() {
        return chapter_value;
    }

    public void setChapterValue(String chapter_value) {
        this.chapter_value = chapter_value == null ? null : chapter_value.trim();
    }

    public String getValueflag() {
        return valueflag;
    }

    public void setValueflag(String valueflag) {
        this.valueflag = valueflag == null ? null : valueflag.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }
}