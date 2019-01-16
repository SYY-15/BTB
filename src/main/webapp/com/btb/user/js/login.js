/**
 * 登录页面脚本
 */
$(document).ready(function() {
		$("#dl").click(function() {
			var data = $("form").serialize();
			$.ajax({
				type : 'post',
				url : "/BTB/LoginServlet",
				cache : false,
				data : data,
				dataType : 'json',
				success : function(data) {
					alert(data.msg);
					if (data.status == 1) {
						window.location.href = "register.html"
					} 
				},
				error : function() {
					alert("请求失败")
				}
			})
		});

	});