/*
 * Project Name: SJBlog
 * Class Name: LoadAllLifeInfoAction.java
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

import net.sf.json.JSONObject;
import top.sj.common.util.ActionResult;
import top.sj.manage.service.LifeService;

import com.opensymphony.xwork2.Action;

/**
 * 载入所有生活段子信息相关的Action
 * 
 * Create User: SteveJrong
 * Create Date: 2016年7月23日 下午7:56:35
 * Modify User: SteveJrong
 * Modify Date: 2016年7月23日 下午7:56:35
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class LoadAllLifeInfoAction implements Action, Serializable {

	private static final long serialVersionUID = -8057359226399905695L;

	/**
	 * 生活段子业务类型的接口，用于Spring Ioc
	 */
	private LifeService mLifeService;

	/**
	 * 每页显示的条数属性
	 */
	private String rows;

	/**
	 * 当前页数属性
	 */
	private String page;

	/**
	 * 结果集JSON对象
	 */
	private JSONObject jsonDatas;

	public String getRows() {
		return rows;
	}

	public void setRows(String rows) {
		this.rows = rows;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public JSONObject getJsonDatas() {
		return jsonDatas;
	}

	public void setJsonDatas(JSONObject jsonDatas) {
		this.jsonDatas = jsonDatas;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setmLifeService(LifeService mLifeService) {
		this.mLifeService = mLifeService;
	}

	/**
	 * 默认执行的方法
	 */
	@Override
	public String execute() throws Exception {
		jsonDatas = mLifeService.getAllLifeInfoSplitPageService(
				Integer.valueOf(page), Integer.valueOf(rows));

		return ActionResult.SUCCESS.getType();
	}
}
