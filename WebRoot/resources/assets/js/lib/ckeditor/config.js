/**
 * @license Copyright (c) 2003-2016, CKSource - Frederico Knabben. All rights
 *          reserved. For licensing, see LICENSE.md or
 *          http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function(config) {
	config.toolbarGroups = [ '/', '/', '/', '/', {
		name : 'document',
		groups : [ 'mode', 'document', 'doctools' ]
	}, {
		name : 'clipboard',
		groups : [ 'clipboard', 'undo' ]
	}, {
		name : 'editing',
		groups : [ 'find', 'selection', 'spellchecker', 'editing' ]
	}, {
		name : 'forms',
		groups : [ 'forms' ]
	}, '/', {
		name : 'basicstyles',
		groups : [ 'basicstyles', 'cleanup' ]
	}, {
		name : 'paragraph',
		groups : [ 'list', 'indent', 'blocks', 'align', 'bidi', 'paragraph' ]
	}, {
		name : 'links',
		groups : [ 'links' ]
	}, {
		name : 'insert',
		groups : [ 'insert' ]
	}, '/', {
		name : 'styles',
		groups : [ 'styles' ]
	}, {
		name : 'colors',
		groups : [ 'colors' ]
	}, {
		name : 'tools',
		groups : [ 'tools' ]
	}, {
		name : 'others',
		groups : [ 'others' ]
	}, {
		name : 'about',
		groups : [ 'about' ]
	} ];

	config.removeButtons = 'Language,Anchor,Flash,Iframe,Blockquote,Form,Radio,Checkbox,Select,Textarea,HiddenField,ImageButton,Button';

	config.language = 'zh-cn';// 语言设置
	config.height = '400px';// 高度
	config.toolbar = 'Basic';// 工具栏：Full/Basic
	config.toolbarLocation = 'top';
	
	CKEDITOR.config.filebrowserBrowseUrl = '/ArticleUDDemo/showFiles.action';
	CKEDITOR.config.filebrowserUploadUrl = '/ArticleUDDemo/showFiles.action';
	
	CKEDITOR.config.filebrowserWindowWidth = '640';
	CKEDITOR.config.filebrowserWindowHeight = '480';
	
	config.filebrowserUploadUrl="uploadPics.action";
	
//	config.extraPlugins = 'syntaxhighlight'; 
//	config.toolbar_Full = (['Code']);
	
//	config.extraPlugins = 'insertcode'; 
};
