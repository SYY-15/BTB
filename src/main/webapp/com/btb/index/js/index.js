/**
 * 
 */
$(document).ready(
		function() {
			var ctxPath = window.location.origin + "/"
					+ window.location.pathname.split("/")[1];
			$.getJSON(ctxPath + "/ProductServlet", function(data) {
				$.each(data.data, function(i, data) {
					console.log(data.prodoctPicture);
					$("#table1").append("<tr><td id=\"td1\">");
					$("#td1").append("<img src=\""+ctxPath+data.prodoctPicture+"\"/>");
					$("#table1").append("</td></tr>");
					
					
					
				})

			})
		});
