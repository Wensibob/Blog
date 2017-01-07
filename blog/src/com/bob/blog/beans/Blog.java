package com.bob.blog.beans;

/**
 * com.bob.blog.beans
 * created by BOB on 2016年11月6日
 * description：Blog文章的bean类
 */
public class Blog {
	
	private int blogId;
	private int owner_id;
	private String blog_subline;
	private String blogDate;
	private String blogTitle;
	private String blogContent;
	
	public int getBlogId() {
		return blogId;
	}
	public int getOwner_id() {
		return owner_id;
	}
	public void setOwner_id(int owner_id) {
		this.owner_id = owner_id;
	}
	public String getBlog_subline() {
		return blog_subline;
	}
	public void setBlog_subline(String blog_subline) {
		this.blog_subline = blog_subline;
	}
	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}
	public String getBlogDate() {
		return blogDate;
	}
	public void setBlogDate(String blogDate) {
		this.blogDate = blogDate;
	}
	public String getBlogTitle() {
		return blogTitle;
	}
	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}
	public String getBlogContent() {
		return blogContent;
	}
	public void setBlogContent(String blogContent) {
		this.blogContent = blogContent;
	}
	
}
