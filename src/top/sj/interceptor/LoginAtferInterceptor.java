/*
 * Project Name: SJBlog
 * Class Name: LoginAtferInterceptor.java
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
package top.sj.interceptor;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import top.sj.common.util.ActionResult;
import top.sj.tool.DateTimeTool;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 登录成功后的拦截器【已弃用】
 * 
 * Create User: SteveJrong
 * Create Date: 2016年8月23日 下午4:55:25
 * Modify User: SteveJrong
 * Modify Date: 2016年8月23日 下午4:55:25
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class LoginAtferInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 6996201061952067551L;

	/**
	 * 源URL属性
	 */
	private String refererUrl;

	public String getRefererUrl() {
		return refererUrl;
	}

	public void setRefererUrl(String refererUrl) {
		this.refererUrl = refererUrl;
	}

	private Logger LOGGER = LoggerFactory
			.getLogger(LoginAtferInterceptor.class);

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// 使用了defaultStack之后就不能直接返回invoke()了，因为这样会跳过invoke()后面的执行而直接结束
		// if (null == SessionScope.getUserEntityInfoOnSessionScope()) {
		// return invocation.invoke();
		// }
		String result = invocation.invoke();

		LOGGER.info(" -- invocation result is 【" + result + "】 -- ");

		Map<String, Object> invocationMap = invocation.getInvocationContext()
				.getParameters();

		String preRedirectUrl = ((String[]) invocationMap.get("refererUrl"))[0]
				.toString();

		refererUrl = preRedirectUrl;

		LOGGER.info(" -- prepare redirect url is 【" + preRedirectUrl + "】 -- ");

		LOGGER.info(" -- 当前类："
				+ Thread.currentThread().getStackTrace()[0].getClassName()
				+ "，执行时间：" + DateTimeTool.getNowDateFormatDateTimeTemplateOne()
				+ " -- ");

		return ActionResult.SUCCESS.getType();
	}
}
