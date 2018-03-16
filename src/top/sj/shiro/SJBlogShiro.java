/*
 * Project Name: SJBlog
 * Class Name: SJBlogShiro.java
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
package top.sj.shiro;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import top.sj.common.util.SysRoleEnum;
import top.sj.entity.SjUsers;
import top.sj.manage.service.UsersService;
import top.sj.service.UserService;
import top.sj.tool.CharacterTool;

/**
 * Shiro权限过滤器
 * 
 * Create User: SteveJrong
 * Create Date: 2016年3月17日 16:48:10
 * Modify User: SteveJrong
 * Modify Date: 2016年3月17日 16:48:10
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class SJBlogShiro extends AuthorizingRealm {

	/**
	 * 用户业务接口类型的属性，用于Spring Ioc
	 */
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * 用户业务接口类型的属性，用于Spring Ioc
	 */
	private UsersService mUsersService;

	public void setmUsersService(UsersService mUsersService) {
		this.mUsersService = mUsersService;
	}

	/**
	 * 权限认证方法
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		String loginUserName = principalCollection.fromRealm(getName()).iterator().next().toString();

		SjUsers sjUsers = mUsersService.getSingleUserInfoByUserNickNameService(loginUserName);
		
//		System.out.println(sjUsers.getUId());
//		System.out.println(sjUsers.getUNickname());
//		System.out.println(sjUsers.getURole());
		
		// 对应applicationContext.xml文件中 /admin/** = roles[admin] 角色限制
		Set<String> roles = new HashSet<String>();
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

		if (null != sjUsers && sjUsers.getURole() .equals(SysRoleEnum.ADMINSTRATOR.getType())) {

			// 为当前登录的用户添加角色
			roles.add("admin");

			// 对应applicationContext.xml文件中 /directionpermission/** =
			// perms[query] 权限限制
			// Set<String> permissions = new HashSet<String>();

			// 为当前登录的用户添加权限
			// permissions.add("query");
			// info.setStringPermissions(permissions);

			//return info;
		}else if (null != sjUsers && sjUsers.getURole().equals(SysRoleEnum.INTER_VIEW.getType())) {
			// 为当前登录的用户添加角色
			roles.add("interview");
		}
		
		info.setRoles(roles);
		
		return info;
	}

	/**
	 * 角色认证方法 2016年3月17日16:49:12
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {

		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;

		SjUsers users = new SjUsers();

		// 用户输入的用户名
		String customerUserName = usernamePasswordToken.getUsername();
		// 用户输入的密码
		String customerPassword = CharacterTool.getStringPwdByCharPwd(
				usernamePasswordToken.getPassword()).toString();

		users.setUNickname(customerUserName);
		users.setUPwd(customerPassword);

		// 先去数据库中查询
		users = userService.doLoginService(users);

		if (null != users) {
			if (null != users.getUId()) {
				return new SimpleAuthenticationInfo(users.getUNickname(),
						users.getUPwd(), getName());
			}
		}

		return null;
	}
}
