/**
 * jQuery EasyUI语言设置 通用JS文件
 * 
 * 创建时间：2016年3月26日 16:20:30
 * 创建人：Steve Jrong
 * 版本：1.0
 */
define(['jquery.min'],function (){
	if ($.fn.pagination) {
		$.fn.pagination.defaults.beforePageText = '第';
		$.fn.pagination.defaults.afterPageText = '共{pages}页';
		$.fn.pagination.defaults.displayMsg = '显示数据从第{from}条到{to}条	共{total}条记录';
	}
	if ($.fn.datagrid) {
		$.fn.datagrid.defaults.loadMsg = '正在处理，请稍候…………';
	}
});