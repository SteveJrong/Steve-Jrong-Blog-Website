/*
 * Project Name: SJBlog
 * Class Name: LeaveMessagesAction.java
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

import java.io.PrintWriter;
import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import top.sj.common.util.ActionResult;
import top.sj.common.util.Constants;
import top.sj.common.util.JCaptchaBusinessUtil;
import top.sj.entity.SjUsers;
import top.sj.inputscope.SessionScope;
import top.sj.service.CommentsOrReplyService;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 评论/回复相关的Action
 * 
 * Create User: SteveJrong
 * Create Date: 2016年8月21日 上午9:46:24
 * Modify User: SteveJrong
 * Modify Date: 2016年8月21日 上午9:46:24
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class CommentsOrReplyAction extends ActionSupport implements
		Serializable {

	private static final long serialVersionUID = 7460900978826568431L;

	/**
	 * 验证码属性
	 */
	private String checkedCode;

	/**
	 * 结果集属性
	 */
	private JSONObject jsonDatas;

	/**
	 * 评论/回复业务接口类型的属性，用于Spring Ioc
	 */
	private CommentsOrReplyService commentsOrReplyService;

	/**
	 * 评论/回复的内容属性
	 */
	private String content;

	/**
	 * 操作系统属性
	 */
	private String system;

	/**
	 * 设备型号属性
	 */
	private String device;

	/**
	 * 文章编号属性
	 */
	private String articleId;

	/**
	 * 重定向URL属性
	 */
	private String redirectUrl;

	public String getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

	public String getArticleId() {
		return articleId;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setCommentsOrReplyService(
			CommentsOrReplyService commentsOrReplyService) {
		this.commentsOrReplyService = commentsOrReplyService;
	}

	public String getCheckedCode() {
		return checkedCode;
	}

	public void setCheckedCode(String checkedCode) {
		this.checkedCode = checkedCode;
	}

	public JSONObject getJsonDatas() {
		return jsonDatas;
	}

	public void setJsonDatas(JSONObject jsonDatas) {
		this.jsonDatas = jsonDatas;
	}

	@Override
	public String execute() throws Exception {
		boolean TorF = false;
		PrintWriter out;
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding(Constants.UTF_8_ENCODING.getValue());
		response.setContentType(Constants.DEFAULT_REQUEST_ENCODING.getValue());
		out = response.getWriter();

		/**
		 * 随机验证码验证
		 */
		HttpServletRequest request = ServletActionContext.getRequest();
		String sessionId = request.getSession().getId();
		String captchaId = sessionId;

		String validateCode = checkedCode;

		// 根据每一次发出请求的sessionid和用户填入的验证码进行匹配结果是否正确
		boolean validateResult = JCaptchaBusinessUtil.getService()
				.validateResponseForID(captchaId, validateCode);

		if (validateResult) {
			TorF = true;
		}

		if (TorF == true) {
			SjUsers users = SessionScope.getUserEntityInfoOnSessionScope();
			if (null == users) {
				return ActionResult.LOGIN.getType();
			} else {
				// 开始处理业务
				if (commentsOrReplyService.addNewCommentsOrReplyInfoService(
						content, device, system, articleId, request, users)) {
					redirectUrl = "/detail_".concat(articleId);
					out.print("<script>alert('恭喜，您的评论/回复发布成功！您的评论/回复需要人工审核才能正常显示，还请您耐心等待哦~'); history.go(-1); location.reload();</script>");
				} else {
					out.print("<script>alert('非常抱歉，您的评论/回复发布失败，请重试您的操作。'); history.go(-1);</script>");
				}
				out.flush();
				out.close();
				return null;
			}
		}
		return ActionResult.FAILED.getType();
	}
}
