/**
 * 后台life manage index页 JS文件
 * 
 * 创建时间：2016年7月23日 19:11:00
 * 创建人：Steve Jrong
 * 版本：1.0
 */
require(['jquery.min','bootstrap.min','easyui/js/jquery.easyui.min','easyui/js/easyui-lang-zh_CN','jquery.dialogBox','../manage/other.define/slide-bar'],function (){
	initSlideBar($("#life-manage-menu-node"), $("#life-manage-menu"), "life-manage");
	$("#dg").datagrid({
		url : 'mAllLifeInfo',
		singleSelect : true,
		iconCls : 'icon-search',
		rowNumbers : true,
		pagination : true,
		pageSize : 5,
		pageList : [ 5, 10, 15 ],
		fitColumns : true,
		striped : true,
		toolbar : [ {
			text : '新增生活段子信息',
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
					title : '新增生活段子',
					content : "* 目前仅支持基于文本形式的生活段子。<br/>生活段子内容：<textarea type='text' maxlength=140 id='newlife' /><br/><input id='device' type='hidden' /><br/><input id='system' type='hidden' />",
					hasBtn : true,
					confirmValue : '添加',
					confirm : function() {
						var os = detectOS();
						var browser;
						
						$("#system").val(os == undefined || os == "Unknown" ? "未知平台" : os);
						
						//浏览器
						if ((BrowserDetect.browser + " " + BrowserDetect.version).indexOf("Mozilla 11") != -1) {
							browser = "Internet Explorer " + BrowserDetect.version;
						}else{
							browser = BrowserDetect.browser + " " + BrowserDetect.version;
						}
						
						$("#device").val(browser == "undefined undefined" ? "未知设备" : browser);
						
						$.getJSON("mAddLifeInfo?newlife="+$("#newlife").val()+"&device="+$("#device").val()+"&system="+$("#system").val(),function (data){
							if (data.result === "successed") {
								$("#dg").datagrid("load","mAllLifeInfo");
								$('#type-dialogBox').dialogBox({
									type : 'correct', // three
									// type:'normal'(default),'correct','error',
									width : 550,
									height : 300,
									hasMask : true,
									autoHide : false,
									effect : 'fade',
									title : '添加成功',
									content : "您已成功地添加了一条生活段子信息。",
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
									content : "您在尝试添加新生活段子信息时发生了异常。请重新操作。",
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
			field : 'lifeId',
			title : '',
			width : 10,
			sortable : false
		}, {
			field : 'lifePublishedDate',
			title : '发布时间',
			width : 40
		}, {
			field : 'lifeModifyDate',
			title : '修改时间',
			width : 40
		}, {
			field : 'lifePublishedIp',
			title : 'IP地址',
			width : 40
		}, {
			field : 'operate',
			title : '操作',
			width : 50,
			formatter : function formatOper(val, row, index) {
				return "<a href='javascript:operate(" + index + ",\"look\");'>查看</a>&nbsp;&nbsp;"+"<a href='javascript:operate(" + index + ",\"edit\");'>编辑</a>&nbsp;&nbsp;"+"&nbsp;&nbsp;<a href='javascript:operate(" + index + ",\"delete\");'>删除</a>";
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
 * 操作生活段子信息的方法
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
				title : '生活段子详情',
				content : "生活段子编号：<input type='text' id='identity' value='" + row.lifeId + "' disabled='disabled' /><br/>生活段子内容：<textarea id='lifecontent' maxlength=140>"+row.lifeContent+"</textarea>",
				hasBtn : true,
				confirmValue : '确认修改',
				confirm : function() {
					$("#identity").removeAttr("disabled", "");
					$.getJSON("mUdLifeInfo?id="+$("#identity").val()+"&content="+$("#lifecontent").val(),function (data){
						if (data.result === "success") {
							$("#dg").datagrid("load","mAllLifeInfo");
							$('#type-dialogBox').dialogBox({
								type : 'correct', // three
								// type:'normal'(default),'correct','error',
								width : 550,
								height : 300,
								hasMask : true,
								autoHide : false,
								effect : 'fade',
								title : '修改成功',
								content : "您已成功地修改此生活段子。",
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
								content : "您在尝试修改此生活段子时发生了异常。请重新操作。",
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
				content : "您确认要删除此生活段子吗？删除之后无法恢复。请确认您的操作。",
				hasBtn : true,
				confirmValue : '删除',
				confirm : function() {
					$.getJSON("mDelLifeInfo?id="+row.lifeId,function (data){
						if (data.result === "success") {
							
							$("#dg").datagrid("load","mAllLifeInfo");
							
							$('#type-dialogBox').dialogBox({
								type : 'correct', // three
								// type:'normal'(default),'correct','error',
								width : 550,
								height : 300,
								hasMask : true,
								autoHide : false,
								effect : 'fade',
								title : '删除成功',
								content : "您已成功地删除此生活段子。",
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
								content : "您在尝试删除此生活段子时发生了异常，请重新操作。<br>如果问题仍无法解决，请联系系统管理员协助处理。",
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
			//查看
		}else if (flag === "look") {
			
			$.getJSON("mAllLifeDetailInfo?lifeId="+row.lifeId,function (data){
				$('#type-dialogBox').dialogBox({
					type : 'normal', // three
					// type:'normal'(default),'correct','error',
					width : 550,
					height : 300,
					hasMask : true,
					autoHide : false,
					effect : 'flip-vertical',
					title : '生活段子详情',
					content : "编号：" + data.lifeId + "<br/>发布时间："+data.lifePublishedDate+"<br/>发布者IP地址："+data.lifePublishedIp+"<br/>内容："+data.lifeContent,
					hasBtn : true,
					confirmValue : '好',
					confirm : function() {
						window.location.href = "javascript:(0);";
					},
				/* cancelValue : '取消', */
				});
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

/**
 * 获取操作系统版本的方法
 * 
 * @returns {String}
 */
function detectOS() {
	var sUserAgent = navigator.userAgent;
	var isWin = (navigator.platform == "Win32")
			|| (navigator.platform == "Windows");
	var isMac = (navigator.platform == "Mac68K")
			|| (navigator.platform == "MacPPC")
			|| (navigator.platform == "Macintosh")
			|| (navigator.platform == "MacIntel");
	var isIPhone = (navigator.platform == "iPhone");
	
	if (isMac) {
		return "Mac";
	}
	
	if (isIPhone) {
		return "iPhone";
	}

	var isUnix = (navigator.platform == "X11") && !isWin && !isMac;

	if (isUnix) {
		return "Unix";
	}

	var isLinux = (String(navigator.platform).indexOf("Linux") > -1);

	if (isLinux) {
		return "Linux";
	}

	if (isWin) {
		var isWin2K = sUserAgent.indexOf("Windows NT 5.0") > -1
				|| sUserAgent.indexOf("Windows 2000") > -1;

		if (isWin2K) {
			return "Microsoft Windows 2000";
		}

		var isWinXP = sUserAgent.indexOf("Windows NT 5.1") > -1
				|| sUserAgent.indexOf("Windows XP") > -1;

		if (isWinXP) {
			return "Microsoft Windows XP";
		}

		var isWin2003 = sUserAgent.indexOf("Windows NT 5.2") > -1
				|| sUserAgent.indexOf("Windows 2003") > -1;

		if (isWin2003) {
			return "Microsoft Windows Server 2003";
		}

		var isWinVista = sUserAgent.indexOf("Windows NT 6.0") > -1
				|| sUserAgent.indexOf("Windows Vista") > -1;

		if (isWinVista) {
			return "Microsoft Windows Vista";
		}

		var isWin7 = sUserAgent.indexOf("Windows NT 6.1") > -1
				|| sUserAgent.indexOf("Windows 7") > -1;

		if (isWin7) {
			return "Microsoft Windows 7";
		}

		var isWin8 = sUserAgent.indexOf("Windows NT 6.2") > -1
				|| sUserAgent.indexOf("Windows 8") > -1;

		if (isWin8) {
			return "Microsoft Windows 8";
		}

		var isWin8_1 = sUserAgent.indexOf("Windows NT 6.3") > -1
				|| sUserAgent.indexOf("Windows 8.1") > -1;

		if (isWin8_1) {
			return "Microsoft Windows 8.1";
		}

		var isWin10 = sUserAgent.indexOf("Windows NT 10.0") > -1;

		if (isWin10) {
			return "Microsoft Windows 10";
		}
	}
	return "Unknown";
}

var BrowserDetect = {
	init : function() {
		this.browser = this.searchString(this.dataBrowser)
				|| "An unknown browser";
		this.version = this.searchVersion(navigator.userAgent)
				|| this.searchVersion(navigator.appVersion)
				|| "an unknown version";
		this.OS = this.searchString(this.dataOS) || "an unknown OS";
	},
	searchString : function(data) {
		for (var i = 0; i < data.length; i++) {
			var dataString = data[i].string;
			var dataProp = data[i].prop;
			this.versionSearchString = data[i].versionSearch
					|| data[i].identity;
			if (dataString) {
				if (dataString.indexOf(data[i].subString) != -1)
					return data[i].identity;
			} else if (dataProp)
				return data[i].identity;
		}
	},
	searchVersion : function(dataString) {
		var index = dataString.indexOf(this.versionSearchString);
		if (index == -1)
			return;
		return parseFloat(dataString.substring(index
				+ this.versionSearchString.length + 1));
	},
	dataBrowser : [ {
		string : navigator.userAgent,
		subString : "Chrome",
		identity : "Chrome"
	}, {
		string : navigator.userAgent,
		subString : "OmniWeb",
		versionSearch : "OmniWeb/",
		identity : "OmniWeb"
	}, {
		string : navigator.vendor,
		subString : "Apple",
		identity : "Safari",
		versionSearch : "Version"
	}, {
		prop : window.opera,
		identity : "Opera"
	}, {
		string : navigator.vendor,
		subString : "iCab",
		identity : "iCab"
	}, {
		string : navigator.vendor,
		subString : "KDE",
		identity : "Konqueror"
	}, {
		string : navigator.userAgent,
		subString : "Firefox",
		identity : "Firefox"
	}, {
		string : navigator.vendor,
		subString : "Camino",
		identity : "Camino"
	}, { // for newer Netscapes (6+)
		string : navigator.userAgent,
		subString : "Netscape",
		identity : "Netscape"
	}, {
		string : navigator.userAgent,
		subString : "MSIE",
		identity : "Internet Explorer",
		versionSearch : "MSIE"
	}, {
		string : navigator.userAgent,
		subString : "Gecko",
		identity : "Mozilla",
		versionSearch : "rv"
	}, { // for older Netscapes (4-)
		string : navigator.userAgent,
		subString : "Mozilla",
		identity : "Netscape",
		versionSearch : "Mozilla"
	} ],
	dataOS : [ {
		string : navigator.platform,
		subString : "Win",
		identity : "Windows"
	}, {
		string : navigator.platform,
		subString : "Mac",
		identity : "Mac"
	}, {
		string : navigator.userAgent,
		subString : "iPhone",
		identity : "iPhone/iPod"
	}, {
		string : navigator.platform,
		subString : "Linux",
		identity : "Linux"
	} ]
};