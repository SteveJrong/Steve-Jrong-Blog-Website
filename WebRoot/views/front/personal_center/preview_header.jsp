<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<base href="<%=basePath%>">
		<!-- JCoup CSS -->
		<link rel="stylesheet" href="resources/assets/css/jcoup/jquery.Jcrop.min.css" type="text/css"></link>
		<link rel="stylesheet" href="resources/assets/css/jcoup/layout.css" type="text/css"></link>
	</head>
	<body>
		<div style="width:30em;height:30em;margin:0em auto">
			<p>请在左侧大图区域使用鼠标截取合适的区域作为您的头像。</p>
			<img id="target" alt="原图" />
	   			<div id="preview-pane">
				<div class="preview-container">
					<img class="jcrop-preview" alt="预览" />
				</div>
			</div>
		</div>
		
		<!-- 隐藏域 -->
		<input type="hidden" id="imageX" name="imageX" />
		<input type="hidden" id="imageY" name="imageY" />
		<input type="hidden" id ="imageHeight" name="imageHeight" />
		<input type="hidden" id="imageWidth" name="imageWidth" />
					
		<script src="resources/assets/js/lib/require.js" data-main="resources/assets/js/lib/main"></script>
		<!-- Define Preview Header Embedded Page Js -->
		<script src="resources/assets/js/front/page.define/preview-header-embedded-page.js"></script>
	</body>
</html>