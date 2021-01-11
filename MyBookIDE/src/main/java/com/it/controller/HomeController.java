package com.it.controller;

import com.it.po.Book;
import com.it.po.Sort;
import com.it.po.User;
import com.it.service.BookService;
import com.it.service.CollectionsService;
import com.it.service.CommentService;
import com.it.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
	@Autowired
	private BookService bookService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private UserService userService;
	@Autowired
	private CollectionsService collectionsService;
	
	//首页内容显示
	@RequestMapping("/index")
	public ModelAndView show()throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		//查询书籍
		List<Book> boolist = bookService.selectListByFlag(null);
		List<Book> boolistA = bookService.selectListByFlag("A");
		List<Book> boolistB = bookService.selectListByFlag("B");
		List<Book> boolistC = bookService.selectListByFlag("C");
		List<Book> boolistD = bookService.selectListByFlag("D");
		List<Book> boolistE = bookService.selectListByFlag("E");
		List<Book> boolistF = bookService.selectListByFlag("F");
		//查询书籍排行榜
		List<Sort> booksort = collectionsService.selectSort();
		//查询用户排行榜
		List<String> usersort = commentService.usersort();
		List<User> users =new ArrayList<User>();
		for (String string : usersort) {
			User user = userService.findUserByName(string);
			users.add(user);
		}
		
		modelAndView.addObject("books",boolist);
		modelAndView.addObject("booka",boolistA);
		modelAndView.addObject("bookb",boolistB);
		modelAndView.addObject("bookc",boolistC);
		modelAndView.addObject("bookd",boolistD);
		modelAndView.addObject("booke",boolistE);
		modelAndView.addObject("bookf",boolistF);
		
		modelAndView.addObject("booksort",booksort);
		modelAndView.addObject("usersort",users);
		
		modelAndView.setViewName("index");
		
		return modelAndView;
	}

}
