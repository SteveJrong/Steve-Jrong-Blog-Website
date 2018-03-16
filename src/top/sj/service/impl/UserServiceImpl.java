/*
 * Project Name: SJBlog
 * Class Name: UserServiceImpl.java
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
package top.sj.service.impl;

import net.sf.json.JSONObject;
import top.sj.dao.UserDao;
import top.sj.entity.SjUsers;
import top.sj.service.UserService;
import top.sj.tool.TimestampTool;
import top.sj.util.PersonalCenterDataGridNode;

/**
 * 用户业务接口的实现类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年11月14日 下午4:19:52
 * Modify User: SteveJrong
 * Modify Date: 2016年11月14日 下午4:19:52
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class UserServiceImpl implements UserService {

	/**
	 * 用户接口类型的属性，用于Spring Ioc
	 */
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/**
	 * 用户登录的方法【业务逻辑】
	 */
	@Override
	public SjUsers doLoginService(SjUsers users) {
		return userDao.doLogin(users);
	}

	/**
	 * 用户注册的方法【业务逻辑】
	 */
	@Override
	public Boolean doRegisterService(SjUsers user) {
		return userDao.doRegister(user);
	}

	/**
	 * 更新用户信息的方法【业务逻辑】
	 */
	@Override
	public Boolean updateUserInfoService(SjUsers users) {
		return userDao.updateUserInfo(users);
	}

	/**
	 * 根据用户编号获取用户信息的方法【业务逻辑】
	 */
	@Override
	public SjUsers getUserInfoByIdService(Integer userId) {
		return userDao.getUserInfoById(userId);
	}

	/**
	 * 根据个人中心DTO更新用户信息的方法【业务逻辑】
	 */
	@Override
	public Boolean updateUserInfoByUserIdAndPersonalCenterDTO(PersonalCenterDataGridNode personalCenterDTO) {
		SjUsers user = this.getUserInfoByIdService(personalCenterDTO.getUserId());
		user.setUQqnum(Integer.valueOf(personalCenterDTO.getQQNum()));
		user.setUAge(personalCenterDTO.getUserAge());
		user.setUEmail(personalCenterDTO.getUserEmail());
		user.setUGender(personalCenterDTO.getUserGender());
		user.setUNickname(personalCenterDTO.getUserNickName());
		user.setUSecurityquestionanswer(personalCenterDTO.getUserSecurityQuestionAnswer());
		if (this.updateUserInfoService(user)) {
			return true;
		}
		return false;
	}

	/**
	 * 根据用户编号获取基于个人信息DataGridNode的JSON数据的方法【业务逻辑】
	 */
	@Override
	public JSONObject getUserInfoBasedOnPersonalCenterDataGridNodeByUserId(Integer userId) {
		SjUsers userInfo = this.getUserInfoByIdService(userId);
		
		PersonalCenterDataGridNode personalCenterDataGridNode = new PersonalCenterDataGridNode();
		personalCenterDataGridNode.setQQNum(Integer.toString(userInfo.getUQqnum()));
		personalCenterDataGridNode.setUserAge(userInfo.getUAge());
		personalCenterDataGridNode.setUserEmail(userInfo.getUEmail());
		personalCenterDataGridNode.setUserGender(userInfo.getUGender());
		personalCenterDataGridNode.setUserId(userInfo.getUId());
		personalCenterDataGridNode.setUserLastLoginDate(TimestampTool.toString(userInfo.getULastlogontime()));
		personalCenterDataGridNode.setUserNickName(userInfo.getUNickname());
		personalCenterDataGridNode.setUserRegisterDate(TimestampTool.toString(userInfo.getUCreatetime()));
		personalCenterDataGridNode.setUserSecurityQuestionAnswer(userInfo.getUSecurityquestionanswer());
		personalCenterDataGridNode.setUserLevel(userInfo.getULevel());
		return JSONObject.fromObject(personalCenterDataGridNode);
	}
}
