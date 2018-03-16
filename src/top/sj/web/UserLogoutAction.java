/*
 * Project Name: SJBlog
 * Class Name: UserLogoutAction.java
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
package top.sj.web;

import java.io.Serializable;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.opensymphony.xwork2.Action;

import top.sj.common.util.ActionResult;

/**
 * 用户退出登录相关的Action
 * 
 * Create User: SteveJrong
 * Create Date: 2016年3月17日18:14:18
 * Modify User: SteveJrong
 * Modify Date: 2016年3月17日18:14:18
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class UserLogoutAction implements Action, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4912627250922215465L;

	/**
	 * 默认的执行方法
	 */
	@Override
	public String execute() throws Exception {
		Subject subject = SecurityUtils.getSubject();
		if (subject.isAuthenticated()) {
			// 退出登录
			subject.logout();
		}
		return ActionResult.HOMEPAGE.getType();
	}
}
