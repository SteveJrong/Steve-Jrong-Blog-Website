/**
 * 后台full text indexes manage index页 JS文件
 * 
 * 创建时间：2016年10月10 日18:20:41
 * 创建人：Steve Jrong
 * 版本：1.0
 */
require(['jquery.min','bootstrap.min','jquery.dialogBox','../manage/other.define/slide-bar'],function (){
	initSlideBar($("#settings-menu-node"), $("#settings-menu"), "full-text-indexes-manage");
	$("#rebuildBtn").click(function (){
		
		$(".loading-pic").css("display","block");
		
		$.getJSON("mReIndexes",function (data){
		
			var title = "";
			var content = "";
			var type = "";
		
			if (data.result == "success") {
				
				title = "重建索引成功";
				content = "您已成功地重建网站所有文章的索引。";
				type = "correct";
			} else {
				title = "重建索引失败";
				content = "在尝试重建索引时失败，请重试。";
				type = "error";
			}
			
			$(".loading-pic").css("display","none");
			
			$('#type-dialogBox').dialogBox({
				type : type,
				width : 350,
				height : 200,
				hasMask : true,
				autoHide : false,
				effect : 'fade',
				title : title,
				content : content,
				hasBtn : true,
				confirmValue : '好',
				confirm : function() {
				},
			});
			
		});
	});
});

/**
 * 获取项目根目录的方法
 * @returns 项目根目录
 */
function getRootPath(){
	//获取当前网址
    var curWwwPath = window.document.location.href;
    //获取主机地址之后的目录
    var pathName = window.document.location.pathname;
    var pos = curWwwPath.indexOf(pathName);
    //获取主机地址
    var localhostPaht = curWwwPath.substring(0, pos);
    //获取带"/"的项目名
    var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
    //返回项目根目录
	return localhostPaht + projectName;
}