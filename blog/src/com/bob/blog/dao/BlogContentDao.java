package com.bob.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.bob.blog.beans.Blog;

/**
 * com.bob.blog.dao
 * created by BOB on 2016年11月8日
 * description： 博客内容数据操作类
 */
public class BlogContentDao {
	
	private Connection connection;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private DBtools tools;
	
	public BlogContentDao(){
		try {
			tools=new DBtools();
		} catch (Exception e) {
			System.out.println("BlogContentDao在创建DBTools对象是出错！");
			e.printStackTrace();
		}
	}
	
	/**
	 * 添加博客文章
	 * @param blog
	 */
	public void addBlog(Blog blog){
		try {
			connection=this.tools.getConnection();
			String sql="insert into blog_content values(?,?,?,?,?,?)";
			System.out.println("sql语句插入blog内容为："+sql);
			pstmt=connection.prepareStatement(sql);
			System.out.println("最大值："+getMax());
			blog.setBlogId(getMax());
			pstmt.setInt(1, blog.getBlogId());
			pstmt.setInt(2, blog.getOwner_id());
			pstmt.setString(3, blog.getBlogTitle());
			pstmt.setString(4, blog.getBlog_subline());
			pstmt.setString(5, blog.getBlogContent());
			pstmt.setString(6, blog.getBlogDate());
			if (pstmt.executeUpdate()>0) {
				System.out.println("插入新的博客成功，博客id为："+blog.getBlogId());
			}
		} catch (Exception e) {
			System.out.println("sql语句插入blog内容出错！");
			e.printStackTrace();
		}finally {
			this.tools.closeConn(connection);
		}
	}
	
	/**
	 * 获取新blog添加进数据库的位置——即blog的id
	 */
	private int getMax(){
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int max=0;			//新添加的blog内容需要添加的位置——即用于的唯一标识——id
		try {
			connection=new DBtools().getConnection();
			String sql="select max(blog_id) max from blog_content";
			System.out.println("sql语句选择计算blog_id："+sql);
			pstmt=connection.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if (rs.next()) {
				max=rs.getInt("max");
			}
		} catch (Exception e) {
			System.out.println("sql语句选择计算blog_id错误！");
			e.printStackTrace();
		}finally {
			this.tools.closeConn(connection);
		}
		return max+1;
	}
	
	/**
	 * 获取前size数量的blog文章
	 * @param size
	 * @return
	 */
	public ArrayList<Blog> getAllBlogsList(int size,int currentPage,HttpServletRequest request){
		ArrayList<Blog> blogs=new ArrayList<Blog>();
		int owner_id =Integer.parseInt(request.getParameter("userid"));
		Blog blog;
		try {
			connection=this.tools.getConnection();
			String sql=
					"select top "+size+" * from blog_content where blog_id not in(select top "
					+(currentPage-1)*size+" blog_id from blog_content where owner_id="+owner_id+" ) and owner_id="+owner_id+" order by blog_id";
			System.out.println("查询所有的blog内容"+sql);
			pstmt=connection.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while (rs.next()) {
				blog=new Blog();
				blog.setBlogId(rs.getInt("blog_id"));
				blog.setBlogTitle(rs.getString("blog_title"));
				blog.setBlog_subline(rs.getString("blog_subline"));
				blog.setBlogContent(rs.getString("blog_content"));
				blog.setBlogDate(rs.getString("blog_date"));
				blogs.add(blog);
			}
		} catch (Exception e) {
			System.out.println("查询所有的blog内容 出错！");
			e.printStackTrace();
		}finally {
			this.tools.closeConn(connection);
		}
		System.out.println("blogs大小："+blogs.size());
		return blogs;
	}
	
	/**
	 * 通过blog的id查找blog
	 * @param blog_id
	 * @return
	 */
	public Blog findBlogById(int blog_id){
		Blog blog=new Blog();
		try {
			connection=this.tools.getConnection();
			String sql="select * from blog_content where blog_id="+blog_id;
			System.out.println("sql语句通过blogid查找blog："+sql);
			pstmt=connection.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				blog.setBlogId(rs.getInt("blog_id"));
				blog.setBlogTitle(rs.getString("blog_title"));
				blog.setBlog_subline(rs.getString("blog_subline"));
				blog.setBlogContent(rs.getString("blog_content"));
				blog.setBlogDate(rs.getString("blog_date"));
			}
		} catch (Exception e) {
			System.out.println("sql语句通过blogid查找blog 出错" );
			e.printStackTrace();
		}finally {
			this.tools.closeConn(connection);
		}
		return blog;
	}
	
	/**
	 * 通过blogid删除blog
	 * @param blog_id
	 */
	public boolean deleteById(int blog_id) {
		boolean result=false;
		try {
			connection=this.tools.getConnection();
			String sql="delete blog_content where blog_id="+blog_id;
			System.out.println("sql语句通过blog的id删除特定的blog："+sql);
			pstmt=connection.prepareStatement(sql);
			if (pstmt.executeUpdate()>0) {
				System.out.println("删除id为："+blog_id+" 的blog成功");
				result=true;
			}else {
				System.out.println("删除id为："+blog_id+" 的blog失败");
			}
		} catch (Exception e) {
			System.out.println("删除id为："+blog_id+" 的blog出现异常！");
			e.printStackTrace();
		}finally {
			this.tools.closeConn(connection);
		}
		return result;
	}
	
	/**
	 * 通过blog的id更新blog内容
	 * @param id
	 * @return
	 */
	public boolean updateById(Blog blog){
		boolean result=false;
		try {
			connection=this.tools.getConnection();
			String sql="update blog_content set blog_title=?,blog_subline=?,blog_content=?,blog_date=? where blog_id=?";
			pstmt=connection.prepareStatement(sql);
			pstmt.setString(1, blog.getBlogTitle());
			pstmt.setString(2, blog.getBlog_subline());
			pstmt.setString(3, blog.getBlogContent());
			pstmt.setString(4, blog.getBlogDate());
			pstmt.setInt(5, blog.getBlogId());
			System.out.println("更新语句："+sql);
			if (pstmt.executeUpdate()>0) {
				System.out.println("更新id为："+blog.getBlogId()+" 的blog成功");
				result=true;
			}else {
				System.out.println("更新id为："+blog.getBlogId()+" 的blog失败");
			}
		} catch (Exception e) {
			System.out.println("更新id为："+blog.getBlogId()+" 的blog出现异常！");
			e.printStackTrace();
		}finally {
			this.tools.closeConn(connection);
		}
		return result;
	}
	
	/**
	 * 获取blog文章的数量
	 * @return
	 */
	public int getAllBlogs( HttpServletRequest request){
		int total=0;
		try {
			connection=this.tools.getConnection();
			int owner_id=Integer.parseInt(request.getParameter("userid"));
			String sql="select count(blog_id) total from blog_content where owner_id="+owner_id;
			System.out.println("查询所有的blog数量"+sql);
			pstmt=connection.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if (rs.next()) {
				total=rs.getInt("total");
			}
		} catch (Exception e) {
			System.out.println("查询所有的blog数量 出错！");
			e.printStackTrace();
		}finally {
			this.tools.closeConn(connection);
		}
		return total;
	}
	
}
