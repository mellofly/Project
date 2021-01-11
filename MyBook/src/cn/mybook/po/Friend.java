package cn.mybook.po;
/**
 * 
 * <p>Title:Friend.java</p>
 * <p>Description: 好友的存储</p>
 * @author mellofly
 * @date 2017年5月11日下午10:35:22
 */
public class Friend {
   
    private String user_name;//好友的名字

    private Integer agree;

    private String userapply;//申请人的名字


    public String getUserName() {
        return user_name;
    }

    public void setUserName(String userName) {
        this.user_name = userName == null ? null : userName.trim();
    }

    public Integer getAgree() {
        return agree;
    }

    public void setAgree(Integer agree) {
        this.agree = agree;
    }

    public String getUserapply() {
        return userapply;
    }

    public void setUserapply(String userapply) {
        this.userapply = userapply == null ? null : userapply.trim();
    }
}