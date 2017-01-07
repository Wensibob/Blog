package com.bob.blog.action;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;
import org.apache.struts2.ServletActionContext;

import com.bob.blog.beans.Blog;
import com.bob.blog.beans.BreakPage;
import com.bob.blog.dao.BlogContentDao;
import com.bob.blog.tool.PageTools;
import com.bob.blog.vo.LoginVO;
import com.opensymphony.xwork2.ActionContext;

/**
 * com.bob.blog.action
 * created by BOB on 2016年11月7日
 * description：登陆操作的验证action
 */
public class LoginAction  {

	private String userid;
	private String userpasd;
	private String login_result="fail";
	
	public String login(){
		HttpServletRequest request = ServletActionContext.getRequest (); //取得request
		LoginVO loginVO=new LoginVO();
		if ( (userid.equals("")||userid==null) || (userpasd.equals("")||userpasd==null) ) {//判断用户名或密码是否为空
			login_result="empty";
			request.setAttribute("info", "用户名或密码为空😏");
		}else if (loginVO.checkPasd(userid, userpasd, request)) {//判断用户名和密码是否正确
			BreakPage breakPage=PageTools.tools(request);
			int currentPage=breakPage.getCurrentPage();
			ArrayList<Blog> blogs=new BlogContentDao().getAllBlogsList(3,currentPage,request);
			HttpSession session=request.getSession();
			session.setAttribute("blogList", blogs);
			session.setAttribute("breakPage", breakPage);
			login_result="success";
		} else {//登录失败
			request.setAttribute("info", "登录失败😏，请返回重新登陆！");
		}
		return login_result;
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


	
}
