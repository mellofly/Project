package com.it.service.impl;

import com.it.mapper.CommentMapper;
import com.it.po.Comment;
import com.it.po.Comment1;
import com.it.po.CommentQuery;
import com.it.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CommentServiceImpl implements CommentService{
	@Autowired
	private CommentMapper commentMapper;
	
	//根据flag查询章节评论内容
	@Override
	public List<Comment1> selectCommentByflag(String flag) throws Exception {
		return commentMapper.selectCommentByflag(flag);
	}
	//根据flag查询章节笔记内容
	@Override
	public List<Comment1> selectNoteByflag(String flag) throws Exception {
		return commentMapper.selectNoteByflag(flag);
	}
	//根据笔记进行笔记评论的查找
	@Override
	public List<Comment>selectCommentByNote(Comment1 note) throws Exception {
		return commentMapper.selectCommentByNote(note);
	}
	//根据评论查询评论的评论
	@Override
	public List<Comment> selectCommentByComment(Comment comment) throws Exception {
		return commentMapper.selectCommentByComment(comment);
	}
	//查找书籍的评论及书籍评论的评论
	@Override
	public List<CommentQuery> selectCommentsBybook(String flag)throws Exception{
		List<CommentQuery> commentsList = new ArrayList<CommentQuery>();
		List<Comment1> comment1 = commentMapper.selectCommentByflag(flag);
		for (Comment1 comment12 : comment1) {
			CommentQuery commentq = new CommentQuery();
			//评论
			List<Comment1> commentq_comment = new ArrayList<Comment1>();
			commentq_comment.add(comment12);
			//评论的评论
			Comment comment= new Comment();
			comment.setFlag(comment12.getFlag());
			comment.setUserName(comment12.getUser_name());
			List<Comment> commentq_comments = commentMapper.selectCommentByComment(comment);
			commentq.setNote(commentq_comment);
			commentq.setComment(commentq_comments);
			commentsList.add(commentq);
		}
		return commentsList;
	}
	
	// 根据名字进行笔记的查找
	@Override
	public List<Comment1> selectNoteByName(String name) throws Exception {
		return commentMapper.selectNoteByName(name);
	}
	//根据名字进行评论的查询
	@Override
	public List<Comment> selectCommentByName(String name) throws Exception {
		return commentMapper.selectCommentByName(name);
	}
	
	
	//查看评论或评论是否存在
	@Override
	public Comment isExist(Comment comment) throws Exception {
		return commentMapper.isExist(comment);
	}
	
	// 添加书籍评论
	@Override
	public void add(Comment comment) throws Exception {
		commentMapper.add(comment);
	}
	//热门用户查询
	@Override
	public List<String> usersort() throws Exception {
		return commentMapper.usersort();
	}
	
	

}
