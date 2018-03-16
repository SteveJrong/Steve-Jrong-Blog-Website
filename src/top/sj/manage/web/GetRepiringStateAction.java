/*
 * Project Name: SJBlog
 * Class Name: GetRepiringStateAction.java
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
 * 获取网站维护状态相关的Action
 * 
 * Create User: SteveJrong
 * Create Date: 2016年10月11日 上午10:19:04
 * Modify User: SteveJrong
 * Modify Date: 2016年10月11日 上午10:19:04
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class GetRepiringStateAction implements Action, Serializable {
	
	private static final long serialVersionUID = 1516583180369223348L;
	
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
		resultMap.put("repairState", SessionScope.getRepairingStateOnSessionScope());
		jsonDatas = JSONObject.fromObject(resultMap);
		return ActionResult.SUCCESS.getType();
	}
}
