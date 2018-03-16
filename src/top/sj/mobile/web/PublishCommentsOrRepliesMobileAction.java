/*
 * Project Name: SJBlog
 * Class Name: PublishCommentsOrRepliesMobileAction.java
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

import org.apache.struts2.ServletActionContext;
import org.codehaus.jettison.json.JSONObject;

import top.sj.entity.SjUsers;
import top.sj.mobile.util.MobileActionResult;
import top.sj.mobile.util.ParameterCodecByMobilePlatformUtil;
import top.sj.service.CommentsOrReplyService;
import top.sj.service.UserService;

import com.opensymphony.xwork2.Action;

/**
 * 【移动平台】发布评论/回复信息的Action
 * 
 * Create User: SteveJrong
 * Create Date: 2016年10月17日 下午4:37:08
 * Modify User: SteveJrong
 * Modify Date: 2016年10月17日 下午4:37:08
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class PublishCommentsOrRepliesMobileAction implements Action, Serializable {
	
	private static final long serialVersionUID = -8903309755557781398L;
	
	/**
	 * 评论/回复业务接口类型的属性，用于Spring Ioc
	 */
	private CommentsOrReplyService commentsOrReplyService;
	
	public void setCommentsOrReplyService(
			CommentsOrReplyService commentsOrReplyService) {
		this.commentsOrReplyService = commentsOrReplyService;
	}
	
	/**
	 * 用户业务接口类型的属性，用于Spring Ioc
	 */
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
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
		// 测试地址：http://localhost:8888/SJBlog/mobilePublishCOrRInfo.action?paramJsonDatas={"articleId":1,"userId":1,content:"文章内容",device:"设备信息",system:"操作系统信息"}
		JSONObject paramJsonDatas = new JSONObject(ParameterCodecByMobilePlatformUtil.parameterEcode("paramJsonDatas"));
		responseResult = new ConcurrentHashMap<String, Object>();
		
		//文章编号
		String articleId = paramJsonDatas.getString("articleId");
		
		//用户编号
		Integer userId = Integer.valueOf(paramJsonDatas.getString("userId"));
		
		//文章内容
		String content = paramJsonDatas.getString("content");
		
		//设备信息
		String device = paramJsonDatas.getString("device");
		
		//操作系统信息
		String system = paramJsonDatas.getString("system");
		
		SjUsers user = userService.getUserInfoByIdService(userId);
		
		if (commentsOrReplyService.addNewCommentsOrReplyInfoService(content, device, system, articleId, ServletActionContext.getRequest(), user)) {
			responseResult.put("result", true);
		}else {
			responseResult.put("result", false);
		}

		return MobileActionResult.SUCCESS.getType();
	}
}
