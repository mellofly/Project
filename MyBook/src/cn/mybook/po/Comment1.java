package cn.mybook.po;

import java.util.Date;

/**
 * 
 * <p>Title:Comment1.java</p>
 * <p>Description: 读书笔记和章节的评论的存储结构</p>
 * @author mellofly
 * @date 2017年5月11日下午10:29:12
 */
public class Comment1 {

	private Integer id;

    private String flag;

    private Integer person;
    
    private String user_name;

    private Date time;

    private String note;

    private String message;
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public Integer getPerson() {
		return person;
	}

	public void setPerson(Integer person) {
		this.person = person;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
