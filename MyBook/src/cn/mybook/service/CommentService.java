package cn.mybook.service;

import java.util.List;

import cn.mybook.po.Comment;
import cn.mybook.po.Comment1;
import cn.mybook.po.CommentQuery;

public interface CommentService {
	// 根据flag查询章节评论内容
	public List<Comment1> selectCommentByflag(String flag)throws Exception;
	//根据flag查询章节笔记内容
	public List<Comment1> selectNoteByflag(String flag)throws Exception;
	
	// 根据笔记进行笔记评论的查找
	public List<Comment> selectCommentByNote(Comment1 note)throws Exception;
	//根据评论进行评论的查询
	public List<Comment> selectCommentByComment(Comment comment)throws Exception;
	
	//查找书籍的评论及书籍评论的评论
	public List<CommentQuery> selectCommentsBybook(String flag)throws Exception;
	
	// 根据名字进行笔记的查找
	public List<Comment1> selectNoteByName(String name)throws Exception;
	//根据名字进行评论的查询
	public List<Comment>selectCommentByName(String name)throws Exception;
	
	//查看评论或笔记是否存在
	public Comment isExist(Comment comment)throws Exception;
	
	// 添加书籍评论
	public void add(Comment comment)throws Exception;
	
	//查询热门用户
	public List<String> usersort()throws Exception;
}
