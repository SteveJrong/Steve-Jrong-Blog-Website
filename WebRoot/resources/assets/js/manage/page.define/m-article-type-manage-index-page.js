/**
 * 后台article type manage index页 JS文件
 * 
 * 创建时间：2016年3月26日 10:47:59
 * 创建人：Steve Jrong
 * 版本：1.0
 */
require(['jquery.min','bootstrap.min','easyui/js/jquery.easyui.min','easyui/js/easyui-lang-zh_CN','jquery.dialogBox','ckeditor/ckeditor','ckeditor/samples/js/sample','../manage/other.define/slide-bar'],function (){
	initSlideBar($("#article-manage-menu-node"), $("#article-manage-menu"), "article-type-manage");
	$("#dg").datagrid({
		url : 'mAllArticleTypesInfo',
		singleSelect : true,
		iconCls : 'icon-search',
		rowNumbers : true,
		pagination : true,
		pageSize : 5,
		pageList : [ 5, 10, 15 ],
		fitColumns : true,
		striped : true,
		toolbar : [ {
			text : '新增博文类型信息',
			iconCls : 'icon-add',
			handler : function() {
				$('#type-dialogBox').dialogBox({
					type : 'normal', // three
					// type:'normal'(default),'correct','error',
					width : 370,
					height : 200,
					hasMask : true,
					autoHide : false,
					effect : 'flip-vertical',
					title : '新增博文类型',
					content : "博文类型名称：<input type='text' maxlength=20 id='newatype' />",
					hasBtn : true,
					confirmValue : '添加',
					confirm : function() {
						$.getJSON("mNewArticleTypeInfo?newatype="+$("#newatype").val(),function (data){
							if (data.result === "success") {
								$("#dg").datagrid("load","mAllArticleTypesInfo");
								$('#type-dialogBox').dialogBox({
									type : 'correct', // three
									// type:'normal'(default),'correct','error',
									width : 550,
									height : 300,
									hasMask : true,
									autoHide : false,
									effect : 'fade',
									title : '添加成功',
									content : "您已成功地添加了一个博文类型。",
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
									title : '添加失败',
									content : "您在尝试添加新博文类型时发生了异常。请重新操作。",
									hasBtn : true,
									confirmValue : '好',
									confirm : function() {
									},
								});
							}
						});
						
					},
				cancelValue : '放弃添加',
				});
				
				
				
			}
		} ],
		columns : [ [ {
			field : 'typeId',
			title : '',
			width : 10,
			sortable : false
		}, {
			field : 'typeName',
			title : '博文类型',
			width : 40
		}, {
			field : 'operate',
			title : '操作',
			width : 50,
			formatter : function formatOper(val, row, index) {
				return "<a href='javascript:operate(" + index + ",\"edit\");'>编辑</a>&nbsp;&nbsp;"+"&nbsp;&nbsp;<a href='javascript:operate(" + index + ",\"delete\");'>删除</a>";
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
		if (flag === "edit") {
			$('#type-dialogBox').dialogBox({
				type : 'normal', // three
				// type:'normal'(default),'correct','error',
				width : 370,
				height : 200,
				hasMask : true,
				autoHide : false,
				effect : 'flip-vertical',
				title : '博文详情',
				content : "博文类型编号：<input type='text' id='identity' value='" + row.typeId + "' disabled='disabled' /><br/>博文类型名称：<input type='text' id='aname' value='" + row.typeName + "' />",
				hasBtn : true,
				confirmValue : '确认修改',
				confirm : function() {
					$("#identity").removeAttr("disabled", "");
					$.getJSON("mUdArticleTypeInfo?id="+$("#identity").val()+"&name="+$("#aname").val(),function (data){
						if (data.result === "success") {
							$("#dg").datagrid("load","mAllArticleTypesInfo");
							$('#type-dialogBox').dialogBox({
								type : 'correct', // three
								// type:'normal'(default),'correct','error',
								width : 550,
								height : 300,
								hasMask : true,
								autoHide : false,
								effect : 'fade',
								title : '修改成功',
								content : "您已成功地修改此博文类型。",
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
								title : '修改失败',
								content : "您在尝试修改此博文类型时发生了异常。请重新操作。",
								hasBtn : true,
								confirmValue : '好',
								confirm : function() {
								},
							});
						}
					});
					
				},
			cancelValue : '放弃修改',
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
					$.getJSON("mDelArticleTypeInfo?id="+row.typeId,function (data){
						if (data.result === "success") {
							
							$("#dg").datagrid("load","mAllArticleTypesInfo");
							
							$('#type-dialogBox').dialogBox({
								type : 'correct', // three
								// type:'normal'(default),'correct','error',
								width : 550,
								height : 300,
								hasMask : true,
								autoHide : false,
								effect : 'fade',
								title : '删除成功',
								content : "您已成功地删除此博文类型。",
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
								content : "您在尝试删除此博文类型时发生了异常。可能由于此博文类型下仍有博文存在，或者由于内部原因无法删除博文类型信息。请重新操作。<br>如果问题仍无法解决，请联系系统管理员协助处理。",
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