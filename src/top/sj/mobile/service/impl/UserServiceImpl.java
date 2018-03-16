/*
 * Project Name: SJBlog
 * Class Name: UserServiceImplResponseBean.java
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
package top.sj.mobile.service.impl;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;

import top.sj.common.util.GsonUtil;
import top.sj.dao.UserDao;
import top.sj.entity.SjUsers;
import top.sj.mobile.service.UserService;
import top.sj.tool.TimestampTool;

/**
 * 【移动平台】用户业务接口的实现类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年5月15日 上午10:51:59
 * Modify User: SteveJrong
 * Modify Date: 2016年5月15日 上午10:51:59
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class UserServiceImpl implements UserService, Serializable {
	private static final long serialVersionUID = -2644610492554489080L;

	/**
	 * 用户接口类型的属性，用于Spring Ioc
	 */
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/**
	 * 用户登录的方法【业务逻辑】
	 * 
	 * @throws UnsupportedEncodingException
	 * 
	 */
	public SjUsers doLogin(String username, String pwd) throws UnsupportedEncodingException {
		SjUsers user = new SjUsers();
		user.setUNickname(username);
		user.setUPwd(DigestUtils.sha256Hex(pwd));
		return userDao.doLogin(user);
	}

	/**
	 * 用户注册的方法【业务逻辑】
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Boolean doRegister(String jsonParam) {
		Map<String, Object> deserializeParam = GsonUtil.getInstance().fromJson(jsonParam, Map.class);
		SjUsers user = new SjUsers();
		// 用户昵称
		user.setUNickname(deserializeParam.get("userNickName").toString());
		// 用户性别
		user.setUGender(deserializeParam.get("userGender").toString());
		// 用户角色
		user.setURole(deserializeParam.get("userRole").toString());
		// 用户年龄
		user.setUAge(new Double(deserializeParam.get("userAge").toString()).intValue());
		// 用户密码
		user.setUPwd(DigestUtils.sha256Hex(deserializeParam.get("userPassword").toString()));
		// 用户安全验证问题答案
		user.setUSecurityquestionanswer(deserializeParam.get("userSecurityQuestionAnswer").toString());
		// 用户状态
		user.setUState(deserializeParam.get("userState").toString());
		// 用户等级
		user.setULevel(new Double(deserializeParam.get("userLevel").toString()).intValue());
		// 用户注册时间
		user.setUCreatetime(TimestampTool.convertDateToTimeStamp(new Date(System.currentTimeMillis())));
		// 用户最后一次登录时间
		user.setULastlogontime(null);
		// 用户电子邮件地址
		user.setUEmail(deserializeParam.get("userEmail").toString());
		// 用户QQ号码
		user.setUQqnum(new Double(deserializeParam.get("userQQNumber").toString()).intValue());
		// 用户地理位置（省市）信息
		user.setUProvinceandcity(deserializeParam.get("userLocation").toString());
		return userDao.doRegister(user);
	}
}
