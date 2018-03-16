<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
	<head>
		<base href="<%=basePath %>">
		<title>您访问的资源受限 :: Steve Jrong's Blog</title>
		<!-- Meta Tags -->
		<meta charset="utf-8">
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
	    <div class="f404"><span>4</span><span>0</span><span>3</span></div>
	    <div class="f404-des">
	    	非常抱歉&nbsp;&nbsp;您暂无权限访问此资源哦<br/>
	    </div>
	  </div>
	</body>
</html>