/*
 * Project Name: SJBlog
 * Class Name: ShiroExceptionEnum.java
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
 * 适用于Apache Shiro框架验证失败的枚举类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年4月4日 下午12:55:54
 * Modify User: SteveJrong
 * Modify Date: 2016年4月4日 下午12:55:54
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public enum ShiroExceptionEnum {
	PASSWORDERROR("您输入的密码有误，请确认后重试"), LOGINFAILEDMAXCOUNTS("您登录的失败次数过多，请稍后再试"), ACCOUNTISLOCKED(
			"您的账号已被锁定，请联系管理员解决此问题"), ACCOUNTISDISABLED("您的账号已被禁用，您无权登录"), ACCOUNTEXPIRED(
			"您的账号已过期，请联系管理员解决此问题"), ACCOUNTNOTEXISTS("您输入的账号不存在，请确认后重试"), ACCOUNTUNAUTHORIZED(
			"此账号没有登录到系统的权限，请联系管理员解决此问题"),OTHER("其他系统异常");

	private String type;

	public String getType() {
		return type;
	}

	private ShiroExceptionEnum(String type) {
		this.type = type;
	}
}
