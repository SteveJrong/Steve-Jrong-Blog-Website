/**
 * 前台personal主页 JS文件
 * 
 * 创建时间：2016年11月29日 16:07:49
 * 创建人：Steve Jrong
 * 版本：1.0
 */
require(['jquery.min','pace.min','modernizr.2.8','jquery.scrollUp.min','scrollup','dialogfx','../front/other.define/exitdialog','bootstrap.min','exitdialog.lib','../front/other.define/social.share'],function (){
	var userId = $("#userIdentity").val();
	requestUserInfo(userId);
});

function requestUserInfo(userId){
	$.ajax({
		url: "getmine",
		type: "POST",
		data: {userId: userId},
		dataType: "JSON",
		cache: false,
		beforeSend: function (XMLHttpRequest){
			var readyLoading = "<img src='loading' />";
			$(".nickname-area p span").html(readyLoading);
			$(".gender-area p span").html(readyLoading);
			$(".age-area p span").html(readyLoading);
			$(".level-area p span").html(readyLoading);
			$(".reg-area p span").html(readyLoading);
			$(".last-login-area p span").html(readyLoading);
		},success: function (data){
			$(".nickname-area p span").text(data.datas.userNickName);
			$(".gender-area p span").text(data.datas.userGender);
			$(".age-area p span").text(data.datas.userAge);
			$(".level-area p span").text(data.datas.userLevel);
			$(".reg-area p span").text(data.datas.userRegisterDate);
			$(".last-login-area p span").text(data.datas.userLastLoginDate);
		},error: function (){
			var errorMsg = "获取数据出错";
			$(".nickname-area p span").text(errorMsg);
			$(".gender-area p span").text(errorMsg);
			$(".age-area p span").text(errorMsg);
			$(".level-area p span").text(errorMsg);
			$(".reg-area p span").text(errorMsg);
			$(".last-login-area p span").text(errorMsg);
		},complete: function (XMLHttpRequest){
			
		}
	});
}

