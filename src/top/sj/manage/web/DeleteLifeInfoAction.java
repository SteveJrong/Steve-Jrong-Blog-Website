/*
 * Project Name: SJBlog
 * Class Name: DeleteLifeInfoAction.java
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
import top.sj.manage.service.LifeService;

import com.opensymphony.xwork2.Action;

/**
 * 删除生活段子信息相关的Action
 * 
 * Create User: SteveJrong
 * Create Date: 2016年8月15日 上午10:48:33
 * Modify User: SteveJrong
 * Modify Date: 2016年8月15日 上午10:48:33
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class DeleteLifeInfoAction implements Serializable, Action {

	private static final long serialVersionUID = 3880872314155028772L;

	/**
	 * 生活段子编号属性
	 */
	private Integer id;

	/**
	 * 生活段子业务接口类型的属性，用于Spring Ioc
	 */
	private LifeService mLifeService;

	/**
	 * 结果集JSON对象
	 */
	private JSONObject jsonDatas;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setmLifeService(LifeService mLifeService) {
		this.mLifeService = mLifeService;
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
		Map<String, String> map = new HashMap<String, String>();
		if (mLifeService.deleteLifeInfoService(id)) {
			map.put("result", "success");
			jsonDatas = JSONObject.fromObject(map);
		} else {
			map.put("result", "failed");
			jsonDatas = JSONObject.fromObject(map);
		}
		return ActionResult.SUCCESS.getType();
	}
}
