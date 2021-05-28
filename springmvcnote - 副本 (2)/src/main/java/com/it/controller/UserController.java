package com.it.controller;

import com.it.po.Account;
import com.it.service.AccountService;
import com.it.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    AccountService accountService;
    @RequestMapping("/queryUser")
    public ModelAndView queryUser() throws Exception {
        //调用service查找数据库，
        List<Account> accountlist = new ArrayList<Account>();
        accountlist.add(accountService.findAccountById(1));
        //userList.add(new User(1,"1212","小明","123456498",'1', null,null,"操作员"));
        //返回ModeAndView
        ModelAndView modelAndView = new ModelAndView();
        //System.out.println(accountlist.get(0).toString());
        modelAndView.addObject("accountlist",accountlist);
        modelAndView.setViewName("/WEB-INF/jsp/userList.jsp");
        return modelAndView;
    }
}