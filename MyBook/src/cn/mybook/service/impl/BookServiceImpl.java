package cn.mybook.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.mybook.mapper.BookMapper;
import cn.mybook.po.Book;
import cn.mybook.service.BookService;

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
