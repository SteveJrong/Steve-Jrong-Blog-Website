/*
 * Project Name: SJBlog
 * Class Name: DeleteCommentsOrReplyInfoAction.java
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
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;
import top.sj.common.util.ActionResult;
import top.sj.manage.service.CommentsOrReplyService;

import com.opensymphony.xwork2.Action;

/**
 * 删除一个评论/回复信息相关的Action
 * 
 * Create User: SteveJrong
 * Create Date: 2016年9月3日 下午6:51:22
 * Modify User: SteveJrong
 * Modify Date: 2016年9月3日 下午6:51:22
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class DeleteCommentsOrReplyInfoAction implements Action, Serializable {

	private static final long serialVersionUID = -5542906251485204609L;

	/**
	 * 评论/回复业务接口类型的属性，用于Spring Ioc
	 */
	private CommentsOrReplyService mCommentsOrReplyService;

	/**
	 * 评论/回复信息编号属性
	 */
	private String id;

	/**
	 * 结果集集合属性
	 */
	private JSONObject jsonDatas;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public JSONObject getJsonDatas() {
		return jsonDatas;
	}

	public void setJsonDatas(JSONObject jsonDatas) {
		this.jsonDatas = jsonDatas;
	}

	public void setmCommentsOrReplyService(
			CommentsOrReplyService mCommentsOrReplyService) {
		this.mCommentsOrReplyService = mCommentsOrReplyService;
	}

	/**
	 * 默认执行的方法
	 */
	@Override
	public String execute() throws Exception {
		Map<String, String> map = new HashMap<String, String>();

		if (mCommentsOrReplyService.delCOrRInfoByIdService(Integer.valueOf(id))) {
			map.put("result", "success");
			jsonDatas = JSONObject.fromObject(map);
		} else {
			map.put("result", "failed");
			jsonDatas = JSONObject.fromObject(map);
		}

		return ActionResult.SUCCESS.getType();
	}
}
