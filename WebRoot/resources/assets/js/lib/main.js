/**
 * RequireJS组件通用main JS文件
 * 
 * 创建时间：2016年11月7日 17:43:55
 * 创建人：Steve Jrong
 */
require.config({
	baseUrl : 'resources/assets/js/lib',
	paths:{
		jquery:'jquery.min',
		bootstrap:'bootstrap.min',
		scrollUp:'jquery.scrollUp.min'
	},
	shim:{
		bootstrap:{
			deps:['jquery']
		},
		scrollUp:{
			deps:['jquery']
		}
	}
});