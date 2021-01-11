package com.it.service.impl;

import com.it.mapper.UserMapper;
import com.it.po.User;
import com.it.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;
	//查询用户
	@Override
	public User selectByPrimaryKey(Integer id) throws Exception {
		
		return userMapper.selectByPrimaryKey(id);
	}
	//根据用户名查询用户
	@Override
	public User findUserByName(String name) throws Exception {
		return userMapper.findUserByName(name);
	}
	//创建用户
	@Override
	public void insert(User record) throws Exception {
		userMapper.insert(record);
	}
	//更新用户
	@Override
	public void updateByPrimaryKey(User user) {
		userMapper.updateByPrimaryKey(user);
	}
	
}
