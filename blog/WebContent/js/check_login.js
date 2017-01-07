var xmlHttp;		//Ajax核心对象名称
var flag;			//定义标志位

function createXMLHttp() {
	if (window.XMLHttpRequest) {
		xmlHttp=new XMLHttpRequest();
	}else {
		xmlHttp = new ActiveXObject("Microsoft.XMLHTTP") ;
	}
}

function checkUserid(userid) {
	if (!(/^\d{4}$/.test(userid))) {
		document.getElementById("userid_msg").innerHTML = "用户名只能为4位数的数字！" ;
		flag=false;
	}else{
		createXMLHttp();
		//设置一个请求，通过地址重写的方式将userid传递到servlet中
		xmlHttp.open("POST","/blog/servlet/CheckId.servlet?user_id="+userid) ;
		xmlHttp.onreadystatechange = checkUseridCallback ;
		xmlHttp.send(null) ;
		document.getElementById("userid_msg").innerHTML = "正在验证..." ;
	}
}

function checkUseridCallback(){
	if(xmlHttp.readyState == 4){
		if(xmlHttp.status == 200){
			var text = xmlHttp.responseText ;
			if(text == "true"){	// 用户id已经存在了
				document.getElementById("userid_msg").innerHTML = "用户名正确！" ;
				flag = true ;
			} 
			else {
				document.getElementById("userid_msg").innerHTML = "此用户名不存在！" ;
				flag = false ;
			}
		}
	}
}
function checkPasdEmpty(pasd) {
	if (pasd==""||pasd==null) {
		document.getElementById("pasd_msg").innerHTML="密码不能为空";
		flag=false;
	}else{
		document.getElementById("pasd_msg").innerHTML="";
		flag=true;
	}
}

function checkForm(){
	return flag ;
}