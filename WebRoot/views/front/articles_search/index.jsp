<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
	<head>
		<title>搜索结果 :: Steve Jrong's Blog</title>
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
	    <!-- jQuery ScrollUp CSS -->
		<link rel="stylesheet" href="resources/assets/css/scrollUp.css" type="text/css"></link>
		<!-- Exit Dialog CSS -->
		<link rel="stylesheet" href="resources/assets/css/dialog-ken.css" type="text/css"></link>
		<link rel="stylesheet" href="resources/assets/css/dialog.css" type="text/css"></link>
		<link rel="stylesheet" href="resources/assets/css/demo.css" type="text/css"></link>
		<!-- Social Share CSS -->
		<link rel="stylesheet" href="resources/assets/css/social-share.css" type="text/css"></link>
		<!-- Define all articles page CSS -->
	    <link rel="stylesheet" href="resources/assets/css/customcss/allarticlespagecss.css">
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
								<a href="javascript:void(0);">搜索结果</a>
							</h1>
							
							<div class="main-data">
								<s:iterator value="result">
									<div class="entry-meta">
										<span class="post-category">
											<a href="detail_${identity }">
												<span class="ion-android-apps">&nbsp;&nbsp;&nbsp;${analysisTarget }</span>
											</a>
										</span>
									</div>
								</s:iterator>
							</div>
								
							<div style="margin: 0px auto; float:right; width: 200px;">
								Support By &nbsp;&nbsp; <img src="lucene" width="90" height="16" /> &trade;
							</div>
							
							<!-- 分页 -->
							<jsp:include page="/views/front/common/pagination.jsp"></jsp:include>
							<input type="hidden" id="pagination_redirect_urlrewrite" value="search_p" />
							
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
		<script src="resources/assets/js/front/page.define/articles-search-index-page.js"></script>
	</body>
</html>