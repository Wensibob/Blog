package com.bob.blog.tool;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * com.bob.blogs.tool
 * created by BOB on 2016年11月4日
 * description：日期字符串生成类
 */
public class DateFormatTool {
	
	public static String getStringDate(){
		Date date = new Date();   
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");   
		String stringDate = format.format(date);
		return stringDate;
	}
}
