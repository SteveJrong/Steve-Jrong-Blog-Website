/**
 * 前台login页 JS文件
 * 
 * 创建时间：2016年11月9日 21:13:35
 * 创建人：Steve Jrong
 * 版本：1.0
 */
require(['jquery.min','pace.min','modernizr.2.8','jquery.scrollUp.min','scrollup','bootstrap.min','exitdialog.lib'],function (){
	$.get("servlet/ValidateCodeServlet", function(data) {
		$("#safeCode").attr("src", "data:image/png;base64," + data);
	});

	$("#changeCode").bind("click", function() {
		$.get("servlet/ValidateCodeServlet", function(data) {
			$("#safeCode").attr("src", "data:image/png;base64," + data);
		});
	});
});