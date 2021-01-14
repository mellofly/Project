package com.it.controller;

import com.it.po.*;
import com.it.service.*;
import com.it.po.*;
import com.it.service.*;
import com.it.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.it.po.Book;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class BookController {
	@Autowired
	private ChapterService chapterService;
	@Autowired
	private BookService bookService;
	@Autowired
	private CvalueService cvalueService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private CollectionsService collectionsService;
	
	//查询书籍的内容
	@RequestMapping("/getbook")
	public ModelAndView getbook(String flag,HttpServletRequest hservletRequest,HttpSession session)throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		
		//书籍的内容
		Book book = bookService.selectByFlag(flag);
		//书籍的章节
		List<Chapter> chapter = chapterService.selectListChapter(book.getName());
		modelAndView.addObject("book",book);
		modelAndView.addObject("chapter",chapter);
		//书籍的评论
		//List<Comment1> bookcomment = commentService.selectCommentByflag(flag);
		List<CommentQuery> bookcomment = commentService.selectCommentsBybook(flag);
		modelAndView.addObject("bookcomment",bookcomment);
		
		modelAndView.setViewName("book/bookchapter");
		
		return modelAndView;
	}
	
	//章节内容
	//@SuppressWarnings("null")
	@RequestMapping("/bookvalue")
	public ModelAndView bookvalue(String flag)throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		
		Chapter chapter = chapterService.selectChapterByflag(flag);
		
		List<Cvalue> cvalue= cvalueService.selectValue(chapter.getValue());//获取章节内容
		//整合到CvalueQuery结构中
		List<CvalueQuery> cvalueQ = new ArrayList<CvalueQuery>();
		for (Cvalue cv : cvalue) {
			//一次循环的内容
			CvalueQuery cvq = new CvalueQuery();
			cvq.setCvalue(cv);//章节内容
			
			//笔记与评论
			List<CommentQuery> CommentQuery = new ArrayList<CommentQuery>();;
			List<Comment1> note = commentService.selectNoteByflag(cv.getValueflag());//查找笔记
			for (Comment1 com1 : note) {
				CommentQuery commentQ = new CommentQuery();
				List<Comment1> notelist = new ArrayList<Comment1>();
				notelist.add(com1);
				commentQ.setNote(notelist);//设置笔记
				List<Comment> commentList = commentService.selectCommentByNote(com1);//查询笔记的评论；
				commentQ.setComment(commentList);//设置笔记的评论
				CommentQuery.add(commentQ);
			}
			cvq.setComment1ist(CommentQuery);
			//段落评论
			List<CommentQuery> chapterComment = commentService.selectCommentsBybook(cv.getValueflag());
			cvq.setChaptercomment(chapterComment);
			cvalueQ.add(cvq);
		}
		
		modelAndView.addObject("cvalueQQ",cvalueQ);
		modelAndView.addObject("chapter",chapter);
		
		modelAndView.setViewName("book/bookvalue");
		
		return modelAndView;
	}
	
	//书籍搜索根据名称
	@RequestMapping("/bookquery")
	public ModelAndView querybook(String bookname)throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		List<Book> book = bookService.selectListByname(bookname);
		
		modelAndView.addObject("books",book);
		modelAndView.setViewName("book/book");
		return modelAndView;
	}
	
	//书籍种类查询书籍
	@RequestMapping("/booktypequery")
	public ModelAndView querybooktype(String bookflag)throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		List<Book> book = bookService.selectListByFlag(bookflag);
		
		modelAndView.addObject("books",book);
		modelAndView.setViewName("book/book");
		return modelAndView;
	}
	
	//添加个性书签
	@RequestMapping("/collection")
	public ModelAndView addCollection(String bookname,String chapterflag,String personalityname,String username)throws Exception{
		Collections collections = new Collections();
		collections.setBook_name(bookname);
		collections.setChapter_flag(chapterflag);
		collections.setPersonalityname(personalityname);
		collections.setUser_name(username);
		Collections collections1 = collectionsService.selectUser(collections);
		if(collections1==null)
		{
			collectionsService.insert(collections);
		}
		else{
			collections.setId(collections1.getId());
			collectionsService.updatebookmark(collections);
		}
		
		//重新书籍页面
		ModelAndView modelAndView = new ModelAndView();
		
		Chapter chapter = chapterService.selectChapterByflag(collections.getChapter_flag());
		
		List<Cvalue> cvalue= cvalueService.selectValue(chapter.getValue());//获取章节内容
		//整合到CvalueQuery结构中
		List<CvalueQuery> cvalueQ = new ArrayList<CvalueQuery>();
		for (Cvalue cv : cvalue) {
			//一次循环的内容
			CvalueQuery cvq = new CvalueQuery();
			cvq.setCvalue(cv);//章节内容
			
			//笔记与评论
			List<CommentQuery> CommentQuery = new ArrayList<CommentQuery>();;
			List<Comment1> note = commentService.selectNoteByflag(cv.getValueflag());//查找笔记
			for (Comment1 com1 : note) {
				CommentQuery commentQ = new CommentQuery();
				List<Comment1> notelist = new ArrayList<Comment1>();
				notelist.add(com1);
				commentQ.setNote(notelist);//设置笔记
				List<Comment> commentList = commentService.selectCommentByNote(com1);//查询笔记的评论；
				commentQ.setComment(commentList);//设置笔记的评论
				CommentQuery.add(commentQ);
			}
			cvq.setComment1ist(CommentQuery);
			//段落评论
			List<CommentQuery> chapterComment = commentService.selectCommentsBybook(cv.getValueflag());
			cvq.setChaptercomment(chapterComment);
			cvalueQ.add(cvq);
		}
		
		modelAndView.addObject("cvalueQQ",cvalueQ);
		modelAndView.addObject("chapter",chapter);
		
		modelAndView.setViewName("book/bookvalue");
		
		return modelAndView;
	}
	
	//添加书籍的评论
	@RequestMapping("/addcomment")
	public ModelAndView addcomment(
			String message,String flag,String username,String name,String note1
			)throws Exception{
		//存储起来。
		Comment iscomment = new Comment();
		iscomment.setFlag(flag);
		iscomment.setMessage(message);
		iscomment.setName(name);
		iscomment.setUserName(username);
		iscomment.setNote(note1);
		iscomment.setTime(new Date());
		if(name==null){
			
		}/*
		Comment1 commentbook = new Comment1();
		commentbook.setFlag(flag);
		commentbook.setMessage(message);
		commentbook.setUser_name(username);
		commentbook.setTime(new Date());
		//验证评论是否存在
		Comment commentbook1 = new Comment();
		commentbook1.setFlag(flag);
		commentbook1.setUserName(username);
		commentbook1.setNote("0");*/
		Comment yes = commentService.isExist(iscomment);
		if(yes==null){
			//添加评论
			commentService.add(iscomment);
		}
		String flag1=null;
		if(flag.length()>4){
			flag1 = cvalueService.selectbookflag(iscomment.getFlag());
		}
		else{
			flag1=flag;
		}
		
		//重新显示章节内容
		ModelAndView modelAndView = new ModelAndView();
		if(flag.length()>4){
			Chapter chapter = chapterService.selectChapterByflag(flag1);
			
			List<Cvalue> cvalue= cvalueService.selectValue(chapter.getValue());//获取章节内容
			//整合到CvalueQuery结构中
			List<CvalueQuery> cvalueQ = new ArrayList<CvalueQuery>();
			for (Cvalue cv : cvalue) {
				//一次循环的内容
				CvalueQuery cvq = new CvalueQuery();
				cvq.setCvalue(cv);//章节内容
				
				//笔记与评论
				List<CommentQuery> CommentQuery = new ArrayList<CommentQuery>();;
				List<Comment1> note = commentService.selectNoteByflag(cv.getValueflag());//查找笔记
				for (Comment1 com1 : note) {
					CommentQuery commentQ = new CommentQuery();
					List<Comment1> notelist = new ArrayList<Comment1>();
					notelist.add(com1);
					commentQ.setNote(notelist);//设置笔记
					List<Comment> commentList = commentService.selectCommentByNote(com1);//查询笔记的评论；
					commentQ.setComment(commentList);//设置笔记的评论
					CommentQuery.add(commentQ);
				}
				cvq.setComment1ist(CommentQuery);
				//章节评论
				List<CommentQuery> chapterComment = commentService.selectCommentsBybook(cv.getValueflag());
				cvq.setChaptercomment(chapterComment);
				cvalueQ.add(cvq);
			}
			
			modelAndView.addObject("cvalueQQ",cvalueQ);
			modelAndView.addObject("chapter",chapter);
			
			modelAndView.setViewName("book/bookvalue");
		}
		else{
			//书籍的内容
			Book book = bookService.selectByFlag(flag);
			//书籍的章节
			List<Chapter> chapter = chapterService.selectListChapter(book.getName());
			modelAndView.addObject("book",book);
			modelAndView.addObject("chapter",chapter);
			//书籍的评论
			//List<Comment1> bookcomment = commentService.selectCommentByflag(flag);
			List<CommentQuery> bookcomment = commentService.selectCommentsBybook(flag);
			modelAndView.addObject("bookcomment",bookcomment);
			
			modelAndView.setViewName("book/bookchapter");
			
			return modelAndView;
		}
		return modelAndView;
	}
}
