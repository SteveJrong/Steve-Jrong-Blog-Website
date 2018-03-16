/**
 * 前台分页 通用JS文件
 * 
 * 创建时间：2016年10月28日 16:41:10
 * 创建人：Steve Jrong
 * 版本：1.0
 */
define(['jquery.min'],function (){
	$(function (){
		//前一页
		var prevPageIndex = $("#prevPageNum").text();
		
		//当前页
		var currentPageIndex = $("#currentPageNum").text();
		
		//下一页
		var nextPageIndex = $("#nextPageNum").text();
		
		//末页
		var lastPageIndex = $("#lastPageNum").text();
		
		//总页数
		var totalPagesIndex = $("#totalPagesNum").text();
		
		//当前页等于上一页，上一页按钮不显示
		if (parseInt(prevPageIndex) == parseInt(currentPageIndex)) {
			$(".prevPageButton").css("display","none");
		}else {
			$(".prevPageButton").css("display","block");
		}
		
		//当当前页数大于1时要显示“首页”按钮
		if (parseInt(currentPageIndex)>1) {
			$(".homePageButton").css("display","block");
		}else {
			$(".homePageButton").css("display","none");
		}
		
		//当最后一页小于总页数时要显示“末页”按钮
		if (parseInt(currentPageIndex) < parseInt(totalPagesIndex)) {
			$(".lastPageButton").css("display","block");
		}else {
			$(".lastPageButton").css("display","none");
		}
		
		if (parseInt(nextPageIndex) > parseInt(lastPageIndex)) {
			$(".nextPageButton").css("display","none");
		}else {
			$(".nextPageButton").css("display","block");
		}
	});
});