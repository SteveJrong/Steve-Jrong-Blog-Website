/*
 * Project Name: SJBlog
 * Class Name: FullTextSearchAction.java
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

import org.apache.log4j.Logger;

import top.sj.common.util.ActionResult;
import top.sj.dto.LuceneSearchDTO;
import top.sj.lucene.LuceneSearchUtil;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 全文搜索相关的Action
 * 
 * Create User: SteveJrong
 * Create Date: 2016年6月12日 上午10:41:41
 * Modify User: SteveJrong
 * Modify Date: 2016年6月12日 上午10:41:41
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class FullTextSearchAction extends ActionSupport implements Serializable {

	private static final long serialVersionUID = 5351009401828876142L;

	private static Logger LOGGER = Logger.getLogger(FullTextSearchAction.class);

	/**
	 * 默认每页显示的条数
	 */
	private static Integer DEFAULT_PAGE_SIZE = 8;

	/**
	 * 搜索关键词属性
	 */
	private String keywords;

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	/**
	 * 搜索键值对结果集属性
	 */
	private List<LuceneSearchDTO> result;

	public List<LuceneSearchDTO> getResult() {
		return result;
	}

	public void setResult(List<LuceneSearchDTO> result) {
		this.result = result;
	}

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
	private Integer pageSize = DEFAULT_PAGE_SIZE;

	/**
	 * 是否隐藏分页组件的属性
	 */
	private Boolean hideSplitComponent;

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

	public Boolean getHideSplitComponent() {
		return hideSplitComponent;
	}

	public void setHideSplitComponent(Boolean hideSplitComponent) {
		this.hideSplitComponent = hideSplitComponent;
	}

	/**
	 * 默认执行的方法
	 */
	@Override
	public String execute() throws Exception {
		// 总数据条数
		Integer totalItemSize = 0;
		
		String[] parameters = keywords.split(" ");
		if (parameters.length == 1) {
			result = LuceneSearchUtil.searchOfSingleAreaAndSingleCondition(
					"AId", "AName", parameters[0], pageIndex, pageSize);
			totalItemSize = LuceneSearchUtil.searchTotalSize(false, "AName", parameters[0]);
		} else if (parameters.length > 1) {
			result = LuceneSearchUtil.searchOfSingleAreaAndMultiCondition(
					"AId", "AName", pageIndex, pageSize, parameters);
			totalItemSize = LuceneSearchUtil.searchTotalSize(true, "AName", parameters);
		} else {
			LOGGER.error("搜索异常，关键词格式不合法！");

			return ActionResult.ERROR.getType();
		}

		System.out.println(result);

		LOGGER.info("搜索成功！");

		// 如果总数小于等于默认的每页显示的条数，则不显示分页组件
		if (totalItemSize <= DEFAULT_PAGE_SIZE) {
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

//		Integer startIndex = (pageIndex - 1) * pageSize;
//		Integer endIndex = (pageIndex - 1) * pageSize + pageSize;

		// 这里需要算法判断
		// 对于奇数结果集来说，要先取出最后一条结果集来，然后每次迭代的时候和最后一条结果集依次比较，如果相等就说明已经是最后一个元素了，此时要设置end
		// = start
		// 表示奇数结果集
//		if (result.size() % 2 != 0) {
//			// 取到所有结果集中的最后一个数据
//			LuceneSearchDTO tempForDTO = result.get(result.size() - 1);
//			for (LuceneSearchDTO item : result) {
//				// 若当前迭代到的对象和最后一个对象相等
//				if (item.hashCode() == tempForDTO.hashCode()) {
//					if (result.size() - startIndex == 1) {
//						// 那么end就等于start
//						endIndex = startIndex + 1;
//					}
//				}
//			}
//
//			// 如果end的位置比结果集的长度还要大，那么这里就需要判断了，避免出现数组越界
//			if (endIndex > result.size()) {
//				// 设置end的位置为数组的最大长度
//				endIndex = result.size();
//			}
//
//			result = result.subList(startIndex, endIndex);
//
//		}

		// System.out.println("分页后的结果集：\n" + result);

		return ActionResult.SUCCESS.getType();
	}
}
