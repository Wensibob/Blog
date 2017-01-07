package com.bob.blog.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

public class LogoutAction {
	
	public String logout(){
		String logout="fail";
		HttpServletRequest request = ServletActionContext.getRequest (); //取得request
		ActionContext ac = ActionContext.getContext();
		Map session = ac.getSession();
		if (session.size()>0) {
			try {
				session.remove("user_name");
				session.remove("user_jpg");
				session.remove("user_check");
				session.remove("blogList");
				session.remove("breakPage");
				logout="success";
			} catch (Exception e) {
				request.setAttribute("logout_info", "注销失败");
				System.out.println("用户注销失败");
				e.printStackTrace();
			}
		}
		return logout;
	}
}
