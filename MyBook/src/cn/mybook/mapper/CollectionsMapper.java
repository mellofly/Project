package cn.mybook.mapper;

import java.util.List;

import cn.mybook.po.Collections;
import cn.mybook.po.Sort;
import cn.mybook.po.User;

public interface CollectionsMapper {
	//查找书架
	public List<Collections> selectListByUser(String name)throws Exception;
	
	//查看是否订阅
	public Collections selectUser(Collections collections)throws Exception;
	
	//更新用户书签
	public void updatebookmark(Collections collections)throws Exception;
	
	//添加书架
	public void insert(Collections collections)throws Exception;
	
	//取消订阅
	public void delect(Collections collections)throws Exception;
	
	//查看订阅排行
	public List<Sort> selectSort()throws Exception;
}
