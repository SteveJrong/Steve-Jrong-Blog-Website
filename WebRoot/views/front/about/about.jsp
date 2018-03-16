<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
	<head>
		<title>关于博主 :: Steve Jrong's Blog</title>
		<!-- Meta Tags -->
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta name="renderer" content="webkit|ie-stand">
		<meta name="description" content="关于Steve Jrong个人博客。">
		<meta name="keywords" content="SteveJrong,关于">
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
		<!-- Exit Diaplog CSS -->
		<link rel="stylesheet" href="resources/assets/css/dialog-ken.css" type="text/css"></link>
		<link rel="stylesheet" href="resources/assets/css/dialog.css" type="text/css"></link>
		<link rel="stylesheet" href="resources/assets/css/demo.css" type="text/css"></link>
		<!-- Sweetalert CSS -->
		<link rel="stylesheet" href="resources/assets/css/sweetalert.css" type="text/css"></link>
		<!-- Social Share CSS -->
		<link rel="stylesheet" href="resources/assets/css/social-share.css" type="text/css"></link>
		<!-- Define aboutpage CSS -->
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
						<h1 class="page-title">关于博主&nbsp;&nbsp;<span class="ion-quote"></span></h1>
						<article class="post">
							<div class="entry-content clearfix">
								<figure class="img-responsive-center">
									<img class="img-responsive" src="machine" alt="Developer Image" style="opacity: .3;z-index: 0">
								</figure>
								<ol class="about" style="z-index: 0; position: relative; margin-top: -30rem; line-height:2.5em;">
									<li class="text2"><b>铭牌：</b>Steve Jrong</li>
	
 									<!-- <li class="text2"><b>现就职：</b>杭州海碧德信息技术有限公司 - 沃奇医药商城（www.woqiyy.com）</li>
	
									<li class="text2"><b>职位：</b>Java EE Developer</li> -->
									
									<li class="text2"><b>副业：</b>Universal Windows Platform Applications Developer</li>
	
									<li class="text2"><b>爱好：</b>社交K歌，喜欢游山玩水，喜好各种电子设备，热爱音乐</li>
									
									<li class="text2"><b>我的足迹：</b>1996年至2016年：山西太原；2016年2月至今 - 浙江杭州</li>
									
									<li class="text2"><b>我的信仰：</b>HTC（情怀）、SONY（信仰）、Nokia Lumia（骨灰）</li>
									
									<li class="text2"><b>玩儿过的：</b>Nokia Lumia 900（2012）、HTC Desire 816（2014）、HTC One M8ST（2015）、Microsoft Zune II（2012）、Nokia Asha 210（2013）、Nokia Lumia 638（2014）、HTC 8X（2015）、Nokia Lumia 822（2016）、Nokia Lumia 1520（2016）、Apple iPhone SE（2016）、Apple MacBook Air（2016）、SONY Xperia Z5 Premium（2016）</li>
									
									<li class="text2"><b>最欣赏的：</b>Lady GaGa（敢做敢为）、Owl City（真心做音乐不求成绩）、Britney Spears（突破自我）</li>
										
									<li class="text2"><b>最感谢的：</b>除了我的父母和我奶奶以外，对我人生有较大影响的就是高二的信息技术老师，从他上过第一堂VB6课程后，我就认为我已经爱上了软件开发</li>
	
									<li class="text2"><b>喜欢并一直关注的技术：</b>Spring Framework、微服务、分布式、Microsoft Universal Windows Platform、Android爱好者（7.0及更高版本）、Hybird App</li>
									
									<li class="text2"><b>终极目标：</b>Full Stack Devloper，希望成为阿里巴巴的一枚同学，同时做一个自由的软件开发者。厌恶被国情体制约束，一直做敲代码的机器（太过理想化……）</li>
									
									<li class="text3"><b>箴言：</b>谁说努力了就一定会成功？但如果抱着偷懒的心态去做每件事，那上天可能连成功的机会都不给你；</li>
	
									<li class="text3">对一件事绝望时，请继续坚持，绝大多数人都因为挺不过绝望期而死在了即将成功的路上；</li>
									
									<li class="text3">如果遭遇了一点失败，身边的人都开始慢慢否定你，一定不要肯定他们的否定，一定要有自己的想法，不要被洪水所同质化，否则你的人生将会随着洪水到处漂流；</li>
									
									<li class="text3">没有过不去的坎儿，只有无法战胜的自己！</li>
								</ol>
								<div class="height-40px"></div>
								<h2 class="title text-center">亲密无间</h2>
								<ul class="social">
									<li class="facebook"><a href="http://wpa.qq.com/msgrd?v=3&uin=1554052208&site=oicqzone.com&menu=yes" target="_blank" rel="nofollow"><span>QQ</span></a></li>
									<li class="twitter"><a href="javascript:weChat();"><span>WeChat</span></a></li>
									<li class="google-plus"><a href="http://weibo.com/u/2984038683" target="_blank" rel="nofollow"><span>Sina</span></a></li>
									<li class="tumblr"><a href="mailto:1554052208@qq.com" rel="nofollow"><span>Mail</span></a></li>
								</ul>
							</div>
						</article>
					</main>
				</div>
			</div>
		</div>
		<footer id="site-footer">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<p class="copyright">
						<span>&copy; 2011-<script type="text/javascript">var myDate = new Date(); document.write(myDate.getFullYear());</script> Steve Jrong&nbsp;&nbsp;&nbsp;All Rights Reserved.</span>
						<span class="line">|</span>
						<span><a href="opensourcelicense">技术及开源许可</a></span>
					</p>
					<p align="center" class="beian_info"><img alt="beian" src="miit">&nbsp;&nbsp;&nbsp;<a href="http://www.miitbeian.gov.cn" target="blank" rel="nofollow">晋ICP备16003543号</a><script type="text/javascript" src="resources/assets/js/lib/cnzz.js"></script></p>
				</div>
			</div>
		</div>
		</footer>
		<!-- Common Mobile Menu -->
		<jsp:include page="/views/front/common/mobilemenu.jsp"></jsp:include>
		<!-- RequireJS Lib -->
		<script src="resources/assets/js/lib/require.js" data-main="resources/assets/js/lib/main"></script>
		<!-- Define about Js -->
		<script src="resources/assets/js/front/page.define/about-page.js"></script>
	</body>
</html>