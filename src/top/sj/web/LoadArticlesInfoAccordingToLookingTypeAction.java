/*
 * Project Name: SJBlog
 * Class Name: LoadArticlesInfoAccordingToTimeAction.java
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
import top.sj.service.ArticlesService;

import com.opensymphony.xwork2.Action;

/**
 * 按照文章查看类型（时间/类别）加载数据相关的Action
 * 
 * Create User: SteveJrong
 * Create Date: 2016年2月28日 下午4:12:33
 * Modify User: SteveJrong
 * Modify Date: 2016年2月28日 下午4:12:33
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class LoadArticlesInfoAccordingToLookingTypeAction implements Action,
		Serializable {

	/**
	 * 
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = -626994835991781237L;

	/**
	 * 加载文章的类型属性（1 - 按文章发布时间；2 - 按文章类别）
	 */
	private Integer type;

	/**
	 * 文章类别编号属性
	 */
	private Integer articleTypeNumber;

	/**
	 * 当前页面的索引
	 */
	private Integer pageIndex = 1;

	/**
	 * 总页数
	 */
	private Integer totalPageSize;

	/**
	 * 上一页的页码
	 */
	private Integer prevPageIndex;

	/**
	 * 下一页的页码
	 */
	private Integer nextPageIndex;

	/**
	 * 末页的页码
	 */
	private Integer lastPageIndex;

	/**
	 * 每页要显示的信息条数
	 */
	private Integer pageSize = 5;

	/**
	 * 文章业务接口类型的属性，用于Spring Ioc
	 */
	private ArticlesService articlesService;

	/**
	 * 文章集合类型的属性
	 */
	private List<SjArticles> articlesList;

	/**
	 * 时间字符串资源属性
	 */
	private String datePartion;
	/**
	 * 是否隐藏分页组件的属性
	 */
	private Boolean hideSplitComponent;

	public Boolean getHideSplitComponent() {
		return hideSplitComponent;
	}

	public void setHideSplitComponent(Boolean hideSplitComponent) {
		this.hideSplitComponent = hideSplitComponent;
	}

	public Integer getArticleTypeNumber() {
		return articleTypeNumber;
	}

	public void setArticleTypeNumber(Integer articleTypeNumber) {
		this.articleTypeNumber = articleTypeNumber;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Integer getTotalPageSize() {
		return totalPageSize;
	}

	public void setTotalPageSize(Integer totalPageSize) {
		this.totalPageSize = totalPageSize;
	}

	public Integer getPrevPageIndex() {
		return prevPageIndex;
	}

	public void setPrevPageIndex(Integer prevPageIndex) {
		this.prevPageIndex = prevPageIndex;
	}

	public Integer getNextPageIndex() {
		return nextPageIndex;
	}

	public void setNextPageIndex(Integer nextPageIndex) {
		this.nextPageIndex = nextPageIndex;
	}

	public Integer getLastPageIndex() {
		return lastPageIndex;
	}

	public void setLastPageIndex(Integer lastPageIndex) {
		this.lastPageIndex = lastPageIndex;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public List<SjArticles> getArticlesList() {
		return articlesList;
	}

	public void setArticlesList(List<SjArticles> articlesList) {
		this.articlesList = articlesList;
	}

	public String getDatePartion() {
		return datePartion;
	}

	public void setDatePartion(String datePartion) {
		this.datePartion = datePartion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setArticlesService(ArticlesService articlesService) {
		this.articlesService = articlesService;
	}

	/**
	 * 默认执行的方法
	 */
	@Override
	public String execute() throws Exception {
		// 获取总数（type的值为1表示按照时间，否则按照类别）
		Integer totalItemSize = type == 1 ? articlesService
				.getArticlesAccordingToCreateDateSOfGetAllCountSplitPageService(datePartion)
				: articlesService
						.getArticlesAccordingToArticleTypeSOfGetAllCountSplitPageService(articleTypeNumber);

		// 如果总数小于等于5，则不显示分页组件
		if (totalItemSize <= 5) {
			hideSplitComponent = true;
		} else {
			hideSplitComponent = false;
		}

		// 将总记录数和总页数进行取余，判断要分出多少页来才能足够显示所有的信息
		if (totalItemSize % pageSize == 0) {
			// 能除尽说明正好可以显示完全部数据
			totalPageSize = totalItemSize / pageSize;
		} else {
			// 除不尽说明还需要加单独的一页才够显示全部数据
			totalPageSize = totalItemSize / pageSize + 1;
		}

		/**
		 * 针对页面进行各种逻辑判断
		 */
		// 当pageIndex即当前页码为第1页时，设置“上一页”按钮的页码也为1，设置“下一页”按钮的页码为当前页码（pageIndex）加1
		if (pageIndex <= 1) {
			prevPageIndex = 1;
			nextPageIndex = pageIndex + 1;

			// 当pageIndex即当前页码在第2页到最大页数之间时，设置“上一页”按钮的页码为当前页码减1，设置“下一页”按钮的页码为当前页码加1
		} else if (pageIndex > 1 && pageIndex < totalPageSize) {
			prevPageIndex = pageIndex - 1;
			nextPageIndex = pageIndex + 1;

			// 当pageIndex即当前页码已经达到了最大页数时，设置“上一页”按钮的页码为当前页码减1（因为要上翻一页就需要当前页码减1），设置“下一页”按钮的页码为当前页码
		} else if (pageIndex >= totalPageSize) {
			prevPageIndex = pageIndex - 1;
			nextPageIndex = pageIndex;
		}

		// 设置“末页”按钮的页码为总页数，即最大页数
		lastPageIndex = totalPageSize;

		// 每次要分页时要从数据库表的第几行数据开始的固定算法(pageIndex - 1) *
		// pageSize，表示当前页码减去1页后和每页要显示的条数的乘积即每次要从第几个开始显示
		articlesList = type == 1 ? articlesService
				.getArticlesAccordingToCreateDateSplitPageService(pageIndex,
						pageSize, datePartion) : articlesService
				.getArticlesAccordingToArticleTypeSplitPageService(pageIndex,
						pageSize, articleTypeNumber);

		return ActionResult.SUCCESS.getType();
	}
}
