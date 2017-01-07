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
 * description：博客文章详情展示类
 */
public class ContentTalk extends HttpServlet {
	
	public ContentTalk() {
		super();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取需要展现内容的blog
		int id=Integer.parseInt(request.getParameter("blogId"));
		Blog blog=new BlogContentDao().findBlogById(id);
		request.setAttribute("blogcontent", blog);
		request.getRequestDispatcher("/client/index/content.jsp").forward(request, response);
	}
	
	@Override
	public void init() throws ServletException {}

}
