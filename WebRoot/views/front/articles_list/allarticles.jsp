<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
	<head>
		<title>所有博文 :: Steve Jrong's Blog</title>
		<!-- Meta Tags -->
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta name="renderer" content="webkit|ie-stand">
		<meta name="description" content="所有博文 ">
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
	    <link rel="stylesheet" href="resources/assets/css/customcss/allarticlespagecss.css">
	    <!-- jQuery ScrollUp CSS -->
		<link rel="stylesheet" href="resources/assets/css/scrollUp.css" type="text/css"></link>
		<!-- Exit Diaplog CSS -->
		<link rel="stylesheet" href="resources/assets/css/dialog-ken.css" type="text/css"></link>
		<link rel="stylesheet" href="resources/assets/css/dialog.css" type="text/css"></link>
		<link rel="stylesheet" href="resources/assets/css/demo.css" type="text/css"></link>
		<!-- Social Share CSS -->
		<link rel="stylesheet" href="resources/assets/css/social-share.css" type="text/css"></link>
		<!-- Define Pagination CSS -->
		<link rel="stylesheet" href="resources/assets/css/customcss/pagination.css" type="text/css"></link>
	</head>
	<body>
		<div class="container">	
			<!-- Common Header -->
			<jsp:include page="/views/front/common/header.jsp"></jsp:include>
		</div>
		<div class="content-body">
			<div class="container">
				<div class="row">
					<main class="col-md-12">
						<h1 class="entry-title">
							<a href="javascript:void(0);">博文目录</a>
						</h1>
						
						<!-- 中部数据div开始 -->
						<div class="main-data">
						
							<!-- 博文标题div开始 -->
							<div class="main-title">
								<s:iterator value="articleList">
									<ul>
										<li>
											<a href="detail_${AId }">
												<span><span class="ion-android-apps"></span>  ${AName }</span>
											</a>
										</li>
										<br/>
									</ul>
								</s:iterator>
							</div>
							<!-- 博文标题div结束 -->
							
							<!-- 博文发布者div开始 -->
							<div class="main-author">
								<s:iterator value="articleList">
									<ul>
										<li>
											<a href="detail_${AId }">
												<span><span class="ion-ios-cloud-upload"></span> ${sjUsers.UNickname }</span>
											</a>
										</li>
									</ul>
								</s:iterator>
							</div>
							<!-- 博文发布者div结束 -->
							
							<!-- 博文发布时间div开始 -->
							<div class="main-date">
								<s:iterator value="articleList">
									<ul>
										<li>
											<a href="detail_${AId }">
												<span><span class="ion-calendar"></span> <time class="entry-date">  <s:date name="ACreatedate" format="yyyy-MM-dd"/> </time></span>
											</a>
										</li>
									</ul>
								</s:iterator>
							</div>
							<!-- 博文发布时间div结束 -->
						
						</div>
						<!-- 中部数据div结束 -->
						
						<!-- 分页 -->
						<jsp:include page="/views/front/common/pagination.jsp"></jsp:include>
						<input type="hidden" id="pagination_redirect_urlrewrite" value="all_p" />
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
		<script src="resources/assets/js/front/page.define/allarticles-page.js"></script>
	</body>
</html>
