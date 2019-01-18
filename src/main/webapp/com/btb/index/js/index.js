/**
 * 
 */
$(document).ready(
		function() {
			var ctxPath = window.location.origin + "/"
					+ window.location.pathname.split("/")[1];
			$.getJSON(ctxPath + "/ProductServlet", function(data) {
				var tr = $("<tr></tr>");
				$.each(data.data, function(i, data) {
					if (i%4 == 0) {
						$("#table1").append(tr);
						tr = $("<tr></tr>");
					}
					var div = $("<div></div>");
					$(div).append("<img src=\""+ctxPath+data.prodoctPicture+"\"/>");
					$(div).append("<a href=\""+ctxPath+data.prodoctUrl+"\"/>"+ctxPath+data.prodoctName+"</p>");
					$(div).append("<p>"+ctxPath+data.prodoctPrice+"</p>");
					$(tr).append(div);
				})
				$("#table1").append(tr);
			})
		});
