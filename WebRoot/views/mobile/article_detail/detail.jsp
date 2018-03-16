<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<title></title>
		<!-- Meta Tags -->
		<meta charset="UTF-8">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no, minimal-ui">
		<!-- Framework7 Library CSS-->
		<link rel="stylesheet" href="resources/assets/css/mobile/framework7.ios.min.css">
		<link rel="stylesheet" href="resources/assets/css/mobile/framework7.ios.colors.min.css">
		<!-- Define My App styles-->
		<link rel="stylesheet" href="resources/assets/css/mobile/my-app.css">
	</head>
	<body>
	    <div class="statusbar-overlay"></div>
	    <div class="panel-overlay"></div>
	    <!-- 左侧侧滑栏-->
	    <!-- <div class="panel panel-left panel-reveal">
	      <div class="content-block">
	        <p>Left panel content goes here</p>
	      </div>
	    </div> -->
	    <!-- 右侧侧滑栏 夜间模式已在原生App中处理好，暂时不在页面中控制了-->
	    <%-- <div class="panel panel-right panel-cover" id="rightSlidePanel">
			<div class="content-block">
				<p><b>阅读设置</b></p>
				<ul class="settings">
					<li>
						<div class="item-content">
							<div class="item-inner">
								<div class="item-input">
									<span>夜间模式</span>
	
									<!-- <i class="icon icon-form-toggle"></i> -->
	
									<label class="label-switch"> <input type="checkbox">
										<div class="checkbox"></div>
									</label>
								</div>
							</div>
						</div>
					</li>
				</ul>
			</div>
		</div> --%>
		
		<!-- 视图-->
		<div class="views">
			<!-- Your main view, should have "view-main" class-->
			<div class="view view-main">
				
				<s:if test="enableNightMode == 'true'">
	              	<input type="hidden" class="themeFlag" value="b" />
	            </s:if>
	              			
				<s:if test="enableNightMode == 'false'">
					<input type="hidden" class="themeFlag" value="w" />
				</s:if>
				
				<input type="hidden" class="articleId" value="1" />
				
				<!-- 顶部导航栏-->
				<%-- <div class="navbar">
					<div class="navbar-inner">
						<!-- We have home navbar without left link-->
						<!-- <div>信息：当前：<span class="thisTop"></span> 主体：<span class="mainContent"></span></div> -->
						<div class="center sliding">${article.AName } - Steve Jrong's Blog</div>
						<div class="right">
	              			<!-- <a href="#" class="link icon-only open-panel"> <i class="icon icon-bars"></i></a> -->
	              			
	              			
	           			</div>
					</div>
				</div> --%>
				
				<div class="pages navbar-through toolbar-through">
					<div data-page="index" class="page">
					
						<!-- Page content应该拥有"pull-to-refresh-content"类 -->
						<!-- <div class="page-content pull-to-refresh-content" id="pullRefresh">
							默认的下拉刷新层
							<div class="pull-to-refresh-layer">
								<div class="preloader"></div>
								<div class="pull-to-refresh-arrow"></div>
							</div> -->
						
						<!-- 主体内容 -->
						<div class="page-content">
							<!-- 中部内容开始 -->
							<%-- <div class="content-block-title">${article.AName } <time class="entry-date"> </div> --%>
							<div class="content-block-title" id="content-block-etc">
								<s:date name="article.ACreatedate" format="yyyy-MM-dd"/> </time>  ${article.sjUsers.UNickname }
							</div>
							<div class="content-block">
								<div class="content-block-inner">
									<!-- 内容区域 -->
									${article.ABodycontents }
								</div>
							</div>
						</div>
						<!-- </div> --><!-- 中部内容结束 -->
					</div><!-- 主体内容 -->
					
					<!-- <div class="content-block-title">Side panels</div>
					<div class="content-block">
					  <div class="row">
					    <div class="col-50"><a href="#" data-panel="left" class="button open-panel">Left Panel</a></div>
					    <div class="col-50"><a href="#" data-panel="right" class="button open-panel">Right Panel</a></div>
					  </div>
					</div> -->
				</div>
			</div>
		</div>
		
		<!-- Framework7 Lib -->
		<script type="text/javascript" src="resources/assets/js/mobile/framework7.min.js"></script>
		<!-- Define My App Js -->
		<script type="text/javascript" src="resources/assets/js/mobile/my-app.js"></script>
	</body>
</html>