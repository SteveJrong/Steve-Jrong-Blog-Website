/**
 * 后台repairing manage index页 JS文件
 * 
 * 创建时间：2016年10月11日 13:08:44
 * 创建人：Steve Jrong
 * 版本：1.0
 */
require(['jquery.min','bootstrap.min','jquery.dialogBox','../manage/other.define/slide-bar'],function (){
	initSlideBar($("#settings-menu-node"), $("#settings-menu"), "repairing-manage");
	$.getJSON("mGetRepSte",function (data){
		$("#state").val(data.repairState);
		
		var state = $("#state").val();
		var showState = $("#showState");
		var stateButton = $("#repairingBtn");
		
		if (state == "true") {
			showState.html("<span style='color:red;'>正在维护</span>");
			stateButton.text("恢复正常");
		} else {
			showState.html("<span style='color:green;'>运行正常</span>");
			stateButton.text("开始维护");
		}
	});

	$("#repairingBtn").click(function (){
		$.getJSON("mRepSte",{repairingState:$("#state").val()},function (data){
			var title = "";
			var content = "";
			var type = "";
			
			var state = $("#state").val();
			var showState = $("#showState");
			var stateButton = $("#repairingBtn");
			
			if (data.result == "success") {
				title = "设置网站状态成功";
				content = "您已成功地设置网站的状态。";
				type = "correct";
				
				//true表示正在维护
				if (state == "true") {
					$("#state").val("false");
					showState.html("<span style='color:green;'>运行正常</span>");
					stateButton.text("开始维护");
				} else {
					$("#state").val("true");
					showState.html("<span style='color:red;'>正在维护</span>");
					stateButton.text("恢复正常");
				}
			} else {
				title = "设置网站状态失败";
				content = "在尝试设置网站状态时失败，请重试。";
				type = "error";
			}
			
			$('#type-dialogBox').dialogBox({
				type : type,
				width : 350,
				height : 200,
				hasMask : true,
				autoHide : false,
				effect : 'fade',
				title : title,
				content : content,
				hasBtn : true,
				confirmValue : '好',
				confirm : function() {
				},
			});
		});
	});
});