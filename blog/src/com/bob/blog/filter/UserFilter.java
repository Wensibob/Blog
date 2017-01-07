package com.bob.blog.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * com.bob.blog.filter
 * created by BOB on 2016年11月8日
 * description：用户验证过滤器类
 */
public class UserFilter implements Filter{

	@Override
	public void destroy() {}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest=(HttpServletRequest) request;
		HttpServletResponse httpServletResponse=(HttpServletResponse) response;
		HttpSession session=httpServletRequest.getSession();
		String message=(String) session.getAttribute("user_check");
		//验证session是否放行
		if ("user_id".equals(message)) {
			chain.doFilter(request, response);
		}else {
			httpServletResponse.sendRedirect("/blog/client/login.jsp");
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {}
}
