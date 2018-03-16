/*
 * Project Name: SJBlog
 * Class Name: LoadAllCommentsOrReplyInfoAction.java
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

import net.sf.json.JSONObject;
import top.sj.common.util.ActionResult;
import top.sj.manage.service.CommentsOrReplyService;

import com.opensymphony.xwork2.Action;

/**
 * 载入所有评论/回复消息相关的Action
 * 
 * Create User: SteveJrong
 * Create Date: 2016年9月3日 上午11:37:53
 * Modify User: SteveJrong
 * Modify Date: 2016年9月3日 上午11:37:53
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class LoadAllCommentsOrReplyInfoAction implements Action, Serializable {

	private static final long serialVersionUID = 2783316726192063236L;

	/**
	 * 评论/回复业务接口类型的属性，用于Spring Ioc
	 */
	private CommentsOrReplyService mCommentsOrReplyService;

	/**
	 * 每页显示的条数属性
	 */
	private String rows;

	/**
	 * 当前页数属性
	 */
	private String page;

	/**
	 * 结果集JSON对象
	 */
	private JSONObject jsonDatas;

	/**
	 * 搜索开始时间属性
	 */
	private String searchStartDate;

	/**
	 * 搜索结束时间属性
	 */
	private String searchEndDate;

	/**
	 * 搜索审核状态属性
	 */
	private String searchVerifyStatus;

	public String getSearchStartDate() {
		return searchStartDate;
	}

	public void setSearchStartDate(String searchStartDate) {
		this.searchStartDate = searchStartDate;
	}

	public String getSearchEndDate() {
		return searchEndDate;
	}

	public void setSearchEndDate(String searchEndDate) {
		this.searchEndDate = searchEndDate;
	}

	public String getSearchVerifyStatus() {
		return searchVerifyStatus;
	}

	public void setSearchVerifyStatus(String searchVerifyStatus) {
		this.searchVerifyStatus = searchVerifyStatus;
	}

	public void setmCommentsOrReplyService(
			CommentsOrReplyService mCommentsOrReplyService) {
		this.mCommentsOrReplyService = mCommentsOrReplyService;
	}

	public String getRows() {
		return rows;
	}

	public void setRows(String rows) {
		this.rows = rows;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public JSONObject getJsonDatas() {
		return jsonDatas;
	}

	public void setJsonDatas(JSONObject jsonDatas) {
		this.jsonDatas = jsonDatas;
	}

	/**
	 * 默认的执行方法
	 */
	@Override
	public String execute() throws Exception {
		jsonDatas = mCommentsOrReplyService.getCOrRInfoBySplitPageService(
				Integer.valueOf(page), Integer.valueOf(rows), searchStartDate,
				searchEndDate, searchVerifyStatus);

		return ActionResult.SUCCESS.getType();
	}
}
