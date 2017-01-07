<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.bob.blog.beans.Blog"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<head>
<title>博文详情</title>
<!-- Meta -->
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
  <div class="container"> <a href="/blog/client/index/settings.jsp"><img class="profile-image img-responsive pull-left" src="${user_jpg }" alt="${user_name }" /></a>
    <div class="profile-content pull-left">
      <center>
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
      <section class="projects section">
        <div class="section-inner">
          <h1 >${blogcontent.blogTitle}</h1>
          <div class="item">
          <h3 class="title"><strong>${blogcontent.blogDate}</strong></h3>
          </div>
          <div class="content">
            <div class="item">
              <p>${blogcontent.blogContent}</p>
               </div>
            <!--// item--> 
          </div>
          <!--//content--> 
        </div>
        <!--//section-inner--> 
      </section>
      <!--//section-->
      
      <section class="projects section" align="left">
          <a class="btn btn-cta-secondary" href="/blog/servlet/EditTalk.servlet?blogId=${blogcontent.blogId}">&nbsp;编辑</a> 
          <a class="btn btn-cta-secondary" href="/blog/servlet/DeleteTalk.servlet?blogId=${blogcontent.blogId}&userid=${user_id }" >删除 &nbsp;</a>
      </section>
      <!--//section--> 
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