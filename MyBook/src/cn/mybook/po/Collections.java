package cn.mybook.po;
/**
 * 
 * <p>Title:Collections.java</p>
 * <p>Description: 收藏与书签存储</p>
 * @author mellofly
 * @date 2017年5月11日下午10:32:56
 */
public class Collections {
    private Integer id;

    private String user_name;

    private String book_name;

    private String personalityname;

    private String chapter_flag;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getPersonalityname() {
		return personalityname;
	}

	public void setPersonalityname(String personalityname) {
		this.personalityname = personalityname;
	}

	public String getChapter_flag() {
		return chapter_flag;
	}

	public void setChapter_flag(String chapter_flag) {
		this.chapter_flag = chapter_flag;
	}

    
}