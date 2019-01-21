/**
 * 
 */
var ctxPath = window.location.origin + "/" + window.location.pathname.split("/")[1];
var tableData;
$(document).ready(function() {
    requestData("1");
    $("#divPage").on("click", "#bottomPage", function() {
        requestData($(this).attr("value"));
    });

});

$(window).resize(function() {
    var size;
    var clientWidth = document.body.clientWidth;
    console.log(clientWidth);
    if (clientWidth < 1000) {
        size = 3;
    } else if (clientWidth <= 1366) {
        size = 4;
    } else {
        size = 5;
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
        $(ul).append("<li><a href=\"" + ctxPath + data.prodoctUrl + "\"><imgsrc=\"" + ctxPath + data.prodoctPicture + "\"/></a></li>");
        $(ul).append("<li>￥" + data.prodoctPrice + "</li>");
        $(ul).append("<li><a href=\"" + ctxPath + data.prodoctUrl + "\">" + data.prodoctName + "</a></li>");
        $(td).append(ul);
        $(tr).append(td);
    })
    $("#table1").append(tr);
});

function requestData(data) {
    $.getJSON(ctxPath + "/ProductServlet", "page=" + data, function(data) {
        tableData = data;
        console.log(tableData);
        sohwTableData();
        sohwPageData();
    });

}
function sohwTableData() {
    $("#table1").empty();
    $("#divPage").empty();
    console.log("eeeeee" + tableData);
    var tr = $("<tr></tr>");
    $.each(tableData.list, function(i, data) {
        var td = $("<td></td>");
        var div = $("<din></div>");
        if (i % 4 == 0 && i != 0) {
            $("#table1").append(tr);
            tr = $("<tr></tr>");
        }
        $(div).append("<div><a href=\"" + ctxPath + data.prodoctUrl + "\"><img src=\"" + ctxPath + data.prodoctPicture + "\"/></a></div>");
        $(div).append("<div>￥" + data.prodoctPrice + "</div>");
        $(div).append("<div><a href=\"" + ctxPath + data.prodoctUrl + "\">" + data.prodoctName + "</a></div>");
        $(td).append(div);
        $(tr).append(td);
    });
    $("#table1").append(tr);
}
function sohwPageData() {
    if (1 == tableData.currentPage) {
        $("#divPage").append($("<button>上一页</button>").attr("disabled", "disabled"));
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
        if (tableData.currentPage + i > 0 && tableData.currentPage + i <= tableData.totalPage) {
            if (i == 0) {
                $("#divPage").append($("<span></span>").text(tableData.currentPage + i));
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
        $("#divPage").append($("<button>下一页</button>").attr("disabled", "disabled"));
    } else {
        $("#divPage").append($("<button>下一页</button>").attr({
            "id" : "bottomPage",
            "value" : tableData.currentPage + 1
        }));
    }
}