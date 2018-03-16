/*
 * Project Name: SJBlog
 * Class Name: VerifyCommentsOrReplyInfoAction.java
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
import top.sj.common.util.Constants;
import top.sj.manage.service.CommentsOrReplyService;

import com.opensymphony.xwork2.Action;

/**
 * 审核未审核的评论/回复消息相关的Action
 * 
 * Create User: SteveJrong
 * Create Date: 2016年9月2日 下午4:35:11
 * Modify User: SteveJrong
 * Modify Date: 2016年9月2日 下午4:35:11
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class VerifyCommentsOrReplyInfoAction implements Action, Serializable {
	
	private static final long serialVersionUID = 5580381142717179747L;

	/**
	 * 评论/回复业务接口类型的属性，用于Spring Ioc
	 */
	private CommentsOrReplyService mCommentsOrReplyService;

	/**
	 * 评论/回复消息编号属性
	 */
	private Integer id;

	/**
	 * 评论/回复消息的审核结果属性
	 */
	private String verifyresult;

	/**
	 * 结果集属性
	 */
	private JSONObject jsonDatas;

	public void setmCommentsOrReplyService(
			CommentsOrReplyService mCommentsOrReplyService) {
		this.mCommentsOrReplyService = mCommentsOrReplyService;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVerifyresult() {
		return verifyresult;
	}

	public void setVerifyresult(String verifyresult) {
		this.verifyresult = verifyresult;
	}

	public JSONObject getJsonDatas() {
		return jsonDatas;
	}

	public void setJsonDatas(JSONObject jsonDatas) {
		this.jsonDatas = jsonDatas;
	}

	/**
	 * 默认执行的方法
	 */
	@Override
	public String execute() throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		if (mCommentsOrReplyService.verifycOrRInfoService(id,verifyresult.equals(Constants.MSG_OF_PASS.getValue()) ? true : false)) {
			map.put("result", "success");
		} else {
			map.put("result", "failed");
		}
		jsonDatas = JSONObject.fromObject(map);
		return ActionResult.SUCCESS.getType();
	}
}
