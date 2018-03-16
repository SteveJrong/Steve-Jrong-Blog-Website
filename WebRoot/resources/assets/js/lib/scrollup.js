/**
 * 页面滚动jQuery插件 JS文件
 * 
 * 创建时间：2016年3月17日 16:27:37
 * 创建人：Steve Jrong
 * 版本：1.0
 * 
 */
define(['jquery.min'],function (){
	try {
		$.scrollUp({
			scrollName : 'scrollUp', // Element ID
			topDistance : '300', // Distance from top before showing element (px)
			topSpeed : 300, // Speed back to top (ms)
			animation : 'fade', // Fade, slide, none
			animationInSpeed : 200, // Animation in speed (ms)
			animationOutSpeed : 200, // Animation out speed (ms)
			scrollText : "返回顶部", // Text for element
			activeOverlay : false, // Set CSS color to display scrollUp active point, e.g '#00FFFF'
		});
	} catch (e) {
		console.log("出错："+e.message);
	}
});
