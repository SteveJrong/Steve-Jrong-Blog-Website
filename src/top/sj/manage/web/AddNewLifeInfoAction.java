/*
 * Project Name: SJBlog
 * Class Name: AddNewLifeInfoAction.java
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
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONObject;
import top.sj.common.util.ActionResult;
import top.sj.entity.SjLife;
import top.sj.inputscope.SessionScope;
import top.sj.manage.service.LifeService;
import top.sj.tool.ReverseProxyIPInfoTool;

import com.opensymphony.xwork2.Action;

/**
 * 新增生活段子信息相关的Action
 * 
 * Create User: SteveJrong
 * Create Date: 2016年7月23日 下午11:05:39
 * Modify User: SteveJrong
 * Modify Date: 2016年7月23日 下午11:05:39
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class AddNewLifeInfoAction implements Action, Serializable {
	
	private static final long serialVersionUID = 785233561000361675L;

	/**
	 * 生活段子业务类型的接口，用于Spring Ioc
	 */
	private LifeService mLifeService;

	/**
	 * 生活段子内容属性
	 */
	private String newlife;

	/**
	 * 设备信息属性
	 */
	private String device;

	/**
	 * 操作系统信息属性
	 */
	private String system;

	/**
	 * 结果集属性
	 */
	private JSONObject jsonDatas;

	public void setmLifeService(LifeService mLifeService) {
		this.mLifeService = mLifeService;
	}

	public String getNewlife() {
		return newlife;
	}

	public void setNewlife(String newlife) {
		this.newlife = newlife;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
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
	@Override
	public String execute() throws Exception {
		Map<String, String> resultMap = new HashMap<String, String>();

		SjLife life = new SjLife();
		life.setLContents(newlife);
		life.setLDeviceinfo(device);
		life.setLIpaddress(ReverseProxyIPInfoTool.getClientIP(ServletActionContext.getRequest()));
		life.setLPublishdate(new Timestamp(System.currentTimeMillis()));
		life.setLModifydate(null);
		life.setLSysteminfo(system);
		life.setSjUsers(SessionScope.getUserEntityInfoOnSessionScope());

		if (mLifeService.addNewLifeInfoService(life)) {
			resultMap.put("result", "successed");
		} else {
			resultMap.put("result", "failed");
		}

		jsonDatas = JSONObject.fromObject(resultMap);

		return ActionResult.SUCCESS.getType();
	}
}
