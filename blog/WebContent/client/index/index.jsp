<%@ page language="java"  contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="com.bob.blog.beans.BreakPage"%>
<%@page import="com.bob.blog.beans.Blog"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html >
<head>
 <title>博客主页</title>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description"
	content="Responsive HTML5 Website landing Page for Developers">
<meta name="author" content="3rd Wave Media">
<link
	href='http://fonts.useso.com/css?family=Lato:300,400,300italic,400italic'
	rel='stylesheet' type='text/css'>
<link href='http://fonts.useso.com/css?family=Montserrat:400,700'
	rel='stylesheet' type='text/css'>
<!-- Global CSS -->
<link rel="stylesheet"
	href="/blog/assets/plugins/bootstrap/css/bootstrap.min.css">
<!-- Plugins CSS -->
<link rel="stylesheet"
	href="/blog/assets/plugins/font-awesome/css/font-awesome.css">
<!-- github acitivity css -->
<link rel="stylesheet"
	href="/blog/assets/plugins/github-activity/dist/github-activity-0.1.1.min.css">
<link rel="stylesheet"
	href="/blog/assets/plugins/github-activity/dist/octicons/octicons.min.css">

<!-- Theme CSS -->
<link id="theme-style" rel="stylesheet" href="/blog/assets/css/styles.css">
<style type="text/css">
body, td, th {
	font-family: Lato, arial, sans-serif;
}
</style>

</head>

<body>
<!--头部-->
<header class="header">
  <div class="container"> <a href="/blog/client/index/settings.jsp"><img class="profile-image img-responsive pull-left" src="${user_jpg }" alt="${user_name }"  /></a>
    <div class="profile-content pull-left">
      <center>
      <% 
      	BreakPage breakPage= (BreakPage)session.getAttribute("breakPage");
    	%>
        <h1 class="name"><a href="/blog/servlet/ListTalk.servlet?userid=${user_id }">${user_name }</a></h1>
      </center>
    </div>
    <!--//profile--> 
    <a class="btn btn-cta-primary pull-right" href="logout.do" ><i class="fa fa-paper-plane"></i> 退出</a> </div>
  <!--//container--> 
</header>
<!--//header--> 
<!--博客列表-->
<div class="container sections-wrapper">
  <div class="row"> 
    
    <!--博客内容-->
    <div class="primary col-md-8 col-sm-12 col-xs-12">
    	
   	<c:forEach items="${ blogList}" var="blog">
      <section class="projects section">
        <div class="section-inner">
          <h2 class="heading"><a href="/blog/servlet/ContentTalk.servlet?blogId=${blog.blogId}">${blog.blogTitle}</a></h2>
          <div class="content">
            <div class="item">
              <h3 class="title"><strong>${blog.blogDate}</strong></h3>
              <p>${blog.blog_subline}</p>
              <a class="btn btn-cta-secondary" href="/blog/servlet/ContentTalk.servlet?blogId=${blog.blogId}">Read  More &nbsp;<i class="fa fa-chevron-right"></i></a> </div>
            <!--// item--> 
          </div>
          <!--//content--> 
        </div>
        <!--//section-inner--> 
      </section>
      <!--//section-->
   	</c:forEach>

      <c:if test="${blogList.size()>0 }">
      <section class="projects section">
        <center>
        <a class="btn btn-cta-secondary" href="/blog/servlet/ListTalk.servlet?page=first&currentPage=${breakPage.currentPage }&userid=${user_id }"  <%=breakPage.getCurrentPage()==1?"DISABLED":"" %>>&nbsp;首页</a> 
          <a class="btn btn-cta-secondary" href="/blog/servlet/ListTalk.servlet?page=previous&currentPage=${breakPage.currentPage }&userid=${user_id }"  <%=breakPage.getCurrentPage()==1?"DISABLED":"" %>>
          		<i class="fa fa-chevron-left"></i> &nbsp;上一页</a> 
          <a class="btn btn-cta-secondary" href="/blog/servlet/ListTalk.servlet?page=next&currentPage=${breakPage.currentPage }&userid=${user_id }"  <%=breakPage.getCurrentPage()==breakPage.getTotalPage()?"DISABLED":"" %>>
          下一页 &nbsp;<i class="fa fa-chevron-right"></i></a>
          <a class="btn btn-cta-secondary" href="/blog/servlet/ListTalk.servlet?page=end&currentPage=${breakPage.currentPage }&userid=${user_id }"  <%=breakPage.getCurrentPage()==breakPage.getTotalPage()?"DISABLED":"" %>>&nbsp;尾页</a> 
        </center>
      </section>
      </c:if>
    </div>
    
    <!--边栏内容-->
    <div class="secondary col-md-4 col-sm-12 col-xs-12">
      <aside class="skills aside section">
        <div class="section-inner">
          <h2 class="heading">操作</h2>
          <div class="content"> <a class="btn btn-cta-secondary" href="/blog/servlet/ListTalk.servlet?userid=${user_id }" >回主页&nbsp; &nbsp; <i class="fa fa-chevron-right"></i></a> <br>
            <br>
            <br>
            <a class="btn btn-cta-secondary" href="/blog/servlet/AddTalk.servlet?userid=${user_id }" >写博客&nbsp; &nbsp; <i class="fa fa-chevron-right"></i></a> </div>
          <!--//content--> 
        </div>
        <!--//section-inner--> 
      </aside>
      <!--//section-->
      
      <aside class="testimonials aside section">
        <div class="section-inner">
          <h2 class="heading">简介</h2>
          <div class="content">
            <div class="item">
              <blockquote class="quote">
                <p><i class="fa fa-quote-left"></i>一个热爱安卓的极客</p>
              </blockquote>
            </div>
            <!--//item--> 
          </div>
          <!--//content--> 
        </div>
        <!--//section-inner--> 
      </aside>
      <!--//section-->
      
      <aside class="info aside section">
        <div class="section-inner">
          <h2 class="heading">联系我</h2>
          <div class="content">
            <ul class="list-unstyled">
              <li><i class="fa fa-map-marker"></i><span class="sr-only">Location:</span>GDUT</li>
              <li><i class="fa fa-envelope-o"></i><span class="sr-only">Email:</span>wensino95@gmail.com</li>
              <li><i class="fa fa-link"></i><span class="sr-only">Website:</span><a href="http://www.cnblogs.com/ghylzwsb/" target="_blank">个人博客</a></li>
            </ul>
          </div>
          <!--//content--> 
        </div>
        <!--//section-inner--> 
      </aside>
      <!--//aside--> 
      
    </div>
    <!--//secondary--> 
  </div>
  <!--//row--> 
</div>
</body>
</html>