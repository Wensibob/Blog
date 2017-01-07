package com.bob.blog.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bob.blog.beans.Blog;
import com.bob.blog.dao.BlogContentDao;
import com.bob.blog.tool.DateFormatTool;

/**
 * com.bob.blog.servlet
 * created by BOB on 2016年11月8日
 * description：博客文章添加类
 */
public class AddTalk extends HttpServlet {

	public AddTalk() {
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
		
		request.setCharacterEncoding("UTF-8");
		int user_id=Integer.parseInt(request.getParameter("userid"));
		//new一个blog对象
		Blog blog=new Blog();
		blog.setOwner_id(user_id);
		blog.setBlogTitle(" ");
		blog.setBlog_subline(" ");
		blog.setBlogContent(" ");
		blog.setBlogDate(new DateFormatTool().getStringDate());
		
		//加入到数据库中
		BlogContentDao blogContentDao=new BlogContentDao();
		blogContentDao.addBlog(blog);
		response.sendRedirect("/blog/servlet/EditTalk.servlet?blogId="+blog.getBlogId());
	}
	
	@Override
	public void init() throws ServletException {}
}
