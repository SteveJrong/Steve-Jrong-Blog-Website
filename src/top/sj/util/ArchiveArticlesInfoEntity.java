/*
 * Project Name: SJBlog
 * Class Name: ArchiveArticlesInfoEntity.java
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
package top.sj.util;

/**
 * 适用于主页的“文章归档”栏目按日期归档的实体工具类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年2月17日 下午5:07:28
 * Modify User: SteveJrong
 * Modify Date: 2016年2月17日 下午5:07:28
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class ArchiveArticlesInfoEntity {

	/**
	 * 文章归档日期属性
	 */
	private String articleArchiveDate;

	/**
	 * 当前归档日期下的文章数量
	 */
	private Integer thisArticleArchiveCount;

	public String getArticleArchiveDate() {
		return articleArchiveDate;
	}

	public void setArticleArchiveDate(String articleArchiveDate) {
		this.articleArchiveDate = articleArchiveDate;
	}

	public Integer getThisArticleArchiveCount() {
		return thisArticleArchiveCount;
	}

	public void setThisArticleArchiveCount(Integer thisArticleArchiveCount) {
		this.thisArticleArchiveCount = thisArticleArchiveCount;
	}

	public ArchiveArticlesInfoEntity(Integer thisArticleArchiveCount,
			String articleArchiveDate) {
		super();
		this.articleArchiveDate = articleArchiveDate;
		this.thisArticleArchiveCount = thisArticleArchiveCount;
	}

}
