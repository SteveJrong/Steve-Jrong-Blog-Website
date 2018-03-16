/**
 * 前台personal主页的头像上传嵌入式页 JS文件
 * 
 * 创建时间：2016年12月3日 17:17:20
 * 创建人：Steve Jrong
 * 版本：1.0
 */
require(['jquery.min','jquery.uploadify.min'],function (){
	//这里替换“views”是生产环境所必须的，开发环境不需要替换
	var uploaderPath = getRootPath().replace("views","")+"/uploadHeader";
	var swfPath = getRootPath().replace("views","")+"/resources/assets/swf/uploadify.swf";
	console.log("Uploadify 上传路径："+uploaderPath);
	console.log("Uploadify SWF文件路径："+swfPath);
	
	$('#uploadify').uploadify({
		"buttonText":"选择图片文件",
		"debug":false,
		"auto":true,
		"method":"post",
		"fileSizeLimit":"102400KB",
		"fileObjName":"uploadFiles",// important ,this name should be the same as the name in the action 
		"wmode": "transparent", //设置按钮背景透明
		"swf":swfPath,
		"uploader":uploaderPath,
		'onUploadComplete' : function(file) {
			//表示上传成功
			if (file.name != "" && file.name != null && file.name != undefined) {
				var imgPath = "resources/upload/users_header/temp_file/"+file.name;
				console.log("头像临时文件路径："+imgPath);
				$("#imgPath", parent.document).attr("data-bind",imgPath);
				$("#imgName", parent.document).attr("data-bind",file.name);
				
				$("#upload-result").attr("class","ion-checkmark-circled");
				$("#upload-result").text("上传成功。");
				$("#upload-result").css({"text-align":"center"});
				
				$("#upload-msg").text("点击“确定”。");
				$("#upload-msg").css({"color":"gray","font-size":"0.5em","text-align":"center"});
			}else{
				$("#upload-result").attr("class","ion-close-circled");
				$("#upload-result").text("上传失败！");
				$("#upload-result").css({"text-align":"center"});
				
				$("#upload-msg").text("请重试。");
				$("#upload-msg").css({"color":"red","font-size":"0.5em","text-align":"center"});
			}
    	},
    	'onQueueComplete' : function(queueData) {
    		console.log(queueData.uploadsSuccessful + "个文件已成功上传。");
    	}
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
	console.log("Host machine dictionary:"+pathName);
    var pos = curWwwPath.indexOf(pathName);
    //获取主机地址
    var localhostPath = curWwwPath.substring(0, pos);
    //获取带"/"的项目名
    var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
    //返回项目根目录
	return localhostPath + projectName;
}