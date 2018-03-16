/*
 * Project Name: SJBlog
 * Class Name: MixRadioDTO.java
 * 
 * Copyright © 2011-2017 SteveJrong  All Rights Reserved.
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
package top.sj.dto;

import java.io.Serializable;

/**
 * PlayLife Pagination DTO实体类
 * 
 * Create User: SteveJrong
 * Create Date: 2017年5月9日 下午5:39:32
 * Modify User: SteveJrong
 * Modify Date: 2017年5月9日 下午5:39:32
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class PlayLifePaginationDTO implements Serializable {

	private static final long serialVersionUID = -4445452238003029126L;

	/**
	 * 上一页属性
	 */
	private Integer prevPageIndex;
	
	/**
	 * 下一页属性
	 */
	private Integer nextPageIndex;
	
	/**
	 * 当前页属性
	 */
	private Integer pageIndex;
	
	/**
	 * 最后一页属性
	 */
	private Integer lastPageIndex;
	
	/**
	 * 总页数属性
	 */
	private Integer totalPageSize;
	
	/**
	 * 总数据条数属性
	 */
	private Integer totalCount;

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

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Integer getLastPageIndex() {
		return lastPageIndex;
	}

	public void setLastPageIndex(Integer lastPageIndex) {
		this.lastPageIndex = lastPageIndex;
	}

	public Integer getTotalPageSize() {
		return totalPageSize;
	}

	public void setTotalPageSize(Integer totalPageSize) {
		this.totalPageSize = totalPageSize;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public PlayLifePaginationDTO(Integer prevPageIndex, Integer nextPageIndex, Integer pageIndex, Integer lastPageIndex,
			Integer totalPageSize, Integer totalCount) {
		super();
		this.prevPageIndex = prevPageIndex;
		this.nextPageIndex = nextPageIndex;
		this.pageIndex = pageIndex;
		this.lastPageIndex = lastPageIndex;
		this.totalPageSize = totalPageSize;
		this.totalCount = totalCount;
	}
	
	public PlayLifePaginationDTO() {
	}
}
