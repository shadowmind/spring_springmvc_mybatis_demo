<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Index</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="//cdn.bootcss.com/jquery/1.12.1/jquery.min.js"></script>
<script type="text/javascript">
	function jsonPost(url, param, callbackFunction) {
		$.ajax({
			type : "post",
			url : url,
			data : param,
			dataType : "json",
			success : callbackFunction,
			error : function() {
				alert("Ajax 请求错误，URL：" + urls);
			}
		});
	}

	function getResult() {
		var name = $("#name").val();
		var password = $("#password").val();
		var param = "name=" + name + "&password=" + password;

		jsonPost("login/verify", param, getResultCallback);
	}

	function getResultCallback(msg) {
		alert(msg);
	}

	function getUserInfo() {
		var id = $("#userID").val();
		jsonPost("user/user/" + id, null, getUserInfoCallback);
	}

	function getUserInfoCallback(msg) {
		alert(" name:" + msg.name + "\r\n email:" + msg.email
				+ "\r\n createTime:" + msg.createTime + "\r\n lastTime:"
				+ msg.lastTime);
	}

	function getUserInfoList() {
		jsonPost("user/users", null, getUserInfoListCallback);
	}

	function getUserInfoListCallback(msg) {
		alert(" name:" + msg[1].name + "\r\n email:" + msg[1].email
				+ "\r\n createTime:" + msg[1].createTime + "\r\n lastTime:"
				+ msg[1].lastTime);
	}
</script>
</head>
<body>

	用户名：
	<input type="text" id="name">
	<br> 密码：
	<input type="password" id="password">
	<br>
	<button id="getResult" onClick="getResult()">获取结果</button>

	<hr>

	用户ID：
	<input type="text" id="userID">
	<br>
	<button id="getUserInfo" onClick="getUserInfo()">获取用户信息</button>

	<hr>

	<button id="getUserInfoList" onClick="getUserInfoList()">获取用户信息列表</button>
</body>
</html>