/*
 * Project Name: SJBlog
 * Class Name: RepairingPageAction.java
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
import top.sj.inputscope.SessionScope;

import com.opensymphony.xwork2.Action;

/**
 * 紧急修复维护页面相关的Action
 * 
 * Create User: SteveJrong
 * Create Date: 2016年10月11日 上午9:19:12
 * Modify User: SteveJrong
 * Modify Date: 2016年10月11日 上午9:19:12
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class RepairingPageAction implements Action,Serializable {

	private static final long serialVersionUID = 4305188307213479113L;

	/**
	 * 网站维护状态属性
	 */
	private String repairingState;
	
	public String getRepairingState() {
		return repairingState;
	}

	public void setRepairingState(String repairingState) {
		this.repairingState = repairingState;
	}

	/**
	 * 结果集JSON对象
	 */
	private JSONObject jsonDatas;
	
	public JSONObject getJsonDatas() {
		return jsonDatas;
	}

	public void setJsonDatas(JSONObject jsonDatas) {
		this.jsonDatas = jsonDatas;
	}
	
	/**
	 * 默认执行的方法
	 */
	@Override
	public String execute() throws Exception {
		Map<String, Object> resultMap = new HashMap<String,Object>();
		try {
			boolean value = !Boolean.valueOf(repairingState);
			SessionScope.putRepairingStateOnSessionScope(value);
			resultMap.put("result", "success");
		} catch (Exception e) {
			resultMap.put("result", "failed");
			e.printStackTrace();
		}
		jsonDatas = JSONObject.fromObject(resultMap);
		return ActionResult.SUCCESS.getType();
	}
}
