package cn.mybook.po;

import java.util.Date;
/**
 * 
 * <p>Title:Comment.java</p>
 * <p>Description:笔记评论或者评论的评论的存储结构 </p>
 * @author mellofly
 * @date 2017年5月11日下午10:32:19
 */
public class Comment {
    private Integer id;

    private String flag;

    private String name;

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
        this.flag = flag == null ? null : flag.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

	
	public Integer getPerson() {
		return person;
	}

	public void setPerson(Integer person) {
		this.person = person;
	}

	public String getUserName() {
        return user_name;
    }

    public void setUserName(String user_name) {
        this.user_name = user_name == null ? null : user_name.trim();
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
        this.note = note == null ? null : note.trim();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }
}