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

				if (data.status == 1) {
					window.location.href = "../../index/html/index.html"
				} else {
					alert(data.msg);
				}
			},
			error : function() {
				alert("请求失败")
			}
		})
	});

});