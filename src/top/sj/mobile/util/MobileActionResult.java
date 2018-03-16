/*
 * Project Name: SJBlog
 * Class Name: MobileActionResult.java
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

/**
 * 用于移动平台的Action的自定义返回值枚举
 * 
 * Create User: SteveJrong
 * Create Date: 2016年10月13日 上午10:03:15
 * Modify User: SteveJrong
 * Modify Date: 2016年10月13日 上午10:03:15
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public enum MobileActionResult {
	SUCCESS("success"), // 成功
	FAILED("failed"), // 失败
	ERROR("error"), // 错误
	NULL("nil"), // 返回的集合或实体为空
	INPUT("input"), // 需要验证
	LOGOUT("logout"), // 退出登录
	HOMEPAGE("home"), // 转到主页（特定，专用）
	LOGIN("login"),// 登录
	REAPIRING("repair"),// 网站维护中
	MOBILE_ARTICLE_DETAIL("articleDetail");// 文章详情页
	
	private String type;

	public String getType() {
		return type;
	}

	private MobileActionResult(String type) {
		this.type = type;
	}
}
