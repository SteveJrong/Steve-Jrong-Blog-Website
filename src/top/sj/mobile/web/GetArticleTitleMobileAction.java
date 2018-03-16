/*
 * Project Name: SJBlog
 * Class Name: GetArticleTitleMobileAction.java
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
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.codehaus.jettison.json.JSONObject;

import top.sj.common.util.ActionResult;
import top.sj.entity.SjArticles;
import top.sj.mobile.service.ArticlesService;
import top.sj.mobile.util.ParameterCodecByMobilePlatformUtil;

import com.opensymphony.xwork2.Action;

/**
 * 【移动平台】获取博文标题的Action
 * 
 * Create User: SteveJrong
 * Create Date: 2016年10月13日 下午5:55:47
 * Modify User: SteveJrong
 * Modify Date: 2016年10月13日 下午5:55:47
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class GetArticleTitleMobileAction implements Action, Serializable {

	private static final long serialVersionUID = 1084780773048022824L;

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
		// 测试地址：http://localhost:8888/SJBlog/mobileGetArticleTitle.action?paramJsonDatas={"articleId":1}
		JSONObject paramJsonDatas = new JSONObject(ParameterCodecByMobilePlatformUtil.parameterEcode("paramJsonDatas"));
		SjArticles article = mobileArticlesService.getArticleDetailInfoService(Integer.valueOf(paramJsonDatas.getString("articleId")));
		responseResult = new ConcurrentHashMap<String, Object>();
		responseResult.put("result", article.getAName());
		return ActionResult.SUCCESS.getType();
	}
}
