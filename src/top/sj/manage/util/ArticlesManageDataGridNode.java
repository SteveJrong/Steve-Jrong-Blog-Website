/*
 * Project Name: SJBlog
 * Class Name: ArticlesManageDataGridNode.java
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
package top.sj.manage.util;

/**
 * 博文信息管理的DataGrid实体类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年3月23日 上午10:34:40
 * Modify User: SteveJrong
 * Modify Date: 2016年3月23日 上午10:34:40
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class ArticlesManageDataGridNode {
	/**
	 * 博文编号属性
	 */
	private Integer articleId;

	/**
	 * 博文标题属性
	 */
	private String articleTitle;

	/**
	 * 博文创建时间属性
	 */
	private String articleCreateDateTime;

	/**
	 * 博文修改时间属性
	 */
	private String articleModifyDateTime;

	/**
	 * 博文类型属性
	 */
	private String articleType;

	/**
	 * 博文创建人属性
	 */
	private String articleUser;
	
	/**
	 * 博文发表时的浏览器信息属性
	 */
	private String browserInfo;
	
	/**
	 * 博文发表时的操作系统信息属性
	 */
	private String systemInfo;
	
	/**
	 * 此博文的附件总数属性
	 */
	private Integer fileAttachemntsTotalCount;
	
	/**
	 * 博文状态属性
	 */
	private String state;
	
	/**
	 * 博文关键字属性
	 */
	private String keywords;
	
	/**
	 * 博文发布时的IP地址属性
	 */
	private String publishedIpAddress;

	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	public String getArticleTitle() {
		return articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	public String getArticleCreateDateTime() {
		return articleCreateDateTime;
	}

	public void setArticleCreateDateTime(String articleCreateDateTime) {
		this.articleCreateDateTime = articleCreateDateTime;
	}

	public String getArticleModifyDateTime() {
		return articleModifyDateTime;
	}

	public void setArticleModifyDateTime(String articleModifyDateTime) {
		this.articleModifyDateTime = articleModifyDateTime;
	}

	public String getArticleType() {
		return articleType;
	}

	public void setArticleType(String articleType) {
		this.articleType = articleType;
	}

	public String getArticleUser() {
		return articleUser;
	}

	public void setArticleUser(String articleUser) {
		this.articleUser = articleUser;
	}

	public String getBrowserInfo() {
		return browserInfo;
	}

	public void setBrowserInfo(String browserInfo) {
		this.browserInfo = browserInfo;
	}

	public String getSystemInfo() {
		return systemInfo;
	}

	public void setSystemInfo(String systemInfo) {
		this.systemInfo = systemInfo;
	}

	public Integer getFileAttachemntsTotalCount() {
		return fileAttachemntsTotalCount;
	}

	public void setFileAttachemntsTotalCount(Integer fileAttachemntsTotalCount) {
		this.fileAttachemntsTotalCount = fileAttachemntsTotalCount;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getPublishedIpAddress() {
		return publishedIpAddress;
	}

	public void setPublishedIpAddress(String publishedIpAddress) {
		this.publishedIpAddress = publishedIpAddress;
	}
	
	public ArticlesManageDataGridNode(Integer articleId, String articleTitle,
			String articleCreateDateTime, String articleModifyDateTime,
			String articleType, String articleUser, String browserInfo,
			String systemInfo, Integer fileAttachemntsTotalCount, String state,
			String keywords, String publishedIpAddress) {
		super();
		this.articleId = articleId;
		this.articleTitle = articleTitle;
		this.articleCreateDateTime = articleCreateDateTime;
		this.articleModifyDateTime = articleModifyDateTime;
		this.articleType = articleType;
		this.articleUser = articleUser;
		this.browserInfo = browserInfo;
		this.systemInfo = systemInfo;
		this.fileAttachemntsTotalCount = fileAttachemntsTotalCount;
		this.state = state;
		this.keywords = keywords;
		this.publishedIpAddress = publishedIpAddress;
	}

	public ArticlesManageDataGridNode() {
	}
}
