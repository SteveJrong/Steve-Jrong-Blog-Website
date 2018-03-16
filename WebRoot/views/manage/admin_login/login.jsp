<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
	<head>
		<title>欢迎登录 :: Steve Jrong's Blog后台管理系统</title>
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
		
		<!-- Demo page code -->
		<style type="text/css">
		#line-chart {
			height: 300px;
			width: 800px;
			margin: 0px auto;
			margin-top: 1em;
		}
		
		.brand {
			font-family: georgia, serif;
		}
		
		.brand .first {
			color: #ccc;
			font-style: italic;
		}
		
		.brand .second {
			color: #fff;
			font-weight: bold;
		}
		</style>
	</head>
	<body class="">
		<div class="navbar">
			<div class="navbar-inner">
				<ul class="nav pull-right">
				</ul>
				<a class="brand" href="manage"><span class="first">Steve
						Jrong's Blog</span> <span class="second">后台管理</span></a>
			</div>
		</div>
		<div class="row-fluid">
			<div class="dialog">
				<div class="block">
					<p class="block-heading">欢迎您登录</p>
					<div class="block-body">
						<form>
							<label>管理员账户</label> <input type="text" class="span12"> <label>管理员密码</label>
							<input type="password" class="span12"> <a
								href="index.html" class="btn btn-primary pull-right">登录</a> <label
								class="remember-me"><input type="checkbox"> 记住我</label>
							<div class="clearfix"></div>
						</form>
					</div>
				</div>
				<p class="pull-right" style="">
					<a href="#" target="blank">Powered by Steve Jrong</a>
				</p>
				<p>
					<a href="reset-password.html">忘记密码？立即找回</a>
				</p>
			</div>
		</div>
		<!-- RequireJS Lib -->
		<script src="resources/assets/js/lib/require.js" data-main="resources/assets/js/lib/main"></script>
		<!-- Define article manage page Js -->
		<script src="resources/assets/js/manage/page.define/m-login-manage-index-page.js"></script>
	</body>
</html>