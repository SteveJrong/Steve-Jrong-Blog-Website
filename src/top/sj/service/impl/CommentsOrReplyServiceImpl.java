/*
 * Project Name: SJBlog
 * Class Name: CommentsOrReplyServiceImpl.java
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
package top.sj.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import top.sj.dao.ArticlesDao;
import top.sj.dao.CommentsOrReplyDao;
import top.sj.entity.SjLeavemessages;
import top.sj.entity.SjUsers;
import top.sj.manage.util.MessageTypeByCommentsOrReplyEnum;
import top.sj.service.CommentsOrReplyService;
import top.sj.tool.ReverseProxyIPInfoTool;
import top.sj.tool.TimestampTool;
import top.sj.util.VerifyStateByCommentsOrReplyEnum;

/**
 * 评论/回复业务接口的实现类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年8月24日 下午5:18:59
 * Modify User: SteveJrong
 * Modify Date: 2016年8月24日 下午5:18:59
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class CommentsOrReplyServiceImpl implements CommentsOrReplyService {

	/**
	 * 评论/回复接口类型的属性，用于Spring Ioc
	 */
	private CommentsOrReplyDao commentsOrReplyDao;

	public void setCommentsOrReplyDao(CommentsOrReplyDao commentsOrReplyDao) {
		this.commentsOrReplyDao = commentsOrReplyDao;
	}

	/**
	 * 博文接口类型的属性，用于Spring Ioc
	 */
	private ArticlesDao articlesDao;

	public void setArticlesDao(ArticlesDao articlesDao) {
		this.articlesDao = articlesDao;
	}

	/**
	 * 评论/回复接口类型的属性，用于Spring Ioc
	 */
	private top.sj.manage.dao.CommentsOrReplyDao mCommentsOrReplyDao;

	public void setmCommentsOrReplyDao(
			top.sj.manage.dao.CommentsOrReplyDao mCommentsOrReplyDao) {
		this.mCommentsOrReplyDao = mCommentsOrReplyDao;
	}

	/**
	 * 添加一个新评论/回复信息的方法【业务逻辑】
	 */
	@Override
	public Boolean addNewCommentsOrReplyInfoService(String content,
			String device, String system, String articleId,
			HttpServletRequest request, SjUsers users) {

		SjLeavemessages leavemessages = new SjLeavemessages();
		leavemessages.setMComments(content);
		leavemessages.setMDeviceinfo(device);
		leavemessages.setMIpaddress(ReverseProxyIPInfoTool
				.getClientIP(request));
		leavemessages.setMMessageType(MessageTypeByCommentsOrReplyEnum.COMMENT
				.getMsgType());
		leavemessages.setMPublishdate(TimestampTool
				.convertNowDateToStimeStamp());
		leavemessages.setMSysteminfo(system);
		leavemessages.setMPraisecount(0);
		leavemessages
				.setMVerifystate(VerifyStateByCommentsOrReplyEnum.UN_VERIFY
						.getState());
		leavemessages.setSjArticles(articlesDao
				.getArticleDetailByArticleId(Integer.valueOf(articleId)));
		// 消息接收者为null
		leavemessages.setSjUsersByMReplyId(null);
		// 消息发送者为当前用户
		leavemessages.setSjUsersByMUId(users);
		return commentsOrReplyDao.addNewCommentsOrReplyInfo(leavemessages);
	}

	/**
	 * 根据文章编号获取此文章下所有互动信息的方法【业务逻辑】
	 */
	@Override
	public List<SjLeavemessages> getAllCOrRInfoByArticleIdService(
			Integer articleId) {
		return commentsOrReplyDao.getAllCOrRInfoByArticleId(articleId);
	}

	/**
	 * 为某个评论/回复点赞的方法（目前不记名）【业务逻辑】
	 */
	@Override
	public Boolean doPraiseService(Integer cOrRId) {
		SjLeavemessages leavemessage = mCommentsOrReplyDao
				.getCOrRInfoById(cOrRId);
		leavemessage.setMPraisecount(null == leavemessage.getMPraisecount()
				|| leavemessage.getMPraisecount() < 1 ? 1 : leavemessage
				.getMPraisecount() + 1);
		return commentsOrReplyDao.doPraise(leavemessage);
	}

	/**
	 * 根据文章编号分页获取此文章下所有互动信息的方法【业务逻辑】
	 */
	@Override
	public List<SjLeavemessages> getAllCOrRInfoByArticleIdSplitPageService(
			Integer articleId, Integer pageIndex) {
		return commentsOrReplyDao.getAllCOrRInfoByArticleIdSplitPage(articleId, pageIndex);
	}
}
