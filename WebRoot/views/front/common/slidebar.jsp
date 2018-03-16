<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<aside class="col-md-4">
	<div class="widget widget-recent-posts">
		<h3 class="widget-title">最近更新</h3>
		<ul>
			<s:iterator value="recentUpdatesArticlesLinks">
				<li><a href="detail_${AId }"> ${AName } </a></li>
			</s:iterator>
		</ul>
	</div>
	<div class="widget widget-archives">
		<h3 class="widget-title">文章归档</h3>
		<ul>
			<s:iterator value="articlesInfoEntities">
				<li>
					<a href="date_1_${articleArchiveDate }">${articleArchiveDate }（${thisArticleArchiveCount }）</a>
				</li>
			</s:iterator>
		</ul>
	</div>
	<div class="widget widget-category">
		<h3 class="widget-title">类别</h3>
		<ul>
			<s:iterator value="articletypes">
				<li><a href="type_2_${TId }">${TName }</a></li>
			</s:iterator>
		</ul>
	</div>
	<div class="widget widget-friendlink">
		<h3 class="widget-title">博文原址</h3>
		<ul>
			<li><a href="mysina" target="blank" rel="nofollow">新浪博客</a></li>
			<li><a href="mycsdn" target="blank" rel="nofollow">CSDN博客</a></li>
		</ul>
	</div>
	<div class="widget widget-friendlink">
		<h3 class="widget-title">友情链接</h3>
		<ul>
			<li><a href="ibm" target="_blank" rel="nofollow">IBM Developer Work</a></li>
			<li><a href="uwp" target="_blank" rel="nofollow">Windows Dev Center</a></li>
			<li><a href="csdn" target="_blank" rel="nofollow">CSDN Community</a></li>
			<li><a href="iteye" target="_blank" rel="nofollow">ITeye</a></li>
			<shiro:hasAnyRoles name="interview">
				<li><a href="myresume" target="_blank" rel="nofollow">我的简历</a></li>
			</shiro:hasAnyRoles>
			<li><a href="manage" target="_self"><img class="background-manage-link" src="resources/assets/img/uac.png" width="16.3px" height="16.3px">后台管理系统</a></li>
		</ul>
	</div>
</aside>