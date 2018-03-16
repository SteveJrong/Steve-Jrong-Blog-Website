<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
	<head>
		<title>我的简历 :: Steve Jrong's Blog</title>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta name="renderer" content="webkit|ie-stand">
		<meta name="description" content="Steve Jrong的个人简历。">
		<meta name="keywords" content="SteveJrong,简历,面试">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="author" content="SteveJrong">
		<!-- <meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="apple-mobile-web-app-status-bar-style" content="black"> -->
		<!-- stylesheet css -->
		<link rel="stylesheet" href="resources/assets/css/bootstrap.min.css">
		<link rel="stylesheet" href="resources/assets/css/font-awesome.min.css">
		<link rel="stylesheet" href="resources/assets/css/resume/templatemo-gray.css">
		<link rel="stylesheet" href="resources/assets/css/ionicons.min.css">
		<!-- Sweetalert CSS -->
		<link rel="stylesheet" href="resources/assets/css/sweetalert.css" type="text/css"></link>
		<!-- Define my resume CSS -->
		<link rel="stylesheet" href="resources/assets/css/customcss/myresumecss.css" type="text/css"></link>
	</head>
	<body data-spy="scroll" data-target=".navbar-collapse">
	
	<div class="header-nav" >
		<a href="home" target="blank">
			<div class="visit-blog">
				<span class="ion-ios-navigate"></span>
				<span>访问博客</span>
			</div>
		</a>
		<div class="language-switch">
			<span class="op-cn"><img src="resources/assets/img/cn.png" width="26" height="26" /></span>
			<span>|</span>
			<span class="op-en"><img src="resources/assets/img/en.png" width="26" height="26" /></span>
		</div>
	</div>
	
	<div class="snow-container" style="position:fixed;top:0;left:0;width:100%;height:100%;pointer-events:none;z-index:100001;"></div>
	<!-- preloader section -->
	<div class="preloader">
		<div class="sk-spinner sk-spinner-wordpress">
	       <span class="sk-inner-ion-disc"></span>
	     </div>
	</div>
	<!-- 头部区域 -->
	<header>
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-sm-12">
					<img src="resources/assets/img/resume/tm-easy-profile.jpg" class="img-responsive img-ion-disc tm-border" alt="templatemo easy profile">
					<h1 class="tm-title bold shadow">王晶</h1>
					<h1 class="white bold shadow" style="font-size:18.5px;">Java软件工程师 后端开发工程师</h1>
				</div>
			</div>
		</div>
	</header>
	<!-- about and skills section -->
	<section class="container">
		<div class="row">
			<!-- <div class="col-md-6 col-sm-12">
				<div class="about">
					<h3 class="accent">Easy Profile</h3>
					<h2>Bootstrap v3.3.5</h2>
					<p>This easy HTML profile is brought to you by templatemo website. There are 4 color themes, <a href="index-green.html">Green</a>, <a href="index.html">Blue</a>, <a href="index-gray.html">Gray</a>, and <a href="index-orange.html">Orange</a>. Sed vitae dui in neque elementum tempor eu id risus. Phasellus sed facilisis lacus, et venenatis augue.</p>
				</div>
			</div>
			<div class="col-md-6 col-sm-12">
				<div class="skills">
					<h2 class="white">Skills</h2>
					<strong>PHP MySQL</strong>
					<span class="pull-right">70%</span>
						<div class="progress">
							<div class="progress-bar progress-bar-primary" role="progressbar" 
	                        aria-valuenow="70" aria-valuemin="0" aria-valuemax="100" style="width: 70%;"></div>
						</div>
					<strong>UI/UX Design</strong>
					<span class="pull-right">85%</span>
						<div class="progress">
							<div class="progress-bar progress-bar-primary" role="progressbar" 
	                        aria-valuenow="85" aria-valuemin="0" aria-valuemax="100" style="width: 85%;"></div>
						</div>
					<strong>Bootstrap</strong>
					<span class="pull-right">95%</span>
						<div class="progress">
							<div class="progress-bar progress-bar-primary" role="progressbar" 
	                        aria-valuenow="95" aria-valuemin="0" aria-valuemax="100" style="width: 95%;"></div>
						</div>
				</div>
			</div> -->
		</div>
	</section>
	<!-- 教育信息区域 -->
	<section class="container" id="education-area">
		<div class="row">
			<div class="col-md-8 col-sm-12">
				<div class="education">
					<h2 class="white">教育信息</h2>
					<div class="education-content">
						<h4 class="education-title accent">Education Infomations</h4>
						<div class="education-school">
							<h5>西安电子科技大学</h5><span></span>
							<h5>2016年12月 - 至今</h5>
						<p class="education-description">目前就读于西安电子科技大学（远程教育）软件工程系（专科）</p>
						</div>
						<div class="education-school">
							<h5>北大青鸟太原学习中心</h5><span></span>
							<h5>2014年1月 - 2014年12月</h5>
						<p class="education-description">在学习中心主修软件工程，同时兼修职业素养课程</p>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-4 col-sm-12">
				<div class="languages" id="basic-info-area">
					<h2>基本信息</h2>
					<ul>
						<li>姓名：王晶</li>
						<li>性别：男</li>
						<li>民族：汉</li>
						<li>出生年月：1996年1月</li>
						<li>联系电话：+86 15034129278</li>
						<li>电邮：wangjing4568@hotmail.com</li>
					</ul>
				</div>
			</div>
		</div>
	</section>
	<!-- 专业技能区域 -->
	<section class="container" id="professional-area">
		<div class="row">
			<div class="col-md-4 col-sm-12">
				<div class="contact">
					<h2>专业技能</h2>
					<p><i class="ion-disc"></i> 熟练掌握并运用Java EE企业级技术，包括Hibernate、Struts 2、Spring三大框架及其整合技术和基于注解的Spring MVC框架和MyBatis ORM框架</p>
					<p><i class="ion-disc"></i> 熟练掌握并运用jQuery技术和基于jQuery的各种开源插件，如DataGrid、jQuery UI、Echarts、CKEditor、RequireJS、AngularJS、Framework7等开发框架</p>
					<p><i class="ion-disc"></i> 熟练掌握并运用JSP、Servlet Web开发技术，对MVC开发模式有较透彻的理解</p>
					<p><i class="ion-disc"></i> 熟练掌握并运用Java Web服务器，熟练Tomcat、Nginx等服务器的配置和使用</p>
					<p><i class="ion-disc"></i> 熟练掌握并运用主流关系型数据库，如Oracle、SQL Server和MySQL</p>
					<p><i class="ion-disc"></i> 了解Spring Cloud微服务分布式应用的原理，使用过Spring Boot框架</p>
					<p><i class="ion-disc"></i> 熟练掌握并运用HTTP、HTTPS+SSL、TCP/IP、UDP等网络协议的使用，了解Socket编程</p>
					<p><i class="ion-disc"></i> 熟练掌握SVN源代码管理工具和Maven的使用</p>
					<p><i class="ion-disc"></i> 熟练掌握Windows和Linux系统的项目部署和运维，熟悉Linux命令，能够在Ubuntu Server和Cent OS上部署项目并运行</p>
					<p><i class="ion-disc"></i> 掌握Hybird App开发技术，了解REST风格的开发模式</p>
					<p><i class="ion-disc"></i> 了解音视频流化技术和视频直播技术</p>
					<p><i class="ion-disc"></i> 能够独立设计并开发中小型项目，并对项目有着中期和远期规划</p>
					<p><i class="ion-disc"></i> 熟练掌握项目开发流程，在项目初期能够给出项目规划文档，在项目期间能够保证项目进度，项目结项时能够对项目进行有效的评估等一系列的工作</p>
				</div>
			</div>
			<div class="col-md-8 col-sm-12">
				<div class="experience">
					<h2 class="white">工作经历</h2>
					<div class="experience-content">
						<h4 class="experience-title accent">Work Experiences</h4>
						<div>
							<h5>杭州沃奇医药有限公司（沃奇医药商城）</h5><span></span>
							<h5>2016年3月 - 2017年1月</h5>
							<p class="education-description">担任Java开发工程师的职位，负责模块功能开发、模块Bug修复、模块功能优化、商城物流系统数据库设计、数据库实现、商城系统和海典ERP系统两系统间物流数据同步、基于优酷视频接口的功能开发。</p>
						</div>
						<div>
							<h5>北京顺联太原分公司</h5><span></span>
							<h5>2015年1月 - 2016年1月</h5>
							<p class="education-description">担任前后端开发工程师，先后开发了易买网B2C网上购物商城、通用博客系统、电力巡检系统等外包项目，在项目中同时担任过开发组组长和开发人员，对数据库设计和实现、项目结构设计有一定经验。</p>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-8 col-sm-12">
				<div class="experience">
					<h2 class="white">工作经验</h2>
					<div class="experience-content">
						<h4 class="experience-title accent">Working Experiences</h4>
						<div>
							<h5>易买网 - B2C网上交易系统</h5><span></span>
							<h5>项目周期：2015年2月 - 2015年5月</h5>
							<p class="education-description">
								<br/>该网站主要用于网上物品交易，具有在线选购、网上下单、商品结算、商品评论等功能。
								<br/>项目主要采用JSP+Servlet+JavaBean体系结构进行开发，采用三层架构对业务代码进行分离解耦，增强了代码的健壮性与维护性。
								<br/>DAO层采用JDBC技术，将SQL语句参数化防止注入攻击，并侦听用户操作并将其保存在日志中以便查阅。
								<br/>数据库采用SQL Server 2008，将应用的部署分为了应用区和数据区，减少服务器的单点压力，充分利用各个服务器，提高吞吐量和处理性能。
							</p>
						</div>
						<div>
							<h5>沃奇医药商城微信客服公众号</h5><span></span>
							<h5>项目周期：2016年7月 - 2016年8月</h5>
							<p class="education-description">
								此系统用于公司内部的客服人员使用，具有基本的客服自动接入功能，通过算法来根据客服个人擅长咨询的领域来自动为客户分配客服人员，如客当前服不在还可以自动转接给其他客服。后台管理还支持查询24小时内的客服人员聊天信息，且支持Excel导出。	
							</p>
						</div>
						<div>
							<h5>沃奇医药商城 - B2B药品交易网</h5><span></span>
							<h5>项目周期：2016年3月 - 2016年12月</h5>
							<p class="education-description">
								沃奇医药商城是一个基于B2B商业模式的药品采购平台。整个体系分为后台管理系统、供应商系统和业务经办人系统三大系统，都基于Java平台且由Spring MVC、Hibernate和JPA框架构建，使用Memcached作为DB缓存，使用Shiro和Lucene分别做权限控制和数据索引，视图引擎采用Freemarker，数据同步通过定时任务来完成。 在网站关键功能如下单支付环节上采用锁机制和线程同步，并针对高并发场景进行性能优化，提高系统处理效率和稳定性。	
							</p>
						</div>
						<div>
							<h5>陆派电动车 - 企业系统网站</h5><span></span>
							<h5>项目周期：2017年1月1日 - 2017年1月13日</h5>
							<p class="education-description">
								该网站是某电动车企业的网站，分为前台展示和后台管理系统。前台栏目分为“关于企业”、“新闻资讯”、“客户服务”、“联系我们”等模块。项目基于SSM框架构建，使用Maven和SVN技术管理Jar包和代码版本库。
								<br/>前台页面使用H5、CSS3技术，视图引擎采用JSP渲染，配合JSTL标签完成页面业务逻辑处理。导航菜单都存放在数据库的导航表中，且可以在后台进行顺序自由调换和显示隐藏等功能。前台轮播大图可在后台上传、编辑，上传插件采用UEditor。
								<br/>后台页面框架采用EasyUI，功能具有文件上锁下载、模块下文本内容编辑、页面视频直播管理、轮播大图管理等模块。文件上锁将每个文件设定密码，然后将信息都保存在数据库文件表中，有此密码的用户才可查看文件。文本内容编辑采用UEditor，页面视频支持优酷视频上传，将视频信息保存在数据库视频表中，然后展示在前台页面上进行播放。
								<br/>网站全部URL都经过URL重写以符合SEO标准，再通过设置百度站长工具，便于搜索引擎抓取。
								<br/>项目部署在阿里云的Cent OS服务器上，采用Nginx做HTTP服务器同时实现动静分离，Netty作为Web服务器处理后端请求。
							</p>
						</div>
						<div>
							<h5>陆派电动车 - 企业系统网站</h5><span></span>
							<h5>项目周期：2016年2月 - 至今</h5>
							<p class="education-description">
								该网站是我的个人博客。基于Java平台，采用SSH框架及Maven构建。网站总体分为前台和后台两套系统。
								<br/>前台采用响应式布局，支持不同屏幕设备访问，使用jQuery并配合RequireJS模块化异步加载资源。
								<br/>系统框架采用SSH，Spring负责Bean的注入和组件管理，Struts负责代码分离，Hibernate作为ORM框架，同时配合Memcached作为DB缓存，提高数据加载速度。
								<br/>使用Lucene作为全文搜索引擎，使用Shiro框架来做权限控制。
								<br/>在每天凌晨会使用Quartz定时任务将保存在Memcached中的访客信息持久化到DB中，每两小时根据访客信息对文章的浏览量进行更新。
								<br/>网站同步开发了Win10 UWP客户端。主界面数据展示采用虚拟化处理的ListView，支持滑动加载更多，同时具有查看博文、登录、注册、评论回复、夜间模式切换等功能。在查看博文详情时采用Hybrid App技术，搭载Framework7框架，使用WebView和原生App交互。
								<br/>博客系统的部署环境基于阿里云的Ubuntu Server ECS，使用Nginx做动静分离，静态资源交给Nginx，动态请求交给Tomcat，提高访问速度和服务器处理效率。网站安全证书采用沃通免费的SSL证书。	
							</p>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-4 col-sm-12">
				<div class="experience" id="other-skills">
					<h2>其他技能</h2>
					<h4 class="other-skills-title accent">Other Skills</h4>
					<p>考取过Microsoft Office Specialist（MOS）Office专业级认证证书，包括Microsoft Word和Microsoft Excel</p>
					<p>考取时间：2013年11月 - 2014年4月</p>
					<p>心得：成功是1%的天赋加99%的汗水</p>
				</div>
				<!-- <div class="contact">
					<h2>我的优势</h2>
					<p>两年Java EE开发经验，曾参与B2B商城和微信公众号开发，熟悉Memcached缓存，熟悉MySql、Oracle、SQLServer，熟悉Linux操作，熟练Spring MVC、SSH，了解AngularJs，熟练jQuery、.Net和C#。熟练Nginx配置和多线程程序开发，有独立博客。了解音视频流化和视频直播，了解Spring Cloud微服务分布式应用原理，用过Spring Boot</p>
				</div> -->
				
				<div class="contact">
					<h2>自我评价</h2>
					<p>本人有责任感、学习能力强、有上进心、具有很强的团队精神，善于与人沟通，表达能力良好。</p>
					<p>喜好编程开发，并且有一定的编程功底，乐于为开源做贡献，在工作上积极负责，能够很好的根据项目计划书完成软件的开发。</p>
				</div>
			</div>
		</div>
	</section>
	<!-- 页脚 -->
	<footer class="footer">
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-sm-12">
					<ul class="social-icons">
						<li><a href="http://wpa.qq.com/msgrd?v=3&uin=1554052208&site=oicqzone.com&menu=yes" target="_blank" rel="nofollow" class="fa fa-qq"></a></li>
	                    <!-- <li><a href="javascript:weChat();" target="_blank" rel="nofollow" class="fa fa-weixin"></a></li> -->
						<li><a href="http://weibo.com/u/2984038683" target="_blank" rel="nofollow" class="fa fa-weibo"></a></li>
						<li><a href="https://github.com/SteveJrong" target="_blank" rel="nofollow" class="fa fa-github"></a></li>
						<li><a href="mailto:1554052208@qq.com" target="_blank" rel="nofollow" class="fa fa-envelope"></a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="copyright-area">
			<p class="copyright">&copy; 2011-2016 Steve Jrong&nbsp;&nbsp;All Rights Reserved.</p>
			<p align="center" class="beian_info"><img alt="beian" src="miit"/>&nbsp;&nbsp;&nbsp;<a href="http://www.miitbeian.gov.cn" target="blank" rel="nofollow">晋ICP备16003543号</a><script type="text/javascript" src="resources/assets/js/lib/cnzz.js"></script></p>
		</div>
	</footer>
	<!-- RequireJS Lib -->
	<script src="resources/assets/js/lib/require.js" data-main="resources/assets/js/lib/main"></script>
	<!-- Define Resumepage Js -->
	<script src="resources/assets/js/front/page.define/resume-page.js"></script>
	</body>
</html>