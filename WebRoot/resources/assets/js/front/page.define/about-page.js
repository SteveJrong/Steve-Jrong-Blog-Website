/**
 * 前台about页 JS文件
 * 
 * 创建时间：2016年11月8日 15:15:47
 * 创建人：Steve Jrong
 * 版本：1.0
 */
require(['jquery.min','jquery.lettering','jquery.textillate','pace.min','modernizr.2.8','jquery.scrollUp.min','scrollup','dialogfx','../front/other.define/exitdialog','bootstrap.min','exitdialog.lib','sweetalert','../front/other.define/aboutpage-textillate','../front/other.define/social.share']);

/**
 * 弹出微信联系框
 */
function weChat(){
	swal({
			title: "<span style='font-size:0.75em;'>Vendetta_Software</span>	<span style='font-size:0.18em; color:silver; margin-left:1em; font-weight:normal;'>Steve Jrong</span>",
			text: "<img style='margin-top:-1em;' src='mywechat' width='180' height='180' /><br/><p style='margin:1em auto;'>扫一扫   关注我</p>",
			html: true,
			timer: 3500,
			showConfirmButton: false
		});
}