package cn.mybook.po;
/**
 * 
 * <p>Title:Book.java</p>
 * <p>Description: 书的信息</p>
 * @author mellofly
 * @date 2017年5月11日下午10:30:31
 */
public class Book {
    private String name;

    private String bookpic;

    private String bookflag;

    private String introduce;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getBookpic() {
        return bookpic;
    }

    public void setBookpic(String bookpic) {
        this.bookpic = bookpic == null ? null : bookpic.trim();
    }

    public String getBookflag() {
        return bookflag;
    }

    public void setBookflag(String bookflag) {
        this.bookflag = bookflag == null ? null : bookflag.trim();
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }
}