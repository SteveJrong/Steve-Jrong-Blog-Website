<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
	<head>
		<base href="<%=basePath %>">
		<title>此模块正在开发中 :: Steve Jrong's Blog</title>
		<!-- Meta Tags -->
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- Website Logo -->
		<link rel="icon" href="resources/assets/img/logo/favicon.ico" type="image/x-icon" />
		<link rel="shortcut icon" href="resources/assets/img/logo/favicon.ico" type="image/x-icon" />
		<!-- Basic CSS -->
		<link rel="stylesheet" type="text/css" href="resources/assets/css/customcss/commonpagecss.css" />
	</head>
	<body>
		<div class="page404">
			<div class="f404"><span>B</span><span>L</span><span>D</span></div>
		  		<div class="f404-des">
		  			非常抱歉 ，您访问的模块正在开发中，目前暂时无法访问，给您带来的不便我们深表歉意<br/>3秒钟后带您浏览更多精彩内容<br/>
		  	</div>
		</div>
	  	<!-- RequireJS Lib -->
		<script src="resources/assets/js/lib/require.js" data-main="resources/assets/js/lib/main"></script>
		<!-- Define Homepage Js -->
		<script src="resources/assets/js/front/page.define/developing-page.js"></script>
	</body>
</html>