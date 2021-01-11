package com.it.controller;

import com.it.po.*;
import com.it.service.CollectionsService;
import com.it.service.CommentService;
import com.it.service.FriendService;
import com.it.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private FriendService friendService;
	
	@Autowired
	private CollectionsService collectionsService;
	
	//用户查询
	@RequestMapping("/queryUser")
	public ModelAndView queryUser()throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		User user = userService.selectByPrimaryKey(1);
		
		modelAndView.addObject("user", user);
		
		modelAndView.setViewName("user/users");
		
		return modelAndView;
	}
	//用户界面
	@RequestMapping("/personal")
	public ModelAndView personal(Integer id,HttpSession session)throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		
		//查找用户信息
		User user = userService.selectByPrimaryKey(id);
		modelAndView.addObject("users",user);
		
		//判断是否为好友
		User userindex = (User) session.getAttribute("user");
		Friend friend1 = new Friend();
		friend1.setUserapply(userindex.getName());
		friend1.setUserName(user.getName());
		int count = friendService.selectIsfriend(friend1);
		modelAndView.addObject("isfriend",count);
		
		//查找笔记信息
		List<Comment1> note = commentService.selectNoteByName(user.getName());
		modelAndView.addObject("notes",note);
		//查找评论信息
		List<Comment> comment = commentService.selectCommentByName(user.getName());
		modelAndView.addObject("comment",comment);
		//好友信息
		List<String> friend = friendService.selectfriend(user.getName());
		List<User> usersfriend = new ArrayList<User>();
		for (String string : friend) {
			User user1 = userService.findUserByName(string);
			usersfriend.add(user1);
		}
		modelAndView.addObject("friends",usersfriend);
		
		//查询收藏
		List<Collections> collectionsList = collectionsService.selectListByUser(user.getName());
		modelAndView.addObject("collectionsList",collectionsList);
		//指定页面
		modelAndView.setViewName("user/personal");
		
		return modelAndView;
	}
	//登录页面
	@RequestMapping("/login")
	public ModelAndView loginUser()throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("user/login");
		
		return modelAndView;
	}
	//check用户
	@RequestMapping("/usercheck")
	public String checkUser(HttpSession session,String username,String password)throws Exception{
		User user = userService.findUserByName(username);
		if(user!=null&&user.getPassword().equals(password)){
			session.removeAttribute("error");;
			session.setAttribute("user", user);
			//登录首页
			return "redirect:/index.action";
		}else{
			String error=new String("用户信息有误，请重新输入");
			session.setAttribute("error", error);
			return "redirect:/login.action";
		}
		
	}
	//登出
	@RequestMapping("/logout")
	public String logoutUser(HttpSession session)throws Exception{
		//清除session
		session.invalidate();
		//重定向到商品列表页面
		return "redirect:/index.action";
	}
	//创建用户界面
	@RequestMapping("/setUser")
	public ModelAndView changUser()throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("user", null);
		
		modelAndView.setViewName("user/setUser");
		
		return modelAndView;
	}
	//提交用户创建
	@RequestMapping("/newUser")
	public ModelAndView setUser(User user,String name,
			MultipartFile picture_pic//接收商品图片
			)throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		
		User finduser= userService.findUserByName(name);
		
		if(finduser!=null){
			modelAndView.addObject("error","用户已经被创建了");
			modelAndView.setViewName("user/setUser");
			return modelAndView;
		}
		else{
			//图片
			//原始名称
			String originalFilename = picture_pic.getOriginalFilename();
			//上传图片
			if(picture_pic!=null && originalFilename!=null && originalFilename.length()>0){
				//存储图片的路径
				String pic_path = "E:\\storypic\\";
				
				//新的名称
				String newFileName=originalFilename;
				//新的图片
				File newFile = new File(pic_path+newFileName);
				
				//将内存中的数据写入磁盘
				picture_pic.transferTo(newFile);
				//将新的图片名称写入到itemsCustom中
				user.setPicture(newFileName);
			}
			 
			userService.insert(user);
			modelAndView.setViewName("user/login");
			return modelAndView;
		}
	}
	
	//添加好友
	@RequestMapping("/addfriend")
	public ModelAndView addfriend(Integer id,String applyname)throws Exception{
		
		Friend friendnew = new Friend();
		
		User usernew = userService.selectByPrimaryKey(id);
		friendnew.setUserapply(applyname);
		friendnew.setUserName(usernew.getName());
		friendnew.setAgree(1);
		int e = friendService.selectIsfriend(friendnew);
		if(e==0){
		friendService.inserapplyfriend(friendnew);
		}
		//返回页面
		ModelAndView modelAndView = new ModelAndView();
		//查找用户信息
		User user = userService.selectByPrimaryKey(id);
		modelAndView.addObject("users",user);
		//查找笔记信息
		List<Comment1> note = commentService.selectNoteByName(user.getName());
		modelAndView.addObject("notes",note);
		//查找评论信息
		List<Comment> comment = commentService.selectCommentByName(user.getName());
		modelAndView.addObject("comment",comment);
		//好友信息
		List<String> friend = friendService.selectfriend(user.getName());
		List<User> usersfriend = new ArrayList<User>();
		for (String string : friend) {
			User user1 = userService.findUserByName(string);
			usersfriend.add(user1);
		}
		modelAndView.addObject("friends",usersfriend);
		modelAndView.setViewName("user/personal");
		
		return modelAndView;
	}
}
