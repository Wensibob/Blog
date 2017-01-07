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
 * description：博客文章更新类
 */
public class UpdateTalk extends HttpServlet{
	
	public UpdateTalk() {
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
		//获取博客文章的信息
		int id=Integer.parseInt(request.getParameter("blogId"));
		String title=request.getParameter("blogTitle");
		String subline=request.getParameter("blogSubline");
		String content=request.getParameter("blogContent");
		//new一个blog对象
		Blog blog=new Blog();
		blog.setBlogId(id);
		blog.setBlogTitle(title);
		blog.setBlog_subline(subline);
		blog.setBlogContent(content);
		blog.setBlogDate(new DateFormatTool().getStringDate());
		
		//加入到数据库中
		BlogContentDao blogContentDao=new BlogContentDao();
		blogContentDao.updateById(blog);
		response.sendRedirect("/blog/servlet/ContentTalk.servlet?blogId="+id);
	}
	
	@Override
	public void init() throws ServletException {}
}
