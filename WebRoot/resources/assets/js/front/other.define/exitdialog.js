/**
 * 用户退出模态框 JS文件
 * 
 * 创建时间：2016年2月16日21:48:30
 * 创建人：Steve Jrong
 * 版本：1.0
 * 
 */
define(['jquery.min','dialogfx'],function (){
	(function() {
		//注销框
		var dlgtrigger;
		
		try {
			dlgtrigger = document.querySelector('[data-dialog]'), somedialog = document
			.getElementById(dlgtrigger.getAttribute('data-dialog')), dlg = new DialogFx(
			somedialog);
			dlgtrigger.addEventListener('click', dlg.toggle.bind(dlg));
		} catch (e) {
			console.log("出错："+e.message);
		}
		
	})(jQuery);
});