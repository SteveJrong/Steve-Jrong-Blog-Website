/*
 * Project Name: SJBlog
 * Class Name: LoadArticlesInfoAtHomePageAction.java
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
package top.sj.web;

import java.io.Serializable;
import java.util.List;

import top.sj.common.util.ActionResult;
import top.sj.entity.SjArticles;
import top.sj.entity.SjArticletypes;
import top.sj.service.ArticleTypesService;
import top.sj.service.ArticlesService;
import top.sj.util.ArchiveArticlesInfoEntity;

import com.opensymphony.xwork2.Action;

/**
 * 载入主页的文章信息相关的Action
 * 
 * Create User: SteveJrong
 * Create Date: 2016年2月17日 下午3:24:27
 * Modify User: SteveJrong
 * Modify Date: 2016年2月17日 下午3:24:27
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class LoadArticlesInfoAtHomePageAction implements Action, Serializable {

	/**
	 * 
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = -5058461655594436826L;

	/**
	 * 文章业务接口类型的属性，用于Spring Ioc
	 */
	private ArticlesService articlesService;

	/**
	 * 文章类型业务接口类型的属性，用于Spring Ioc
	 */
	private ArticleTypesService articleTypesService;

	public void setArticleTypesService(ArticleTypesService articleTypesService) {
		this.articleTypesService = articleTypesService;
	}

	/**
	 * 页面中部文章信息集合属性
	 */
	private List<SjArticles> articles;

	/**
	 * 页面右部“最近更新”栏目文章链接集合属性
	 */
	private List<SjArticles> recentUpdatesArticlesLinks;

	/**
	 * 页面右中部“文章归档”集合属性
	 */
	private List<ArchiveArticlesInfoEntity> articlesInfoEntities;

	/**
	 * 页面右下部“类别”集合属性
	 */
	private List<SjArticletypes> articletypes;

	public List<SjArticletypes> getArticletypes() {
		return articletypes;
	}

	public void setArticletypes(List<SjArticletypes> articletypes) {
		this.articletypes = articletypes;
	}

	public List<ArchiveArticlesInfoEntity> getArticlesInfoEntities() {
		return articlesInfoEntities;
	}

	public void setArticlesInfoEntities(
			List<ArchiveArticlesInfoEntity> articlesInfoEntities) {
		this.articlesInfoEntities = articlesInfoEntities;
	}

	public List<SjArticles> getRecentUpdatesArticlesLinks() {
		return recentUpdatesArticlesLinks;
	}

	public void setRecentUpdatesArticlesLinks(
			List<SjArticles> recentUpdatesArticlesLinks) {
		this.recentUpdatesArticlesLinks = recentUpdatesArticlesLinks;
	}

	public List<SjArticles> getArticles() {
		return articles;
	}

	public void setArticles(List<SjArticles> articles) {
		this.articles = articles;
	}

	public void setArticlesService(ArticlesService articlesService) {
		this.articlesService = articlesService;
	}

	/**
	 * 默认执行的方法
	 */
	@Override
	public String execute() throws Exception {
		articles = articlesService.getArticlesBriefInfoOfTopFiveService();
		recentUpdatesArticlesLinks = articlesService
				.getRecentUpdatesLinkInfoService();
		articlesInfoEntities = articlesService
				.getAccordingToDateForArchiveArticleInfoService();
		articletypes = articleTypesService.getArticleTypeInfoService();
		if (articles.size() != 0 && recentUpdatesArticlesLinks.size() != 0
				&& articletypes.size() != 0) {
			return ActionResult.SUCCESS.getType();
		} else {
			return ActionResult.NULL.getType();
		}
	}
}
