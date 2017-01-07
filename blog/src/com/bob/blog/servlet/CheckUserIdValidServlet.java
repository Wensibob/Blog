package com.bob.blog.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bob.blog.dao.BlogsUserDao;

/**
 * com.bob.blog.servlet
 * created by BOB on 2016年11月8日
 * description：用户id验证类
 */
public class CheckUserIdValidServlet extends HttpServlet {
	
	public CheckUserIdValidServlet() {
	}

	@Override
	public void destroy() {
		super.destroy();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int user_id=Integer.parseInt(request.getParameter("user_id"));
		PrintWriter out=response.getWriter();
		BlogsUserDao dao=new BlogsUserDao();
		if (dao.isUserIdExist(user_id)) {
			out.print("true");
			System.out.println("true");
		}else {
			out.print("false");
			System.out.println("false");
		}
	}
	
}
