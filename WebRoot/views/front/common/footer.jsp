<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<footer id="site-footer">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<p class="copyright">
					&copy; 2011-<script type="text/javascript">var myDate = new Date(); document.write(myDate.getFullYear());</script> Steve Jrong&nbsp;&nbsp;All Rights Reserved.
				</p>
				<p align="center" class="beian_info"><img alt="beian" src="miit">&nbsp;&nbsp;&nbsp;<a href="http://www.miitbeian.gov.cn" target="blank" rel="nofollow">晋ICP备16003543号</a><script type="text/javascript" src="resources/assets/js/lib/cnzz.js"></script></p>
			</div>
		</div>
	</div>
</footer>