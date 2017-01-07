package com.bob.blog.vo;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.bob.blog.beans.User;
import com.bob.blog.dao.BlogsUserDao;

/**
 * com.bob.blog.vo
 * created by BOB on 2016年11月7日
 * description：登陆操作的vo类
 */
public class LoginVO {
	
	/**
	 * 创建一个user对象
	 * @param userid
	 * @param userpasd
	 * @param username
	 * @return
	 */
	public User packUsers(String userid,String userpasd,String username){
		User user=new User();
		try {
			user.setUserId(Integer.parseInt(userid));
			user.setUserName(username);
			user.setPasd(userpasd);
		} catch (Exception e) {
			System.out.println("得到用户输入的数据出错！");
			e.printStackTrace();
		}
		return user;
	}
	
	/**
	 * 检查用户输入的id是否存在
	 * @param user_id
	 * @return true表示id存在不能注册，false表示id不存在，可以注册
	 */
	public boolean checkUserIdExist(int user_id){
		boolean isIdExist =false;
		ArrayList<User> users=(ArrayList<User>)new BlogsUserDao().getAllUsers();
		for(int i=0;i<users.size();i++){
			if (users.get(i).getUserId()==user_id ) {
					isIdExist=true;
					break;
			}
		}
		return isIdExist;
	}
	
	/**
	 * 判断id与密码是否正确
	 * @param user_id
	 * @param user_pasd
	 * @return
	 */
	public boolean checkPasd(String user_id,String user_pasd,HttpServletRequest request){
		boolean result=false;
			ServletContext sContext=request.getServletContext();
			String[] pasd_name_jpg=new BlogsUserDao().findPasById(user_id);
			if (pasd_name_jpg!=null) {
				String password=pasd_name_jpg[0];
				String user_name=pasd_name_jpg[1];
				String user_jpg=pasd_name_jpg[2];
				if (user_pasd.equals(password)) {
					//密码正确，判断是否为第一次登录
						//如果是第一次，就存入session
						HttpSession session=request.getSession();
						session.setAttribute("user_id", user_id);
						session.setAttribute("user_name", user_name);
						session.setAttribute("user_jpg", user_jpg);
						session.setAttribute("user_check", "user_id");
						result=true;
//						System.out.println("第一次登陆");
				}
			}
		return result;
	}
	
	/**
	 * 通过id判断用户是否为第一次登陆
	 * @param sc
	 * @param user_id
	 * @return
	 */
	private boolean checkFirstIn(ServletContext sc,String user_id){
		
		boolean result=false;
		//从application属性中曲中user判断用户是否为第一次登陆
		ArrayList all=(ArrayList) sc.getAttribute("ListUserId");
		//判断是否为空，如果为空就为首次登陆，接着需要设置attribute
		if (all==null) {
			all=new ArrayList();
			all.add(user_id);
			sc.setAttribute("ListUserId", all);
			result=true;
		}else{//如果不为空，需要循环查找
			for (int i = 0; i <all.size(); i++) {	//循环查找，如果找到就跳出，设置为true
				String userId=(String) all.get(i);
				if (userId.equals(user_id)) {
					result=true;
					break;
				}
			}
			if (!result) {	//如果查找不到，就说明result为false，此时应加入attribute
				all.add(user_id);
				sc.setAttribute("ListUserId", all);
			}
		}
		return result;
	}
}
