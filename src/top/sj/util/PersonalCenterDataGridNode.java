/*
 * Project Name: SJBlog
 * Class Name: PersonalCenterDataGridNode.java
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
package top.sj.util;

/**
 * “个人中心”模块的DataGrid实体类【前台】
 * 
 * Create User: SteveJrong
 * Create Date: 2016年11月30日 10:29:25
 * Modify User: SteveJrong
 * Modify Date: 2016年11月30日 10:29:25
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class PersonalCenterDataGridNode {
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
	 * 用户年龄属性
	 */
	private Integer userAge;
	
	/**
	 * 用户的安全验证问题（密保）答案属性
	 */
	private String userSecurityQuestionAnswer;
	
	/**
	 * 用户电子邮箱属性
	 */
	private String userEmail;
	
	/**
	 * 用户QQ号码属性
	 */
	private String QQNum;
	
	/**
	 * 用户注册时间属性
	 */
	private String userRegisterDate;
	
	/**
	 * 用户上次登录时间属性
	 */
	private String userLastLoginDate;
	
	/**
	 * 用户等级属性
	 */
	private Integer userLevel;

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

	public Integer getUserAge() {
		return userAge;
	}

	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}

	public String getUserSecurityQuestionAnswer() {
		return userSecurityQuestionAnswer;
	}

	public void setUserSecurityQuestionAnswer(String userSecurityQuestionAnswer) {
		this.userSecurityQuestionAnswer = userSecurityQuestionAnswer;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getQQNum() {
		return QQNum;
	}

	public void setQQNum(String qQNum) {
		QQNum = qQNum;
	}

	public String getUserRegisterDate() {
		return userRegisterDate;
	}

	public void setUserRegisterDate(String userRegisterDate) {
		this.userRegisterDate = userRegisterDate;
	}

	public String getUserLastLoginDate() {
		return userLastLoginDate;
	}

	public void setUserLastLoginDate(String userLastLoginDate) {
		this.userLastLoginDate = userLastLoginDate;
	}
	
	public Integer getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(Integer userLevel) {
		this.userLevel = userLevel;
	}

	public PersonalCenterDataGridNode(Integer userId, String userNickName, String userGender, Integer userAge,
			String userSecurityQuestionAnswer, String userEmail, String qQNum, String userRegisterDate,
			String userLastLoginDate, Integer userLevel) {
		super();
		this.userId = userId;
		this.userNickName = userNickName;
		this.userGender = userGender;
		this.userAge = userAge;
		this.userSecurityQuestionAnswer = userSecurityQuestionAnswer;
		this.userEmail = userEmail;
		this.QQNum = qQNum;
		this.userRegisterDate = userRegisterDate;
		this.userLastLoginDate = userLastLoginDate;
		this.userLevel = userLevel;
	}

	public PersonalCenterDataGridNode() {
	}
}
