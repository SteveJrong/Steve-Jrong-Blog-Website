<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
	<head>
	    <title>编辑博文信息 :: Steve Jrong's Blog</title>
	    <!-- Meta Tags -->
	    <meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="author" content="SteveJrong">
		<!-- Website Logo -->
		<link rel="icon" href="resources/assets/img/logo/favicon.ico" type="image/x-icon" />
		<link rel="shortcut icon" href="resources/assets/img/logo/favicon.ico" type="image/x-icon" />
		<!-- Basic CSS -->
	    <link rel="stylesheet" href="resources/assets/css/bootstrap.css">
	    <link rel="stylesheet" href="resources/assets/css/theme.css">
	    <link rel="stylesheet" href="resources/assets/css/font-awesome.css">
	    <!-- DialogBox CSS -->
	    <link rel="stylesheet" href="resources/assets/css/jquery.dialogbox.css">
		<!-- CK Editor CSS -->
		<link rel="stylesheet" href="resources/assets/js/lib/ckeditor/samples/toolbarconfigurator/lib/codemirror/neo.css"></link>
		<!-- Uploadify Plugin CSS -->
		<link rel="stylesheet" href="resources/assets/css/uploadify.css" />
		<!-- Define article manage add page CSS -->
	    <link rel="stylesheet" href="resources/assets/css/customcss/addnewarticlepagecss.css">
	</head>
	<body>
		<!-- Common Header -->
		<jsp:include page="/views/manage/common/header.jsp"></jsp:include>
		<!-- Common SlideBar -->
		<jsp:include page="/views/manage/common/slidebar.jsp"></jsp:include>
		<div class="content">
		    <div class="header">
		        <h1 class="page-title">博文信息管理</h1>
		    </div>
		    <ul class="breadcrumb">
		        <li><a href="manage">主页</a> <span class="divider">/</span></li>
		        <li><a href="manage">博文信息管理</a> <span class="divider">/</span></li><li class="active">编辑博文信息</li>
		    </ul>
		    <div class="container-fluid">
		        <div class="row-fluid">
		            <h2>编辑博文信息</h2>
						<div class="alert alert-info" id="msg" style="display: none;">
							<button type="button" class="close" data-dismiss="alert">×</button>
							<strong>温馨提示：</strong>系统检测到您当前正在使用非Internet Explorer浏览器，如果您需要从外部文件粘贴带图片或富文本的资源到正文编辑器则请切换至Internet Explorer浏览器。
						</div>
						<form action="mUdArticleDetailInfo" method="post">
		            	<input type="hidden" name="browser" />
		            	<input type="hidden" name="system" />
			            <div class="basic">
			            	<ul class="basic-info">
			            		<li>博文名称：</li><li><input name="aname" type="text" placeholder="请键入博文名称" maxlength="50" value="${articles.AName }" /></li>
			            		<li>博文类型：</li>
			            			<li>
			            				<select name="atype" class="input-xlarge" style="width: 220px;">
			            					<option value="-1">--请选择博文类型--</option>
			            					<s:iterator value="articletypes">
			            						<option value="${TId }"> <s:property value="TName" /> </option>
			            					</s:iterator>
			            				</select>
			            			</li>
			            		<li>发布者：</li>
			            			<li>
			            				<select name="apublisher" class="input-xlarge" style="width: 220px;">
			            					<option value="-1">--请选择发布者--</option>
			            					<s:iterator value="users">
			            						<option value="${UId }"> <s:property value="UNickname" /> </option>
			            					</s:iterator>
			            				</select>
			            			</li>
			            		<li>博文关键字：</li><li><input name="atag" type="text" placeholder="请键入博文关键字" maxlength="10" value="${articles.ATagkeyword }" /></li>
			            		<li>置顶：<input type="checkbox" name="atop" /></li>
			            		<li>简略介绍：</li><li><textarea name="abrief" style="width: 95%" rows="5" placeholder="请在此以纯文本的形式简略的介绍博文信息" maxlength="500">${articles.ABriefcontents }</textarea></li>
			            		<li>附件资源上传（选中后自动上传）：</li>
			            		<li>
			            			<input type="file" name="uploadFiles" id="uploadify" />
			            			<p style="color:silver;">非常抱歉，目前暂不支持文件附件编辑。</p>
			            		</li>
			            	</ul>
			            </div>
		            	<textarea class="ckeditor" id="content" name="content" rows="10">${articles.ABodycontents }</textarea>
		            	<input type="submit" value="确认修改" class="btn btn-primary" />
		            	<input type="hidden" name="articleId" value="${articles.AId }" />
		            </form>
		            <!-- Common Footer -->
		            <jsp:include page="/views/manage/common/footer.jsp"></jsp:include>
		        </div>
		    </div>
		</div>
		<!-- RequireJS Lib -->
		<script src="resources/assets/js/lib/require.js" data-main="resources/assets/js/lib/main"></script>
		<!-- Define article manage page Js -->
		<script src="resources/assets/js/manage/page.define/m-article-manage-common-add-edit-page.js"></script>
	</body>
</html>