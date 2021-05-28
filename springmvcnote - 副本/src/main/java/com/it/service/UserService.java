package com.it.service;

import com.it.po.User;

public interface UserService {
    public User findUserById(int id) throws Exception;
}
