<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<span class="comments-link" style="margin-right:0.5rem; margin-left:0.5rem;">
	<a href="javascript:void(0);">
		<!-- Google Chrome ICON -->
		<s:if test="ABrowserinfo.indexOf('Chrome')!=-1">
			<img src="chrome" width="18" height="18" title="该博文发布者使用Chrome浏览器发布" alt="Google Chrome" />
		</s:if>
		
		<!-- Mozilla FireFox ICON -->
		<s:if test="ABrowserinfo.indexOf('Firefox')!=-1">
			<img src="firefox" width="18" height="18" title="该博文发布者使用FireFox浏览器发布" alt="FireFox"  />
		</s:if>
		
		<!-- Internet Explorer Or Microsoft Edge ICON -->
		<s:if test="ABrowserinfo.indexOf('Internet Explorer')!=-1 || ABrowserinfo.indexOf('Edge')!=-1">
			<img src="edge" width="18" height="18" title="该博文发布者使用Internet Explorer浏览器发布" alt="Internet Explorer"  />
		</s:if>
		
		<!-- Apple Safari ICON -->
		<s:if test="ABrowserinfo.indexOf('Safari')!=-1">
			<img src="safari" width="18" height="18" title="该博文发布者使用Safari浏览器发布" alt="Safari"  />
		</s:if>
	</a>
</span>

<span class="comments-link">
	<a href="javascript:void(0);">
		<!-- Linux Operating System ICON -->
		<s:if test="ASysteminfo.indexOf('Linux')!=-1">
			<img src="resources/assets/img/platform/pc/linux-logo.png" width="18" height="18" title="该博文发布者在Linux操作系统下发布" alt="Linux"  />
		</s:if>
		
		<!-- OS X Operating System ICON -->
		<s:if test="ASysteminfo.indexOf('Mac')!=-1">
			<img src="macosx" width="18" height="18" title="该博文发布者在Mac OS X操作系统下发布" alt="OS X"  />
		</s:if>
		
		<!-- Microsoft Windows Operating System ICON -->
		<s:if test="ASysteminfo.indexOf('Windows')!=-1">
			<img src="win32" width="18" height="18" title="该博文发布者在Windows操作系统下发布" alt="Windows"  />
		</s:if>
	</a>
</span>