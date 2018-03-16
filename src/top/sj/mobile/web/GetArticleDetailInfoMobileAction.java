/*
 * Project Name: SJBlog
 * Class Name: GetArticleDetailInfoMobileAction.java
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

import org.codehaus.jettison.json.JSONObject;

import top.sj.entity.SjArticles;
import top.sj.mobile.service.ArticlesService;
import top.sj.mobile.util.MobileActionResult;
import top.sj.mobile.util.ParameterCodecByMobilePlatformUtil;

import com.opensymphony.xwork2.Action;

/**
 * 【移动平台】获取博文详情信息的Action
 * 
 * Create User: SteveJrong
 * Create Date: 2016年5月28日 上午10:36:11
 * Modify User: SteveJrong
 * Modify Date: 2016年5月28日 上午10:36:11
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class GetArticleDetailInfoMobileAction implements Action, Serializable {

	private static final long serialVersionUID = 1084780773048022824L;

	/**
	 * 博文业务类型的接口，用于Spring Ioc
	 */
	private ArticlesService mobileArticlesService;

	public void setMobileArticlesService(ArticlesService mobileArticlesService) {
		this.mobileArticlesService = mobileArticlesService;
	}

	/**
	 * 文章类型的属性
	 */
	private SjArticles article;
	
	public SjArticles getArticle() {
		return article;
	}

	public void setArticle(SjArticles article) {
		this.article = article;
	}
	
	/**
	 * 是否开启夜间模式
	 */
	private String enableNightMode;

	public String getEnableNightMode() {
		return enableNightMode;
	}

	public void setEnableNightMode(String enableNightMode) {
		this.enableNightMode = enableNightMode;
	}

	/**
	 * 默认执行的方法
	 */
	@Override
	public String execute() throws Exception {
		//入参：是否开启夜间模式的标识符、文章ID
		// 测试地址：http://localhost:8888/SJBlog/mobileGetArticleDetailInfo.action?paramJsonDatas={"enableNightMode":true,"articleId":1}
		JSONObject paramJsonDatas = new JSONObject(ParameterCodecByMobilePlatformUtil.parameterEcode("paramJsonDatas"));
		article = mobileArticlesService.getArticleDetailInfoService(Integer.valueOf(paramJsonDatas.getString("articleId")));
		enableNightMode = paramJsonDatas.getString("enableNightMode");
		return MobileActionResult.MOBILE_ARTICLE_DETAIL.getType();
	}
}
