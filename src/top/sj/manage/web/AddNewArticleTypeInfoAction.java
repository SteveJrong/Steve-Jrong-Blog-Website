/*
 * Project Name: SJBlog
 * Class Name: .java
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
 * 新增博文类型信息相关的Action
 * 
 * Create User: SteveJrong
 * Create Date: 2016年3月27日 下午2:13:02
 * Modify User: SteveJrong
 * Modify Date: 2016年3月27日 下午2:13:02
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class AddNewArticleTypeInfoAction implements Action, Serializable {

	private static final long serialVersionUID = -5007828177571227007L;

	/**
	 * 博文类型名称属性
	 */
	private String newatype;

	/**
	 * 博文类型业务接口，用于Spring Ioc
	 */
	private ArticleTypesService mArticleTypesService;

	/**
	 * 结果集属性
	 */
	private JSONObject jsonDatas;

	public JSONObject getJsonDatas() {
		return jsonDatas;
	}

	public void setJsonDatas(JSONObject jsonDatas) {
		this.jsonDatas = jsonDatas;
	}

	public String getNewatype() {
		return newatype;
	}

	public void setNewatype(String newatype) {
		this.newatype = newatype;
	}

	public void setmArticleTypesService(ArticleTypesService mArticleTypesService) {
		this.mArticleTypesService = mArticleTypesService;
	}

	/**
	 * 默认执行的方法
	 */
	@Override
	public String execute() throws Exception {
		Map<String, String> map = new HashMap<String, String>();

		if (mArticleTypesService.addNewArticleTypeInfoService(newatype)) {
			map.put("result", "success");
			jsonDatas = JSONObject.fromObject(map);
		} else {
			map.put("result", "failed");
			jsonDatas = JSONObject.fromObject(map);
		}

		System.out.println(jsonDatas);

		return ActionResult.SUCCESS.getType();
	}
}
