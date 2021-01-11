package com.it.mapper;

import com.it.po.User;

public interface UserMapper {
	//查找用用户根据ID
	public User selectByPrimaryKey(Integer id)throws Exception;
	//查找用用户根据名字
	public User findUserByName(String name)throws Exception;
	//注册新用户
    public void  insert(User record)throws Exception;
    //更新用户
    public void updateByPrimaryKey(User record);
}