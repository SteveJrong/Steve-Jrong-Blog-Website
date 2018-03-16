<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div class="navbar">
    <div class="navbar-inner">
        <ul class="nav pull-right">
            <li id="fat-menu" class="dropdown">
                <a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown">
                    <i class="icon-user"></i><s:property value="#session.userName" />
                    <i class="icon-caret-down"></i>
                </a>
                <ul class="dropdown-menu">
                    <li><a tabindex="-1" href="home">返回主站</a></li>
                    <li class="divider"></li>
                    <!-- <li class="divider visible-phone"></li> -->
                    <li><a tabindex="-1" href="exit">退出登录</a></li>
                </ul>
            </li>
        </ul>
        <a class="brand" href="manage"><span class="first">Steve Jrong's Blog</span> <span class="second">后台管理系统</span></a>
    </div>
</div>