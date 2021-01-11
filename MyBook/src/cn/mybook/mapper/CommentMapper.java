package cn.mybook.mapper;

import java.util.List;

import cn.mybook.po.Comment;
import cn.mybook.po.Comment1;

public interface CommentMapper {
	// 根据flag查询章节评论内容
	public List<Comment1> selectCommentByflag(String flag)throws Exception;
	//根据flag查询章节的笔记内容
	public List<Comment1> selectNoteByflag(String flag)throws Exception;
	
	// 根据笔记进行笔记评论的查找
	public List<Comment> selectCommentByNote(Comment1 note)throws Exception;
	//根据评论进行评论的查询
	public List<Comment> selectCommentByComment(Comment comment)throws Exception;
	
	// 根据名字进行笔记的查找
	public List<Comment1> selectNoteByName(String name)throws Exception;
	//根据名字进行评论的查询
	public List<Comment> selectCommentByName(String name)throws Exception;
	
	//查看评论是否存在
	public Comment isExist(Comment comment)throws Exception;
	
	// 添加书籍评论
	public void add(Comment comment)throws Exception;
	
	//查询热门用户
	public List<String> usersort()throws Exception;
}
