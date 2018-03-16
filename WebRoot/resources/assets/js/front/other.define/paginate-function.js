/**
 * 前台分页执行函数 通用JS文件
 * 
 * 创建时间：2016年11月9日 10:06:03
 * 创建人：Steve Jrong
 * 版本：1.0
 */
function pageSkip(num,type){
	if (type === "front") {
		$("input[name*='pageIndex']").val(parseInt($("#currentPageNum").text())-1);
	}else if (type === "back") {
		$("input[name*='pageIndex']").val(parseInt($("#currentPageNum").text())+1);
	}else if (type === "last") {
		$("input[name*='pageIndex']").val($("#lastPageNum").text()*1);
	}else if (type === "first") {
		$("input[name*='pageIndex']").val($("#homePageNum").text()*1);
	}
	window.location.href=$("#pagination_redirect_urlrewrite").val()+$("input[name*='pageIndex']").val();
}