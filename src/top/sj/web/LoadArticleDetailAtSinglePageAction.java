/*
 * Project Name: SJBlog
 * Class Name: LoadArticleDetailAtSinglePageAction.java
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
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import top.sj.common.util.ActionResult;
import top.sj.entity.SjArticles;
import top.sj.entity.SjArticletypes;
import top.sj.entity.SjFileAttachments;
import top.sj.entity.SjLeavemessages;
import top.sj.inputscope.SessionScope;
import top.sj.manage.dto.FileAttachmentsOfArticleDTO;
import top.sj.service.ArticleTypesService;
import top.sj.service.ArticlesService;
import top.sj.service.CommentsOrReplyService;
import top.sj.service.FileAttachmentsService;
import top.sj.tool.FileTool;
import top.sj.tool.ProjectPropertiesTool;
import top.sj.tool.ReverseProxyIPInfoTool;
import top.sj.util.ArchiveArticlesInfoEntity;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

/**
 * 载入文章详情页的文章信息相关的Action
 * 
 * Create User: SteveJrong
 * Create Date: 2016年2月27日 下午7:58:09
 * Modify User: SteveJrong
 * Modify Date: 2016年2月27日 下午7:58:09
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class LoadArticleDetailAtSinglePageAction implements Action,
		Serializable {
	private static final long serialVersionUID = 6217808509310968922L;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoadArticleDetailAtSinglePageAction.class);

	/**
	 * 文章业务接口类型的属性，用于Spring Ioc
	 */
	private ArticlesService articlesService;

	/**
	 * 评论/回复业务接口类型的属性，用于Spring Ioc
	 */
	private CommentsOrReplyService commentsOrReplyService;

	/**
	 * 文章类型业务接口类型的属性，用于Spring Ioc
	 */
	private ArticleTypesService articleTypesService;

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
	
	/**
	 * 文章编号属性
	 */
	private Integer aid;

	/**
	 * 文章实体类型的属性
	 */
	private SjArticles article;

	/**
	 * 是否登录的标识符（true-已登录；false-未登录）
	 */
	private Boolean isLogin;

	/**
	 * 此文章的互动信息集合结果集属性
	 */
	private List<SjLeavemessages> thisArticleCOrRs;
	
	/**
	 * 文件附件业务接口类型的属性，用于Spring Ioc
	 */
	private FileAttachmentsService fileAttachmentsService;
	
	/**
	 * 此博文所有文件附件集合属性
	 */
	private List<FileAttachmentsOfArticleDTO> fileAttachmentsOfArticleDTOs = new ArrayList<FileAttachmentsOfArticleDTO>();
	
	public void setFileAttachmentsService(
			FileAttachmentsService fileAttachmentsService) {
		this.fileAttachmentsService = fileAttachmentsService;
	}

	public List<FileAttachmentsOfArticleDTO> getFileAttachmentsOfArticleDTOs() {
		return fileAttachmentsOfArticleDTOs;
	}

	public void setFileAttachmentsOfArticleDTOs(
			List<FileAttachmentsOfArticleDTO> fileAttachmentsOfArticleDTOs) {
		this.fileAttachmentsOfArticleDTOs = fileAttachmentsOfArticleDTOs;
	}
	
	public void setCommentsOrReplyService(
			CommentsOrReplyService commentsOrReplyService) {
		this.commentsOrReplyService = commentsOrReplyService;
	}
	
	public List<SjLeavemessages> getThisArticleCOrRs() {
		return thisArticleCOrRs;
	}

	public void setThisArticleCOrRs(List<SjLeavemessages> thisArticleCOrRs) {
		this.thisArticleCOrRs = thisArticleCOrRs;
	}

	public Boolean getIsLogin() {
		return isLogin;
	}

	public void setIsLogin(Boolean isLogin) {
		this.isLogin = isLogin;
	}

	public SjArticles getArticle() {
		return article;
	}

	public void setArticle(SjArticles article) {
		this.article = article;
	}

	public Integer getAid() {
		return aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public void setArticlesService(ArticlesService articlesService) {
		this.articlesService = articlesService;
	}

	public List<SjArticles> getRecentUpdatesArticlesLinks() {
		return recentUpdatesArticlesLinks;
	}

	public void setRecentUpdatesArticlesLinks(
			List<SjArticles> recentUpdatesArticlesLinks) {
		this.recentUpdatesArticlesLinks = recentUpdatesArticlesLinks;
	}

	public List<ArchiveArticlesInfoEntity> getArticlesInfoEntities() {
		return articlesInfoEntities;
	}

	public void setArticlesInfoEntities(
			List<ArchiveArticlesInfoEntity> articlesInfoEntities) {
		this.articlesInfoEntities = articlesInfoEntities;
	}

	public List<SjArticletypes> getArticletypes() {
		return articletypes;
	}

	public void setArticletypes(List<SjArticletypes> articletypes) {
		this.articletypes = articletypes;
	}

	public void setArticleTypesService(ArticleTypesService articleTypesService) {
		this.articleTypesService = articleTypesService;
	}

	/**
	 * 默认执行的方法
	 */
	@Override
	public String execute() throws Exception {
		recentUpdatesArticlesLinks = articlesService
				.getRecentUpdatesLinkInfoService();
		articlesInfoEntities = articlesService
				.getAccordingToDateForArchiveArticleInfoService();
		articletypes = articleTypesService.getArticleTypeInfoService();
		article = articlesService.getArticleDetailByArticleIdService(aid);
		thisArticleCOrRs = commentsOrReplyService
				.getAllCOrRInfoByArticleIdService(aid);
		List<SjFileAttachments> fileAttachments = fileAttachmentsService.getAllFilesByArticleIdService(aid);

		if (CollectionUtils.isNotEmpty(fileAttachmentsOfArticleDTOs) && fileAttachmentsOfArticleDTOs.size() > 0) {
			fileAttachmentsOfArticleDTOs.clear();
		}
		
		for (SjFileAttachments faItem : fileAttachments) {
			FileAttachmentsOfArticleDTO faDTO = new FileAttachmentsOfArticleDTO();
			faDTO.setFileId(faItem.getFaId());
			faDTO.setFilePath(ProjectPropertiesTool.getProjHttpRootUrl(ServletActionContext.getRequest()).concat(faItem.getFaFilePath()));
			faDTO.setFileShortName(faItem.getFaFilePath().substring(faItem.getFaFilePath().lastIndexOf("/")+1).length() > 25 ? faItem.getFaFilePath().substring(faItem.getFaFilePath().lastIndexOf("/")+1,faItem.getFaFilePath().lastIndexOf("/")+25) : faItem.getFaFilePath().substring(faItem.getFaFilePath().lastIndexOf("/")+1));
			faDTO.setFileFullName(faItem.getFaFilePath().substring(faItem.getFaFilePath().lastIndexOf("/")+1));
			faDTO.setFileMD5Value(faItem.getFaMd5Var());
			faDTO.setFileExists(FileTool.checkFileExists(ProjectPropertiesTool.getProjLocalRootUrl(ServletActionContext.getRequest()).concat(faItem.getFaFilePath())));
			faDTO.setNeedShortMode(faItem.getFaFilePath().substring(faItem.getFaFilePath().lastIndexOf("/")+1).length() > 25 ? Boolean.TRUE : Boolean.FALSE);
			fileAttachmentsOfArticleDTOs.add(faDTO);
			LOGGER.info("本地文件路径："+ProjectPropertiesTool.getProjLocalRootUrl(ServletActionContext.getRequest()).concat(faItem.getFaFilePath()));
			LOGGER.info("文件状态："+FileTool.checkFileExists(ProjectPropertiesTool.getProjLocalRootUrl(ServletActionContext.getRequest()).concat(faItem.getFaFilePath())));
		}
		
		//处理评论/回复信息点赞数为0时显示空值的问题
		for (SjLeavemessages lm : thisArticleCOrRs) {
			if (null == lm.getMPraisecount() || lm.getMPraisecount() <= 0) {
				lm.setMPraisecount(0);
			}
		}
		
		if (null == SessionScope.getUserEntityInfoOnSessionScope()) {
			isLogin = false;
		} else {
			isLogin = true;
		}
		
		ActionContext.getContext().getValueStack().set("articleId", aid);
		ActionContext.getContext().getValueStack().set("guestIP", ReverseProxyIPInfoTool.getClientIP(ServletActionContext.getRequest()));

		if (null != article) {
			return ActionResult.SUCCESS.getType();
		} else {
			return ActionResult.NULL.getType();
		}
	}
}
