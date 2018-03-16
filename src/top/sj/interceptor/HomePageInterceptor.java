/*
 * Project Name: SJBlog
 * Class Name: HomePageInterceptor.java
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

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 主页拦截器【暂时弃用】
 * 
 * Create User: SteveJrong
 * Create Date: 2016年3月16日20:29:12
 * Modify User: SteveJrong
 * Modify Date: 2016年3月16日20:29:12
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class HomePageInterceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3162396505763292562L;

	/**
	 * 拦截方法
	 */
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		return "redirectHomePage";
	}
}
