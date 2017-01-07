package com.bob.blog.action;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.bob.blog.dao.BlogsUserDao;
import com.bob.blog.tool.CutImageTool;

public class UploadImageAction {
	private File imgFile;
	private int x;
	private int y;
	private int w;
	private int h;
	private CutImageTool imageTool;
	private BlogsUserDao userDao;
	public String upload(){
		HttpServletRequest request = ServletActionContext.getRequest (); //取得request
		int userid=Integer.parseInt(request.getParameter("userid"));
		System.out.println("userid为："+userid);
		String result= "fail";
		String fileName=imgFile.getAbsolutePath();
		System.out.println("文件位置："+fileName);
		long currentTime=System.currentTimeMillis();
		System.out.println(request.getContextPath());
		 String realPath="E:\\FirstColumnWorkSpace\\blog\\WebContent\\assets\\images"+File.separator+currentTime+".png";
		 System.out.println("保存的位置为："+realPath);
		 String savePath="/blog/assets/images/"+currentTime+".png";
		imageTool=new CutImageTool(fileName, realPath, x, y, w, h);
		try {
			imageTool.cut();
			userDao=new BlogsUserDao();
			if (userDao.updateUserImage(savePath, userid)) {
				result="success";
				request.setAttribute("info", "头像更换成功！");
				request.getSession().setAttribute("user_jpg", savePath);
			}
		} catch (Exception e) {
			System.out.println("上传文件出现异常！");
			result="error";
			request.setAttribute("info", "更换头像出现异常！");
		}
		return result;
	}
	
	
	public File getImgFile() {
		return imgFile;
	}
	public void setImgFile(File imgFile) {
		this.imgFile = imgFile;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getW() {
		return w;
	}
	public void setW(int w) {
		this.w = w;
	}
	public int getH() {
		return h;
	}
	public void setH(int h) {
		this.h = h;
	}
}
