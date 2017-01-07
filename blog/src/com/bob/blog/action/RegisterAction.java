package com.bob.blog.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.bob.blog.beans.User;
import com.bob.blog.dao.BlogsUserDao;
import com.bob.blog.vo.LoginVO;

/**
 * com.bob.blog.action
 * created by BOB on 2016年11月7日
 * description：注册操作的action
 */
public class RegisterAction {
	private String userid;
	private String userpasd;
	private String username;
	private String register_result="fail";
	
	public String register(){
		HttpServletRequest request = ServletActionContext.getRequest (); //取得request
		LoginVO loginVO=new LoginVO();
		if ( (userid.equals("")||userid==null) || (userpasd.equals("")||userpasd==null) ||(username.equals("")||username==null) ) {
			register_result="empty";
			request.setAttribute("info", "请将表单填写完整😏");
		}else if (!(loginVO.checkUserIdExist(Integer.parseInt(userid)))) {
			User new_user=loginVO.packUsers(userid,userpasd,username);
			boolean result=new BlogsUserDao().addUser(new_user);
			if (result) {
				register_result="success";
				request.setAttribute("info","恭喜你注册成功😋！您可以<a href =/blog/client/login.jsp >登录</a>啦！");
			}else{
				request.setAttribute("info", "注册失败😏，请重新注册呗！");
			}
		}else{
			request.setAttribute("info", "注册失败😏，请重新注册呗！");
		}
		return register_result;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserpasd() {
		return userpasd;
	}

	public void setUserpasd(String userpasd) {
		this.userpasd = userpasd;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	

}
