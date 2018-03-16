<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div class="pagination_nav">
	<ul class="pagination">
		<!-- 首页 -->
		<li>
			<a class="homePageButton"> <span class="ion-skip-backward"></span> <span id="homePageNum"></span></a>
		</li>
		<!-- 上一页 -->
		<li>
			<a class="prevPageButton"> <span class="ion-arrow-left-b"></span> <span id="prevPageNum"></span></a>
		</li>
		<!-- 当前页 -->
		<li>
			<a class="currentPageButton"> <span id="currentPageNum"></span></a>
		</li>
		<!-- 下一页 -->
		<li>
			<a class="nextPageButton"> <span class="ion-arrow-right-b"></span>  <span id="nextPageNum"></span></a>
		</li>
		<!-- 末页 -->
		<li>
			<a class="lastPageButton"> <span class="ion-skip-forward"></span> <span id="lastPageNum"></span></a>
		</li>
		<!-- 空白列 -->
		<li>
			<a><span id="spaces">&nbsp;&nbsp;</span></a>
		</li>
		<!-- 总页数 -->
		<li>
			<a class="totalPagesButton"><span id="totalPagesNum"></span></a>
		</li>
		<!-- 上一页： --><input type="hidden" name="prevPageIndex" value="${prevPageIndex}" />
		<!-- 当前页： --><input type="hidden" name="pageIndex" value="${pageIndex}" />
		<!-- 下一页： --><input type="hidden" name="nextPageIndex" value="${nextPageIndex}" />
		<!-- 最后一页： --><input type="hidden" name="lastPageIndex" value="${lastPageIndex}" />
		<!-- 总条数： --><input type="hidden" name="totalCount" value="${totalCount}" />
	</ul>
</div>