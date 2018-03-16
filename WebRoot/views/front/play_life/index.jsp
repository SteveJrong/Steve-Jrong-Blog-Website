<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
	<head>
		<title>玩生活 :: Steve Jrong's Blog</title>
		<!-- Meta Tags -->
		<meta charset="UTF-8">
		<meta name="description" content="Steve Jrong的个人博客，IT技术分享家。">
		<meta name="keywords" content="Java,.NET,Windows Phone,Android,iOS,JavaWeb,jQuery,Linux,Mac OS X,Windows,大数据,分布式,实用工具,SteveJrong,爱好者,博客,博文,文章,分享">
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
		<!-- Social Share CSS -->
		<link rel="stylesheet" href="resources/assets/css/social-share.css" type="text/css"></link>
		<!-- Pagination Plugin CSS -->
		<link rel="stylesheet" href="resources/assets/css/customcss/pagination.css" type="text/css"></link>
		<!-- Zero Modal Dialog CSS -->
		<link rel="stylesheet" href="resources/assets/css/zeroModal.css" type="text/css"></link>
		<!-- Dark Player CSS -->
		<!-- <link rel="stylesheet" href="resources/assets/css/darkplayer/demo.css" type="text/css"></link> -->
		<link rel="stylesheet" href="resources/assets/css/darkplayer/style.css" type="text/css"></link>
		<!-- Define playlifepage CSS -->
		<link rel="stylesheet" href="resources/assets/css/customcss/lifepagecss.css" type="text/css"></link>
	</head>
	<body>
		<div class="container">
			<!-- Common Header -->
			<jsp:include page="/views/front/common/header.jsp"></jsp:include>
		</div>
		<div class="content-body">
			<div class="container">
				<div class="row">
					<main class="col-md-8">
						<div class="main-life-data">
							<img class="loading-data-pic" src="loadingMixRadio" width="38px" height="38px" />
						</div>
						<!-- 分页 -->
						<jsp:include page="/views/front/common/pagination_ajax.jsp"></jsp:include>
					</main>
					<!-- 右侧边栏 -->
					<aside class="col-md-4">
						<div class="widget widget-recent-posts">
							<h3 class="widget-title">MixRadio</h3>
							<img class="loading-pic" src="loadingMixRadio" width="38px" height="38px" />
							<div class="my-music-box">
							</div>
						</div>
					</aside>
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
		<script src="resources/assets/js/front/page.define/play-life-index-page.js"></script>
	</body>
</html>