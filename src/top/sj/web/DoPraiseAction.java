/*
 * Project Name: SJBlog
 * Class Name: DoPraiseAction.java
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
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import top.sj.common.util.ActionResult;
import top.sj.service.CommentsOrReplyService;
import top.sj.tool.ReverseProxyIPInfoTool;
import top.sj.util.DoPraiseEntityUtil;
import top.sj.util.DoPraiseManageUtil;

import com.opensymphony.xwork2.Action;

/**
 * 点赞/取消点赞相关的Action
 * 
 * Create User: SteveJrong
 * Create Date: 2016年9月6日 下午7:35:05
 * Modify User: SteveJrong
 * Modify Date: 2016年9月6日 下午7:35:05
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class DoPraiseAction implements Action, Serializable {

	private static final long serialVersionUID = 5820350864257649709L;

	/**
	 * 评论/回复业务接口类型的属性，用于Spring Ioc
	 */
	private CommentsOrReplyService commentsOrReplyService;

	public void setCommentsOrReplyService(
			CommentsOrReplyService commentsOrReplyService) {
		this.commentsOrReplyService = commentsOrReplyService;
	}

	/**
	 * 评论/回复消息编号
	 */
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 结果集集合属性
	 */
	private JSONObject jsonDatas;

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
		Boolean flag = false;
		// 获取用户的IP地址
		String guestIP = ReverseProxyIPInfoTool
				.getClientIP(ServletActionContext.getRequest());

		//这里要做个判断：遍历DoPraiseManageUtil中的集合，将其中的元素依次取出，并根据当前IP和消息编号进行遍历判断是否能继续点赞
		for (DoPraiseEntityUtil entityUtil : DoPraiseManageUtil.getDoPraiseEntityUtils()) {
			//如果管理类中存在当前IP记录，那么再继续判断是否是当前消息，是则设置flag为true
			if (entityUtil.getIpAddress().equals(guestIP)) {
				if (entityUtil.getcOrRId().hashCode() == id.hashCode()) {
					flag = true;
				}
			}
		}

		if (!flag) {
			if (commentsOrReplyService.doPraiseService(id)) {
				map.put("result", "success");
				// 点赞成功以后，将记录放入点赞管理类的集合中做暂存，暂时不采用置于Memcached中的方案
				DoPraiseEntityUtil praiseEntity = new DoPraiseEntityUtil();
				
				//消息编号
				praiseEntity.setcOrRId(id);
				
				//是否点过赞
				praiseEntity.setIsDoPraised(true);
				
				//用户IP地址
				praiseEntity.setIpAddress(guestIP);
				
				DoPraiseManageUtil.getDoPraiseEntityUtils().add(praiseEntity);
				
			} else {
				map.put("result", "failed");
			}
		} else {
			// 表示已经点过赞
			map.put("result", "praised");
		}

		jsonDatas = JSONObject.fromObject(map);
		return ActionResult.SUCCESS.getType();
	}
}
