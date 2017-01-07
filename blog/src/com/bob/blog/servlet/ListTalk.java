package com.bob.blog.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bob.blog.beans.Blog;
import com.bob.blog.beans.BreakPage;
import com.bob.blog.dao.BlogContentDao;
import com.bob.blog.tool.PageTools;

/**
 * com.bob.blog.servlet
 * created by BOB on 2016年11月8日
 * description：博客文章列表展示类
 */
public class ListTalk extends HttpServlet {

	public ListTalk() {
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
		//blog文章的更新
		BreakPage breakPage=PageTools.tools(request);
		int currentPage=breakPage.getCurrentPage();
		ArrayList<Blog> blogs=new BlogContentDao().getAllBlogsList(3,currentPage,request);
		request.setAttribute("blogList", blogs);
		request.setAttribute("breakPage", breakPage);
		request.getRequestDispatcher("/client/index/index.jsp").forward(request, response);
	}
	
	@Override
	public void init() throws ServletException {}
}
