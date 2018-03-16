/*
 * Project Name: SJBlog
 * Class Name: LoadUserInfoAction.java
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
 * 更新用户信息相关的Action
 * 
 * Create User: SteveJrong
 * Create Date: 2016年11月30日 13:48:02
 * Modify User: SteveJrong
 * Modify Date: 2016年11月30日 13:48:02
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class UpdateUserInfoAction implements Action, Serializable {

	private static final long serialVersionUID = 4500142693324838582L;

	private static final Logger LOGGER = LoggerFactory.getLogger(UpdateUserInfoAction.class);
	
	/**
	 * 用户业务接口类型的属性，用于Spring Ioc
	 */
	private UserService userService;
	
	/**
	 * “个人中心”实体类属性
	 */
	private PersonalCenterDataGridNode personalCenter;
	
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

	public PersonalCenterDataGridNode getPersonalCenter() {
		return personalCenter;
	}

	public void setPersonalCenter(PersonalCenterDataGridNode personalCenter) {
		this.personalCenter = personalCenter;
	}

	/**
	 * 默认执行的方法
	 */
	public String execute() {
		Map<String, Object> resultMap = new HashMap<String,Object>();
		if (userService.updateUserInfoByUserIdAndPersonalCenterDTO(personalCenter)) {
			LOGGER.info(" -- ["+DateTimeTool.getNowDateFormatDateTimeTemplateOne()+"]更新个人信息成功 -- ");
			resultMap.put("result", true);
		}else {
			LOGGER.info(" -- ["+DateTimeTool.getNowDateFormatDateTimeTemplateOne()+"]更新个人信息失败 -- ");
			resultMap.put("result", false);
		}
		
		jsonDatas = JSONObject.fromObject(resultMap);
		
		return ActionResult.SUCCESS.getType();
	}
}