require(['zeroModal','jquery.Jcrop.min','jquery.uploadify.min','device.min'],function (zeroModal,jcrop,uploadify){
	var userId = $("#userIdentity").val();
	
	//修改账户（密码）信息
	$("#edit-pwd-link").bind("click",function (){
		var title = "<span class='ion-android-alert' style='padding-right:.85em;'></span>账户信息修改";
		var content = "<div class='zeroModal-edit'>" +
						"<p><span for='oldPwd'>原密码</span><span><input type='password' id='oldPwd' class='form-control' /></span><span id='oldPwdMsg'></span></p>" +
						"<p><span for='newPwd'>新密码</span><span><input type='password' id='newPwd' class='form-control' /></span><span id='newPwdMsg'></span></p>" +
						"<p><span for='reNewPwd'>确认密码</span><span><input type='password' id='reNewPwd' class='form-control' /></span><span id='reNewPwdMsg'></span></p>" +
						"</div>";
		
		zeroModal.show({
		    title: title,
		    content: content,
		    width: '65%',
	        height: '80%',
		    dragHandle: 'top',
		    esc: true,
		    ok: true,
		    okTitle: "确认修改",
		    okEagerClose: false,
		    okFn: function (){
		    	
		    	var errorMsgFlag = false;
		    	
		    	//旧密码
		    	var oldPwd = $("#oldPwd").val();
		    	var $oldPwdMsg = $("#oldPwdMsg");
		    	
		    	//新密码
		    	var newPwd = $("#newPwd").val();
		    	var $newPwdMsg = $("#newPwdMsg");
		    	
		    	//确认密码
		    	var rePwd = $("#reNewPwd").val();
		    	var $reNewPwdMsg = $("#reNewPwdMsg");
		    	
		    	if (oldPwd == "" || oldPwd == null) {
		    		errorMsgFlag = true;
		    		$oldPwdMsg.text("请您填写旧密码。");
				}else {
					$oldPwdMsg.text("");
				}
		    	
		    	if (newPwd == "" || newPwd == null) {
		    		errorMsgFlag = true;
		    		$newPwdMsg.text("请您填写新密码。");
				}else {
					$newPwdMsg.text("");
				}
		    	
		    	if (rePwd == "" || rePwd == null) {
		    		errorMsgFlag = true;
		    		$reNewPwdMsg.text("请您确认密码。");
				}else {
					$reNewPwdMsg.text("");
				}
		    	
		    	if (newPwd != rePwd) {
		    		errorMsgFlag = true;
		    		$reNewPwdMsg.text("新密码和确认密码不一致。");
				}
		    	
		    	if (errorMsgFlag == true) {
					return;
				}
		    	
		    	$.post("updMineAcc",{oldPassword: $("#oldPwd").val(),newPassword: $("#newPwd").val(),userId: userId},function (data){
		    		if (data.result == true) {
		    			zeroModal.success('恭喜！您的密码已成功修改。');
					}else {
						if (data.msg == "oldPwdNotCorrect") {
							zeroModal.error('非常抱歉，您输入的旧密码不正确，请重试。');
						}
					}
		    	});
		    },
		    cancel: true,
		    cancelTitle: "取消",
		    cancelFn: function (){
		    }
		});
	});
	
	//修改个人信息
	$("#edit-link").bind("click",function (){
		$.post("loadUserInfo.action",{userId:userId},function (data){
			if (data.result != false) {
				
				var title = "<span class='ion-android-alert' style='padding-right:.85em;'></span>个人信息修改";
				var gender = data.datas.userGender;
				var genderContent;
				
				if (gender != "" && gender != null && gender != undefined) {
					if (gender == "男") {
						genderContent = "<input type='radio' id='male' name='userGender' value='男' checked='checked' /><span for='male'>男</span>&nbsp;&nbsp;&nbsp;<input type='radio' id='female' name='userGender' value='女' /><span for='female'>女</span>";
					} else {
						genderContent = "<input type='radio' id='male' name='userGender' value='男' /><span for='male'>男</span>&nbsp;&nbsp;&nbsp;<input type='radio' id='female' name='userGender' value='女' checked='checked' /><span for='female'>女</span>";
					}
				}
				
				var age = data.datas.userAge;
				var ageContent = "<option value='-1'>--选择您的年龄--</option>";
				
				for (var i = 5; i <= 100; i++) {
					if (i != undefined && i == age) {
						ageContent+="<option value='"+i+"' selected='selected'>"+i+"</option>";
					}else {
						ageContent+="<option value='"+i+"'>"+i+"</option>";
					}
				}
				
				var content = "<div class='zeroModal-edit'>" +
				"<p><span for='nickName'>昵称</span><span><input id='nickName' type='text' class='form-control' value='"+data.datas.userNickName+"' /></span><span id='nickNameMsg'></span></p>" +
				"<p><span>性别</span><span>"+genderContent+"</span><span id='userGenderMsg'></span></p>" +
				"<p><span for='uAge'>年龄</span><span><select id='uAge' class='form-control'>"+ageContent+"</select></span><span id='uAgeMsg'></span></p>" +
				"<p><span for='sQAnswer'>密保答案</span><span><input id='sQAnswer' type='text' class='form-control' value='"+data.datas.userSecurityQuestionAnswer+"' /></span><span id='sQAnswerMsg'></span></p>" +
				"<p><span for='emailAddress'>电子邮箱</span><span><input id='emailAddress' type='text' class='form-control' value='"+data.datas.userEmail+"' /></span><span id='emailAddressMsg'></span></p>" +
				"<p><span for='qqNum'>QQ号码</span><span><input id='qqNum' type='text' class='form-control' value='"+data.datas.QQNum+"' /></span><span id='qqNumMsg'></span></p>" +
				"</div>";

				zeroModal.show({
				    title: title,
				    content: content,
				    dragHandle: 'top',
				    esc: true,
				    ok: true,
				    okTitle: "确认修改",
				    okEagerClose: false,
				    okFn: function (){
				    	
				    	var errorMsgFlag = false;
				    	
				    	//昵称
				    	var nickName = $("#nickName").val();
				    	var $nickNameMsg = $("#nickNameMsg");
				    	
				    	//性别
				    	var userGender = $("input[name*='userGender']:checked").val();
				    	var $userGenderMsg = $("#userGenderMsg");
				    	
				    	//年龄
				    	var uAge = $("#uAge").val();
				    	var $uAgeMsg = $("#uAgeMsg");
				    	
				    	//安全验证问题答案
				    	var sQAnswer = $("#sQAnswer").val();
				    	var $sQAnswerMsg = $("#sQAnswerMsg");
				    	
				    	//电子邮箱
				    	var emailAddress = $("#emailAddress").val();
				    	var $emailAddressMsg = $("#emailAddressMsg");
				    	
				    	//QQ号码
				    	var qqNum = $("#qqNum").val();
				    	var $qqNumMsg = $("#qqNumMsg");
				    	
				    	if (nickName == null || nickName == "") {
				    		errorMsgFlag = true;
				    		$nickNameMsg.text("请输入您的昵称。");
						}else {
							$nickNameMsg.text("");
						}
				    	
				    	if (userGender == null || userGender == "") {
				    		errorMsgFlag = true;
				    		$userGenderMsg.text("请选择您的性别。");
						}else {
							$userGenderMsg.text("");
						}
				    	
				    	if (uAge == -1) {
				    		errorMsgFlag = true;
				    		$uAgeMsg.text("请选择您的年龄。");
						}else {
							$uAgeMsg.text("");
						}
				    	
				    	if (sQAnswer == null || sQAnswer == "") {
				    		errorMsgFlag = true;
				    		$sQAnswerMsg.text("请输入您的密保问题答案。");
						}else {
							$sQAnswerMsg.text("");
						}
				    	
				    	if (emailAddress == null || emailAddress == "") {
				    		errorMsgFlag = true;
				    		$emailAddressMsg.text("请输入您的电子邮箱。");
						}else {
							$emailAddressMsg.text("");
						}
				    	
				    	if (qqNum == null || qqNum == "") {
				    		errorMsgFlag = true;
				    		$qqNumMsg.text("请输入您的QQ号码。");
						}else {
							$qqNumMsg.text("");
						}
				    	
				    	if (errorMsgFlag == true) {
							return;
						}
				    	
				    	var paramMap = {
					    					"personalCenter.userNickName":$("#nickName").val(),
					    					"personalCenter.userGender":$("input[name*='userGender']:checked").val(),
					    					"personalCenter.userAge":$("#uAge").val(),
					    					"personalCenter.userSecurityQuestionAnswer":$("#sQAnswer").val(),
					    					"personalCenter.userEmail":$("#emailAddress").val(),
					    					"personalCenter.QQNum":$("#qqNum").val(),
					    					"personalCenter.userId":userId
				    					};
				    	$.post("updatemine",paramMap,function (data){
				    		if (data.result == true) {
				    			zeroModal.success('操作成功!');
				    			requestUserInfo(userId);
							}else {
								zeroModal.error('请选择数据进行操作!');
							}
				    	});
				    },
				    cancel: true,
				    cancelTitle: "取消",
				    cancelFn: function (){
				    	
				    }
				});
			}
		});
	});
	
	//上传头像
	$(".my-header").bind("click",function (){
		
		//上传头像之前要先检查是否是平板或是桌面设备
		if (!device.desktop() && !device.tablet()) {
			//非桌面或非平板设备提示无法操作
			zeroModal.error("上传头像请使用电脑或平板设备操作。");
			return;
		}
		
		//上传头像之前要先检查本机是否安装了Flash插件
		var flashPlugin = flashChecker();
		
		if(!flashPlugin.f){
			//未安装Flash插件，提示前往安装并重启浏览器后继续操作
			zeroModal.error("您设备上当前还未安装Flash插件，无法进行头像上传。<br/><p style='font-size:14.5px; font-weight:bold;'>请安装Adobe&reg; Flash&trade;后，重启浏览器在进行操作。</p>");
			return;
		}
		
		//图片相对路径
		var imgPath;
		
		//上传头像HTML
		var uploadHeaderHtml = "<iframe id='uploadHeaderFrame' width='100%' height='100%' frameborder=0 src='views/front/personal_center/upload_header.jsp' />";
		zeroModal.show({
		    title: "<span class='ion-android-alert' style='padding-right:.85em;'></span>第一步：上传您的头像",
		    content: uploadHeaderHtml,
		    width: '45%',
	        height: '50%',
		    dragHandle: 'top',
		    esc: true,
		    ok: true,
		    okTitle: "确定",
		    okEagerClose: false,
		    okFn: function (){
		    	//获取到上传成功之后的图片相对路径
		    	imgPath = $("#imgPath").attr("data-bind");
		    	//关闭全部Modal
		    	zeroModal.closeAll();
		    	var imgPathValue = $("#imgPath").attr("data-bind");
				//如果成功上传
				if (imgPathValue != null && imgPathValue != "" && imgPathValue != undefined) {
					//预览头像HTML
					var previewHeaderHtml = "<iframe id='uploadHeaderFrame' width='100%' height='100%' frameborder=0 scrolling='no' src='views/front/personal_center/preview_header.jsp' />";
					zeroModal.show({
					    title: "<span class='ion-android-alert' style='padding-right:.85em;'></span>第二步：设置并预览您的头像",
					    content: previewHeaderHtml,
					    width: '95%',
				        height: '85%',
					    dragHandle: 'top',
					    ok: true,
					    okTitle: "保存",
					    okEagerClose: false,
					    okFn: function (){
					    	var imageX = $("#imageX").attr("data-bind");
					    	var imageY = $("#imageY").attr("data-bind");
					    	var imageHeight = $("#imageHeight").attr("data-bind");
					    	var imageWidth = $("#imageWidth").attr("data-bind");
					    	
					    	$.post("cutHeader",{tempHeaderFileName:$("#imgName").attr("data-bind"), imageX:imageX,imageY:imageY, imageHeight:imageHeight, imageWidth:imageWidth },function (data){
					    		//操作成功
					    		if (data.result == true) {
					    			zeroModal.success('操作成功！请您关闭弹出层查看。');
					    			$(".my-header").attr("src",data.datas);
								} else {
									zeroModal.error('非常抱歉，设置您的头像失败，请重试!');
								}
					    	});
					    },
					    cancel: true,
					    cancelTitle: "取消",
					    cancelFn: function (){
					    	
					    }
					});
				} else {

				}
		    },
		    cancel: true,
		    cancelTitle: "取消",
		    cancelFn: function (){
		    	
		    }
		});
	});
});

/**
 * 检测Flash插件
 * @returns {___anonymous12856_12898}
 */
function flashChecker() {
	var hasFlash = 0;
	var flashVersion = 0;
	if(document.all) { 
		var swf = new ActiveXObject('ShockwaveFlash.ShockwaveFlash'); 
		if(swf) { 
			hasFlash = 1; 
			VSwf = swf.GetVariable("$version"); 
			flashVersion = parseInt(VSwf.split(" ")[1].split(",")[0]); 
		} 
	} else { 
		if(navigator.plugins && navigator.plugins.length > 0) { 
			var swf = navigator.plugins["Shockwave Flash"]; 
			if(swf) { 
				hasFlash = 1; 
				var words = swf.description.split(" "); 
				for(var i = 0; i < words.length; ++i) { 
					if(isNaN(parseInt(words[i]))) continue; 
					flashVersion = parseInt(words[i]); 
				} 
			} 
		} 
	} 
	return { 
		f: hasFlash, 
		v: flashVersion 
	}; 
}

