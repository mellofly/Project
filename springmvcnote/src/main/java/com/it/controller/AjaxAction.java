package com.it.controller;

import com.it.json.Bean;
import com.it.json.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class AjaxAction{
    @RequestMapping(method= RequestMethod.POST,value="/bean2json")
    public @ResponseBody
    User bean2json(User user){
        System.out.println(user);
        return user;
    }
    @RequestMapping(method=RequestMethod.POST,value="/listbean2json")
    public @ResponseBody List<User> listbean2json(Bean bean){
        List<User> listuser=bean.getListuser();
        return listuser;
    }
    @RequestMapping(method=RequestMethod.POST,value="/mapbean2json")
    public @ResponseBody Map<String,Object> mapbean2json(Bean bean){
        List<User> listuser=bean.getListuser();
        Map<String, Object> mapuser=new HashMap<String, Object>();
        mapuser.put("success",true);
        mapuser.put("detail",listuser);
        return mapuser;
    }
    //表单提交
    @RequestMapping(method=RequestMethod.POST,value="/json2json")
    public @ResponseBody User bean2json(@RequestBody Map<String, String> map){
        String username="";
        int age=0;
        if(map.containsKey("username")){
            username=map.get("username");
        }
        if(map.containsKey("age")){
            age=Integer.parseInt(map.get("age"));
        }
        User user=new User(1,username,age);
        return user;
    }
}
