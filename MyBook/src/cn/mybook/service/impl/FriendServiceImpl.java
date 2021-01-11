package cn.mybook.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.mybook.mapper.FriendMapper;
import cn.mybook.po.Friend;
import cn.mybook.service.FriendService;

public class FriendServiceImpl implements FriendService{
	@Autowired
	private FriendMapper friendMapper;
	// 查看好友列表 
	@Override
	public List<String> selectfriend(String name) throws Exception {
		return friendMapper.selectfriend(name);
	}
	//查看是否是好友 
	@Override
	public int selectIsfriend(Friend friend) throws Exception {
		return friendMapper.selectIsfriend(friend);
	}
	//删除好友
	@Override
	public void delectfriend(Friend friend) throws Exception {
		friendMapper.delectfriend(friend);
	}
	// 添加申请 
	@Override
	public void inserapplyfriend(Friend friend) throws Exception {
		friendMapper.inserapplyfriend(friend);
	}

}
