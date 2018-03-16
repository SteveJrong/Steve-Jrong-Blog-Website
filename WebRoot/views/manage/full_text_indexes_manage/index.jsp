<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
	<head>
	    <title>Steve Jrong's Blog :: 全文索引管理</title>
	    <!-- Meta Tags -->
	    <meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="author" content="SteveJrong">
		<!-- Website Logo -->
		<link rel="icon" href="resources/assets/img/logo/favicon.ico" type="image/x-icon" />
		<link rel="shortcut icon" href="resources/assets/img/logo/favicon.ico" type="image/x-icon" />
		<!-- Basic CSS -->
	    <link rel="stylesheet" href="resources/assets/css/bootstrap.css">
	    <link rel="stylesheet" href="resources/assets/css/theme.css">
	    <link rel="stylesheet" href="resources/assets/css/font-awesome.css">
	    <!-- DialogBox CSS -->
	    <link rel="stylesheet" href="resources/assets/css/jquery.dialogbox.css">
	    <!-- Define full text indexes manage index page CSS -->
	    <link rel="stylesheet" href="resources/assets/css/customcss/allarticlesmanagecss.css">
	</head>
	<body>
		<!-- Common Header -->
		<jsp:include page="/views/manage/common/header.jsp"></jsp:include>
		<!-- Common SlideBar -->
		<jsp:include page="/views/manage/common/slidebar.jsp"></jsp:include>
		<div class="content">
		    <div class="header">
		        <h1 class="page-title">全文索引管理</h1>
		    </div>
		    <ul class="breadcrumb">
		        <li><a href="manage">主页</a> <span class="divider">/</span></li>
		        <li><a class="active">全文索引管理</a></li>
		    </ul>
		    <div class="container-fluid">
		        <div class="row-fluid">
		            <h2>手动管理全文索引</h2>
		            <img class="loading-pic" src="loadingMixRadio" width="38px" height="38px" />
	            	<p align="right"><button id="rebuildBtn" class="btn btn-primary">开始重建</button></p>
		            <!-- Common Footer -->
		            <jsp:include page="/views/manage/common/footer.jsp"></jsp:include>
		        </div>
		    </div>
		</div>
		<!-- RequireJS Lib -->
		<script src="resources/assets/js/lib/require.js" data-main="resources/assets/js/lib/main"></script>
		<!-- Define article manage page Js -->
		<script src="resources/assets/js/manage/page.define/m-full-text-indexes-manage-index-page.js"></script>
	</body>
</html>