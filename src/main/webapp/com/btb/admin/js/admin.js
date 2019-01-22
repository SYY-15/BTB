/**
 * 
 */
var ctxPath = window.location.origin + "/"
		+ window.location.pathname.split("/")[1];
var tableData;
$(document).ready(function() {
	requestData("1");
	$("#divPage").on("click", "#bottomPage", function() {
		requestData($(this).attr("value"));
	});

});


function requestData(data) {
	$.getJSON(ctxPath + "/ProductServlet", "page=" + data, function(data) {
		tableData = data;
		console.log(tableData);
		showTableData();
		showPageData();
		$("#table1").show();
	});

}
function showTableData() {
	
	$("#table1 tr").not("#table1 tr:first").remove();
	$("#divPage").empty();
	var id = 1;
	$.each(tableData.list, function(i, data) {
		var tr = $("<tr></tr>");
		$(tr).append("<td><input type=\"checkbox\" value=\""+data.id+"\"></td>");
		$(tr).append("<td>"+ id +"</td>");
		$(tr).append("<td>"+ data.prodoctName + "</td>");
		$(tr).append("<td>"+ data.prodoctPrice + "</td>");
		$(tr).append("<td>"+ data.prodoctUrl + "</td>");
		$(tr).append("<td>"+ data.prodoctPicture + "</td>");
		$(tr).append("<td><button  value=\""+data.id+"\">修改</button><button  value=\""+data.id+"\">删除</button></td>");
		$("#table1").append(tr);
	});
}
function showPageData() {
	if (1 == tableData.currentPage) {
		$("#divPage").append(
				$("<button>上一页</button>").attr("disabled", "disabled"));
	} else {
		$("#divPage").append($("<button>上一页</button>").attr({
			"id" : "bottomPage",
			"value" : tableData.currentPage - 1
		}));
	}
	if (tableData.currentPage >= 5) {
		$("#divPage").append($("<button>1</button>").attr({
			"id" : "bottomPage",
			"value" : 1
		}));
		if (tableData.currentPage != 5) {
			$("#divPage").append($("<span>...</span>"));
		}
	}
	for (var i = -3; i < 3; i++) {
		if (tableData.currentPage + i > 0
				&& tableData.currentPage + i <= tableData.totalPage) {
			if (i == 0) {
				$("#divPage").append(
						$("<span></span>").text(tableData.currentPage + i));
			} else {
				$("#divPage").append($("<button></button>").attr({
					"id" : "bottomPage",
					"value" : tableData.currentPage + i
				}).text(tableData.currentPage + i));
			}
		}
	}
	if (tableData.currentPage + 3 <= tableData.totalPage) {
		if (tableData.currentPage + 3 != tableData.totalPage) {
			$("#divPage").append($("<span>...</span>"));
		}
		$("#divPage").append($("<button></button>").attr({
			"id" : "bottomPage",
			"value" : tableData.totalPage
		}).text(tableData.totalPage));
	}
	if (tableData.currentPage == tableData.totalPage) {
		$("#divPage").append(
				$("<button>下一页</button>").attr("disabled", "disabled"));
	} else {
		$("#divPage").append($("<button>下一页</button>").attr({
			"id" : "bottomPage",
			"value" : tableData.currentPage + 1
		}));
	}
}