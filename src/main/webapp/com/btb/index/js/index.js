/**
 * 
 */
var ctxPath = window.location.origin + "/"
		+ window.location.pathname.split("/")[1];
var tableData, size;
$(document).ready(function() {
	getSize();
	requestData("1");
	$("#divPage").on("click", "#bottomPage", function() {
		requestData($(this).attr("value"));
	});

});

$(window).resize(function() {
	getSize();
	showTableData();
	showPageData();
});
function getSize() {
	var clientWidth = document.body.clientWidth;
	console.log(clientWidth);
	if (clientWidth < 900) {
		size = 3;
	} else if (clientWidth <= 1100) {
		size = 4;
	} else {
		size = 5;
	}
}

function requestData(data) {
	$.getJSON(ctxPath + "/ProductServlet", "page=" + data, function(data) {
		tableData = data;
		console.log(tableData);
		showTableData();
		showPageData();
		$("#table").show();
	});

}
function showTableData() {
	$("#table1").empty();
	$("#divPage").empty();
	var tr = $("<tr height=\"360px\"></tr>");
	$.each(tableData.list, function(i, data) {
		var td = $("<td></td>");
		var div = $("<div></div>");
		if (i % size == 0 && i != 0) {
			$("#table1").append(tr);
			tr = $("<tr height=\"360px\"></tr>");
		}
		$(div).append(
				"<div class=\"div\"><a href=\"" + ctxPath + data.prodoctUrl
						+ "\"><img src=\"" + ctxPath + data.prodoctPicture
						+ "\"/></a></div>");
		$(div).append("<div>￥" + data.prodoctPrice + "</div>");
		$(div).append(
				"<div><a href=\"" + ctxPath + data.prodoctUrl + "\">"
						+ data.prodoctName + "</a></div>");
		$(td).append(div);
		$(tr).append(td);
	});
	$("#table1").append(tr);
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