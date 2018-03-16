/*
 * Project Name: SJBlog
 * Class Name: ActionResult.java
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
package top.sj.common.util;

/**
 * 用于Action的自定义返回值枚举
 * 
 * Create User: SteveJrong
 * Create Date: 2015年12月13日 下午6:58:31
 * Modify User: SteveJrong
 * Modify Date: 2015年12月13日 下午6:58:31
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public enum ActionResult {
	SUCCESS("success"), // 成功
	FAILED("failed"), // 失败
	ERROR("error"), // 错误
	NULL("nil"), // 返回的集合或实体为空
	INPUT("input"), // 需要验证
	LOGOUT("logout"), // 退出登录
	HOMEPAGE("home"), // 转到主页（特定，专用）
	LOGIN("login"),// 登录
	REAPIRING("repair");// 网站维护中

	private String type;

	public String getType() {
		return type;
	}

	private ActionResult(String type) {
		this.type = type;
	}
}
