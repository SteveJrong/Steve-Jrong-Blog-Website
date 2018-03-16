/**
 * 前台personal主页的头像预览嵌入式页 JS文件
 * 
 * 创建时间：2016年12月5日 10:43:11
 * 创建人：Steve Jrong
 * 版本：1.0
 */
require(['jquery.min','jquery.Jcrop.min','jquery.uploadify.min'],function (){
	var imgPathValue = $('#imgPath', parent.document).attr("data-bind");
	$("#target").attr("src",imgPathValue);
	$(".jcrop-preview").attr("src",imgPathValue);
	
	// Create variables (in this scope) to hold the API and image size
	var jcrop_api, boundx, boundy,

	// Grab some information about the preview pane
	$preview = $('#preview-pane'), $pcnt = $('#preview-pane .preview-container'), $pimg = $('#preview-pane .preview-container img'),

	xsize = $pcnt.width(), ysize = $pcnt.height();

	console.log('init', [ xsize, ysize ]);

	$('#target').Jcrop({
		bgFade: true,
		shade: true,
		bgOpacity: .2,
		onChange : updatePreview,
		onSelect : updatePreview,
		aspectRatio : 1
	}, function() {
		// Use the API to get the real image size
		var bounds = this.getBounds();
		boundx = bounds[0];
		boundy = bounds[1];
		// Store the API in the jcrop_api variable
		jcrop_api = this;

		// Move the preview into the jcrop container for css positioning
		$preview.appendTo(jcrop_api.ui.holder);
	});

	function updatePreview(c) {
		if (parseInt(c.w) > 0) {
			var rx = xsize / c.w;
			var ry = ysize / c.h;

			$pimg.css({
				width : Math.round(rx * boundx) + 'px',
				height : Math.round(ry * boundy) + 'px',
				marginLeft : '-' + Math.round(rx * c.x) + 'px',
				marginTop : '-' + Math.round(ry * c.y) + 'px'
			});
			
			$('#imageX').val(c.x);
			$('#imageY').val(c.y);
			$('#imageHeight').val(c.h);
			$('#imageWidth').val(c.w);
			
			$('#imageX', parent.document).attr("data-bind",c.x);
			$('#imageY', parent.document).attr("data-bind",c.y);
			$('#imageHeight', parent.document).attr("data-bind",c.h);
			$('#imageWidth', parent.document).attr("data-bind",c.w);
		}
	};
});