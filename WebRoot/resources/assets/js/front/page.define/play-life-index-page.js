/**
 * 前台play life index页 JS文件
 * 
 * 创建时间：2016年11月9日 14:47:22
 * 创建人：Steve Jrong
 * 版本：1.0
 */
require(['jquery.min','modernizr.2.8','dialogfx','bootstrap.min','jquery.scrollUp.min','scrollup','exitdialog.lib','../front/other.define/exitdialog','../front/other.define/social.share','../front/other.define/pagination_ajax','../front/other.define/paginate-ajax-function','jquery.jplayer','ttw-music-player-min'],function (){
	
	getAjaxData();
	
	//播放列表
	var myPlaylist = new Array();
	
	$.ajax({
		url: "mixRadio",
		type: "POST",
		dataType: "JSON",
		async: true,
		cache: false,
		success: function (data){
			var myObj = eval(data);
			
			var tempStr;
			for (var i = 0; i < myObj.length; i++) {
				var mixRadioMpeg3 = myObj[i].mp3;
				var mixRadioOga = myObj[i].oga;
				var mixRadioTitle = myObj[i].title;
				var mixRadioArtist = myObj[i].artist;
				var mixRadioRating = myObj[i].rating;
				var mixRadioBuy = myObj[i].buy;
				var mixRadioPrice = myObj[i].price;
				var mixRadioDuration = myObj[i].duration;
				var mixRadioCover = myObj[i].cover;
				
				tempStr={mp3:mixRadioMpeg3,oga:mixRadioOga,title:mixRadioTitle,artist:mixRadioArtist,rating:mixRadioRating,buy:mixRadioBuy,price:mixRadioPrice,duration:mixRadioDuration,cover:mixRadioCover};
				
				myPlaylist.push(tempStr);
			}
			
			var description = "<marquee direction='left' behavior='scroll' scrollamount='3.5' loop='-1'>欢迎收听 Steve Jrong 的 MixRadio</marquee>";
			
			$(".my-music-box").ttwMusicPlayer(myPlaylist, {
				autoPlay:false, 
				description:description,
				jPlayer:{
					swfPath:'../plugin/jquery-jplayer' //You need to override the default swf path any time the directory structure changes
				}
			});
			
			$(".my-music-box").children("img").remove();
			
			$(".loading-pic").remove();
			
		},error: function (){
			
		}
	});
});

var zeroModalObj;

require(['zeroModal'],function (zeroModal){
	zeroModalObj = zeroModal;
});

function regVipToDownloadLosslessMusic(){
	var regVipAlertHtml = "<div class='reg-vip-nav'>" +
							"<div><img src='hires' width='60px' height='60px' /><p><a href='javascript:losslessMusicDetail();'>超高解析度音频&nbsp;<span class='ion-android-hand'></span></a></p></div>" + 
							"<div><img src='hugemusic' width='60px' height='60px' /><p>海量无损音乐任您聆听</p></div>" + 
						"</div>";
	
	zeroModalObj.show({
	    title: "<span class='ion-person-add' style='padding-right:.85em;'></span>注册会员 立即感受天籁之声",
	    content: regVipAlertHtml,
	    width: '70%',
        height: '60%',
	    dragHandle: 'top',
	    esc: true,
	    ok: true,
	    okTitle: "立即加入",
	    okEagerClose: false,
	    okFn: function (){
	    	window.open("reg");
	    },
	    cancel: true,
	    cancelTitle: "已有账号 去登录",
	    cancelFn: function (){
	    	window.open("login");
	    }
	});
}

function losslessMusicDetail(){
	zeroModalObj.definesuccess("hires","登录后，您即可下载满足Hi-Res Audio&reg;标准的音源。<br/>现阶段为您免费提供FLAC格式的音源。");
}

/**
 * 获取Ajax数据的方法
 */
function getAjaxData(){
	//首先清除旧有数据
	$(".main-life-data div").remove();
	
	//数据未开始加载时显示loading图标
	$(".loading-data-pic").css("display","block");
	
	//当前页
	var pageIndex = $("#currentPageNum").text();

	if (pageIndex == undefined || pageIndex == "") {
		$(".pagination_nav").css("display","none");
	}
	
	//左侧数据列
	$.ajax({
		url: "loadLife",
		type: "POST",
		dataType: "JSON",
		data: {pageIndex: pageIndex },
		async: true,
		cache: false,
		success: function (data){
			$(".loading-data-pic").css("display","none");
			$(".pagination_nav").css("display","block");
			
			//使用jQuery的eval()方法将JSON字符串解析为对象
			var resuObj = eval(data);
			
			//获取玩生活数据
			var resuDatas = resuObj[0].playLifeDatas;
			
			for (var i = 0; i < resuDatas.length; i++) {
				var resuElement = "<div class=\"mylife\">" +
					"<span>" + resuDatas[i].content + "</span>" +
					"<hr />" +
					"<p> <time class=\"entry-date\">" + resuDatas[i].publishedDate + "</time>&nbsp;&nbsp;在" + resuDatas[i].systemInfo + "上使用" + resuDatas[i].deviceinfo + "发布&nbsp;&nbsp;</p>" +
				"</div>";
				
				$(".main-life-data").append(resuElement);
			}
			
			//设置div边框颜色
			$(".mylife").each(function() {
				$(this).css("border-color","rgb(" + parseInt(Math.random() * 255) + ","+ parseInt(Math.random() * 255) + ","+ parseInt(Math.random() * 255) + ")");
			});
			
			var resuPagination = resuObj[0].playLifePagination;
			
			//调用Ajax分页方法
			paginationAjax(resuPagination.prevPageIndex, resuPagination.nextPageIndex, resuPagination.pageIndex, resuPagination.lastPageIndex, resuPagination.totalPageSize, resuPagination.totalCount);
		},error: function (){
			zeroModalObj.error("玩生活数据加载失败，请刷新页面以重试！");
		}
	});
}