package com.bob.blog.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bob.blog.dao.BlogContentDao;

/**
 * com.bob.blog.servlet
 * created by BOB on 2016年11月8日
 * description：博客文章删除类
 */
public class DeleteTalk extends HttpServlet {
	
	public DeleteTalk() {
		super();
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//blog文章的删除
		int blog_id=Integer.parseInt(request.getParameter("blogId"));
		int user_id=Integer.parseInt(request.getParameter("userid"));
		BlogContentDao blogContentDao=new BlogContentDao();
		blogContentDao.deleteById(blog_id);
		response.sendRedirect("/blog/servlet/ListTalk.servlet?userid="+user_id);
	}
	
	@Override
	public void init() throws ServletException {}
}
