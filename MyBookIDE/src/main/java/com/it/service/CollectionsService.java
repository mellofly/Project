package com.it.service;

import com.it.po.Collections;
import com.it.po.Sort;

import java.util.List;

public interface CollectionsService {
	//查找订阅
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
