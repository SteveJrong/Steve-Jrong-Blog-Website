/**
 * 后台article manage add页、edit页 通用JS文件
 * 
 * 创建时间：2016年3月26日 00:51:23
 * 创建人：Steve Jrong
 * 版本：1.0
 */
require(['jquery.min','bootstrap.min','easyui/js/jquery.easyui.min','easyui/js/easyui-lang-zh_CN','jquery.dialogBox','ckeditor/ckeditor','ckeditor/samples/js/sample','jquery.uploadify.min','../manage/other.define/slide-bar'],function (){
		initSlideBar($("#article-manage-menu-node"), $("#article-manage-menu"), "article-manage");
		$('#uploadify').uploadify({
  			"buttonText":"选择文件",
  			"debug":false,
			"auto":true,
  			"method":"post",
  			"fileSizeLimit":"102400KB",
  			"fileObjName":"uploadFiles",// important ,this name should be the same as the name in the action 
  			"wmode": "transparent", //设置按钮背景透明
  			"swf":"resources/assets/swf/uploadify.swf",
  			"uploader":"uploadFiles.action",
			'onUploadComplete' : function(file) {
            	$("#singleFileUploadResultShow").append(file.name+"已上传成功，大小为"+(file.size/1024/1024).toFixed(1)+"MB。<br/>");
        	},
        	'onQueueComplete' : function(queueData) {
        		$("#queueFileUploadResultShow").html(queueData.uploadsSuccessful + "个文件已成功上传。");
        	}
		});
				
	$("[rel=tooltip]").tooltip();
	BrowserDetect.init();
	
	$('.demo-cancel-click').click(function () {
       return false;
	});
   
	//表示为IE 11浏览器
	if ((BrowserDetect.browser + " " + BrowserDetect.version).indexOf("Mozilla 11") != -1) {
		$("input[name*='browser']").val("Internet Explorer " + BrowserDetect.version);
		$("input[name*='system']").val(detectOS());
	}else{
		$("input[name*='browser']").val(
				BrowserDetect.browser + " " + BrowserDetect.version);
		$("input[name*='system']").val(detectOS());
	}

	if ((BrowserDetect.browser + " " + BrowserDetect.version)
			.indexOf("Mozilla 11") == -1
			&& (BrowserDetect.browser + " " + BrowserDetect.version)
					.indexOf("Internet Explorer") == -1) {
		msgOfPraseFromWord();
	}
});

/**
* 从Word粘贴到编辑区域的提示信息方法
*/
function msgOfPraseFromWord() {
	$("#msg").fadeIn();
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
	
	if (isMac) {
		return "Mac";
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
    var localhostPath = curWwwPath.substring(0, pos);
    //获取带"/"的项目名
    var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
    //返回项目根目录
	return localhostPath + projectName;
}
