/**
 * 后台article manage index页 JS文件
 * 
 * 创建时间：2016年3月26日 10:47:59
 * 创建人：Steve Jrong
 * 版本：1.0
 */
require(['jquery.min','bootstrap.min','easyui/js/jquery.easyui.min','easyui/js/easyui-lang-zh_CN','jquery.dialogBox','../manage/other.define/slide-bar'],function (){
	initSlideBar($("#article-manage-menu-node"), $("#article-manage-menu"), "article-manage");
	$("#dg").datagrid({
		url : 'mAllArticleInfo',
		singleSelect : true,
		iconCls : 'icon-search',
		rowNumbers : true,
		pagination : true,
		pageSize : 5,
		pageList : [ 5, 10, 15 ],
		fitColumns : true,
		striped : true,
		toolbar : [ {
			text : '新增博文信息',
			iconCls : 'icon-add',
			handler : function() {
				window.location.href = getRootPath()+'/mNewArticleInfo';
			}
		} ],
		columns : [ [ {
			field : 'articleId',
			title : '',
			width : 15,
			sortable : false
		}, {
			field : 'articleTitle',
			title : '博文标题',
			width : 180
		}, {
			field : 'articleCreateDateTime',
			title : '创建时间',
			width : 75
		}, {
			field : 'articleModifyDateTime',
			title : '修改时间',
			width : 75
		}, {
			field : 'articleType',
			title : '博文类型',
			width : 30
		}, {
			field : 'articleUser',
			title : '创建人',
			width : 50
		}, {
			field : 'operate',
			title : '操作',
			width : 100,
			formatter : function formatOper(val, row, index) {
				return "<a href='javascript:operate(" + index + ",\"look\");'>查看</a>&nbsp;&nbsp;"+"&nbsp;&nbsp;<a href='javascript:operate(" + index + ",\"delete\");'>删除</a>"+"&nbsp;&nbsp;<a href='javascript:operate(" + index + ",\"edit\");'>编辑</a>";
			}
		} ] ],
		loadMsg : "数据拼命加载中……"
	});
	
	$("[rel=tooltip]").tooltip();
	$(function() {
		$('.demo-cancel-click').click(function() {
			return false;
		});
	});
});

/**
 * 操作博文信息的方法
 * @param index
 */
function operate(index,flag) {
	$('#dg').datagrid('selectRow', index);// 关键在这里
	var row = $('#dg').datagrid('getSelected');
	
	if (row) {
		
		//查看信息
		if (flag === "look") {
			$('#type-dialogBox').dialogBox({
				type : 'normal', // three
				// type:'normal'(default),'correct','error',
				width : 350,
				height : 430,
				hasMask : true,
				autoHide : false,
				effect : 'flip-vertical',
				title : '博文详情',
				content : "编号：" + row.articleId + "<br/>标题："+row.articleTitle+"<br/>创建时间："+row.articleCreateDateTime+"<br/>修改时间："+row.articleModifyDateTime+"<br/>博文类型："+row.articleType+"<br/>发布者："+row.articleUser
				+"<br/>浏览器："+row.browserInfo+"<br/>操作系统："+row.systemInfo+"<br/>总附件文件数："+row.fileAttachemntsTotalCount+"<br/>状态："+row.state+"<br/>关键字："+row.keywords+"<br/>IP地址："+row.publishedIpAddress,
				hasBtn : true,
				confirmValue : '好',
				confirm : function() {
					window.location.href = "javascript:(0);";
				},
			/* cancelValue : '取消', */
			});
			//删除信息
		}else if (flag === "delete") {
			$('#type-dialogBox').dialogBox({
				type : 'error', // three
				// type:'normal'(default),'correct','error',
				width : 550,
				height : 300,
				hasMask : true,
				autoHide : false,
				effect : 'flip-vertical',
				title : '删除博文',
				content : "您确认要删除这篇博文吗？删除之后无法恢复。请确认您的操作。",
				hasBtn : true,
				confirmValue : '删除',
				confirm : function() {
					$.getJSON("delArticleInfo.action?articleId="+row.articleId,function (data){
						if (data.result === "success") {
							
							$("#dg").datagrid("load","mAllArticleInfo");
							
							$('#type-dialogBox').dialogBox({
								type : 'correct', // three
								// type:'normal'(default),'correct','error',
								width : 550,
								height : 300,
								hasMask : true,
								autoHide : false,
								effect : 'fade',
								title : '删除成功',
								content : "您已成功地删除此博文。",
								hasBtn : true,
								confirmValue : '好',
								confirm : function() {
								},
							});
						}else {
							$('#type-dialogBox').dialogBox({
								type : 'error', // three
								// type:'normal'(default),'correct','error',
								width : 550,
								height : 300,
								hasMask : true,
								autoHide : false,
								effect : 'fade',
								title : '删除失败',
								content : "您在尝试删除此博文时发生了异常。请重新操作。",
								hasBtn : true,
								confirmValue : '好',
								confirm : function() {
								},
							});
						}
					});
				},
			cancelValue : '取消',
			});
		}else if (flag === "edit") {
			var aid = row.articleId;
			window.location.href="mEditArticleManage_"+aid;
		}
	}
}

/**
 * 获取项目根目录的方法
 * @returns 项目根目录
 */
function getRootPath(){
	//获取当前网址
    var curWwwPath = window.document.location.href;
    //获取主机地址之后的目录
    var pathName = window.document.location.pathname;
    var pos = curWwwPath.indexOf(pathName);
    //获取主机地址
    var localhostPaht = curWwwPath.substring(0, pos);
    //获取带"/"的项目名
    var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
    //返回项目根目录
	return localhostPaht + projectName;
}

