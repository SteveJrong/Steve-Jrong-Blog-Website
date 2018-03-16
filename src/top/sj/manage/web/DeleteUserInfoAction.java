/*
 * Project Name: SJBlog
 * Class Name: DeleteUserInfoAction.java
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
package top.sj.manage.web;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;
import top.sj.common.util.ActionResult;
import top.sj.manage.service.UsersService;

import com.opensymphony.xwork2.Action;

/**
 * 删除用户信息相关的Action
 * 
 * Create User: SteveJrong
 * Create Date: 2016年4月6日 上午10:26:09
 * Modify User: SteveJrong
 * Modify Date: 2016年4月6日 上午10:26:09
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class DeleteUserInfoAction implements Action, Serializable {

	private static final long serialVersionUID = 6617507626785109000L;

	/**
	 * 用户业务类型的接口，用于Spring Ioc
	 */
	private UsersService mUsersService;

	/**
	 * 用户编号属性
	 */
	private Integer userId;

	/**
	 * 结果集属性
	 */
	private JSONObject jsonDatas;

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

	public void setmUsersService(UsersService mUsersService) {
		this.mUsersService = mUsersService;
	}

	/**
	 * 默认执行的方法
	 */
	@Override
	public String execute() throws Exception {
		Map<String, String> map = new HashMap<String, String>();

		if (mUsersService.deleteUserInfoByIdService(userId)) {
			map.put("result", "success");
			jsonDatas = JSONObject.fromObject(map);
		} else {
			map.put("result", "failed");
			jsonDatas = JSONObject.fromObject(map);
		}

		return ActionResult.SUCCESS.getType();
	}
}
