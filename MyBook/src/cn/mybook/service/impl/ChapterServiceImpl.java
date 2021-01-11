package cn.mybook.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.mybook.mapper.ChapterMapper;
import cn.mybook.po.Chapter;
import cn.mybook.service.ChapterService;

public class ChapterServiceImpl implements ChapterService{
	@Autowired
	private ChapterMapper chapterMapper;
	@Override
	public List<Chapter> selectListChapter(String name) throws Exception {
		return chapterMapper.selectListChapter(name);
	}
	@Override
	public Chapter selectChapterByflag(String chapterflag) throws Exception {
		
		return chapterMapper.selectChapterByflag(chapterflag);
	}
	
}
