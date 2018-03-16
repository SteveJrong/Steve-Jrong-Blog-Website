/*
 * Project Name: SJBlog
 * Class Name: UserManageDataGridNodeDTO.java
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
package top.sj.manage.dto;

/**
 * 用于用户管理的DataGrid数据传输对象
 * 
 * Create User: SteveJrong
 * Create Date: 2016年4月5日 下午5:16:32
 * Modify User: SteveJrong
 * Modify Date: 2016年4月5日 下午5:16:32
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class UserManageDataGridNodeDTO {
	/**
	 * 用户编号属性
	 */
	private Integer userId;

	/**
	 * 用户昵称属性
	 */
	private String userNickName;

	/**
	 * 用户性别属性
	 */
	private String userGender;

	/**
	 * 用户角色属性
	 */
	private String userRole;

	/**
	 * 用户年龄属性
	 */
	private Integer userAge;

	/**
	 * 账户状态属性
	 */
	private String accountState;

	/**
	 * 用户等级属性
	 */
	private Integer userLevel;

	/**
	 * 用户注册时间属性
	 */
	private String userRegisterDateTime;

	/**
	 * 用户最后一次登录时间属性
	 */
	private String userLastLogOnDateTime;

	/**
	 * 用户电子邮件地址属性
	 */
	private String userEmail;

	/**
	 * 用户QQ号码属性
	 */
	private String userQQNum;

	/**
	 * 用户省市信息属性
	 */
	private String userProvinceAndCity;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserNickName() {
		return userNickName;
	}

	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public Integer getUserAge() {
		return userAge;
	}

	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}

	public String getAccountState() {
		return accountState;
	}

	public void setAccountState(String accountState) {
		this.accountState = accountState;
	}

	public Integer getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(Integer userLevel) {
		this.userLevel = userLevel;
	}

	public String getUserRegisterDateTime() {
		return userRegisterDateTime;
	}

	public void setUserRegisterDateTime(String userRegisterDateTime) {
		this.userRegisterDateTime = userRegisterDateTime;
	}

	public String getUserLastLogOnDateTime() {
		return userLastLogOnDateTime;
	}

	public void setUserLastLogOnDateTime(String userLastLogOnDateTime) {
		this.userLastLogOnDateTime = userLastLogOnDateTime;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserQQNum() {
		return userQQNum;
	}

	public void setUserQQNum(String userQQNum) {
		this.userQQNum = userQQNum;
	}

	public String getUserProvinceAndCity() {
		return userProvinceAndCity;
	}

	public void setUserProvinceAndCity(String userProvinceAndCity) {
		this.userProvinceAndCity = userProvinceAndCity;
	}

	public UserManageDataGridNodeDTO(Integer userId, String userNickName,
			String userGender, String userRole, Integer userAge,
			String accountState, Integer userLevel,
			String userRegisterDateTime, String userLastLogOnDateTime,
			String userEmail, String userQQNum, String userProvinceAndCity) {
		super();
		this.userId = userId;
		this.userNickName = userNickName;
		this.userGender = userGender;
		this.userRole = userRole;
		this.userAge = userAge;
		this.accountState = accountState;
		this.userLevel = userLevel;
		this.userRegisterDateTime = userRegisterDateTime;
		this.userLastLogOnDateTime = userLastLogOnDateTime;
		this.userEmail = userEmail;
		this.userQQNum = userQQNum;
		this.userProvinceAndCity = userProvinceAndCity;
	}

	public UserManageDataGridNodeDTO() {
	}
}
