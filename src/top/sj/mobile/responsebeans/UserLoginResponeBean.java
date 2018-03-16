/*
 * Project Name: SJBlog
 * Class Name: UserLoginResponeBean.java
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
package top.sj.mobile.responsebeans;

import java.io.Serializable;

/**
 * 【移动平台】用户登录DTO Bean
 * 
 * Create User: SteveJrong
 * Create Date: 2016年10月17日 下午8:31:38
 * Modify User: SteveJrong
 * Modify Date: 2016年10月17日 下午8:31:38
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class UserLoginResponeBean implements Serializable {
	private static final long serialVersionUID = -7627119619554982010L;
	
	/**
	 * 登录结果标识符属性
	 */
	private Boolean result;
	
	/**
	 * 用户编号属性
	 */
	private String userId;

	public Boolean getResult() {
		return result;
	}

	public void setResult(Boolean result) {
		this.result = result;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public UserLoginResponeBean(Boolean result, String userId) {
		super();
		this.result = result;
		this.userId = userId;
	}
	
	public UserLoginResponeBean() {
	}
}
