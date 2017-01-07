package com.bob.blog.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * com.bob.myblog.dao
 * created by BOB on 2016年10月30日
 * description：
 */
public class DBtools {
	
	//声明数据库的驱动程序以及数据库的用户名和密码
	private static final String DBDRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String DBURL = "jdbc:sqlserver://localhost:1433; DatabaseName=blog";
	private static final String DBUSER = "sa";
	private static final String DBPASSWORD = "aaa123456";
	//生命数据库连接对象
	private Connection conn=null;
	/**
	 * 构造方法，加载数据库,自动抛出异常
	 */
	public DBtools()throws Exception{
			Class.forName(DBDRIVER);
			this.conn=DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
	}
	
	/**
	 * 获取已经连接的数据库的对象
	 * @return 数据库连接对象
	 */
	public Connection getConnection(){
		return this.conn;
	}
	
	/**
	 * 关闭数据库连接
	 */
	public void closeConn(Connection conn){
		try {
			if (conn!=null) {
				conn.close();
			}
		} catch (Exception e) {
			System.out.println("关闭数据库连接失败");
			e.printStackTrace();
		}
	}	
}
