/*
 * Project Name: SJBlog
 * Class Name: LoadAllUnVerifyCommentsOrReplyInfoAction.java
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
 * 载入所有未审核的评论/回复消息相关的Action
 * 
 * Create User: SteveJrong
 * Create Date: 2016年8月25日 下午6:26:17
 * Modify User: SteveJrong
 * Modify Date: 2016年8月25日 下午6:26:17
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class LoadAllUnVerifyCommentsOrReplyInfoAction implements Action,Serializable {

	private static final long serialVersionUID = 8940292476575002769L;

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
		jsonDatas = mCommentsOrReplyService
				.getUnverifyCOrRInfoBySplitPageService(Integer.valueOf(page),
						Integer.valueOf(rows));

		return ActionResult.SUCCESS.getType();
	}
}
