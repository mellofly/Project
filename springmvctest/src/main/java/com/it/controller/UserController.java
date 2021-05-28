package com.it.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.it.po.User;

import java.util.ArrayList;
import java.util.List;
//使用@Controller标识，他是一个控制器
@Controller
public class UserController{
    //@RequestMapping实现对queryUser方法与url进行映射
    @RequestMapping("/queryUser.action")
    public ModelAndView queryUser() throws Exception {
        //调用service查找数据库，
        List<User> userList = new ArrayList<User>();
        User user1 = new User();
        user1.setId(1);
        user1.setName("小明");
        userList.add(user1);
        //返回ModeAndView
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userList",userList);
        modelAndView.setViewName("userList");
        return modelAndView;
    }
}
