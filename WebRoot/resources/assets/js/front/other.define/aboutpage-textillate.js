/**
 * 前台about页Textillate插件 JS文件
 * 
 * 创建时间：2016年3月19日 20:57:30
 * 创建人：Steve Jrong
 * 版本：1.0
 */
define(['jquery.min'],function (){
	$(function() {
		$('.text1').textillate({
			in : {
				effect : 'rollIn'
			}
		});
		$('.text2').textillate({
			initialDelay : 1, // 设置动画开始时间
			in : {
				effect : 'flipInX' // 设置动画名称
			}
		});
		$('.text3').textillate({
			initialDelay : 2000,
			in : {
				effect : 'bounceInDown'
			}
		});
	});
});