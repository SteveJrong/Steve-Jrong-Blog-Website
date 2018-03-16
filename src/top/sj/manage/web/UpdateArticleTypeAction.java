/*
 * Project Name: SJBlog
 * Class Name: UpdateArticleTypeAction.java
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
import top.sj.manage.service.ArticleTypesService;

import com.opensymphony.xwork2.Action;

/**
 * 修改博文类型信息相关的Action
 * 
 * Create User: SteveJrong
 * Create Date: 2016年3月27日 下午1:18:30
 * Modify User: SteveJrong
 * Modify Date: 2016年3月27日 下午1:18:30
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class UpdateArticleTypeAction implements Action, Serializable {

	private static final long serialVersionUID = 8834556332703182490L;

	/**
	 * 博文类型编号属性
	 */
	private Integer id;

	/**
	 * 博文类型名称属性
	 */
	private String name;

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

	/**
	 * 博文类型业务类型接口，用于Spring Ioc
	 */
	private ArticleTypesService mArticleTypesService;

	public void setmArticleTypesService(ArticleTypesService mArticleTypesService) {
		this.mArticleTypesService = mArticleTypesService;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 默认执行的方法
	 */
	@Override
	public String execute() throws Exception {
		Map<String, String> map = new HashMap<String, String>();

		if (mArticleTypesService
				.updateArticleTypeInfoByTypeIdAndTypeNameService(id, name)) {
			map.put("result", "success");
			jsonDatas = JSONObject.fromObject(map);
		} else {
			map.put("result", "failed");
			jsonDatas = JSONObject.fromObject(map);
		}

		return ActionResult.SUCCESS.getType();
	}
}
