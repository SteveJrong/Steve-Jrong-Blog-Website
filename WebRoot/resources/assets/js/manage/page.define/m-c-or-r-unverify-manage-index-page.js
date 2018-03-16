/**
 * 后台comments or reply unverify manage index页 JS文件
 * 
 * 创建时间：2016年8月29日 18:38:22
 * 创建人：Steve Jrong
 * 版本：1.0
 */
require(['jquery.min','bootstrap.min','easyui/js/jquery.easyui.min','easyui/js/easyui-lang-zh_CN','jquery.dialogBox','bootstrap-datetimepicker','bootstrap-datetimepicker.zh-CN','../manage/other.define/slide-bar'],function (){
	initSlideBar($("#c-or-r-manage-menu-node"), $("#c-or-r-manage-menu"), "c-or-r-verify-manage");
	$("#dg").datagrid({
		url : 'mUnverifycOrR',
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
				return "<a href='javascript:operate(" + index + ",\"verify\");'>审核</a>";
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
		
		//编辑信息
		if (flag === "verify") {
			$('#type-dialogBox').dialogBox({
				type : 'normal', // three
				// type:'normal'(default),'correct','error',
				width : 450,
				height : 400,
				hasMask : true,
				autoHide : false,
				effect : 'flip-vertical',
				title : '互动审核',
				content : "<div style='margin:0em auto; width:25em; overflow:hidden; margin-top:-3em;'><!-- 消息编号：--><input type='hidden' id='identity' value='" + row.cOrRId + "' disabled='disabled' /><br/>发布者："+row.cOrRPublichedPeople+"<br/>接收者："+row.cOrRReceivedPeople+"<br/>内&nbsp;&nbsp;&nbsp;容：<textarea type='text' id='cOrRContent' cols=3 rows=4 disabled='disabled'>"+row.cOrRContent+"</textarea><br/>状&nbsp;&nbsp;&nbsp;态："+row.cOrRVerifyState+"<br /><span style='float:left;'>审&nbsp;&nbsp;&nbsp;核：</span><div class='radio' style='float:left; margin-top:2px;'><label><input type='radio' name='verifyBtn' value='通过' />通过</label></div><div class='radio' style='float:left; margin-top:2px; margin-left:8px;'><label><input type='radio' name='verifyBtn' value='拒绝' />拒绝</label></div></div>",
				hasBtn : true,
				confirmValue : '确认审核',
				confirm : function() {
					$("#identity").removeAttr("disabled", "");
					if ($("input:radio[name*='verifyBtn']:checked").val() != "通过" && $("input:radio[name*='verifyBtn']:checked").val() != "拒绝") {
						alert("请正确填写审核数据。");
						return;
					}
					$.getJSON("mVerifycOrR?id="+$("#identity").val()+"&verifyresult="+$("input:radio[name*='verifyBtn']:checked").val(),function (data){
						if (data.result === "success") {
							$("#dg").datagrid("load","mUnverifycOrR");
							$('#type-dialogBox').dialogBox({
								type : 'correct', // three
								// type:'normal'(default),'correct','error',
								width : 550,
								height : 300,
								hasMask : true,
								autoHide : false,
								effect : 'fade',
								title : '审核成功',
								content : "您已成功地审核此条互动消息。",
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
								title : '审核失败',
								content : "您在尝试审核此条互动消息时发生了异常。请重新操作。",
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