/*
 * Project Name: SJBlog
 * Class Name: AddNewArticleInfoAction.java
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
import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.struts2.ServletActionContext;

import top.sj.common.util.ActionResult;
import top.sj.common.util.Constants;
import top.sj.entity.SjArticles;
import top.sj.entity.SjArticletypes;
import top.sj.entity.SjFileAttachments;
import top.sj.entity.SjUsers;
import top.sj.manage.dto.FileattachmentsTempUploadDTO;
import top.sj.manage.service.ArticleTypesService;
import top.sj.manage.service.ArticlesService;
import top.sj.manage.service.UsersService;
import top.sj.manage.util.FileAttachmentsTempUploadManageUtil;
import top.sj.tool.ReverseProxyIPInfoTool;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 新增博文信息相关的Action
 * 
 * Create User: SteveJrong
 * Create Date: 2016年3月25日 下午11:48:45
 * Modify User: SteveJrong
 * Modify Date: 2016年3月25日 下午11:48:45
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class AddNewArticleInfoAction extends ActionSupport implements
		Serializable {
	
	private static final long serialVersionUID = 3609538168727111215L;

	/**
	 * 文章业务类型的接口，用于Spring Ioc
	 */
	private ArticlesService mArticlesService;

	public void setmArticlesService(ArticlesService mArticlesService) {
		this.mArticlesService = mArticlesService;
	}

	/**
	 * 文章类型业务接口，用于Spring Ioc
	 */
	private ArticleTypesService mArticleTypesService;

	public void setmArticleTypesService(ArticleTypesService mArticleTypesService) {
		this.mArticleTypesService = mArticleTypesService;
	}

	/**
	 * 用户业务接口类型的属性，用于Spring Ioc
	 */
	private UsersService mUsersService;

	public void setmUsersService(UsersService mUsersService) {
		this.mUsersService = mUsersService;
	}

	/**
	 * 博文名称属性
	 */
	private String aname;

	/**
	 * 博文类型编号属性
	 */
	private String atype;

	/**
	 * 博文发布者编号属性
	 */
	private String apublisher;

	/**
	 * 博文关键字属性
	 */
	private String atag;

	/**
	 * 博文置顶属性
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
	 * 发布博文时的浏览器信息属性
	 */
	private String browser;

	/**
	 * 发布博文时的操作系统信息属性
	 */
	private String system;

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

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	/**
	 * 默认执行的方法
	 */
	@SuppressWarnings("unchecked")
	@Override
	public synchronized String execute() throws Exception {

		SjArticletypes articletypes = mArticleTypesService
				.getSingleArticleTypeInfoByIdService(Integer.parseInt(atype));

		SjUsers sjUsers = mUsersService.getSingleUserInfoByIdService(Integer
				.parseInt(apublisher));

		SjArticles articles = new SjArticles();
		articles.setAAttachfilespath(null);
		articles.setABodycontents(content);
		articles.setABriefcontents(abrief);
		articles.setABrowserinfo(browser);
		articles.setACreatedate(new Timestamp(System.currentTimeMillis()));
		articles.setAHoldtop(null != atop && atop.equals("on") ? Short
				.parseShort("1") : Short.parseShort("0"));
		articles.setAIpaddress(ReverseProxyIPInfoTool.getClientIP(ServletActionContext.getRequest()));
		articles.setAModifydate(null);
		articles.setAName(aname);
		articles.setAReadcount(0L);
		articles.setAState(Constants.USER_STATE_OF_NORMAL.getValue());
		articles.setASysteminfo(system);
		articles.setATagkeyword(atag);
		articles.setSjArticletypes(articletypes);
		articles.setSjUsers(sjUsers);
		
		List<FileattachmentsTempUploadDTO> fileattachmentsTempUploadDTOs = FileAttachmentsTempUploadManageUtil.getFileattachmentsTempUploadDTOs();
		
		//保存文件附件信息
		//如果集合不为空，则进行处理
		if (CollectionUtils.isNotEmpty(fileattachmentsTempUploadDTOs)) {
			for (FileattachmentsTempUploadDTO ftItem : fileattachmentsTempUploadDTOs) {
				SjFileAttachments fileAttachment = new SjFileAttachments();
				fileAttachment.setFaCreateDate(ftItem.getCreateDate());
				fileAttachment.setFaDowmloadCount(ftItem.getDownloadCount());
				fileAttachment.setFaEnableDownload(ftItem.getEnableDownload());
				fileAttachment.setFaFileFormat(ftItem.getFileFmt());
				fileAttachment.setFaFilePath(ftItem.getFilePath());
				fileAttachment.setFaMd5Var(ftItem.getMD5Value());
				fileAttachment.setFaModifyDate(ftItem.getModifyDate());
				fileAttachment.setSjArticles(articles);
				
				//添加此文件附件对象
				articles.getSjFileAttachmentses().add(fileAttachment);
			}
			//执行成功之后清除集合
			FileAttachmentsTempUploadManageUtil.getFileattachmentsTempUploadDTOs().clear();
		}

		return mArticlesService.addNewArticlesInfoService(articles) == true ? ActionResult.SUCCESS
				.getType() : ActionResult.FAILED.getType();

	}
}
