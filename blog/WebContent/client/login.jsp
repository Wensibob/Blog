<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>登陆</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description"
	content="Responsive HTML5 Website landing Page for Developers">
<meta name="author" content="3rd Wave Media">
<link rel="stylesheet" href="/blog/assets/css/loginMy.css"/>
<style type="text/css">
span{
	margin-left: 29%;
}
submit{
	margin-left: 15%;
}
</style>
</head>
<script language="javascript" src="/blog/js/check_login.js"></script>
<body>

	<div class="main">
	<div class="center">
	<center>
		<h1 ><font size="8" color="#272822" >欢迎登陆</font></h1>
	</center>
	
		<form action="login.do" method="post"  onsubmit="return checkForm()">
			<input type="text" name="userid"  onblur="checkUserid(this.value)" placeholder="用户名"><br/>
			<span id="userid_msg"></span>
			<br/>
			<input type="password" name="userpasd"  onblur="checkPasdEmpty(this.value)" placeholder="密码"><br>
			<span id="pasd_msg"></span>
			<br/>
			<input type="submit" value="登录" id="submit">
			<div id="userOperation" ><a href="/blog/client/register.jsp">没有账号就赶快注册吧！</a></div>
			<div id="userOperation" >${info }</div>
			<div id="userOperation" >${logout_info }</div>
		</form>
	</div>
</div>
</body>
</html>