/*
 * Project Name: SJBlog
 * Class Name: MobileInterfaceFactory.java
 * 
 * Copyright © 2011-2016 SteveJrong  All Rights Reserved.
 * 
 * Licensed under the SteveJrong
 * 
 * https://www.steve.jrong.top/
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package top.sj.mobile.interfaces.factory;

import java.util.Properties;

import top.sj.common.util.Constants;
import top.sj.tool.PropertiesTool;

/**
 * 移动平台接口工厂类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年5月16日 下午3:20:36
 * Modify User: SteveJrong
 * Modify Date: 2016年5月16日 下午3:20:36
 * Modify Remark: 此类中定义了所有适用于移动平台的手机接口，目的是为了便于集中管理
 * 
 * @author SteveJrong
 * @version 1.0
 */
public final class MobileInterfaceFactory {

	public enum InterfacesNames {
		// 根路径
		ROOT_URL("ROOT_URL");

		// 声明一个私有变量
		private String type;

		// 在单参数的构造函数中，将传入的参数赋值给私有变量
		private InterfacesNames(String name) {
			this.type = name;
		}

		// 获取时即获取到枚举对象对应的值了
		public String getType() {
			return type;
		}
	}

	public MobileInterfaceFactory() {
		Properties prop = PropertiesTool.getPropertiesFileAsObject(Constants.CONFIG_OF_BASIC_CONFIGURATIONS.getValue());

		// 从属性文件中初始化根路径
		ROOT_URL = prop.get(InterfacesNames.ROOT_URL.getType()).toString();
	}

	/**
	 * 根路径
	 */
	public static String ROOT_URL = null;

	/**
	 * 用户登录接口
	 * 
	 * @param 参数
	 *            ：paramJsonDatas={"<b>userNickName</b>":[string value]","
	 *            <b>userPassword</b> ":"[string value]"}
	 */
	public static String USER_LOGIN = "mobileUserLogin.action";

	/**
	 * 用户注册接口
	 * 
	 * @param 参数
	 *            ：paramJsonDatas={"<b>userNickName</b>":"[string value]",
	 *            "<b>userGender</b>": "[string value]" ,"<b>userRole</b>":
	 *            "[string value]","<b>userAge</b>":[integer value],
	 *            "<b>userPassword</b>" :"[string value]",
	 *            "<b>userSecurityQuestionAnswer</b>": "[string value]" ,
	 *            "<b>userState</b>":"[string value]","<b>userLevel</b>"
	 *            :[integer value],"<b>userEmail</b>":"[string value]",
	 *            "<b>userQQNumber</b>" :[integer value],"<b>userLocation</b>":
	 *            "[string value]"}
	 */
	public static String USER_REGISTER = "mobileUserRegister.action";

	/**
	 * 载入所有博文信息接口
	 * 
	 * @param 参数
	 *            ：paramJsonDatas={"<b>paramJsonDatas</b>":"[integer value]"}
	 */
	public static String GET_ALL_ARTICLES_INFO = "mobileLoadAllArticlesInfo.action";

	/**
	 * 获取一个博文详情信息接口
	 * 
	 * @param 参数：paramJsonDatas={"<b>enableNightMode</b>":"['true' or 'false' string value]","<b>articleId</b>",[integer value]}
	 */
	public static String GET_AN_ARTCILE_DETAIL_INFO = "mobileGetArticleDetailInfo.action";
	
	/**
	 * 获取一个博文标题接口
	 * 
	 * @param 参数：paramJsonDatas={"<b>enableNightMode</b>":"['true' or 'false' string value]","<b>articleId</b>",[integer value]}
	 */
	public static String GET_AN_ARTCILE_TITLE_INFO = "mobileGetArticleTitle.action";
	
	/**
	 * 获取博文的评论/回复信息接口
	 * 
	 * @param 参数：paramJsonDatas={"<b>articleId</b>":[integer value],"<b>pageIndex</b>":[integer value]}
	 */
	public static String GET_AN_ARTICLE_COMMENTS_OR_REPLIES_INFO = "mobileGetArticleCOrRInfo.action";
	
	/**
	 * 发布评论/回复信息接口
	 * 
	 * @param 参数：paramJsonDatas={"<b>articleId</b>":[integer value],"<b>userId</b>":[integer value],"<b>content</b>":[string value],"<b>device</b>":[string value],"<b>system</b>":[string value]}
	 */
	public static String PUBLISH_COMMENTS_OR_REPLIES_INFO = "mobilePublishCOrRInfo.action";
	
	/**
	 * 为评论/回复消息点赞接口
	 * 
	 * @param 参数：paramJsonDatas={"<b>paramJsonDatas</b>":[integer value]}
	 */
	public static String DO_PRAISE_FOR_COMMENTS_OR_REPLIES_INFO = "mobileDoPraise.action";
	
	/**
	 * 测试调用接口
	 * 
	 * @param 参数：无入参
	 */
	public static String TEST_INVOKING = "mobileInvokingTest.action";
	
}
