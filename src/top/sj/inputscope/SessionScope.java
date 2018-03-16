/*
 * Project Name: SJBlog
 * Class Name: SessionScope.java
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
package top.sj.inputscope;

import java.io.Serializable;

import top.sj.entity.SjUsers;

import com.opensymphony.xwork2.ActionContext;

/**
 * Session会话作用域
 * 
 * Create User: SteveJrong
 * Create Date: 2016年2月26日 下午9:46:46
 * Modify User: SteveJrong
 * Modify Date: 2016年2月26日 下午9:46:46
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class SessionScope implements Serializable {

	private static final long serialVersionUID = 2764447976349120056L;

	/**
	 * 将用户信息存入Session域中
	 * 
	 * 方法描述:
	 * 
	 * @param user
	 * @return
	 * @returnType Boolean 创建人： Steve Jrong 创建时间：2016-2-26 下午9:46:04
	 */
	public static void putUserInfoOnSessionScope(SjUsers user) {
		ActionContext.getContext().getSession()
				.put("userName", user.getUNickname());
		ActionContext.getContext().getSession().put("user", user);
	}

	/**
	 * 获取完整的已登录的单个用户实体信息
	 * 
	 * @return
	 */
	public static SjUsers getUserEntityInfoOnSessionScope() {
		return (SjUsers) ActionContext.getContext().getSession().get("user");
	}
	
	/**
	 * 将网站的维护状态存入Session域中
	 * @param repairingState true-维护中;false-正常运行
	 */
	public static void putRepairingStateOnSessionScope(Boolean repairingState) {
		Boolean trueValue = true;
		//如果状态为空就赋初始值默认为false不维护
		if (null == ActionContext.getContext().getSession().get("repairingState")) {
			trueValue = false;
		}else {
			//如果不为空则赋值为入参值
			trueValue = repairingState;
		}
		ActionContext.getContext().getSession().put("repairingState", trueValue);
	}
	
	/**
	 * 获取网站的维护状态
	 * 
	 * @return
	 */
	public static Boolean getRepairingStateOnSessionScope() {
		if (null == ActionContext.getContext().getSession().get("repairingState")) {
			ActionContext.getContext().getSession().put("repairingState", false);
		}
		return (Boolean) ActionContext.getContext().getSession().get("repairingState");
	}
}
