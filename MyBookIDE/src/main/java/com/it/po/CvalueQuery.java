package com.it.po;

import java.util.List;

/**
 * 
 * <p>Title:CvalueQuery.java</p>
 * <p>Description:章节内容的查询结果，包括章节内容和每个章节的笔记及评论和章节评论 </p>
 * @author mellofly
 * @date 2017年5月11日下午10:39:26
 */
public class CvalueQuery {
	
	private Cvalue cvalue;
	
	private List<CommentQuery> comment1ist;//读书笔记及笔记的评论
	
	private List<CommentQuery> chaptercomment;//章节的评论
	
	public Cvalue getCvalue() {
		return cvalue;
	}

	public void setCvalue(Cvalue cvalue) {
		this.cvalue = cvalue;
	}

	public List<CommentQuery> getComment1ist() {
		return comment1ist;
	}

	public void setComment1ist(List<CommentQuery> comment1ist) {
		this.comment1ist = comment1ist;
	}

	public List<CommentQuery> getChaptercomment() {
		return chaptercomment;
	}

	public void setChaptercomment(List<CommentQuery> chaptercomment) {
		this.chaptercomment = chaptercomment;
	}


}
