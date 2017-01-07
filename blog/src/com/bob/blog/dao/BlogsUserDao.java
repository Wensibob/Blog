package com.bob.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bob.blog.beans.User;

/**
 * com.bob.blog.dao
 * created by BOB on 2016年11月8日
 * description：blog中user的数据库通讯类
 */
public class BlogsUserDao {
	
	private PreparedStatement pstmt;
	private Connection connection;
	private ResultSet rs;
	private DBTest tools;
	
	public BlogsUserDao() {
		try {
			tools=new DBTest();
		} catch (Exception e) {
			System.out.println("创建DBtools对象出错！");
			e.printStackTrace();
		}
	}
	
	/**
	 * 新增用户
	 * @param user
	 */
	public boolean addUser(User user){
		boolean result=false;
		try {
			connection=this.tools.getConnection();
			String sql="insert into blog_owners values(?,?,?,?)";
			System.out.println("sql语句为插入一个用户："+sql);
			pstmt=connection.prepareStatement(sql);
			pstmt.setInt(1, user.getUserId());
			pstmt.setString(2, user.getUserName());
			pstmt.setString(3, user.getPasd());
			pstmt.setString(4, user.getUserJpg());
			if (pstmt.executeUpdate()>0) {
				System.out.println("添加用户成功");
				result=true;
			}
		} catch (Exception e) {
			System.out.println("添加用户失败");
			e.printStackTrace();;
		}finally {
			this.tools.closeConn(connection);
			return result;
		}
	}
	
	/**
	 * 获取新用户添加进数据库的位置——即用户的id
	 */
	private int getMax(){
		int max=0;			//新添加的用户需要添加的位置——即用于的唯一标识——id
		try {
			connection=this.tools.getConnection();
			String sql="select count(user_id) max from blog_owners";
			System.out.println("sql语句选择计算user_id："+sql);
			pstmt=connection.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if (rs.next()) {
				max=rs.getInt("max");
			}
		} catch (Exception e) {
			System.out.println("sql语句选择计算user_id错误！");
			e.printStackTrace();
		}finally {
			this.tools.closeConn(connection);
		}
		return max+1;
	}
	
	/**
	 * 通过user_id查询表数据
	 * @return 所有用户的数据集合
	 */
	public ArrayList<User> getAllUsers(){
		ArrayList<User> usersList=new ArrayList<User>();
		User user;
		try{
			connection=this.tools.getConnection();
			String sql="select * from blog_owners order by user_id";
			System.out.println("sql语句获取所有的用户信息："+sql);
			pstmt=connection.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while (rs.next()) {
				user=new User();
				user.setUserId(rs.getInt("user_id"));
				user.setUserName(rs.getString("user_name"));
				user.setPasd(rs.getString("user_pasd"));
				usersList.add(user);
			}
			System.out.println("users:"+usersList.size());
		}catch(Exception e){
			System.out.println("sql语句获取所有的用户信息 失败！");
			e.printStackTrace();
		}finally {
			this.tools.closeConn(connection);
		}
		return usersList;
	}
	
	/**
	 * 通过用户id查询用户的密码以及名字
	 * @param userName 用户ID
	 * @return 用户名对应的密码
	 */
	public String[] findPasById(String userId){
		String[] pasd_name_jpg=null;
		String pasd=null;
		String user_name=null;
		String user_jpg=null;
		try {
			connection=this.tools.getConnection();
			String sql="select user_pasd,user_name,user_jpg from blog_owners where user_id="+userId;
			System.out.println("通过用户名查询密码的语句"+sql);
			pstmt=connection.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				pasd=rs.getString("user_pasd");
				user_name=rs.getString("user_name");
				user_jpg=rs.getString("user_jpg");
			}
			pasd_name_jpg=new String[]{pasd,user_name,user_jpg};
		} catch (Exception e) {
			System.out.println("通过用户名查询密码的语句 出错！");
			e.printStackTrace();
		}finally {
			this.tools.closeConn(connection);
		}
		return pasd_name_jpg;
	}
	
	/**
	 * 检查用户输入的id是否存在
	 * @param user_id
	 * @return  true表示id存在不能注册，false表示id不存在，可以注册
	 */
	public boolean isUserIdExist(int user_id){
		boolean isIdExist=false;
		try {
			connection=this.tools.getConnection();
			String sql="select count(user_id) from blog_owners where user_id="+user_id;
			System.out.println("通过用户名查询密码的语句"+sql);
			pstmt=connection.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				if (rs.getInt(1)>0) {
					isIdExist=true;
				}
			}
		} catch (Exception e) {
			System.out.println("通过用户id是否存在的语句 出错！");
			e.printStackTrace();
		}finally {
			this.tools.closeConn(connection);
			return isIdExist;
		}
	}
	
	/**
	 * 更新用户头像
	 * @param user_jpg
	 * @param user_id
	 * @return
	 */
	public boolean updateUserImage(String user_jpg,int user_id){
		boolean update=false;
		if (user_jpg!=null||!user_jpg.equals("")) {
			try {
				connection=this.tools.getConnection();
				String sql="update blog_owners set user_jpg=? where user_id=?";
				pstmt=connection.prepareStatement(sql);
				pstmt.setString(1, user_jpg);
				pstmt.setInt(2, user_id);
				System.out.println("头像路径为："+user_jpg);
				System.out.println("用户id为："+user_id);
				if (pstmt.executeUpdate()>0) {
					System.out.println("更新用户的头像成功！");

					update=true;
				}else {
					System.out.println("更新用户的头像失败！");
				}
			} catch (Exception e) {
				System.out.println("更新用户的头像出现异常！");
				e.printStackTrace();
			}finally {
				this.tools.closeConn(connection);
			}
		}else {
			System.out.println("用户头像不能为空！");
		}
		return update;
	}
	
}
