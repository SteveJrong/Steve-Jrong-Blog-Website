<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
	<head>
		<title>技术及开源许可 :: Steve Jrong's Blog</title>
		<!-- Meta Tags -->
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta name="renderer" content="webkit|ie-stand">
		<meta name="description" content="Steve Jrong个人博客的技术支持信息和网站开源许可。">
		<meta name="keywords" content="SteveJrong,授权,开源,许可,协议">
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
		<!-- Textillate CSS -->
		<link rel="stylesheet" href="resources/assets/css/animate.css" />
		<!-- jQuery ScrollUp CSS -->
		<link rel="stylesheet" href="resources/assets/css/scrollUp.css" type="text/css"></link>
		<!-- Exit Dialog CSS -->
		<link rel="stylesheet" href="resources/assets/css/dialog-ken.css" type="text/css"></link>
		<link rel="stylesheet" href="resources/assets/css/dialog.css" type="text/css"></link>
		<link rel="stylesheet" href="resources/assets/css/demo.css" type="text/css"></link>
		<link rel="stylesheet" href="resources/assets/css/sweetalert.css" type="text/css"></link>
		<!-- Social Share CSS -->
		<link rel="stylesheet" href="resources/assets/css/social-share.css" type="text/css"></link>
		<!-- Define licensepage CSS -->
		<link rel="stylesheet" href="resources/assets/css/customcss/aboutmepagecss.css" type="text/css"></link>
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
						<h1 class="page-title">核心技术&nbsp;&nbsp;<span class="ion-paintbucket"></span></h1>
						<article class="post">
							<div class="entry-content clearfix">
								<figure class="img-responsive-center">
									<img class="img-responsive" src="opensource"
										alt="Developer Image" style="opacity: .4;z-index: 0">
								</figure>
								<ol class="about" style="z-index: 0; position: relative; margin-top: -30rem;">
									<b><li class="text3">Web服务器</li></b>
									
									<li class="text3">Nginx&trade; HTTP Server</li>
									
									<li class="text3">Apache&reg; Tomcat Web Server</li>
									
									<b><li class="text3">搜索引擎</li></b>
									
									<li class="text3">Apache&reg; Lucene</li>
									
									<b><li class="text3">系统缓存</li></b>
									
									<li class="text3">Memcached Cache System</li>
									
									<b><li class="text3">前端组件</li></b>
									
									<li class="text3">Bootstrap 3.0</li>
									
									<li class="text3">jQuery Library</li>
									
									<li class="text3">BaiDu&reg; ECharts</li>
									
									<li class="text3">CKSource&reg; CKEditor</li>
									
									<li class="text3">RequireJS Module Loader</li>
									
									<li class="text3">Ionicons Powered By Ionic Framework&reg;</li>
									
									<b><li class="text3">中间件</li></b>
									
									<li class="text3">Spring Framework</li>
									
									<li class="text3">Apache&reg; Struts 2 MVC Framework</li>
									
									<li class="text3">Apache&reg; Hibernate ORM Framework</li>
									
									<b><li class="text3">音频标签读取</li></b>
									
									<li class="text3">JAudioTagger Library</li>
									
									<b><li class="text3">其他</li></b>
									
									<li class="text3">博客中的流媒体采用Ogg Vorbis音频编码</li>
									
									<br/><br/>
									
									<li class="text3">技术不是一个人的，而是全世界千千万万个码农们携手共建的一个技术分享平台。我倡导开源，同时也倡导适当的闭源，保护发布者知识产权的同时，又能够将自己的技术成果和经验分享给大家，这样对自己也是一种进步和提升。</li>
									
									<br/><br/>
									
									<li class="text3">本博客本着开源的思想，也是在其中使用到了很多的开源组件，也非常感谢他们能够把自己开发的组件共享到Internet上来。我很希望和大家一起建立起一个规范化、多元化的技术分享平台，可以在第一时间找到你最需要的技术解决方案，共同营造一个高效良好的技术分享平台。</li>
									
									<li class="text3" align="right">2016/4/9 18:07:09&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Steve Jrong.</li>
								</ol>
								<div class="height-40px"></div>
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
		<!-- Define licensepage Js -->
		<script src="resources/assets/js/front/page.define/license-page.js"></script>
	</body>
</html>