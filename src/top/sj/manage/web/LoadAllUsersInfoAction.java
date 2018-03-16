/*
 * Project Name: SJBlog
 * Class Name: LoadAllUsersInfoAction.java
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
import top.sj.manage.service.UsersService;

import com.opensymphony.xwork2.Action;

/**
 * 载入用户信息相关的Action
 * 
 * Create User: SteveJrong
 * Create Date: 2016年4月5日 下午5:09:52
 * Modify User: SteveJrong
 * Modify Date: 2016年4月5日 下午5:09:52
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class LoadAllUsersInfoAction implements Action, Serializable {

	private static final long serialVersionUID = 6651364479513298126L;

	/**
	 * 用户业务接口类型的属性，用于Spring Ioc
	 */
	private UsersService mUsersService;

	/**
	 * 每页显示的条数属性
	 */
	private String rows;

	/**
	 * 当前页数属性
	 */
	private String page;

	/**
	 * 结果集属性
	 */
	private JSONObject jsonDatas;

	public void setmUsersService(UsersService mUsersService) {
		this.mUsersService = mUsersService;
	}

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

	/**
	 * 默认执行的方法
	 */
	@Override
	public String execute() throws Exception {
		jsonDatas = mUsersService.getAllUsersInfoBySplitPageService(
				Integer.parseInt(page), Integer.parseInt(rows));
		return ActionResult.SUCCESS.getType();
	}
}
