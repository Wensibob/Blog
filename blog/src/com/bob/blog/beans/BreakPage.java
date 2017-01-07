package com.bob.blog.beans;

/**
 * com.bob.blog.beans
 * created by BOB on 2016年11月6日
 * description：定义页面显示的位置
 */
public class BreakPage {
	
	private int start;				//起始条目的位置
	private int pageSize=3;	//每页显示的数量
	private int end;				//结束条目的位置
	private int currentPage;	//当前页面
	private int totalPage;		//页面总数
	
	public BreakPage(int mTotal){
		start=1;
		currentPage=1;
		end=currentPage*pageSize;
		if (mTotal<=pageSize) {
			totalPage=1;
		}else{
			totalPage=mTotal/pageSize;
			if (mTotal%pageSize!=0) {
				totalPage++;
			}
		}
		System.out.println("totalPage=="+totalPage);
	}

	/**
	 * 下一页
	 * @param mCurrentPage 当前页
	 */
	public void nextPage(int mCurrentPage,int blogsNumber){
		currentPage=mCurrentPage;
		if (currentPage>=totalPage) {//当前为最后一页
			endPage(blogsNumber);
		}else{
			currentPage++;
			start=(currentPage-1)*pageSize+1;
			end=start+pageSize-1;
		}
	}
	
	/**
	 * 上一页
	 * @param mCurrentPage 当前页
	 */
	public void previousPage(int mCurrentPage){
		currentPage=mCurrentPage;
		if (currentPage<=1) {
			firstPage();
		}
		currentPage --;
		start=(currentPage-1)*pageSize+1;
		end=start+pageSize-1;
	}
	
	/**
	 * 首页
	 */
	public void firstPage(){
		currentPage=1;
		start=1;
		end=pageSize;
	}
	
	/**
	 * 尾页
	 */
	public void endPage(int blogsNumber){
		currentPage=totalPage;
		start=(currentPage-1)*pageSize+1;
		end=blogsNumber;
	}

	public int getStart() {
		return start;
	}

	public int getEnd() {
		return end;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getTotalPage() {
		return totalPage;
	}
	
}
