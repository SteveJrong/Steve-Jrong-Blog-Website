<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
	<head>
		<title>博文分类查看 :: Steve Jrong's Blog</title>
		<!-- Meta Tags -->
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta name="renderer" content="webkit|ie-stand">
		<meta name="description" content="博文分类查看 ">
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
		<!-- Exit Dialog CSS -->
		<link rel="stylesheet" href="resources/assets/css/dialog-ken.css" type="text/css"></link>
		<link rel="stylesheet" href="resources/assets/css/dialog.css" type="text/css"></link>
		<link rel="stylesheet" href="resources/assets/css/demo.css" type="text/css"></link>
		<!-- Social Share CSS -->
		<link rel="stylesheet" href="resources/assets/css/social-share.css" type="text/css"></link>
		<!-- Pagination Plugin CSS -->
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
						<s:iterator value="articlesList">
							<article class="post post-1">
								<header class="entry-header">
									<h1 class="entry-title">
										<a href="javascript:void(0);">${AName }</a>
									</h1>
									<div class="entry-meta">
										<span class="post-date"><a href="javascript:void(0);"><time
													class="entry-date">
													<s:date name="ACreatedate" format="yyyy-MM-dd" />
												</time></a></span> <span class="post-author"><a
											href="javascript:void(0);"> ${sjUsers.UNickname } </a></span> <span
											class="post-category"><a href="javascript:void(0);">
												${ATagkeyword } </a></span>
												<jsp:include page="/views/front/common/article_published_platform.jsp"></jsp:include>
									</div>
								</header>
								<div class="entry-content clearfix">
									<p>
										<s:property value="ABriefcontents" />
									</p>
									<div class="read-more cl-effect-14">
										<a href="detail_${AId }" class="more-link">阅读全文<span
											class="meta-nav">→</span></a>
									</div>
								</div>
							</article>
						</s:iterator>
						<!-- 分页 -->
						<jsp:include page="/views/front/common/pagination.jsp"></jsp:include>
						<input type="hidden" id="pagination_redirect_urlrewrite" value="looktype_p" />
					</main>
				</div>
			</div>
		<!-- Common Footer -->
		<jsp:include page="/views/front/common/footer.jsp"></jsp:include>
		<!-- Common Mobile Menu -->
		<jsp:include page="/views/front/common/mobilemenu.jsp"></jsp:include>
		<!-- RequireJS Lib -->
		<script src="resources/assets/js/lib/require.js" data-main="resources/assets/js/lib/main"></script>
		<!-- Define Articles Looking Type Sort Js -->
		<script src="resources/assets/js/front/page.define/articles-looking-type-sort-page.js"></script>
	</body>
</html>
