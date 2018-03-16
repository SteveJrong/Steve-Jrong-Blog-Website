/**
 * 百度一键分享 image_api JS文件
 * 
 * 创建时间：2016年11月11日 22:05:53
 * 创建人：Steve Jrong
 * 版本：1.0
 */
window._bd_share_main.F.module("share/image_api",function(e,t,n){var r=e("base/tangram").T,i=e("base/class").Class,s=e("component/comm_tools"),o=e("share/api_base");t.Api=i.create(function(e){var t=this;t._init=function(){var e=t.getView();e.render(),e.init(),e.on("moreover",function(){e._keepBarVisible()})},t._processAction=function(n){var r=t.getView();return e.bdPic=r._getImageSrc(),{data:{type:"imgshare"}}},t._distory=function(){}},o.ApiBase)});