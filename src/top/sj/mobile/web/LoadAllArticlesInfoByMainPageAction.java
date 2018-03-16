/*
 * Project Name: SJBlog
 * Class Name: LoadAllArticlesInfoByMainPageAction.java
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
package top.sj.mobile.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jettison.json.JSONObject;

import com.opensymphony.xwork2.Action;

import top.sj.common.util.ActionResult;
import top.sj.entity.SjArticles;
import top.sj.mobile.responsebeans.ArticlesResponeBean;
import top.sj.mobile.service.ArticlesService;
import top.sj.mobile.util.ParameterCodecByMobilePlatformUtil;
import top.sj.tool.TimestampTool;

/**
 * 【移动平台】载入所有博文信息相关的Action
 * 
 * Create User: SteveJrong
 * Create Date: 2016年5月23日 下午19:42:10
 * Modify User: SteveJrong
 * Modify Date: 2016年5月23日 下午19:42:10
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class LoadAllArticlesInfoByMainPageAction implements Action, Serializable {

	private static final long serialVersionUID = -4864556638784794349L;

	/**
	 * 博文业务类型的接口，用于Spring Ioc
	 */
	private ArticlesService mobileArticlesService;

	public void setMobileArticlesService(ArticlesService mobileArticlesService) {
		this.mobileArticlesService = mobileArticlesService;
	}

	/**
	 * 结果集属性
	 */
	private Map<String, Object> responseResult;

	public Map<String, Object> getResponseResult() {
		return responseResult;
	}

	public void setResponseResult(Map<String, Object> responseResult) {
		this.responseResult = responseResult;
	}

	/**
	 * 默认执行的方法
	 */
	@Override
	public String execute() throws Exception {
		// 测试地址：http://localhost:8888/SJBlog/mobileLoadAllArticlesInfo.action?paramJsonDatas={"paramJsonDatas":1}
		JSONObject paramJsonDatas = new JSONObject(ParameterCodecByMobilePlatformUtil.parameterEcode("paramJsonDatas"));
		List<SjArticles> articles = mobileArticlesService.getAllArticlesInfoBySplitPageService(Integer.valueOf(paramJsonDatas.getString("paramJsonDatas")));
		responseResult = new HashMap<String, Object>();

		List<ArticlesResponeBean> resultEntities = new ArrayList<ArticlesResponeBean>();

		for (SjArticles sjArticles : articles) {
			ArticlesResponeBean articleBean = new ArticlesResponeBean();
			articleBean.setArticleId(sjArticles.getAId());
			articleBean.setArticleCreateDate(TimestampTool.toString(sjArticles.getACreatedate()));
			articleBean.setArticleName(sjArticles.getAName());
			resultEntities.add(articleBean);
		}

		responseResult.put("result", net.sf.json.JSONArray.fromObject(resultEntities));
//		System.out.println(responseResult);
		return ActionResult.SUCCESS.getType();
	}
}
