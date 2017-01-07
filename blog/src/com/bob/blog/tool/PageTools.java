package com.bob.blog.tool;

import javax.servlet.http.HttpServletRequest;

import com.bob.blog.beans.BreakPage;
import com.bob.blog.dao.BlogContentDao;

/**
 * com.bob.blog.proxy
 * created by BOB on 2016年10月31日
 * description：页面显示工具类
 */
public class PageTools {
	
	public static BreakPage tools(HttpServletRequest request){
		BlogContentDao dao=new BlogContentDao();
		int blogsNumber=dao.getAllBlogs(request);
		BreakPage pages=new BreakPage(blogsNumber);
		//从页面中读取page属性
		String code=request.getParameter("page");
		if (code!=null) {
			int currentPage=Integer.parseInt(request.getParameter("currentPage"));
			
			if ("next".equals(code)) {
				pages.nextPage(currentPage,blogsNumber);
			}else if ("previous".equals(code)) {
				pages.previousPage(currentPage);
			}else if ("first".equals(code)) {
				pages.firstPage();
			}else if ("end".equals(code)) {
				pages.endPage(blogsNumber);
			}
		}
		return pages;
	}
}
