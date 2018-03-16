/*
 * Project Name: SJBlog
 * Class Name: LoadAllArticlesInfoAction.java
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
import top.sj.manage.service.ArticleTypesService;

import com.opensymphony.xwork2.Action;

/**
 * 载入所有博文类型信息相关的Action
 * 
 * Create User: SteveJrong
 * Create Date: 2016年3月23日 上午10:49:46
 * Modify User: SteveJrong
 * Modify Date: 2016年3月23日 上午10:49:46
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class LoadAllArticleTypesInfoAction implements Action, Serializable {

	private static final long serialVersionUID = -8825878550590683424L;

	/**
	 * 博文类型业务接口类型的属性，用于Spring Ioc
	 */
	private ArticleTypesService mArticleTypesService;

	public void setmArticleTypesService(ArticleTypesService mArticleTypesService) {
		this.mArticleTypesService = mArticleTypesService;
	}

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

	/**
	 * 默认的执行方法
	 */
	@Override
	public String execute() throws Exception {
		jsonDatas = mArticleTypesService.getAllArticleTypesInfoService(
				new Integer(page).intValue(), new Integer(rows).intValue());

		return ActionResult.SUCCESS.getType();
	}
}
