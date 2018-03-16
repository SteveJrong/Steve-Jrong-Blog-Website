/*
 * Project Name: SJBlog
 * Class Name: UpdateLifeInfoAction.java
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
 * 修改生活段子信息相关的Action
 * 
 * Create User: SteveJrong
 * Create Date: 2016年8月15日 上午9:55:55
 * Modify User: SteveJrong
 * Modify Date: 2016年8月15日 上午9:55:55
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class UpdateLifeInfoAction implements Action, Serializable {

	private static final long serialVersionUID = -6503847112205482884L;

	/**
	 * 生活段子编号属性
	 */
	private Integer id;

	/**
	 * 生活段子内容属性
	 */
	private String content;

	/**
	 * 生活段子业务接口类型的属性，用于Spring Ioc
	 */
	private LifeService mLifeService;

	/**
	 * 返回的结果集属性
	 */
	private JSONObject jsonDatas;

	public JSONObject getJsonDatas() {
		return jsonDatas;
	}

	public void setJsonDatas(JSONObject jsonDatas) {
		this.jsonDatas = jsonDatas;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setmLifeService(LifeService mLifeService) {
		this.mLifeService = mLifeService;
	}

	/**
	 * 默认执行的方法
	 */
	@Override
	public String execute() throws Exception {
		Map<String, String> map = new HashMap<String, String>();

		if (mLifeService.updateLifeInfoService(id, content)) {
			map.put("result", "success");
			jsonDatas = JSONObject.fromObject(map);
		} else {
			map.put("result", "failed");
			jsonDatas = JSONObject.fromObject(map);
		}

		return ActionResult.SUCCESS.getType();
	}

}
