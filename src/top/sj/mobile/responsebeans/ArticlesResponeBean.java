/*
 * Project Name: SJBlog
 * Class Name: MainPageResponeBean.java
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
package top.sj.mobile.responsebeans;

import java.io.Serializable;

/**
 * 【移动平台】博文DTO Bean
 * 
 * Create User: SteveJrong
 * Create Date: 2016年5月24日 下午8:23:34
 * Modify User: SteveJrong
 * Modify Date: 2016年5月24日 下午8:23:34
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class ArticlesResponeBean implements Serializable {
	private static final long serialVersionUID = 4207199898070804268L;

	/**
	 * 博文编号属性
	 */
	private Integer articleId;

	/**
	 * 博文创建时间属性
	 */
	private String articleCreateDate;

	/**
	 * 博文名称属性
	 */
	private String articleName;

	/**
	 * 博文发布者属性
	 */
	private String articleAuthor;

	/**
	 * 博文类型属性
	 */
	private String articleType;

	/**
	 * 博文内容属性
	 */
	private String articleContent;

	public String getArticleAuthor() {
		return articleAuthor;
	}

	public void setArticleAuthor(String articleAuthor) {
		this.articleAuthor = articleAuthor;
	}

	public String getArticleType() {
		return articleType;
	}

	public void setArticleType(String articleType) {
		this.articleType = articleType;
	}

	public String getArticleContent() {
		return articleContent;
	}

	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}

	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	public String getArticleCreateDate() {
		return articleCreateDate;
	}

	public void setArticleCreateDate(String articleCreateDate) {
		this.articleCreateDate = articleCreateDate;
	}

	public String getArticleName() {
		return articleName;
	}

	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}

	public ArticlesResponeBean(Integer articleId, String articleCreateDate, String articleName, String articleAuthor,
			String articleType, String articleContent) {
		super();
		this.articleId = articleId;
		this.articleCreateDate = articleCreateDate;
		this.articleName = articleName;
		this.articleAuthor = articleAuthor;
		this.articleType = articleType;
		this.articleContent = articleContent;
	}

	public ArticlesResponeBean() {
	}
}
