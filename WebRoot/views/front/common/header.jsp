<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<header id="site-header">
	<div class="row">
		<div class="col-md-4 col-sm-5 col-xs-8">
			<div class="logo">
				<h1>
					<a href="home"><b>Steve Jrong</b> 's Blog</a>
				</h1>
			</div>
		</div>
		<!-- col-md-4 -->
		<div class="col-md-8 col-sm-7 col-xs-4">
			<nav class="main-nav" role="navigation">
				<div class="navbar-header">
					<button type="button" id="trigger-overlay" class="navbar-toggle">
						<span class="ion-navicon"></span>
					</button>
				</div>
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav navbar-right">
						<li class="cl-effect-11">
							<a href="home" data-hover="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;">首页</a>
						</li>
						<!--
							<li class="cl-effect-11">
								<a href="dev" data-hover="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;">玩技术</a>
							</li>
						-->
						<li class="cl-effect-11">
							<a href="life" data-hover="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;">玩生活</a>
						</li>
						<li class="cl-effect-11">
							<a href="bd" data-hover="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;">大数据</a>
						</li>
						<li class="cl-effect-11">
							<a href="aboutme" data-hover="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;">关于</a>
						</li>
						<li class="cl-effect-11" id="title-github">
							<a href="https://github.com/SteveJrong" data-hover="GitHub" rel="nofollow">GitHub</a>
						</li>
						<s:if test="#session.userName != null">
							<li class="cl-effect-11" id="title-settings">
								<a href="mine" rel="nofollow" data-hover="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"><span class="ion-ios-gear"></span></a>
							</li>
						</s:if>
						<li class="cl-effect-11" id="title-login-logout">
							<s:if test="#session.userName == null">
								<a href="login" rel="nofollow" data-hover="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"><span class="ion-android-person"></span></a>
							</s:if>
							<s:if test="#session.userName != null">
								<a href="javascript:void(0);" rel="nofollow" data-dialog="somedialog" data-hover="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"><span class="ion-android-exit"></span></a>
							</s:if>
						</li>
					</ul>
				</div>
				<!-- /.navbar-collapse -->
			</nav>
			<div id="header-search-box">
				<a id="search-menu" href="#">
					<span id="search-icon" class="ion-ios-search-strong"></span>
				</a>
				<div id="search-form" class="search-form">
					<form role="search" method="post" id="searchform" action="search">
						<input type="search" placeholder="多关键词空格分隔搜索" name="keywords" required>
						<button type="submit">
							<a><span class="ion-ios-search-strong"></span></a>
						</button>
					</form>
				</div>
			</div>
		</div>
		<!-- col-md-8 -->
	</div>
</header>