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
import java.util.List;

import top.sj.common.util.ActionResult;
import top.sj.entity.SjArticles;
import top.sj.entity.SjArticletypes;
import top.sj.entity.SjUsers;
import top.sj.manage.service.ArticlesService;
import top.sj.manage.service.UsersService;

import com.opensymphony.xwork2.Action;

/**
 * 载入博文详情信息相关的Action
 * 
 * Create User: SteveJrong
 * Create Date: 2016年10月27日 下午5:16:18
 * Modify User: SteveJrong
 * Modify Date: 2016年10月27日 下午5:16:18
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class LoadArticleDetailInfoAction implements Action, Serializable {
	
	private static final long serialVersionUID = -6214366950842648672L;

	/**
	 * 文章编号属性
	 */
	private Integer articleId;
	
	/**
	 * 文章业务接口类型的属性，用于Spring Ioc
	 */
	private ArticlesService mArticlesService;
	
	/**
	 * 文章属性
	 */
	private SjArticles articles;
	
	/**
	 * 文章类型集合属性
	 */
	private List<SjArticletypes> articletypes; 
	
	/**
	 * 用户集合属性
	 */
	private List<SjUsers> users;
	
	/**
	 * 用户业务类型的接口，用于Spring Ioc
	 */
	private UsersService mUsersService;

	public void setmUsersService(UsersService mUsersService) {
		this.mUsersService = mUsersService;
	}
	
	public List<SjUsers> getUsers() {
		return users;
	}

	public void setUsers(List<SjUsers> users) {
		this.users = users;
	}

	public void setmArticlesService(ArticlesService mArticlesService) {
		this.mArticlesService = mArticlesService;
	}
	
	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}
	
	public SjArticles getArticles() {
		return articles;
	}

	public void setArticles(SjArticles articles) {
		this.articles = articles;
	}
	
	public List<SjArticletypes> getArticletypes() {
		return articletypes;
	}

	public void setArticletypes(List<SjArticletypes> articletypes) {
		this.articletypes = articletypes;
	}

	/**
	 * 默认的执行方法
	 */
	@Override
	public String execute() throws Exception {
		articles = mArticlesService.getArticleInfoByArticleIdService(articleId);
		articletypes = mArticlesService.getArticleTypesInfoService();
		users = mUsersService.getAllAdminstratorsAccountService();
		return ActionResult.SUCCESS.getType();
	}
}
