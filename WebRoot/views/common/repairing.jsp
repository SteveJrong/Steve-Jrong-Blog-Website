<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
	<head>
		<base href="<%=basePath %>">
		<title>维护中 :: Steve Jrong's Blog</title>
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
	    <div class="f404"><span>F</span><span>I</span><span>X</span></div>
	    <div class="f404-des">
	    	给我一点时间  让我把您的梦想打造的更完美<br/>
	    </div>
	  </div>
	</body>
</html>