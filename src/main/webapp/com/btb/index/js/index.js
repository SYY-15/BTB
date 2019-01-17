/**
 * 
 */
$(document).ready(function() {
	
$("#div1").load("/ProductSelvlet",function(response,status){
	if(status=='success'){
		alert("请求成功");
		alert(response.producturl);
		"<td><img src="+response.productrul+"/></td>"
		
	}else{
		
		alert("请求失败");
		
	}

	
	
})
});
