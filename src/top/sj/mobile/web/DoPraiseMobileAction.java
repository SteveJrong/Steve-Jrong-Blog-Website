/*
 * Project Name: SJBlog
 * Class Name: DoPraiseMobileAction.java
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
package top.sj.mobile.web;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;
import org.codehaus.jettison.json.JSONObject;

import top.sj.common.util.ActionResult;
import top.sj.mobile.responsebeans.DoPraiseResponeBean;
import top.sj.mobile.util.ParameterCodecByMobilePlatformUtil;
import top.sj.service.CommentsOrReplyService;
import top.sj.tool.ReverseProxyIPInfoTool;
import top.sj.util.DoPraiseEntityUtil;
import top.sj.util.DoPraiseManageUtil;

import com.opensymphony.xwork2.Action;

/**
 * 【移动平台】为评论/回复消息点赞的Action
 * 
 * Create User: SteveJrong
 * Create Date: 2016年10月18日 下午3:45:13
 * Modify User: SteveJrong
 * Modify Date: 2016年10月18日 下午3:45:13
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class DoPraiseMobileAction implements Action, Serializable {
	
	private static final long serialVersionUID = -2880454104229644542L;

	/**
	 * 评论/回复业务接口类型的属性，用于Spring Ioc
	 */
	private CommentsOrReplyService commentsOrReplyService;

	public void setCommentsOrReplyService(
			CommentsOrReplyService commentsOrReplyService) {
		this.commentsOrReplyService = commentsOrReplyService;
	}
	
	/**
	 * 结果集属性
	 */
	private Map<String, Object> responseResult;

	public Map<String, Object> getResponseResult() {
		return responseResult;
	}

	public void setResponseResult(Map<String, Object> responseResult) {
		this.responseResult = responseResult;
	}
	
	/**
	 * 默认执行的方法
	 */
	@Override
	public String execute() throws Exception {
		// 测试地址：http://localhost:8888/SJBlog/mobileDoPraise.action?paramJsonDatas={"paramJsonDatas":1}
		JSONObject paramJsonDatas = new JSONObject(ParameterCodecByMobilePlatformUtil.parameterEcode("paramJsonDatas"));
		DoPraiseResponeBean responeBean = new DoPraiseResponeBean();
		responseResult = new ConcurrentHashMap<String,Object>();
		Boolean flag = false;
		Integer cOrRId = Integer.valueOf(paramJsonDatas.getString("paramJsonDatas"));
		
		// 获取用户的IP地址
		String guestIP = ReverseProxyIPInfoTool.getClientIP(ServletActionContext.getRequest());
		
		//这里要做个判断：遍历DoPraiseManageUtil中的集合，将其中的元素依次取出，并根据当前IP和消息编号进行遍历判断是否能继续点赞
		for (DoPraiseEntityUtil entityUtil : DoPraiseManageUtil.getDoPraiseEntityUtils()) {
			//如果管理类中存在当前IP记录，那么再继续判断是否是当前消息，是则设置flag为true
			if (entityUtil.getIpAddress().equals(guestIP)) {
				if (entityUtil.getcOrRId().hashCode() == cOrRId.hashCode()) {
					flag = true;
				}
			}
		}
		
		if (!flag) {
			Boolean result = commentsOrReplyService.doPraiseService(cOrRId);
			
			if (result == true) {
				//表示点赞成功
				
				responeBean.setIsParised(false);
				responeBean.setResult(true);
				
				// 点赞成功以后，将记录放入点赞管理类的集合中做暂存，暂时不采用置于Memcached中的方案
				DoPraiseEntityUtil praiseEntity = new DoPraiseEntityUtil();
				
				//消息编号
				praiseEntity.setcOrRId(cOrRId);
				
				//是否点过赞
				praiseEntity.setIsDoPraised(true);
				
				//用户IP地址
				praiseEntity.setIpAddress(guestIP);
				
				DoPraiseManageUtil.getDoPraiseEntityUtils().add(praiseEntity);
			}else {
				//表示点赞失败
				
				responeBean.setIsParised(false);
				responeBean.setResult(false);
			}
			
		}else {
			//表示已经点过赞
			responeBean.setIsParised(true);
			responeBean.setResult(false);
		}
		
		responseResult.put("result", JSONArray.fromObject(responeBean));
		return ActionResult.SUCCESS.getType();
	}
}
