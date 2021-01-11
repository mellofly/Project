package cn.mybook.mapper;

import java.util.List;

import cn.mybook.po.Friend;

public interface FriendMapper {
	// 查看好友列表 
	public List<String> selectfriend(String string)throws Exception;
		
	//查看是否是好友 
	public int selectIsfriend(Friend friend)throws Exception;
	
	//删除好友 
	public void delectfriend(Friend friend)throws Exception;
		
	// 添加申请 -->
	public void inserapplyfriend(Friend friend)throws Exception;
}
