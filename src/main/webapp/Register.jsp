<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册</title>
</head>
<body>
	<form action="UserServlet" method="post">
	<p>用户名:</p>
	<input  type="text" name="name"><p style="color:red">${sb}</p>
	<p>密码:</p>
	<input  type="password" name="password" maxlength="20" >
	<p></p>
	<input type="submit"  value="注册">
	</form>
	<p>${cg}</p>
</body>
</html>