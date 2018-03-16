/**
 * 前台big data index页 JS文件
 * 
 * 创建时间：2016年11月9日 14:47:22
 * 创建人：Steve Jrong
 * 版本：1.0
 */
require(['jquery.min','echarts.common.min','modernizr.2.8','dialogfx','bootstrap.min','jquery.scrollUp.min','scrollup','exitdialog.lib','../front/other.define/exitdialog','../front/other.define/social.share'],function (jquery,echarts){
	// 基于准备好的dom，初始化echarts实例
	var myChart = echarts.init(document.getElementById('container'));

	myChart.setOption({
		animationEasing : 'exponentialIn',
		title : {
			text : "Steve Jrong's Blog 大数据"
		},
		tooltip : {
			trigger : 'axis'
		},
		legend : {
			data : [ '周访问量' ]
		},
		grid : {
			left : '3%',
			right : '4%',
			bottom : '3%',
			containLabel : true
		},
		toolbox : {
			feature : {
				saveAsImage : {}
			}
		},
		xAxis : {
			type : 'category',
			boundaryGap : false,
			data : []
		},
		yAxis : {
			boundaryGap : [ 0, '1000%' ],
			type : 'value'
		},
		series : [ {
			name : '周访问量',
			type : 'line',
			smooth : true,
			animation : true,
			hoverAnimation : true,
			stack : '总量',
			data : []
		} ]
	});

	myChart.showLoading();

	$(window).resize(function() {
		myChart.resize();
	});

	$.get('loadBD').done(function(data) {

		myChart.hideLoading();

		// 填入数据
		myChart.setOption({
			xAxis : {
				data : data.dates
			},
			series : [ {
				// 根据名字对应到相应的系列
				name : '周访问量',
				data : data.values
			} ]
		});
	});

	/**
	 * 时间线Java Script脚本
	 */
	var $timeline_block = $('.cd-timeline-block');
	$timeline_block.each(function() {
		if ($(this).offset().top > $(window).scrollTop() + $(window).height()
				* 0.75) {
			$(this).find('.cd-timeline-img, .cd-timeline-content').addClass(
			'is-hidden');
		}
	});
	$(window).on('scroll',function() {
		$timeline_block.each(function() {
			if ($(this).offset().top <= $(window).scrollTop() + $(window).height() * 0.75 && $(this).find('.cd-timeline-img').hasClass('is-hidden')) {
				$(this).find('.cd-timeline-img, .cd-timeline-content').removeClass('is-hidden').addClass('bounce-in');
			}
		});
	});
});