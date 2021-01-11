package cn.mybook.service;

import java.util.List;

import cn.mybook.po.Chapter;

public interface ChapterService {
	//查询目录根据名字
	public List<Chapter> selectListChapter(String name)throws Exception;
	//查询目录根据flag
	public Chapter selectChapterByflag(String chapterflag)throws Exception;
}
