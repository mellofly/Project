package com.it.mapper;

import com.it.po.Chapter;

import java.util.List;

public interface ChapterMapper {
	//查询目录根据名字
	public List<Chapter> selectListChapter(String name)throws Exception;
	//查询目录根据flag
	public Chapter selectChapterByflag(String chapterflag)throws Exception;
}
