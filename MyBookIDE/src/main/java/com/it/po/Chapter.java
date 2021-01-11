package com.it.po;
/**
 * 
 * <p>Title:Chapter.java</p>
 * <p>Description: 书的章节内容</p>
 * @author mellofly
 * @date 2017年5月11日下午10:30:53
 */
public class Chapter {
    private String value;

    private String book_name;

    private String chapterflag;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public String getBookName() {
        return book_name;
    }

    public void setBookName(String bookName) {
        this.book_name = bookName == null ? null : bookName.trim();
    }

    public String getChapterflag() {
        return chapterflag;
    }

    public void setChapterflag(String chapterflag) {
        this.chapterflag = chapterflag == null ? null : chapterflag.trim();
    }
}