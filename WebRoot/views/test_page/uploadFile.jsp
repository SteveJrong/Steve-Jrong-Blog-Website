<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<base href="<%=basePath%>">
	<title>My JSP 'uploadFile.jsp' starting page</title>
	<link rel="stylesheet" href="css/uploadify.css" />
	<style type="text/css">
		a{
			text-decoration: none;
			color:black;
		}
	</style>
</head>

<body>
	<input type="file" name="uploadFiles" id="uploadify" />
	<p><a href="javascript:$('#uploadify').uploadify('upload')">开始上传</a></p>
	
	<div id="progress"></div>
	<div id="singleFileUploadResultShow"></div>
	<div id="queueFileUploadResultShow"></div>
	
	<a href="javascript:$('#uploadify').uploadify('cancel')">结束第一个文件的上传</a> | <a href="javascript:$('#uploadify').uploadify('cancel', '*')">清除上传队列</a>
	
	<script src="js/jquery-1.7.2.min.js"></script>
	<script src="js/jquery.uploadify.min.js"></script>
	<script type="text/javascript">
		$(function(){
  		initUploadify();
  	});
  	function initUploadify(){
  		$('#uploadify').uploadify({
  			"buttonText":"选择文件",
  			"debug":false,
  			//"auto":false,
  			"method":"post",
  			'fileSizeLimit' : '102400KB',
  			"fileObjName":"uploadFiles",// important ,this name should be the same as the name in the action 
  			'wmode': 'transparent', //设置按钮背景透明
  			"swf":"<%=basePath%>js/uploadify.swf",
  			"uploader":"<%=basePath%>uploadFiles.action",
			'onUploadComplete' : function(file) {
            	$("#singleFileUploadResultShow").append(file.name+"已上传成功，大小为"+(file.size/1024/1024).toFixed(1)+"MB。<br/>");
        	},
        	'onQueueComplete' : function(queueData) {
        		$("#queueFileUploadResultShow").html(queueData.uploadsSuccessful + "个文件已成功上传。");
        	}
		});
	}
	</script>
</body>
</html>
