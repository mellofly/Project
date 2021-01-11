package com.it.service;

import com.it.po.Friend;

import java.util.List;

public interface FriendService {
		// 查看好友列表 
		public List<String> selectfriend(String string)throws Exception;
			
		//查看是否是好友 
		public int selectIsfriend(Friend friend)throws Exception;
		
		//删除好友 
		public void delectfriend(Friend friend)throws Exception;
			
		// 添加申请 -->
		public void inserapplyfriend(Friend friend)throws Exception;
}
