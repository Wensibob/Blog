package com.bob.blog.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bob.blog.beans.Blog;
import com.bob.blog.dao.BlogContentDao;

/**
 * com.bob.blog.servlet
 * created by BOB on 2016年11月8日
 * description：博客文章修改类
 */
public class EditTalk extends HttpServlet{

	public EditTalk() {
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
		//blog文章的修改
		int id=Integer.parseInt(request.getParameter("blogId"));
		BlogContentDao blogContentDao=new BlogContentDao();
		Blog editBlog=blogContentDao.findBlogById(id);
		request.setAttribute("editBlog", editBlog);
		request.getRequestDispatcher("/client/index/edit.jsp").forward(request, response);
	}
	
	@Override
	public void init() throws ServletException {}
}
