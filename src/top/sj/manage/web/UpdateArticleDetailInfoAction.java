/*
 * Project Name: SJBlog
 * Class Name: UpdateArticleDetailInfoAction.java
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

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import top.sj.common.util.ActionResult;
import top.sj.entity.SjArticles;
import top.sj.manage.service.ArticleTypesService;
import top.sj.manage.service.ArticlesService;
import top.sj.service.UserService;
import top.sj.tool.ReverseProxyIPInfoTool;
import top.sj.tool.TimestampTool;

import com.opensymphony.xwork2.Action;

/**
 * 更新博文详情信息相关的Action
 * 
 * Create User: SteveJrong
 * Create Date: 2016年10月28日 下午2:13:10
 * Modify User: SteveJrong
 * Modify Date: 2016年10月28日 下午2:13:10
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class UpdateArticleDetailInfoAction implements Action, Serializable {
	
	private static final long serialVersionUID = -6214366950842648672L;

	/**
	 * 文章编号属性
	 */
	private Integer articleId;
	
	/**
	 * 博文名称属性
	 */
	private String aname;
	
	/**
	 * 博文类型属性
	 */
	private String atype;
	
	/**
	 * 博文发布者属性
	 */
	private String apublisher;
	
	/**
	 * 博文关键字属性
	 */
	private String atag;
	
	/**
	 * 是否置顶属性
	 */
	private String atop;
	
	/**
	 * 博文简略介绍属性
	 */
	private String abrief;
	
	/**
	 * 博文正文内容属性
	 */
	private String content;
	
	/**
	 * 博文业务接口类型的属性，用于Spring Ioc
	 */
	private ArticlesService mArticlesService;
	
	/**
	 * 博文类型业务接口类型的属性，用于Spring Ioc
	 */
	private ArticleTypesService mArticleTypesService;
	
	/**
	 * 用户接口类型的属性，用于Spring Ioc
	 */
	private UserService userService;
	
	public void setmArticleTypesService(ArticleTypesService mArticleTypesService) {
		this.mArticleTypesService = mArticleTypesService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
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

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getAtype() {
		return atype;
	}

	public void setAtype(String atype) {
		this.atype = atype;
	}

	public String getApublisher() {
		return apublisher;
	}

	public void setApublisher(String apublisher) {
		this.apublisher = apublisher;
	}

	public String getAtag() {
		return atag;
	}

	public void setAtag(String atag) {
		this.atag = atag;
	}

	public String getAtop() {
		return atop;
	}

	public void setAtop(String atop) {
		this.atop = atop;
	}

	public String getAbrief() {
		return abrief;
	}

	public void setAbrief(String abrief) {
		this.abrief = abrief;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * 默认的执行方法
	 */
	@Override
	public String execute() throws Exception {
		SjArticles article = mArticlesService.getArticleInfoByArticleIdService(articleId);
		article.setABodycontents(content);
		article.setABriefcontents(abrief);
		article.setAHoldtop(StringUtils.isNotEmpty(atop) && atop.equals("on") ? Short.valueOf("1"): Short.valueOf("0"));
		article.setAIpaddress(ReverseProxyIPInfoTool.getClientIP(ServletActionContext.getRequest()));
		article.setAModifydate(TimestampTool.convertNowDateToStimeStamp());
		article.setAName(aname);
		article.setATagkeyword(atag);
		article.setSjArticletypes(mArticleTypesService.getSingleArticleTypeInfoByIdService(Integer.valueOf(atype)));
		article.setSjUsers(userService.getUserInfoByIdService(Integer.valueOf(apublisher)));
		if (mArticlesService.updateArticleInfoService(article)) {
			return ActionResult.SUCCESS.getType();
		}else {
			return ActionResult.FAILED.getType();
		}
	}
}
