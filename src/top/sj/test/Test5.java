package top.sj.test;

import java.io.IOException;

import top.sj.common.util.HttpNetUtil;
import top.sj.mobile.interfaces.factory.MobileInterfaceFactory;

/**
 * 登录接口测试
 * 
 * 
 * 项目名称：SJBlog 类名称：Test5.java 类描述：TODO 创建人：Jrong 创建时间：2016年5月16日 下午3:24:34
 * 修改人：wangj 修改时间：2016年5月16日 下午3:24:34 修改备注：
 * 
 * @version 1.0 Beta
 *
 */
public class Test5 {
	public static void main(String[] args) throws IOException {
		new MobileInterfaceFactory();
		String requestUrl = MobileInterfaceFactory.ROOT_URL
				.concat(MobileInterfaceFactory.USER_LOGIN);
		// 注意：参数中的空格要用%20代替，不能直接写为空格，否则会报错505
		String param = "paramJsonDatas={\"name\":\"Steve%20Jrong\",\"pwd\":\"123\"}";
		String s = HttpNetUtil.sendGet("http://127.0.0.1:8888/"
				+ requestUrl, param);
		System.out.println(s);
	}
}