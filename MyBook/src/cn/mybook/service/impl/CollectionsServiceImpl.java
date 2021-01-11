package cn.mybook.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.mybook.mapper.CollectionsMapper;
import cn.mybook.po.Collections;
import cn.mybook.po.Sort;
import cn.mybook.service.CollectionsService;

public class CollectionsServiceImpl implements CollectionsService{
	@Autowired
	private CollectionsMapper collectionsMapper;
	//查询用户的订阅列表
	@Override
	public List<Collections> selectListByUser(String name) throws Exception {
		return collectionsMapper.selectListByUser(name);
	}
	//查看是否订阅
	@Override
	public Collections selectUser(Collections collections) throws Exception {
		return collectionsMapper.selectUser(collections);
	}
	//更新用户的书签
	@Override
	public void updatebookmark(Collections collections) throws Exception {
		collectionsMapper.updatebookmark(collections);
	}
	//加入书架
	@Override
	public void insert(Collections collections) throws Exception {
		collectionsMapper.insert(collections);
		
	}
	//删除书架
	@Override
	public void delect(Collections collections) throws Exception {
		collectionsMapper.delect(collections);		
	}
	//查询排行榜
	@Override
	public List<Sort> selectSort() throws Exception {
		return collectionsMapper.selectSort();
	}
}
