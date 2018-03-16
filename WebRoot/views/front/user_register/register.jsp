<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
	<head>
	    <title>欢迎来访 快速注册</title>
	    <!-- Meta Tags -->
	    <meta charset="UTF-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
	    <!-- Website Logo -->
		<link rel="icon" href="resources/assets/img/logo/favicon.ico" type="image/x-icon" />
		<link rel="shortcut icon" href="resources/assets/img/logo/favicon.ico" type="image/x-icon" />
	    <!-- Basic CSS -->
	    <link rel="stylesheet" href="resources/assets/css/bootstrap.min.css">
	    <link rel="stylesheet" href="resources/assets/css/ionicons.min.css">
	    <link rel="stylesheet" href="resources/assets/css/pace.css">
	    <link rel="stylesheet" href="resources/assets/css/custom.css">
	    <link rel="stylesheet" href="resources/assets/css/dropdownlist.css" />
	    <!-- jQuery ScrollUp CSS -->
		<link rel="stylesheet" href="resources/assets/css/scrollUp.css" type="text/css"></link>
		<!-- Dialog css file -->
		<link rel="stylesheet" href="resources/assets/css/dialog-ken.css" type="text/css"></link>
		<link rel="stylesheet" href="resources/assets/css/dialog.css" type="text/css"></link>
		<link rel="stylesheet" href="resources/assets/css/demo.css" type="text/css"></link>
	</head>
	<body id="page">
	    <div class="container">
	        <!-- Common Header -->
			<jsp:include page="/views/front/common/header.jsp"></jsp:include>
	    </div>
	    <div class="content-body">
	        <div class="container">
	            <div class="row">
	                <main class="col-md-12">
	                    <h1 class="page-title">欢迎来访&nbsp;&nbsp;快速注册</h1>
	                    <article class="post">
	                        <div class="entry-content clearfix">
	                            <form action="doreg" method="post" class="contact-form" id="registerForm">
	                                <div class="row">
	                                    <div class="col-md-6 col-md-offset-3">
	                                        <input type="text" name="user.UNickname" placeholder="请键入您的昵称" required>
	                                        <select id="selectGender" name="user.UGender">
	                                            <option value="无" selected="selected">--选择您的性别--</option>
	                                            <option value="男">我是男生</option>
	                                            <option value="女">我是女生</option>
	                                        </select>
	                                        <select id="chooseAge" name="user.UAge">
	                                            <option value="无" selected="selected">--选择您的年龄--</option>
	                                        </select>
	                                        <input type="password" id="pwd" name="user.UPwd" placeholder="请键入您的密码" required>
	                                        <input type="password" id="repwd" name="userRePwd" placeholder="请确认您的密码" required>
	                                        <input type="text" name="user.USecurityquestionanswer" placeholder="设置密保问题：您父亲的父亲名字叫什么？" required>
	                                        <input type="email" name="user.UEmail" placeholder="请键入您的电子邮件地址" required>
	                                        <input type="text" name="qqNum" placeholder="请键入您的QQ号码" required>
	                                        <button class="btn-send btn-5 btn-5b ion-ios-paperplane"><span>快速注册</span></button>
	                                    </div>
	                                </div>	<!-- row -->
	                            </form>
	                        </div>
	                    </article>
	                </main>
	            </div>
	        </div>
	    </div>
	    <!-- Common Footer -->
		<jsp:include page="/views/front/common/footer.jsp"></jsp:include>
		<!-- Common Mobile Menu -->
		<jsp:include page="/views/front/common/mobilemenu.jsp"></jsp:include>
		<!-- RequireJS Lib -->
		<script src="resources/assets/js/lib/require.js" data-main="resources/assets/js/lib/main"></script>
		<!-- Define Homepage Js -->
		<script src="resources/assets/js/front/page.define/register-page.js"></script>
	</body>
</html>