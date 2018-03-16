/**
 * 后台user manage index页 JS文件
 * 
 * 创建时间：2016年4月5日 18:16:55
 * 创建人：Steve Jrong
 * 版本：1.0
 */
require(['jquery.min','bootstrap.min','jquery.dialogBox','easyui/js/jquery.easyui.min','easyui/js/easyui-lang-zh_CN','../manage/other.define/slide-bar'],function (){
	initSlideBar($("#user-info-manage-menu-node"), $("#user-info-manage-menu"), "user-info-manage");
	$(window).resize(function (){
		$("div [class='datagrid-wrap panel-body']").css("width","100%");
		$("tr [class='datagrid-header-row'] td").css("width","100%");
		//document.write("变");
	});
	
	$("#dg").datagrid({
		url : 'mAllUsersInfo',
		singleSelect : true,
		iconCls : 'icon-search',
		rowNumbers : true,
		pagination : true,
		pageSize : 5,
		pageList : [ 5, 10, 15 ],
		//fit : true,
		fitColumns : true,
		striped : true,
		columns : [ [ {
			field : 'userNickName',
			title : '用户昵称',
			width : 20,
			sortable : false
		}, {
			field : 'userRole',
			title : '用户角色',
			width : 20
		}, {
			field : 'accountState',
			title : '账户状态',
			width : 15
		}, {
			field : 'userLevel',
			title : '用户等级',
			width : 15
		}, {
			field : 'userRegisterDateTime',
			title : '注册时间',
			width : 25
		}, {
			field : 'userLastLogOnDateTime',
			title : '最后一次登录时间',
			width : 25
		}, {
			field : 'operate',
			title : '操作',
			width : 20,
			formatter : function formatOper(val, row, index) {
				return "<a href='javascript:operate(" + index + ",\"look\");'>查看</a>&nbsp;&nbsp;"+"&nbsp;&nbsp;<a href='javascript:operate(" + index + ",\"delete\");'>删除</a>";
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
 * 操作用户信息的方法
 * @param index
 */
function operate(index,flag) {
	$('#dg').datagrid('selectRow', index);// 关键在这里
	var row = $('#dg').datagrid('getSelected');
	
	if (row) {
		
		var content = "<table align='center' style='padding:20px; text-align:left;'>"+
			"<tr>"+
				"<th>用户编号</th>"+
				"<td>"+ row.userId +"</td>"+
			"</tr>"+
			
			"<tr>"+
				"<th>用户昵称</th>"+
				"<td>"+  row.userNickName+"</td>"+
			"</tr>"+
			
			"<tr>"+
				"<th>用户性别</th>"+
				"<td>"+  row.userGender +"</td>"+
			"</tr>"+
			
			"<tr>"+
				"<th>用户角色</th>"+
				"<td>"+  row.userRole +"</td>"+
			"</tr>"+
			
			"<tr>"+
				"<th>用户年龄</th>"+
				"<td>"+  row.userAge +"</td>"+
			"</tr>"+
			
			"<tr>"+
				"<th>账户状态</th>"+
				"<td>"+  row.accountState +"</td>"+
			"</tr>"+
			
			"<tr>"+
				"<th>用户等级</th>"+
				"<td>"+  row.userLevel +"</td>"+
			"</tr>"+
			
			"<tr>"+
				"<th>用户注册时间</th>"+
				"<td>"+  row.userRegisterDateTime +"</td>"+
			"</tr>"+
			
			"<tr>"+
				"<th>用户最近一次登录时间</th>"+
				"<td>"+  row.userLastLogOnDateTime +"</td>"+
			"</tr>"+
			
			"<tr>"+
				"<th>用户电子邮件地址</th>"+
				"<td>"+  row.userEmail +"</td>"+
			"</tr>"+
			
			"<tr>"+
				"<th>用户QQ号码</th>"+
				"<td>"+  row.userQQNum +"</td>"+
			"</tr>"+
			
			"<tr>"+
				"<th>用户位置信息</th>"+
				"<td>"+  row.userProvinceAndCity +"</td>"+
			"</tr>"+
		"</table>";
		
		//查看信息
		if (flag === "look") {
			$('#type-dialogBox').dialogBox({
				type : 'normal', // three
				// type:'normal'(default),'correct','error',
				width : 550,
				height : 450,
				hasMask : true,
				autoHide : false,
				effect : 'flip-vertical',
				title : '用户详细信息',
				content : content,
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
				width : 300,
				height : 200,
				hasMask : true,
				autoHide : false,
				effect : 'flip-vertical',
				title : '删除此用户',
				content : "您确认要删除这个用户吗？删除之后无法恢复。请您谨慎进行删除操作。",
				hasBtn : true,
				confirmValue : '删除',
				confirm : function() {
					$.getJSON("mDelUserInfo?userId="+row.userId,function (data){
						if (data.result === "success") {
							
							$("#dg").datagrid("load","mAllUsersInfo");
							
							$('#type-dialogBox').dialogBox({
								type : 'correct', // three
								// type:'normal'(default),'correct','error',
								width : 300,
								height : 200,
								hasMask : true,
								autoHide : false,
								effect : 'fade',
								title : '删除成功',
								content : "您已成功地删除此用户的信息。",
								hasBtn : true,
								confirmValue : '好',
								confirm : function() {
								},
							});
						}else {
							$('#type-dialogBox').dialogBox({
								type : 'error', // three
								// type:'normal'(default),'correct','error',
								width : 300,
								height : 200,
								hasMask : true,
								autoHide : false,
								effect : 'fade',
								title : '删除失败',
								content : "您在尝试删除此用户的信息时发生了异常。请重新操作。",
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