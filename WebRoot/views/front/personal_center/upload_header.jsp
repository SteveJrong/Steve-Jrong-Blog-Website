<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<base href="<%=basePath%>">
		<!-- Basic CSS -->
		<link rel="stylesheet" href="resources/assets/css/ionicons.min.css">
		<!-- Uploadify Plugin CSS -->
		<link rel="stylesheet" href="resources/assets/css/uploadify.css" />
		<style type="text/css">.uploadify-queue{ display: none; }</style>
	</head>
	<body>
		<div style="width:100px;height:100px;margin:0px auto">
			<input type="file" name="uploadFiles" id="uploadify" />
			<div id="upload-result"></div>
			<div id="upload-msg"></div>
		</div>
		<script src="resources/assets/js/lib/require.js" data-main="resources/assets/js/lib/main"></script>
		<!-- Define Homepage Js -->
		<script src="resources/assets/js/front/page.define/upload-header-embedded-page.js"></script>
	</body>
</html>