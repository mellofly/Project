package cn.mybook.po;

import java.util.List;

public class CommentQuery {
	private List<Comment1> note;//读书笔记结构或者书籍的评论
	
	private List<Comment> comment;//评论的存储结构

	public List<Comment1> getNote() {
		return note;
	}

	public void setNote(List<Comment1> note) {
		this.note = note;
	}

	public List<Comment> getComment() {
		return comment;
	}

	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}
	
}
