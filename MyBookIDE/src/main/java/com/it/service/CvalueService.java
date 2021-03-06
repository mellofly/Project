package com.it.service;

import com.it.po.Cvalue;

import java.util.List;

public interface CvalueService {
	//查看章节内容
	public List<Cvalue> selectValue(String chapterValue)throws Exception;
	
	//查找评论
	public String selectflag(String value)throws Exception;
	
	//通过章节flag查找书籍的flag
	public String selectbookflag(String cvalueflag)throws Exception;
}
