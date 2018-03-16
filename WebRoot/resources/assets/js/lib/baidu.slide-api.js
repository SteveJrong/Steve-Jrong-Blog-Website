/**
 * 百度一键分享 slide_api JS文件
 * 
 * 创建时间：2016年11月11日 17:27:47
 * 创建人：Steve Jrong
 * 版本：1.0
 * 备注：JS引用版本：v=ec14f516.js
 */
window._bd_share_main.F.module("share/slide_api",function(e,t,n){var r=e("base/tangram").T,i=e("base/class").Class,s=e("share/api_base");t.Api=i.create(function(e){var t=this;t._init=function(){var e=t.getView();e.render(),e.init()},t._slidePop=function(t,n){t._popupBox=n.boxEle,t._getPosition=function(){return{top:0,left:e.bdPos=="left"?0:n.element.width()}},t.show(n,e)},t._processAction=function(e){return{data:{type:"share"}}},t._distory=function(){}},s.ApiBase)});