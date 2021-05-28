package com.it.controller;

import com.alibaba.fastjson.JSONObject;
import com.it.po.Account;
import com.it.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.alibaba.fastjson.JSON;
import org.apache.commons.io.IOUtils;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value="userinfo")
public class Hello {
    /**
     * consumes 用于指定处理何种请求的提交内容类型context-type，如果不是指定的类型，则不处理
     * method 用于指定请求的方法，可以设置单个或多个，如果请求方法不满足条件则会请求失败。设置post，就只支持post请求，不设置这个属性就两种请求都支持
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(params = "hello", consumes="application/json", method = RequestMethod.POST)
    @ResponseBody//这个注解是把返回的map自动封装成json数据的，但是需要在spring.xml里配置，不然会报406错误
    public Map<String,Object> testModel(HttpServletRequest request, HttpServletResponse response) throws Exception{
        Map<String,Object> responseMap = new HashMap<String, Object>();//用来存接口返回信息
        try{
            String data= IOUtils.toString(request.getInputStream());//获取传入的json
            Map<String, Object> requsetMap = new HashMap<String, Object>();//用来保存接口请求信息
            System.out.println("传来的Json是：" + data);
            requsetMap = JSON.parseObject(data);//把json转成map
            System.out.println("打印requsetMap："+requsetMap.toString());

            /*********业务逻辑开始**********/
            //下面只是模拟，所以我简单处理一下
            Account user = new Account();
            String  username = requsetMap.get("name").toString();
            String  age = requsetMap.get("age").toString();
            user.setId(Integer.parseInt(age));
            user.setName(username);
            user.setPhone("hahahhahaha");


            System.out.println("打印user" + user.toString());
            //我把这个user对象直接存入返回的map中去了
            responseMap.put("data", user);
            //一般做接口开发，都会用到下面两个，一个是code代表你的接口状态，第二是msg，代表接口的情况
            responseMap.put("code", "0");//状态码
            responseMap.put("msg", "请求成功");//信息描述

            /*********业务逻辑结束**********/

        }catch(Exception e){
            responseMap.put("data", "");
            responseMap.put("code", "1");//状态码
            responseMap.put("msg", "请求失败，系统异常");//信息描述
            e.printStackTrace();
        }
        System.out.println("接口返回的json：" + JSON.toJSONString(responseMap));
        return responseMap;
    }

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
