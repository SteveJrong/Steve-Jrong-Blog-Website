/**
 * 后台comments or reply manage index页 JS文件
 * 
 * 创建时间：2016年9月3日 09:30:28
 * 创建人：Steve Jrong
 * 版本：1.0
 */
require(['jquery.min','bootstrap.min','easyui/js/jquery.easyui.min','easyui/js/easyui-lang-zh_CN','jquery.dialogBox','bootstrap-datetimepicker','bootstrap-datetimepicker.zh-CN','../manage/other.define/slide-bar'],function (){
	initSlideBar($("#c-or-r-manage-menu-node"), $("#c-or-r-manage-menu"), "c-or-r-manage");
	$(function () {
	    $("#start_dtp").datetimepicker({
	    	format : 'yyyy-mm-dd hh:ii:ss'
	    });
	    $("#end_dtp").datetimepicker({
	    	format : 'yyyy-mm-dd hh:ii:ss'
	    });
	});
	
	$("#dg").datagrid({
		url : 'mCOrRInfo',
		singleSelect : true,
		iconCls : 'icon-search',
		rowNumbers : true,
		pagination : true,
		pageSize : 5,
		pageList : [ 5, 10, 15 ],
		fitColumns : true,
		striped : true,
		columns : [ [ {
			field : 'cOrRId',
			title : '',
			width : 10,
			sortable : false
		}, {
			field : 'cOrRPublichedPeople',
			title : '互动发布者',
			width : 40
		}, {
			field : 'cOrRReceivedPeople',
			title : '互动接收者',
			width : 40
		}, {
			field : 'cOrRPublichedDateTime',
			title : '发布时间',
			width : 63
		}, {
			field : 'cOrRMsgType',
			title : '消息类型',
			width : 40
		}, {
			field : 'cOrRVerifyState',
			title : '审核状态',
			width : 30
		}, {
			field : 'cOrRPublishedIPAddress',
			title : '发布者IP地址',
			width : 40
		}, {
			field : 'cOrRDeviceInfo',
			title : '设备信息',
			width : 40
		}, {
			field : 'cOrRSystemInfo',
			title : '平台信息',
			width : 65
		}, {
			field : 'operate',
			title : '操作',
			width : 50,
			formatter : function formatOper(val, row, index) {
				return "<a href='javascript:operate(" + index + ",\"delete\");'>删除</a>";
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
	
	//搜索按钮点击事件
	$("#searchBtn").bind("click",function (){
		$("#dg").datagrid("load",{"searchStartDate":$("#start_dtp").val(),"searchEndDate":$("#end_dtp").val(),"searchVerifyStatus":$("#combo_verify_status").val()});
	});
});

/**
 * 操作互动信息的方法
 * @param index
 */
function operate(index,flag) {
	$('#dg').datagrid('selectRow', index);// 关键在这里
	var row = $('#dg').datagrid('getSelected');
	
	if (row) {
		//删除信息
		if (flag === "delete") {
			$('#type-dialogBox').dialogBox({
				type : 'error', // three
				// type:'normal'(default),'correct','error',
				width : 550,
				height : 300,
				hasMask : true,
				autoHide : false,
				effect : 'flip-vertical',
				title : '删除互动消息',
				content : "您确认要删除这条互动消息吗？删除之后无法恢复。请确认您的操作。",
				hasBtn : true,
				confirmValue : '删除',
				confirm : function() {
					$.getJSON("mDelCOrR?id="+row.cOrRId,function (data){
						if (data.result === "success") {
							$("#dg").datagrid("load","mCOrRInfo");
							$('#type-dialogBox').dialogBox({
								type : 'correct', // three
								// type:'normal'(default),'correct','error',
								width : 550,
								height : 300,
								hasMask : true,
								autoHide : false,
								effect : 'fade',
								title : '删除成功',
								content : "您已成功地删除此条互动消息。",
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
								content : "您在尝试删除此条互动消息时发生了异常。请重新操作。",
								hasBtn : true,
								confirmValue : '好',
								confirm : function() {
								},
							});
						}
					});
				},
			/*cancelValue : '取消',*/
			});
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