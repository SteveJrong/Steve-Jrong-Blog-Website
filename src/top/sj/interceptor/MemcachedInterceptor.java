/*
 * Project Name: SJBlog
 * Class Name: MemcachedInterceptor.java
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

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.util.Assert;

import top.sj.common.util.ActionResult;
import top.sj.guest.history.GuestHistoryRecord;
import top.sj.inputscope.SessionScope;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * Memcached初始化拦截器
 * 
 * Create User: SteveJrong
 * Create Date: 2016年3月30日 下午10:25:06
 * Modify User: SteveJrong
 * Modify Date: 2016年3月30日 下午10:25:06
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class MemcachedInterceptor extends AbstractInterceptor {
	
	private static final long serialVersionUID = -5642551974075474160L;

	/**
	 * 拦截方法
	 */
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		HttpServletRequest request = (HttpServletRequest) invocation.getInvocationContext().get(ServletActionContext.HTTP_REQUEST);
		try {
			new GuestHistoryRecord().guestsInfoFilter(request);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
			Assert.state(true, "Memcached工作异常！");
		}
		
		boolean value = SessionScope.getRepairingStateOnSessionScope().booleanValue();
		//如果网站的维护状态为false，则正常显示主页
		if (value == false) {
			invocation.invoke();
			return ActionResult.HOMEPAGE.getType();
		}else {
			//否则网站的维护状态为true，则转向紧急维护提示页面
			return ActionResult.REAPIRING.getType();
		}
	}
}
