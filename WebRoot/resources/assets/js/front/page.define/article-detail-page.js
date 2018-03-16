/**
 * 前台single页 自定义JS文件
 * 
 * 创建时间：2016年8月24日 17:41:01
 * 创建人：Steve Jrong
 * 版本：1.0
 */
define(['jquery.min'],function (){
	$("#pubBtn").bind("click",function (){
		$("#system").val(detectOS());
		//浏览器
		if ((BrowserDetect.browser + " " + BrowserDetect.version).indexOf("Mozilla 11") != -1) {
			$("#device").val("Internet Explorer " + BrowserDetect.version);
		}else{
			$("#device").val(BrowserDetect.browser + " " + BrowserDetect.version);
		}
		return;
		$("#myForm").submit();
	});

	$.get("servlet/ValidateCodeServlet", function(data) {
		$("#safeCode").attr("src", "data:image/png;base64," + data);
	});

	$("#changeCode").bind("click", function() {
		$.get("servlet/ValidateCodeServlet", function(data) {
			$("#safeCode").attr("src", "data:image/png;base64," + data);
		});
	});
	
	//评论/回复框
	var c_or_r_trigger = document.querySelector('[data-dialog-c-or-r]'), c_or_r_dialog = document
	.getElementById(c_or_r_trigger.getAttribute('data-dialog-c-or-r')), c_or_r_dlg = new DialogFx(
			c_or_r_dialog);
	c_or_r_trigger.addEventListener('click', c_or_r_dlg.toggle.bind(c_or_r_dlg));

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
});

define(['zeroModal'],function (zeroModal){
	$(".good").bind("click",function (){
		var cOrRId = $(this).attr("data-bind");
		var $praiseElement = $(this).find(".praise_count");
		var beforePraiseCount = $praiseElement.html();
		$.get("praise",{id:cOrRId},function (data){
			if (data.result == "failed") {
				zeroModal.error("非常抱歉，点赞失败，请重试操作。");
			}else if(data.result == "praised"){
				zeroModal.error("您已经点过赞了，不可重复点赞哦！");
			}else {
				var addResult = Number(beforePraiseCount)+1;
				$praiseElement.html(addResult);
			}
		});
	});
});