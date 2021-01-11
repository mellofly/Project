package com.it.service;

import com.it.po.User;

public interface UserService {
	//查找用户
	public User selectByPrimaryKey(Integer id)throws Exception;
	//查找用用户根据名字
	public User findUserByName(String name)throws Exception;
	//注册新用户
    public void  insert(User record)throws Exception;
    //更新用户
    public void updateByPrimaryKey(User record);
}
