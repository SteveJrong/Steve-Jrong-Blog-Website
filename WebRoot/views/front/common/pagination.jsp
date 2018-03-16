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
			<a class="homePageButton" href="javascript:pageSkip(1,'first');"> <span class="ion-skip-backward"></span> <span id="homePageNum">1</span></a>
		</li>
		<!-- 上一页 -->
		<li>
			<a class="prevPageButton" href="javascript:pageSkip(${prevPageIndex},'front');"> <span class="ion-arrow-left-b"></span> <span id="prevPageNum">${prevPageIndex}</span></a>
		</li>
		<!-- 当前页 -->
		<li>
			<a class="currentPageButton" href="javascript:void(0);">  <span id="currentPageNum">${pageIndex }</span></a>
		</li>
		<!-- 下一页 -->
		<li>
			<a class="nextPageButton" href="javascript:pageSkip(${nextPageIndex},'back');"> <span class="ion-arrow-right-b"></span>  <span id="nextPageNum">${pageIndex+1 }</span></a>
		</li>
		<!-- 末页 -->
		<li>
			<a class="lastPageButton" href="javascript:pageSkip(${lastPageIndex},'last');"> <span class="ion-skip-forward"></span> <span id="lastPageNum">${lastPageIndex}</span></a>
		</li>
		<!-- 空白列 -->
		<li>
			<a><span id="spaces">&nbsp;&nbsp;</span></a>
		</li>
		<!-- 总页数 -->
		<li>
			<a class="totalPagesButton"><span id="totalPagesNum">${totalPageSize}</span></a>
		</li>
		<!-- 总条数 -->
		<%-- <li>
			<a class="totalCountButton">共<span id="totalCountNum">${totalCount}</span>条记录</a>
		</li> --%>
		<!-- 上一页： --><input type="hidden" name="prevPageIndex" value="${prevPageIndex}" />
		<!-- 当前页： --><input type="hidden" name="pageIndex" value="${pageIndex}" />
		<!-- 下一页： --><input type="hidden" name="nextPageIndex" value="${nextPageIndex}" />
		<!-- 最后一页： --><input type="hidden" name="lastPageIndex" value="${lastPageIndex}" />
		<!-- 总条数： --><input type="hidden" name="totalCount" value="${totalCount}" />
	</ul>
</div>