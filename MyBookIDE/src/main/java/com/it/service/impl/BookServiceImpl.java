package com.it.service.impl;

import com.it.mapper.BookMapper;
import com.it.po.Book;
import com.it.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookServiceImpl implements BookService{
	@Autowired
	private BookMapper bookMapper;
	
	@Override
	public List<Book> selectListByname(String name) throws Exception {
		return bookMapper.selectListByname(name);
	}

	@Override
	public Book selectByname(String name) throws Exception {
		return bookMapper.selectByname(name);
	}
	
	@Override
	public List<Book> selectListByFlag(String flag) throws Exception {
		return bookMapper.selectListByFlag(flag);
	}
	
	@Override
	public Book selectByFlag(String flag) throws Exception {
		return bookMapper.selectByFlag(flag);
	}

}
