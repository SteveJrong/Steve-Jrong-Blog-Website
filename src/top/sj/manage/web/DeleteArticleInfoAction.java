/*
 * Project Name: SJBlog
 * Class Name: DeleteArticleInfoAction.java
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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.json.JSONObject;
import top.sj.common.util.ActionResult;
import top.sj.manage.service.ArticlesService;

import com.opensymphony.xwork2.Action;

/**
 * 删除博文信息相关的Action
 * 
 * Create User: SteveJrong
 * Create Date: 2016年3月26日 下午3:21:00
 * Modify User: SteveJrong
 * Modify Date: 2016年3月26日 下午3:21:00
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class DeleteArticleInfoAction implements Action, Serializable {

	private static final long serialVersionUID = 2131679963379106254L;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DeleteArticleInfoAction.class);

	/**
	 * 文章业务接口类型的属性，用于Spring Ioc
	 */
	private ArticlesService mArticlesService;

	public void setmArticlesService(ArticlesService mArticlesService) {
		this.mArticlesService = mArticlesService;
	}

	/**
	 * 处理结果属性
	 */
	private JSONObject jsonDatas;

	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	/**
	 * 文章编号属性
	 */
	private Integer articleId;

	public JSONObject getJsonDatas() {
		return jsonDatas;
	}

	public void setJsonDatas(JSONObject jsonDatas) {
		this.jsonDatas = jsonDatas;
	}

	@Override
	public String execute() throws Exception {

		Map<String, String> map = new HashMap<String, String>();

		if (mArticlesService.delArticleInfoByIdService(articleId)) {
			map.put("result", "success");
			jsonDatas = JSONObject.fromObject(map);
		} else {
			map.put("result", "failed");
			jsonDatas = JSONObject.fromObject(map);
		}

		LOGGER.info(" -- "+jsonDatas+" -- ");

		return ActionResult.SUCCESS.getType();
	}
}
