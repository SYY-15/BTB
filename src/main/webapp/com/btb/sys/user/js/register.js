/**
 * 
 */
$(document).ready(function() {
	var ctxPath = window.location.origin+"/"+window.location.pathname.split("/")[1];
	$("#register").click(function() {
		$.ajax({
			type : $("form").attr("method"),
			url : ctxPath+$("form").attr("action"),
			data : $("form").serialize(),
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