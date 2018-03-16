<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
	<head>
	    <title>欢迎来访 请您登录 :: Steve Jrong's Blog</title>
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
	                    <h1 class="page-title">欢迎来访&nbsp;&nbsp;请您登录</h1>
	                    <article class="post">
	                        <div class="entry-content clearfix">
	                            <form action="dologin" method="post" class="contact-form">
	                                <div class="row">
	                                    <div class="col-md-6 col-md-offset-3">
	                                    	<s:if test="#request.message != null">
			                                    <span style="color:darkred;"><img style="margin-top: -4px; margin-right: 10px;" src="warning" title="警告信息" alt="警告" width="18" height="18"/>${message }</span>
	                                    	</s:if>
	                                        <input type="text" name="users.UNickname" placeholder="请键入您的用户名" required>
	                                        <input type="password" name="users.UPwd" placeholder="请键入您的登录密码" required>
	                                        <input type="text" name="checkedCode" placeholder="请键入验证码" required>
	                                        <input type="hidden" name="refererUrl" value="<%=request.getHeader("referer") %>" />
	                                        <p>
	                                        	<img src="servlet/ValidateCodeServlet" alt="验证码" id="safeCode" />
	                                        	<a id="changeCode" style="cursor: pointer;">看不清，换一张</a>
	                                        </p>
	                                        <button class="btn-send btn-5 btn-5b ion-ios-paperplane"><span>一键登录</span></button>
	                                        <p align="right"><a href="reg">还没有账号？立即注册</a></p>
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
		<script src="resources/assets/js/front/page.define/login-page.js"></script>
	</body>
</html>