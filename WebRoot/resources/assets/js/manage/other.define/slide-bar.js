/**
 * 后台所有页边栏样式 自定义 通用JS文件
 * 
 * 创建时间：2016年11月17日 13:25:15
 * 创建人：Steve Jrong
 * 版本：1.0
 */

/*
 * 初始化边栏样式的方法
 * 
 * $elementOfParentNode <a>标签（可点击的父节点）元素
 * $elementOfUl <ul>标签列表元素
 * correctDataBindValue 要比较的data-bind属性值
 */
function initSlideBar($elementOfParentNode,$elementOfUl,correctDataBindValue){
	//移除模块管理下的默认class
	$elementOfParentNode.removeClass("nav-header collapsed");
	//为模块管理新加class
	$elementOfParentNode.addClass("nav-header");
	
	//为模块管理列表新加class
	$elementOfUl.addClass("nav nav-list collapse in");
	//为模块管理下的“博文类型管理”新加class
	$elementOfUl.children("li").each(function (){
		var elementDataBindValue = $(this).attr("data-bind");
		if(elementDataBindValue === correctDataBindValue){
			$(this).addClass("active");
			return;
		}
	});
}
