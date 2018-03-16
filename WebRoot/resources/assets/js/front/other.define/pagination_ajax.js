/**
 * 前台Ajax分页 通用JS文件
 * 
 * 创建时间：2017年5月3日 下午8:05:54
 * 创建人：Steve Jrong
 * 版本：1.0
 */
define(['jquery.min'],function (){
});

/**
 * Ajax分页方法
 * @param prevPageIndex 上一页
 * @param nextPageIndex 下一页
 * @param pageIndex 当前页
 * @param lastPageIndex 最后一页
 * @param totalPageSize 总页数
 * @param totalCount 数据总数
 */
function paginationAjax(prevPageIndex, nextPageIndex, pageIndex, lastPageIndex, totalPageSize, totalCount){
	$(".homePageButton").attr("href","javascript:pageSkip(1,'first');");
	$("#homePageNum").html("1");
	
	$(".prevPageButton").attr("href","javascript:pageSkip(" + prevPageIndex + ",'front');");
	$("#prevPageNum").html(prevPageIndex);
	
	$(".currentPageButton").attr("href","javascript:void(0);");
	$("#currentPageNum").html(pageIndex);
	
	$(".nextPageButton").attr("href","javascript:pageSkip(" + nextPageIndex + ",'back');");
	$("#nextPageNum").html(nextPageIndex);
	
	$(".lastPageButton").attr("href","javascript:pageSkip(" + lastPageIndex + ",'last');");
	$("#lastPageNum").html(lastPageIndex);
	
	$("#totalPagesNum").html(totalPageSize);
	
	//当前页等于上一页，上一页按钮不显示
	if (parseInt(prevPageIndex) == parseInt(pageIndex)) {
		$(".prevPageButton").css("display","none");
	}else {
		$(".prevPageButton").css("display","block");
	}
	
	//当当前页数大于1时要显示“首页”按钮
	if (parseInt(pageIndex)>1) {
		$(".homePageButton").css("display","block");
	}else {
		$(".homePageButton").css("display","none");
	}
	
	//当最后一页小于总页数时要显示“末页”按钮
	if (parseInt(pageIndex) < parseInt(totalPageSize)) {
		$(".lastPageButton").css("display","block");
	}else {
		$(".lastPageButton").css("display","none");
	}
	
	if (parseInt(nextPageIndex) > parseInt(lastPageIndex)) {
		$(".nextPageButton").css("display","none");
	}else {
		$(".nextPageButton").css("display","block");
	}
}