<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div class="overlay overlay-hugeinc">
	<button type="button" class="overlay-close">
		<span class="ion-ios-close-empty"></span>
	</button>
	<nav>
		<ul>
			<li class="cl-effect-11"><a href="home">首页</a></li>
			<!-- <li class="cl-effect-11"><a href="dev">玩技术</a></li> -->
			<li class="cl-effect-11"><a href="life">玩生活</a></li>
			<li class="cl-effect-11"><a href="bd">大数据</a></li>
			<li class="cl-effect-11"><a href="aboutme">关于</a></li>
			<li class="cl-effect-11"><a href="download">移动App</a></li>
			<s:if test="#session.userName == null">
				<li class="cl-effect-11"><a href="login">登录</a></li>
			</s:if>
			<s:if test="#session.userName != null">
				<li class="cl-effect-11"><a href="mine">个人中心</a></li>
			</s:if>
		</ul>
	</nav>
</div>
<!-- Exit Dialog -->
<div id="somedialog" class="dialog">
	<div class="dialog__overlay"></div>
	<div class="dialog__content">
		<h2>
			<strong> <s:property value="#session.userName" />
			</strong>,现在离开吗？
		</h2>
		<div>
			<button class="action" data-dialog-close onclick="javascript:window.location.href='exit'">注销</button>
		</div>
	</div>
</div>