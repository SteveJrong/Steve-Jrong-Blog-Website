/*
 * Project Name: SJBlog
 * Class Name: HibernateBaseUtil.java
 * 
 * Copyright © 2011-2017 SteveJrong  All Rights Reserved.
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
package top.sj.common.util;

import org.apache.struts2.ServletActionContext;

/**
 * Hibrnate工具类
 * 
 * Create User: SteveJrong
 * Create Date: 2017年5月11日 上午7:41:36
 * Modify User: SteveJrong
 * Modify Date: 2017年5月11日 上午7:41:36
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class ServletContextUtil{
	
	/**
	 * 根据上下文参数Key获取值的方法
	 * @param contextParamKey
	 * @return
	 */
	public static String getValueByContextParamKey(String contextParamKey){
		return ServletActionContext.getServletContext().getInitParameter(contextParamKey);
	}
}
