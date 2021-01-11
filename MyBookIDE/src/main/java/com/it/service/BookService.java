package com.it.service;

import com.it.po.Book;

import java.util.List;

public interface BookService {
	//查询书籍列表通过名字
    public List<Book> selectListByname(String name)throws Exception;
  //查询书籍列表通过名字
    public Book selectByname(String name)throws Exception;
    //查询书籍列表通过flag
    public List<Book> selectListByFlag(String flag)throws Exception;
  //查询书籍列表通过flag
    public Book selectByFlag(String flag)throws Exception;
}
