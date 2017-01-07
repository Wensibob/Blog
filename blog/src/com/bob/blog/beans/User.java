package com.bob.blog.beans;

 /**
 * com.bob.blog.beans
 * created by BOB on 2016年11月6日
 * description：用户user的bean类 
 */
public class User {
	
	private int userId;
	private String pasd;
	private String userName;
	private String userJpg;
	
	public User() {
		setUserJpg("/blog/assets/images/profile.png");
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getPasd() {
		return pasd;
	}
	public void setPasd(String pasd) {
		this.pasd = pasd;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserJpg() {
		return userJpg;
	}
	public void setUserJpg(String userJpg) {
		this.userJpg = userJpg;
	}
}
