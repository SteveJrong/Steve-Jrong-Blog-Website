/*
 * Project Name: SJBlog
 * Class Name: LoadPlayLifeInfoAction.java
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
import top.sj.common.util.GsonUtil;
import top.sj.dto.PlayLifeDTO;
import top.sj.dto.PlayLifeDatasDTO;
import top.sj.dto.PlayLifePaginationDTO;
import top.sj.entity.SjLife;
import top.sj.service.LifeService;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.Action;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 载入玩生活信息相关的Action
 * 
 * Create User: SteveJrong
 * Create Date: 2016年5月6日 下午4:59:10
 * Modify User: SteveJrong
 * Modify Date: 2016年5月6日 下午4:59:10
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class LoadPlayLifeInfoAction implements Action, Serializable {

	private static final long serialVersionUID = 2904520609602639198L;
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
	private Integer pageSize = 2;

	/**
	 * 是否隐藏分页组件的属性
	 */
	private Boolean hideSplitComponent;

	/**
	 * 生活业务类型接口的属性
	 */
	private LifeService lifeService;

	/**
	 * 结果集JSON对象
	 */
	private String jsonDatas;
	
	public String getJsonDatas() {
		return jsonDatas;
	}

	public void setJsonDatas(String jsonDatas) {
		this.jsonDatas = jsonDatas;
	}

	public void setLifeService(LifeService lifeService) {
		this.lifeService = lifeService;
	}

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		if (null == pageIndex) {
			pageIndex = 1;
		}else {
			this.pageIndex = pageIndex;
		}
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
		// 获取总数
		Integer totalItemSize = lifeService
				.getTotalCountOfAllLifeInfoBySplitPageService();

		// 如果总数小于等于5，则不显示分页组件
		if (totalItemSize <= 2) {
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

		List<PlayLifeDatasDTO> playLifeDatas = lifeService.getAllLifeInfoSplitPageService(pageIndex, pageSize);
		PlayLifePaginationDTO playLifePagination = new PlayLifePaginationDTO(prevPageIndex, nextPageIndex, pageIndex, lastPageIndex, totalPageSize, totalItemSize);
		
		PlayLifeDTO playLife = new PlayLifeDTO(playLifePagination, playLifeDatas);
		
		jsonDatas = JSONArray.fromObject(playLife).toString();
		
		System.out.println(jsonDatas);

		return ActionResult.SUCCESS.getType();
	}
}
