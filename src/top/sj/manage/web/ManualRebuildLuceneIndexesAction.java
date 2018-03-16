/*
 * Project Name: SJBlog
 * Class Name: ManualRebuildLuceneIndexesAction.java
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
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import top.sj.common.util.ActionResult;
import top.sj.entity.SjArticles;
import top.sj.lucene.LuceneIndexesUtil;
import top.sj.service.ArticlesService;

import com.opensymphony.xwork2.Action;

/**
 * 手动重建索引相关的Action
 * 
 * Create User: SteveJrong
 * Create Date: 2016年10月10日 下午5:55:08
 * Modify User: SteveJrong
 * Modify Date: 2016年10月10日 下午5:55:08
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class ManualRebuildLuceneIndexesAction implements Action,Serializable {
	
	private static final long serialVersionUID = -8790056723637645186L;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ManualRebuildLuceneIndexesAction.class);
	
	/**
	 * 博文业务接口类型的属性，用于Spring Ioc
	 */
	private ArticlesService articlesService;

	public void setArticlesService(ArticlesService articlesService) {
		this.articlesService = articlesService;
	}
	
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
	public String execute() {
		Map<String, String> map = new HashMap<String, String>();
		List<SjArticles> articles = articlesService.getArticlesInfoByBuildLuceneIndexesService();

		String[][] datas = new String[articles.size()][8];

		for (int i = 0; i < articles.size(); i++) {
			datas[i][0] = "AId";
			datas[i][1] = articles.get(i).getAId().toString();
			datas[i][2] = "ABriefcontents";
			datas[i][3] = articles.get(i).getABriefcontents()
					.toString();
			datas[i][4] = "ABodycontents";
			datas[i][5] = articles.get(i).getABodycontents()
					.toString();
			datas[i][6] = "AName";
			datas[i][7] = articles.get(i).getAName().toString();
		}

		try {
			LuceneIndexesUtil.buildFileIndexes(datas);
			map.put("result", "success");
			LOGGER.info("Manual rebuild full text search indexes was been successed!");
		} catch (Exception e) {
			map.put("result", "failed");
			LOGGER.error("Manual rebuild full text search indexes was been failed!");
		}
		jsonDatas = JSONObject.fromObject(map);
		return ActionResult.SUCCESS.getType();
	}
}
