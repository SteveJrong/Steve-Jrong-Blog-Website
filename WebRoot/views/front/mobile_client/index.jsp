<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
	<head>
		<title>移动应用 :: Steve Jrong's Blog</title>
		<!-- Meta Tags -->
		<meta charset="UTF-8">
		<meta name="description" content="Steve Jrong's Blog移动App。">
		<meta name="keywords" content="Java,.NET,Windows Phone,Android,iOS,JavaWeb,jQuery,Linux,Mac OS X,Windows,大数据,分布式,实用工具,SteveJrong,爱好者,博客,博文,文章,分享">
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
		<!-- Social Share CSS -->
		<link rel="stylesheet" href="resources/assets/css/social-share.css" type="text/css"></link>
		<!-- Define mobile client CSS -->
		<link rel="stylesheet" href="resources/assets/css/customcss/homepagecss.css" type="text/css"></link>
		<link rel="stylesheet" href="resources/assets/css/customcss/mobileclientpagecss.css" type="text/css"></link>
	</head>
	<body>
		<div class="container">
			<!-- Common Header -->
			<jsp:include page="/views/front/common/header.jsp"></jsp:include>
		</div>
		<div class="content-body">
			<div class="container">
				<div class="row">
				
					<div class="uwp_title_area">
						<h3 class="uwp_title"><span class="ion-social-windows"></span>Windows 10 客户端</h3>
					</div>
				
					<!-- 轮播图片区域 -->
					<div id="jssor_1" style="position: relative; margin: 0 auto; top: 0px; left: 0px; width: 800px; height: 356px ; overflow: hidden; visibility: hidden; background-color: #24262e;">
				        <!-- Loading Screen -->
				        <div data-u="loading" style="position: absolute; top: 0px; left: 0px;">
				            <div style="filter: alpha(opacity=70); opacity: 0.7; position: absolute; display: block; top: 0px; left: 0px; width: 100%; height: 100%;"></div>
				            <div style="position:absolute;display:block;background:url('img/loading.gif') no-repeat center center;top:0px;left:0px;width:100%;height:100%;"></div>
				        </div>
				        <div data-u="slides" style="position: relative; top: 0px; left: 0px; width: 800px; height: 356px; overflow: hidden;">
				            <div data-p="144.50" style="display: none;">
				                <img data-u="image" src="resources/assets/img/client/splash_screen_uwp.png" />
				                <img data-u="thumb" src="resources/assets/img/client123/splash_screen_uwp.png" />
				            </div>
				            <div data-p="144.50" style="display: none;">
				                <img data-u="image" src="resources/assets/img/client/main_screen_uwp.png" />
				                <img data-u="thumb" src="resources/assets/img/client/main_screen_uwp.png" />
				            </div>
				            <div data-p="144.50" style="display: none;">
				                <img data-u="image" src="resources/assets/img/client/main_screen_pivot_uwp.png" />
				                <img data-u="thumb" src="resources/assets/img/client/main_screen_pivot_uwp.png" />
				            </div>
				            <div data-p="144.50" style="display: none;">
				                <img data-u="image" src="resources/assets/img/client/login_uwp.png" />
				                <img data-u="thumb" src="resources/assets/img/client/login_uwp.png" />
				            </div>
				            <div data-p="144.50" style="display: none;">
				                <img data-u="image" src="resources/assets/img/client/article_detail_uwp.png" />
				                <img data-u="thumb" src="resources/assets/img/client/article_detail_uwp.png" />
				            </div>
				            <div data-p="144.50" style="display: none;">
				                <img data-u="image" src="resources/assets/img/client/comment_or_reply_uwp.png" />
				                <img data-u="thumb" src="resources/assets/img/client/comment_or_reply_uwp.png" />
				            </div>
				        </div>
				        <!-- Thumbnail Navigator -->
				        <!-- <div data-u="thumbnavigator" class="jssort01" style="position:absolute;left:0px;bottom:0px;width:800px;height:100px;" data-autocenter="1">
				            Thumbnail Item Skin Begin
				            <div data-u="slides" style="cursor: default;">
				                <div data-u="prototype" class="p">
				                    <div class="w">
				                        <div data-u="thumbnailtemplate" class="t"></div>
				                    </div>
				                    <div class="c"></div>
				                </div>
				            </div>
				            Thumbnail Item Skin End
				        </div> -->
				        <!-- Arrow Navigator -->
				        <span data-u="arrowleft" class="jssora05l" style="top:158px;left:8px;width:40px;height:40px;"></span>
				        <span data-u="arrowright" class="jssora05r" style="top:158px;right:8px;width:40px;height:40px;"></span>
    				</div>
    				
    				<div class="uwp_version">
    					<p>
    						版本信息： v1.3 2016-11-14<br/>安装包大小：7.53MB<br/>适用于Windows 10 PC、Windows 10 Mobile
    					</p>
    				</div>
    				
    				<div class="read-more cl-effect-14">
						<a href="https://www.microsoft.com/store/apps/9nblggh43jg6" target="black" rel="nofollow" class="more-link">
							立即下载（<span class="ion-social-windows"></span> Win App Store）&nbsp;<span class="ion-arrow-down-a"></span>
						</a>
					</div>
				</div>
			</div>
		</div>
		<!-- Common Footer -->
		<jsp:include page="/views/front/common/footer.jsp"></jsp:include>
		<!-- Common Mobile Menu -->
		<jsp:include page="/views/front/common/mobilemenu.jsp"></jsp:include>
		<!-- RequireJS Lib -->
		<script src="resources/assets/js/lib/require.js" data-main="resources/assets/js/lib/main"></script>
		<!-- Define mobile client page Js -->
		<script src="resources/assets/js/front/page.define/mobile-client-page.js"></script>
	</body>
</html>