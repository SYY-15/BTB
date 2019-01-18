/**
 * 
 */
var ctxPath = window.location.origin + "/"
					+ window.location.pathname.split("/")[1];
var tableData;
$(document).ready(
		function() {
			
			$.getJSON(ctxPath + "/ProductServlet", function(data) {
				var tr = $("<tr></tr>");
				tableData = data.data;
				$.each(data.data, function(i, data) {
					var td = $("<td></td>");
					if (i % 4 == 0 && i != 0) {
						$("#table1").append(tr);
						tr = $("<tr></tr>");
					}
					var ul = $("<ul></ul>");
					$(ul).append(
							"<li><a href=\"" + ctxPath + data.prodoctUrl
									+ "\"><img src=\"" + ctxPath
									+ data.prodoctPicture + "\"/></a></li>");
					$(ul).append("<li>￥" + data.prodoctPrice + "</li>");
					$(ul).append(
							"<li><a href=\"" + ctxPath + data.prodoctUrl
									+ "\">" + data.prodoctName + "</a></li>");
					$(td).append(ul);
					$(tr).append(td);
				})
				$("#table1").append(tr);

			})

		});
$(window).resize(function() {
	var size = 4;
	console.log(document.body.clientWidth);
	
	if(document.body.clientWidth < 1000){
		size=3;
	}else if(document.body.clientWidth <= 1366){
		size=4;
	}else{
		size=5;
	}
	var tr = $("<tr></tr>");
	$("#table1").empty();
	$.each(tableData, function(i, data) {
		var td = $("<td></td>");
		if (i % size == 0 && i != 0) {
			$("#table1").append(tr);
			tr = $("<tr></tr>");
		}
		var ul = $("<ul></ul>");
		$(ul).append(
				"<li><a href=\"" + ctxPath + data.prodoctUrl
						+ "\"><img src=\"" + ctxPath
						+ data.prodoctPicture + "\"/></a></li>");
		$(ul).append("<li>￥" + data.prodoctPrice + "</li>");
		$(ul).append(
				"<li><a href=\"" + ctxPath + data.prodoctUrl
						+ "\">" + data.prodoctName + "</a></li>");
		$(td).append(ul);
		$(tr).append(td);
	})
	$("#table1").append(tr);
});