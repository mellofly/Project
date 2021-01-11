package com.it.service.impl;

import com.it.mapper.ChapterMapper;
import com.it.po.Chapter;
import com.it.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
