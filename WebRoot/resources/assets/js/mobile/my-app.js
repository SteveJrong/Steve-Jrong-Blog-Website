// 初始化App
var myApp = new Framework7();

// 选择器定义
var $$ = Dom7;

// 当前滚动高度
var nScrollTop = 0;

// 文章主体内容区域高度
var nDivHight = $$(".page-content").height();

init();

// Add view
var mainView = myApp.addView('.view-main', {
    // Because we use fixed-through navbar we can enable dynamic navbar
    dynamicNavbar: true
});

$$(".page-content").on("scroll",function() {
	nScrollTop = $$(this)[0].scrollTop;
	
	// 当前滚动高度
	$$(".thisTop").html(nScrollTop);
	
	// 文章主题内容区域高度
	$$(".mainContent").html(nDivHight);
	
	if (nScrollTop > 0) {
		myApp.destroyPullToRefresh(".page-content");
		
		$$(".navbar").hide();
		$$("#pullRefresh").css("margin-top","-44px");
		$$(".pull-to-refresh-layer").css("display","none");
//		$$(".views").css("margin-top","50px");
		
		$$(".pages").css("margin-bottom","50px");
	}else {
		myApp.initPullToRefresh(".page-content");
		
		$$(".navbar").show();
		$$("#pullRefresh").css("margin-top","0px");
		$$(".pull-to-refresh-layer").css("display","block");
//		$$(".views").css("margin-top","0px");
	}
});

$$(".page-content").on("refresh",function (){
	location.reload();
});

//夜间模式已在原生App中处理好，暂时不在页面中控制了
//$$(".label-switch").on("click",function (){
//	if (event.target.type != "checkbox") {
//		var theme = $$(".themeFlag").val();
//		if (theme == "w") {
//			$$(".themeFlag").val("b");
//			$$("body").addClass("layout-dark");
//		}else if(theme == "b"){
//			$$(".themeFlag").val("w");
//			$$("body").removeClass("layout-dark");
//		}
//	}
//});

//初始化方法
function init(){
	$$("img").css({"width":document.body.offsetWidth,"height":"auto"});
	
	var theme = $$(".themeFlag").val();
	if (theme == "b") {
		$$(".themeFlag").val("b");
		$$("body").addClass("layout-dark");
	}else if(theme == "w"){
		$$(".themeFlag").val("w");
		$$("body").removeClass("layout-dark");
	}
	
	// UWP WebView通知
	window.external.notify($$(".articleId").val());
	
	$$("img").on("click",function (){
		//以Popup方式显示的图片浏览器
	    var myPhotoBrowserPopup = myApp.photoBrowser({
	        photos : [
	            $$(this).attr('src')
	        ],
	        type: 'popup'
	    });
	    myPhotoBrowserPopup.open();
	});
}