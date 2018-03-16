/*
 * Project Name: SJBlog
 * Class Name: SysRoleEnum.java
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
 * 系统角色枚举
 * 
 * Create User: SteveJrong
 * Create Date: 2016年3月26日 下午6:43:02
 * Modify User: SteveJrong
 * Modify Date: 2016年3月26日 下午6:43:02
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public enum SysRoleEnum {
	ADMINSTRATOR("系统管理员"), NORMAL("普通用户"), INTER_VIEW("面试官");

	private String type;

	private SysRoleEnum(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
}
