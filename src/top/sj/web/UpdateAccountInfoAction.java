/*
 * Project Name: SJBlog
 * Class Name: UpdateAccountInfoAction.java
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
package top.sj.web;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.jboss.cache.config.OldFileFormatException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.Action;

import net.sf.json.JSONObject;
import top.sj.common.util.ActionResult;
import top.sj.entity.SjUsers;
import top.sj.service.UserService;
import top.sj.tool.DateTimeTool;
import top.sj.util.PersonalCenterDataGridNode;

/**
 * 更新账户信息相关的Action
 * 
 * Create User: SteveJrong
 * Create Date: 2016年11月30日 17:52:54
 * Modify User: SteveJrong
 * Modify Date: 2016年11月30日 17:52:54
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class UpdateAccountInfoAction implements Action, Serializable {

	private static final long serialVersionUID = 4500142693324838582L;

	private static final Logger LOGGER = LoggerFactory.getLogger(UpdateAccountInfoAction.class);
	
	/**
	 * 用户业务接口类型的属性，用于Spring Ioc
	 */
	private UserService userService;
	
	/**
	 * 用户编号属性
	 */
	private Integer userId;
	
	/**
	 * 旧密码属性
	 */
	private String oldPassword;
	
	/**
	 * 新密码属性
	 */
	private String newPassword;
	
	/**
	 * 结果集JSON对象
	 */
	private JSONObject jsonDatas;
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public JSONObject getJsonDatas() {
		return jsonDatas;
	}

	public void setJsonDatas(JSONObject jsonDatas) {
		this.jsonDatas = jsonDatas;
	}
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	/**
	 * 默认执行的方法
	 */
	public String execute() {
		Map<String, Object> resultMap = new HashMap<String,Object>();
		
		SjUsers user = userService.getUserInfoByIdService(userId);
		
		//原密码
		String oldDecodePassword = DigestUtils.sha256Hex(oldPassword);
		
		//如果输入的原密码正确
		if (oldDecodePassword.equals(user.getUPwd())) {
			//修改为新密码
			user.setUPwd(DigestUtils.sha256Hex(newPassword));
			
			if (userService.updateUserInfoService(user)) {
				resultMap.put("result", true);
				resultMap.put("msg", "success");
			}
		}else {
			//输入的原密码不正确
			resultMap.put("result", false);
			resultMap.put("msg", "oldPwdNotCorrect");
		}
		
		jsonDatas = JSONObject.fromObject(resultMap);
		
		LOGGER.info(" -- 账户信息操作结果："+jsonDatas+" -- ");
		
		return ActionResult.SUCCESS.getType();
	}
}
