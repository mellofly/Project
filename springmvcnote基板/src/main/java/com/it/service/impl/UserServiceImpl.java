package com.it.service.impl;

import com.it.po.User;
import com.it.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public User findUserById(int id) throws Exception {
        User user1 = new User(1,"1212","小明","123456498",'1', null,null,"操作员");
        return user1;
    }
}
