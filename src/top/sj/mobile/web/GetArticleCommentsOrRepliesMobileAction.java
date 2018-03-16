/*
 * Project Name: SJBlog
 * Class Name: GetArticleCommentsOrRepliesMobileAction.java
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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.codehaus.jettison.json.JSONObject;

import top.sj.entity.SjLeavemessages;
import top.sj.mobile.responsebeans.CommentsOrRepliesResponeBean;
import top.sj.mobile.util.MobileActionResult;
import top.sj.mobile.util.ParameterCodecByMobilePlatformUtil;
import top.sj.service.CommentsOrReplyService;
import top.sj.tool.DateTimeTool;
import top.sj.tool.TimestampTool;

import com.opensymphony.xwork2.Action;

/**
 * 【移动平台】获取文章的评论/回复信息的Action
 * 
 * Create User: SteveJrong
 * Create Date: 2016年10月17日 上午9:42:10
 * Modify User: SteveJrong
 * Modify Date: 2016年10月17日 上午9:42:10
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class GetArticleCommentsOrRepliesMobileAction implements Action, Serializable {
	private static final long serialVersionUID = -5956968153549251245L;

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
		//入参：是否开启夜间模式的标识符、文章ID
		// 测试地址：http://localhost:8888/SJBlog/mobileGetArticleCOrRInfo.action?paramJsonDatas={"articleId":1,"pageIndex":1}
		JSONObject paramJsonDatas = new JSONObject(ParameterCodecByMobilePlatformUtil.parameterEcode("paramJsonDatas"));
		responseResult = new ConcurrentHashMap<String, Object>();
		
		Integer articleId = Integer.valueOf(paramJsonDatas.getString("articleId"));
		Integer pageIndex = Integer.valueOf(paramJsonDatas.getString("pageIndex"));
		
		List<SjLeavemessages> leavemessages = commentsOrReplyService.getAllCOrRInfoByArticleIdSplitPageService(articleId, pageIndex);
		
		List<CommentsOrRepliesResponeBean> resultEntities = new ArrayList<CommentsOrRepliesResponeBean>();
		
		for (SjLeavemessages lm : leavemessages) {
			CommentsOrRepliesResponeBean responeBean = new CommentsOrRepliesResponeBean();
			responeBean.setContent(lm.getMComments());
			responeBean.setId(lm.getMId().longValue());
			responeBean.setMessageType(lm.getMMessageType());
			responeBean.setPraiseCount(lm.getMPraisecount().longValue());
			responeBean.setPublishDate(TimestampTool.toString(lm.getMPublishdate()));
			responeBean.setPublishedDeviceInfo(lm.getMDeviceinfo());
			responeBean.setPublishedSystemInfo(lm.getMSysteminfo());
			resultEntities.add(responeBean);
		}
		responseResult.put("result", net.sf.json.JSONArray.fromObject(resultEntities));
		return MobileActionResult.SUCCESS.getType();
	}
}
