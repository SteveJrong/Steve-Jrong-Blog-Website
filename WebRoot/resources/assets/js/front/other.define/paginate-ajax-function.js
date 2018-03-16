/**
 * 前台Ajax分页执行函数 通用JS文件
 * 
 * 创建时间：2017年5月9日 下午7:52:24
 * 创建人：Steve Jrong
 * 版本：1.0
 */
function pageSkip(num,type){
	if (type === "front") {
		$("#currentPageNum").html(parseInt($("#currentPageNum").text())-1);
	}else if (type === "back") {
		$("#currentPageNum").html(parseInt($("#currentPageNum").text())+1);
	}else if (type === "last") {
		$("#currentPageNum").html($("#lastPageNum").text()*1);
	}else if (type === "first") {
		$("#currentPageNum").html($("#homePageNum").text()*1);
	}
	
	getAjaxData();
}