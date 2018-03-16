/**
 * 前台developing页 JS文件
 * 
 * 创建时间：2016年11月10日 10:45:40
 * 创建人：Steve Jrong
 * 版本：1.0
 */
require(['jquery.min','pace.min','modernizr.2.8','bootstrap.min','jquery.scrollUp.min','scrollup'],function (){
	setInterval(navigation, 3000);
	var theme = [
			["#002c4a", "#005584"],
			["#35ac03", "#3f4303"],
			["#ac0908", "#cd5726"],
			["#18bbff", "#00486b"]
		]
	$(".color li").each(function(index, val) {
		var color = theme[index];
		 $(this).mouseover(function(){
		 	victor(color).set();
		 })
	});
});

function navigation() {
	window.location.href = "../home";
}