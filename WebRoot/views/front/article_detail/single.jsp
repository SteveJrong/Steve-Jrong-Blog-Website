<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
	<head>
	    <title>${article.AName }-${article.sjUsers.UNickname } :: Steve Jrong's Blog</title>
	    <!-- Meta Tags -->
	    <meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta name="renderer" content="webkit|ie-stand">
	    <meta name="description" content="${article.AName }-${article.sjUsers.UNickname }">
		<meta name="keywords" content="${article.ATagkeyword }">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="author" content="${article.sjUsers.UNickname }">
		<!-- Website Logo -->
		<link rel="icon" href="resources/assets/img/logo/favicon.ico" type="image/x-icon" />
		<link rel="shortcut icon" href="resources/assets/img/logo/favicon.ico" type="image/x-icon" />
	    <!-- Basic CSS -->
	    <link rel="stylesheet" href="resources/assets/css/bootstrap.min.css">
	    <link rel="stylesheet" href="resources/assets/css/ionicons.min.css">
	    <link rel="stylesheet" href="resources/assets/css/pace.css">
	    <link rel="stylesheet" href="resources/assets/css/custom.css">
	    <!-- jQuery ScrollUp CSS -->
		<link rel="stylesheet" href="resources/assets/css/scrollUp.css" type="text/css"></link>
		<!-- Exit Diaplog CSS -->
		<link rel="stylesheet" href="resources/assets/css/dialog-ken.css" type="text/css"></link>
		<link rel="stylesheet" href="resources/assets/css/dialog.css" type="text/css"></link>
		<link rel="stylesheet" href="resources/assets/css/demo.css" type="text/css"></link>
		<!-- Zero Modal Dialog CSS -->
		<link rel="stylesheet" href="resources/assets/css/zeroModal.css" type="text/css"></link>
		<!-- Social Share CSS -->
		<link rel="stylesheet" href="resources/assets/css/social-share.css" type="text/css"></link>
		<!-- Define single page CSS -->
		<link rel="stylesheet" href="resources/assets/css/customcss/articledetailPagecss.css" type="text/css"></link>
	</head>
	<body>
	    <div class="container">
	        <!-- Common Header -->
			<jsp:include page="/views/front/common/header.jsp"></jsp:include>
	    </div>
	    <div class="content-body">
	        <div class="container">
	            <div class="row">
	                <main class="col-md-8">
	                    <article class="post post-1">
	                        <header class="entry-header">
	                            <h1 class="entry-title"> ${article.AName } </h1>
	                            <div class="entry-meta">
		
		                                <span class="post-date"><a href="javascript:void(0);"><time class="entry-date">  <s:date name="article.ACreatedate" format="yyyy-MM-dd"/> </time></a></span>
		
		                                <span class="post-author"><a href="javascript:void(0);"> ${article.sjUsers.UNickname } </a></span>
		                                
		                                <span class="post-category"><a href="javascript:void(0);"> ${article.ATagkeyword } </a></span>
		                                
		                                <jsp:include page="/views/front/common/article_published_platform_of_article_detail.jsp"></jsp:include>
		                               
		                                <span class="post-views"><span>浏览量：${article.AReadcount }</span></span>
		                            </div>
	                        </header>
	                        <div class="entry-content clearfix">
	                            <p>
	                            	${article.ABodycontents }
		                        </p>
	                        </div>
	                    </article>
	                    
	                    <div class="entry-content clearfix">
	                    <div class="split_line"></div>
	                    
	                    <!-- 已登录显示发布表单 -->
	                    <s:if test="isLogin == true">
	                    	<form action="cOrR" method="post" class="contact-form" id="myForm">
		                        <div class="row">
		                        	<div class="messages">
		                        		<textarea name="content" rows="5" cols="3" placeholder="据说在这里留言的人，几年以后都变得牛逼了" required></textarea>
										<p>
											<img src="servlet/ValidateCodeServlet" alt="验证码" id="safeCode" />
											<input type="text" name="checkedCode" placeholder="请键入验证码" required>
											
											<input type="hidden" id="system" name="system" />
											<input type="hidden" id="device" name="device" />
											<input type="hidden" id="articleId" name="articleId" value="${article.AId }" />
											<a id="changeCode" style="cursor: pointer;">看不清，换一张</a>
										</p>
										<button id="pubBtn" class="btn-send btn-5 btn-5b ion-ios-paperplane"><span>发布</span></button>
		                        	</div>
		                        </div>
		                    </form>
		                </s:if>
	                    <!-- 未登录显示浮层 -->
	                    <s:if test="isLogin == false">
	                    	<div class="shadow">
	                    		<form action="cOrR" method="post" class="contact-form">
			                        <div class="row">
			                        	<div class="messages">
			                        		<textarea rows="5" cols="3" placeholder="据说在这里留言的人，几年以后都变得牛逼了" required></textarea>
											<p>
												<img src="servlet/ValidateCodeServlet" alt="验证码" id="safeCode" />
												<input type="text" name="checkedCode" placeholder="请键入验证码" required>
												<a id="changeCode" style="cursor: pointer;">看不清，换一张</a>
											</p>
											<button class="btn-send btn-5 btn-5b ion-ios-paperplane"><span>发布</span></button>
			                        	</div>
			                        </div>
			                    </form>
	                    	</div>
	                    	<div class="please_login">
	                    		<p>请登录后再发表</p>
	                    		<p><button class="btn-send btn-5 btn-5b ion-ios-paperplane" onclick="javascript:window.location.href='login';"><span>现在去登录</span></button></p>
	                    	</div>
	                    </s:if>
	                 </div>
	                 
	                 <div class="split_line"></div>
	                 
	               	<h4>文件附件</h4>
	           		<div class="all_file">
	           			<c:if test="${fn:length(fileAttachmentsOfArticleDTOs) <= 0}">
	                  			<p style="text-align:center; margin-top:-8px; margin-bottom:10px; color:gray;">暂无文件附件供下载</p>
	                  	</c:if>
	                  	
	                  	<c:if test="${fn:length(fileAttachmentsOfArticleDTOs) > 0}">
		            		<ul>
		              		<s:iterator value="fileAttachmentsOfArticleDTOs">
		              			<li>
		           					<span title="文件附件名：${fileFullName }">${fileShortName }
		           						<s:if test="needShortMode == true">
		           							...
		           						</s:if>
		           					</span>
		           					<span title="文件附件MD5值：${fileMD5Value }">MD5：${fileMD5Value }</span>
		           					
		           					<s:if test="fileExists == true">
		           						<span title="点击链接以下载附件文件"><a href="dFile_${fileId}">点击下载</a></span>
		           					</s:if>
		           					
		           					<s:if test="fileExists == false">
		           						<span title="服务器文件丢失 暂不提供下载" class="file_not_exists">文件丢失不可下载</span>
		           					</s:if>
		              			</li>
		              			<br/>
		              		</s:iterator>
		            		</ul>
	            		</c:if>
	           		</div>
	                 
	                 <h4>互动</h4>
	                    
	                 <div class="all_c_or_r">
	                  	<ul>
	                  		<c:if test="${fn:length(thisArticleCOrRs) <= 0}">
	                  			<p style="text-align:center; margin-top:-8px; margin-bottom:10px; color:gray;">暂无互动信息</p>
	                  		</c:if>
	                  		
	                  		<c:if test="${fn:length(thisArticleCOrRs) > 0}">
	                  			<s:iterator value="thisArticleCOrRs">
	                  			<li>
		                   			<div class="c_header">
		                   				<img alt="${sjUsersByMUId.UNickname }" title="${sjUsersByMUId.UNickname }" src="${sjUsersByMUId.UHeader }" width="30em" height="30em" />
		                   			</div>
		                   			
		                   			<div class="c_content">
		                   				<span>${MComments }</span>
		                   			</div>
		                   			
		                   			<div class="c_operate">
		                   				<%-- <span class="reply"><a data-dialog-c-or-r="c_or_r_dialog">🔃（<span>-</span>）</a></span> --%>
		                   				<span class="good" data-bind="${MId }"><a>  <span class="ion-heart"></span> （<span class="praise_count">${MPraisecount }</span>）</a></span>
		                   			</div>
		                   			
		                   			<div class="c_or_r_date" title="${sjUsersByMUId.UNickname } 在 <s:date name="MPublishdate" format="yyyy-MM-dd HH:mm:ss" /> 发表">
		                   				<s:date name="MPublishdate" format="yyyy-MM-dd HH:mm:ss" />
		                   			</div>
	                  			</li>
	                  			<hr />
	                  			</s:iterator>
	                  		</c:if>
	                  	</ul>
	                 </div>
	                </main>
	                <!-- Common Slide Bar -->
					<jsp:include page="/views/front/common/slidebar.jsp"></jsp:include>
	            </div>
	        </div>
	    </div>
	    <!-- Common Footer -->
		<jsp:include page="/views/front/common/footer.jsp"></jsp:include>
		<!-- Common Mobile Menu -->
		<jsp:include page="/views/front/common/mobilemenu.jsp"></jsp:include>
		<!-- RequireJS Lib -->
		<script src="resources/assets/js/lib/require.js" data-main="resources/assets/js/lib/main"></script>
		<!-- Define Singlepage Js -->
		<script src="resources/assets/js/front/page.define/single-page.js"></script>
	</body>
</html>