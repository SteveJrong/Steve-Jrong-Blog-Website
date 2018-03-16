<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div class="sidebar-nav">
    <!-- <a href="#dashboard-menu" class="nav-header collapsed" data-toggle="collapse"><i class="icon-home"></i>主页<i class="icon-chevron-up"></i></a>
    <ul id="dashboard-menu" class="nav nav-list collapse">
        <li><a href="javascript:void(0);">仪表板</a></li>
        <li><a href="javascript:void(0);">用户</a></li>
        <li><a href="javascript:void(0);">文章</a></li>
        <li><a href="javascript:void(0);">互动</a></li>
    </ul> -->
    <a id="article-manage-menu-node" href="#article-manage-menu" class="nav-header collapsed" data-toggle="collapse"><i class="icon-book"></i>博文管理<i class="icon-chevron-up"></i></a>
    <ul id="article-manage-menu" class="nav nav-list collapse">
        <li data-bind="article-manage"><a href="manage">博文信息管理</a></li>
        <li data-bind="article-type-manage"><a href="atypemanage">博文类型管理</a></li>
    </ul>
    <a id="user-info-manage-menu-node" href="#user-info-manage-menu" class="nav-header collapsed" data-toggle="collapse"><i class="icon-user"></i>用户管理<!--<span class="label label-info">+3</span>--><i class="icon-chevron-up"></i></a>
    <ul id="user-info-manage-menu" class="nav nav-list collapse">
        <li data-bind="user-info-manage"><a href="usermanage">用户信息管理</a></li>
    </ul>
    <a id="life-manage-menu-node" href="#life-manage-menu" class="nav-header collapsed" data-toggle="collapse"><i class="icon-leaf"></i>生活段子管理<i class="icon-chevron-up"></i></a>
    <ul id="life-manage-menu" class="nav nav-list collapse">
        <li data-bind="life-manage"><a href="lifemanage">生活段子管理</a></li>
    </ul>
    <a id="c-or-r-manage-menu-node" href="#c-or-r-manage-menu" class="nav-header collapsed" data-toggle="collapse"><i class="icon-comments"></i>互动信息管理<i class="icon-chevron-up"></i></a>
    <ul id="c-or-r-manage-menu" class="nav nav-list collapse">
        <li data-bind="c-or-r-manage"><a href="cOrRmanage">互动信息管理</a></li>
        <li data-bind="c-or-r-verify-manage"><a href="cOrRUnverifymanage">互动信息审核</a></li>
    </ul>
    <a id="settings-menu-node" href="#settings-menu" class="nav-header collapsed" data-toggle="collapse"><i class="icon-cog"></i>系统设置<i class="icon-chevron-up"></i></a>
    <ul id="settings-menu" class="nav nav-list collapse">
        <li data-bind="full-text-indexes-manage"><a href="mReIndexesManage">全文索引</a></li>
        <li data-bind="repairing-manage"><a href="mRepManage">网站维护状态管理</a></li>
    </ul>
    <!-- <a href="javascript:void(0);" class="nav-header"><i class="icon-question-sign"></i>帮助</a>
    <a href="javascript:void(0);" class="nav-header"><i class="icon-phone"></i>联系我</a> -->
</div>