package controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import po.User;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class UserController implements Controller {

    public ModelAndView handleRequest(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
        //调用service查找数据库，
        List<User> userList = new ArrayList<User>();
        User user1 = new User(1,"1212","小明","123456498",'1', null,null,"操作员");
        userList.add(user1);
        //返回ModeAndView
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userList",userList);
        modelAndView.setViewName("/WEB-INF/jsp/userList.jsp");
        return modelAndView;
    }
}
