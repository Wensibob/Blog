package com.bob.blog.dao;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
/**
 * com.bob.blog.dao
 * created by BOB on 2016年11月8日
 * description：数据库连接池操作类
 */
public class DBTest {
	public  Connection getConnection(){
		try {
			Context initContext=new InitialContext();
			if (initContext==null) {
				throw new Exception("No Context");
			}
			Context envContext=(Context) initContext.lookup("java:/comp/env");
			DataSource dSource=(DataSource) envContext.lookup("jdbc/blog");
			if (dSource!=null) {
				Connection connection=dSource.getConnection();
				if (connection!=null) {
					return connection;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
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
