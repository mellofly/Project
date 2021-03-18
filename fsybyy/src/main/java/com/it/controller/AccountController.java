package com.it.controller;

import com.it.po.Account;
import com.it.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AccountController {
    @Autowired
    private AccountService accountService;
    /**
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/queryUser")
    public ModelAndView queryUser()throws Exception{
        //调用service查找数据库，
        List<Account> accountList = new ArrayList<Account>();
        // Account account1 = new Account(1,"1212","小明","123456498",'1', null,null,"操作员");
        //accountList.add(account1);
        Account account = accountService.findAccountById(1);
        accountList.add(account);
        //返回ModeAndView
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userList", accountList);
        modelAndView.setViewName("/WEB-INF/jsp/userList.jsp");
        return modelAndView;
    }
}
