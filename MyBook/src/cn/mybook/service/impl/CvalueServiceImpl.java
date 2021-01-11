package cn.mybook.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.mybook.mapper.CvalueMapper;
import cn.mybook.po.Cvalue;
import cn.mybook.service.CvalueService;

public class CvalueServiceImpl implements CvalueService{

	@Autowired
	private CvalueMapper cvalueMapper;
	//查看章节内容
	@Override
	public List<Cvalue> selectValue(String chapterValue) throws Exception {
		return cvalueMapper.selectValue(chapterValue);
	}
	//查找评论
	@Override
	public String selectflag(String value) throws Exception {
		return cvalueMapper.selectflag(value);
	}
	//通过章节flag查找书籍的flag
	@Override
	public String selectbookflag(String cvalueflag) throws Exception {
		return cvalueMapper.selectbookflag(cvalueflag);
	}
}
