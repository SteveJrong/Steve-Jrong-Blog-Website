<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
	<html>
	<head>
		<title>个人中心 :: Steve Jrong's Blog</title>
		<!-- Meta Tags -->
		<meta charset="UTF-8">
		<meta name="description" content="Steve Jrong个人博客用户中心，信息展示。">
		<meta name="keywords" content="Steve Jrong，个人中心，登录，授权，信息，用户信息">
		<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="author" content="SteveJrong">
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
		<!-- Exit Dialog CSS -->
		<link rel="stylesheet" href="resources/assets/css/dialog-ken.css" type="text/css"></link>
		<link rel="stylesheet" href="resources/assets/css/dialog.css" type="text/css"></link>
		<link rel="stylesheet" href="resources/assets/css/demo.css" type="text/css"></link>
		<!-- Zero Modal Dialog CSS -->
		<link rel="stylesheet" href="resources/assets/css/zeroModal.css" type="text/css"></link>
		<!-- Social Share CSS -->
		<link rel="stylesheet" href="resources/assets/css/social-share.css" type="text/css"></link>
		
		<!-- JCoup CSS -->
		<!-- <link rel="stylesheet" href="resources/assets/css/jcoup/base.css" type="text/css"></link> -->
		<!-- <link rel="stylesheet" href="resources/assets/css/jcoup/demo.css" type="text/css"></link> -->
		<link rel="stylesheet" href="resources/assets/css/jcoup/jquery.Jcrop.min.css" type="text/css"></link>
		<link rel="stylesheet" href="resources/assets/css/jcoup/layout.css" type="text/css"></link>
		<!-- Uploadify Plugin CSS -->
		<link rel="stylesheet" href="resources/assets/css/uploadify.css" />
		<!-- Define homepage CSS -->
		<link rel="stylesheet" href="resources/assets/css/customcss/personalpagecss.css" type="text/css"></link>
	</head>
	<body>
		<div class="container">
			<!-- Common Header -->
			<jsp:include page="/views/front/common/header.jsp"></jsp:include>
		</div>
		<div class="content-body">
			<div class="container">
				<div class="row">
					<div class="person-info-nav">
						<h2 class="person-title">用户中心</h2>
						<input id="userIdentity" type="hidden" value="${userId }"/>
						<div class="person-info-grid">
							<div class="person-header-container">
								<img class="my-header" src="${userHeaderFilePath }" width="50em" height="50em" />
							</div>
							<div class="person-basic-info-container">
								<a id="edit-link">
									<div class="edit">
										<span class="ion-edit">&nbsp;修改个人信息</span>
									</div>
								</a>
								<a id="edit-pwd-link">
									<div class="edit">
										<span class="ion-edit">&nbsp;修改账户信息</span>
									</div>
								</a>
								<div class="nickname-area">
									<p>用户昵称：<span></span></p>
								</div>
								<div class="gender-area">
									<p>性别：<span></span></p>
								</div>
								<div class="age-area">
									<p>年龄：<span></span></p>
								</div>
								<div class="level-area">
									<p>用户等级：<span></span></p>
								</div>
								<div class="reg-area">
									<p>注册时间：<span></span></p>
								</div>
								<div class="last-login-area">
									<p>上次登录时间：<span></span></p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- 隐藏域 -->
		<span id="imgPath"></span>
		<span id="imgName"></span>
		
		<span id="imageX"></span>
		<span id="imageY"></span>
		<span id="imageHeight"></span>
		<span id="imageWidth"></span>
		
		<!-- Common Footer -->
		<jsp:include page="/views/front/common/footer.jsp"></jsp:include>
		<!-- Common Mobile Menu -->
		<jsp:include page="/views/front/common/mobilemenu.jsp"></jsp:include>
		<!-- RequireJS Lib -->
		<script src="resources/assets/js/lib/require.js" data-main="resources/assets/js/lib/main"></script>
		<!-- Define Homepage Js -->
		<script src="resources/assets/js/front/page.define/personal-page.js"></script>
	</body>
</html>