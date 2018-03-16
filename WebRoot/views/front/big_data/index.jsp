<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
	<head>
		<title>大数据 :: Steve Jrong's Blog</title>
		<!-- Meta Tags -->
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta name="renderer" content="webkit">
		<meta name="description" content="Steve Jrong的个人博客大数据分析">
		<meta name="keywords" content="博客大数据">
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
		<!-- Time line Component CSS -->
		<link rel="stylesheet" href="resources/assets/css/timeline.css" type="text/css"></link>
		<!-- Social Share CSS -->
		<link rel="stylesheet" href="resources/assets/css/social-share.css" type="text/css"></link>
		<!-- Define big data CSS -->
		<link rel="stylesheet" href="resources/assets/css/customcss/homepagecss.css" type="text/css"></link>
	</head>
	<body>
		<div class="container">
			<!-- Common Header -->
			<jsp:include page="/views/front/common/header.jsp"></jsp:include>
		</div>
		<div class="content-body">
			<div class="container">
				<!-- ECharts按周查看访客量DOM -->
				<div id="container" style="height:35rem; width: 100%;"></div>
				<section id="cd-timeline" class="cd-container">
					<div class="cd-timeline-block">
						<div class="cd-timeline-img cd-1">
							<img src="rocket" alt="rocket">
						</div>
						<div class="cd-timeline-content" style="border:2px rgb(192,59,68) solid; border-radius:20px;">
							<h2>理想的云图</h2>
							<p>2016年年初，这个博客系统还处于计划中。那是一个美丽的梦想，美丽而望尘莫及。</p>
							<span class="cd-date">Jan · 2016</span>
						</div>
					</div>
					<div class="cd-timeline-block">
						<div class="cd-timeline-img cd-2 is-hidden">
							<img src="build" width="200" alt="building">
						</div>
						<div class="cd-timeline-content is-hidden" style="border:2px rgb(117,206,102) solid; border-radius:20px;">
							<h2>梦想开始的地方</h2>
							<p>2016年2月15号，我建立了这个博客系统的第一个文件，这也意味着我的博客已经正式开工了！</p>
							<span class="cd-date">Feb 15 · 2016</span>
						</div>
					</div>
					<div class="cd-timeline-block">
						<div class="cd-timeline-img cd-3 is-hidden">
							<img src="bingo" alt="bingo">
						</div>
						<div class="cd-timeline-content is-hidden" style="border:2px #1E90FF solid; border-radius:20px;">
							<h2>首次发版</h2>
							<p>2016年3月26号，Steve Jrong's Blog - 我的个人博客网站已经正式上线。有很多朋友参与了首发公测，也提出了很多具有实质性和极为宝贵的意见和建议，在此我由衷的感谢他们，为博客反馈问题。真心的感谢！这一版初步功能都已具备，但路还很长。</p>
							<span class="cd-date">Mar 26 · 2016</span>
						</div>
					</div>
					
					<div class="cd-timeline-block">
						<div class="cd-timeline-img cd-4 is-hidden">
							<img src="flydisk" alt="flydisk">
						</div>
						<div class="cd-timeline-content is-hidden" style="border:2px #4B0082 solid; border-radius:20px;">
							<h2>二次升级</h2>
							<p>2016年7月9号，在经过几个月的紧张开发之后，博客二次发版上线，开放了更多的功能。特别是新增了UWP手机客户端（正在紧张开发中，1.0版即将上线），阅读博客还有客户端，更方便大家的阅读。</p>
							<span class="cd-date">July 9 · 2016</span>
						</div>
					</div>
					
					<div class="cd-timeline-block">
						<div class="cd-timeline-img cd-5 is-hidden">
							<img src="sailing" alt="sailing">
						</div>
						<div class="cd-timeline-content is-hidden" style="border:2px #EEAD0E solid; border-radius:20px;">
							<h2>整理 重构 再出发</h2>
							<p>2016年11月12号，经过紧张的项目重构后又一次发版。前端重构率达到了95%，使用RequireJS组件组织管理页面繁杂的脚本文件，异步加载，响应更快；分享组件从百度分享改用自定义组件，更安全，速度加载更快。</p>
							<p>同时Win10客户端版本号也更新到了1.2 Beta，更好用，更易用，体验更好。</p>
							<span class="cd-date">Nov 12 · 2016</span>
						</div>
					</div>
					
					<div class="cd-timeline-block">
						<div class="cd-timeline-img cd-6 is-hidden">
							<img src="fasteners" alt="fasteners">
						</div>
						<div class="cd-timeline-content is-hidden" style="border:2px #EE1289 solid; border-radius:20px;">
							<h2>架构再进化 细节更优化</h2>
							<p>2017年5月17号，经过几个月的开发和bug修复，在重大调整后台项目架构更利于开发维护后，对系统的每一处细节都进行了调整，界面更协调，尤其是在移动设备上的UI显示着力优化，体验更好。</p>
							<p>为了移动平台都能更方便的浏览博客，将计划开发混合移动App，并逐步渗透到iOS、Android和Win10等平台。</p>
							<span class="cd-date">Nov 12 · 2016</span>
						</div>
					</div>
					
					<div class="cd-timeline-block">
						<div class="cd-timeline-img cd-7 is-hidden">
							<img src="monkey" alt="monkey">
						</div>
						<div class="cd-timeline-content is-hidden" style="border:2px #8470FF solid; border-radius:20px;">
							<h2>精彩，就在未来</h2>
							<p>未完待续，更多精彩稍后就来~</p>
							<span class="cd-date">Future</span>
						</div>
					</div>
					
					</div>
				</section>
			</div>
		</div>
		<!-- Common Footer -->
		<jsp:include page="/views/front/common/footer.jsp"></jsp:include>
		<!-- Common Mobile Menu -->
		<jsp:include page="/views/front/common/mobilemenu.jsp"></jsp:include>
		<!-- RequireJS Lib -->
		<script src="resources/assets/js/lib/require.js" data-main="resources/assets/js/lib/main"></script>
		<!-- Define Homepage Js -->
		<script src="resources/assets/js/front/page.define/big-data-index-page.js"></script>
	</body>
</html>