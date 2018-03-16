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
import top.sj.tool.TimestampTool;
import top.sj.util.PersonalCenterDataGridNode;

/**
 * 载入用户信息相关的Action
 * 
 * Create User: SteveJrong
 * Create Date: 2016年11月28日 17:53:29
 * Modify User: SteveJrong
 * Modify Date: 2016年11月28日 17:53:29
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class LoadUserInfoAction implements Action, Serializable {

	private static final long serialVersionUID = 4230471517329273108L;
	@SuppressWarnings("unused")
	private static final Logger LOGGER = LoggerFactory.getLogger(LoadUserInfoAction.class);
	
	/**
	 * 用户业务接口类型的属性，用于Spring Ioc
	 */
	private UserService userService;
	
	/**
	 * 用户编号属性
	 */
	private Integer userId;
	
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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public JSONObject getJsonDatas() {
		return jsonDatas;
	}

	public void setJsonDatas(JSONObject jsonDatas) {
		this.jsonDatas = jsonDatas;
	}

	/**
	 * 默认执行的方法
	 */
	public String execute() {
		Map<String, Object> resultMap = new HashMap<String,Object>();
		
		JSONObject resultJsonObject = userService.getUserInfoBasedOnPersonalCenterDataGridNodeByUserId(userId);
		if (resultJsonObject.size() > 0) {
			resultMap.put("result", true);
			resultMap.put("datas", resultJsonObject);
		}else {
			resultMap.put("result", false);
			resultMap.put("datas", null);
		}
		
		jsonDatas = JSONObject.fromObject(resultMap);
		
		return ActionResult.SUCCESS.getType();
	}
}
