<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#zc").click(function() {
			var data = $("form").serialize();
			$.ajax({
				type : 'post',
				url : "UserServlet",
				cache : false,
				data : data,
				dataType : 'json',
				success : function(data) {
					alert(data.mgs);
				},
				error : function() {
					alert("请求失败")
				}
			})
		});

	});
</script>
<title>注册</title>
</head>
<body>
	<form  method="post">
		<p>用户名:</p>
		<input type="text" name="name">
		<p id="p1" style="color: red">${sb}</p>
		<p>密码:</p>
		<input type="password" name="password" maxlength="20">
		<p></p>
		<input id="zc" type="button" value="注册">
	</form>
	<p>${cg}</p>
</body>
</html>