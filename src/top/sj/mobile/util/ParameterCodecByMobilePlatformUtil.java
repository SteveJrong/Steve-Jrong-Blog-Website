/*
 * Project Name: SJBlog
 * Class Name: ParameterCodecByMobilePlatformUtil.java
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
package top.sj.mobile.util;

import org.apache.struts2.ServletActionContext;

/**
 * 适用于移动平台的编解码工具类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年5月15日 下午1:50:28
 * Modify User: SteveJrong
 * Modify Date: 2016年5月15日 下午1:50:28
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class ParameterCodecByMobilePlatformUtil {
	/**
	 * 单个传入参数解码的方法
	 * 
	 * @param paramName
	 *            JSON参数名称
	 */
	public static String parameterEcode(String paramName) {
		String currentResult = null;
		//			currentResult = new String(ServletActionContext.getRequest().getParameter(paramName).getBytes("ISO-8859-1"),
//					"UTF-8");
		/**
		 * 此处不要解码，否则在Nginx + SSL环境下会乱码 在本地开发环境中要解码，生产环境中请注释掉解码过程
		 */
		 currentResult =
		 ServletActionContext.getRequest().getParameter(paramName);
		return currentResult;
	}
}
