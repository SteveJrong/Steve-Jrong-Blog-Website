<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<footer>
    <hr>
    <p class="pull-right">
    	Powered By <a href="javascript:void(0);" title="Steve Jrong" target="_blank">Steve Jrong</a>
    </p>
    <p>
    	&copy; 2011-<script type="text/javascript">var myDate = new Date(); document.write(myDate.getFullYear());</script> SteveJrong&nbsp;&nbsp;&nbsp;All rights reserved.
    </p>
</footer>
<!-- 显示DialogBox对话框区域 -->
<div id='type-dialogBox'></div>