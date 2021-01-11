package com.it.service;

import com.it.po.Chapter;

import java.util.List;

public interface ChapterService {
	//查询目录根据名字
	public List<Chapter> selectListChapter(String name)throws Exception;
	//查询目录根据flag
	public Chapter selectChapterByflag(String chapterflag)throws Exception;
}
