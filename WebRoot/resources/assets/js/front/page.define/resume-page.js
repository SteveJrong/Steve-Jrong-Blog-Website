/**
 * 前台resume index页 JS文件
 * 
 * 创建时间：2016年12月24日 上午10:13:50
 * 创建人：Steve Jrong
 * 版本：1.0
 */
require(['jquery.min'],function (){
	$('.preloader').delay(1000).fadeOut("slow"); // set duration in brackets
	console.log($);
});
require(['../front/other.define/jquery.backstretch.min'],function (backstretch){
	$('body').backstretch(["resources/assets/img/resume/tm-bg-slide-1.jpg","resources/assets/img/resume/tm-bg-slide-2.jpg","resources/assets/img/resume/tm-bg-slide-3.jpg"],{duration: 3200, fade: 1300});
	console.log(backstretch);
});

require(['../front/other.define/all','sweetalert','device.min'],function (){
	var isDesktop = device.desktop();
	if (isDesktop == false) {
		$(".snow-container").remove();
	}
});

/**
 * 弹出微信联系框
 */
//function weChat(){
//	swal({
//			title: "<span style='font-size:0.75em;'>Vendetta_Software</span>	<span style='font-size:0.18em; color:silver; margin-left:1em; font-weight:normal;'>Steve Jrong</span>",
//			text: "<img style='margin-top:-1em;' src='mywechat' width='180' height='180' /><br/><p style='margin:1em auto;'>扫一扫   关注我</p>",
//			html: true,
//			timer: 3500,
//			showConfirmButton: false
//		});
//}