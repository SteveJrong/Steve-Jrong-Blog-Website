/*
 * Project Name: SJBlog
 * Class Name: CommentsOrReplyService.java
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
package top.sj.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import top.sj.entity.SjLeavemessages;
import top.sj.entity.SjUsers;

/**
 * 评论/回复业务接口
 * 
 * Create User: SteveJrong
 * Create Date: 2016年8月24日 下午5:18:17
 * Modify User: SteveJrong
 * Modify Date: 2016年8月24日 下午5:18:17
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public interface CommentsOrReplyService {
	/**
	 * 添加一个新评论/回复信息的方法【抽象业务逻辑】
	 * 
	 * @param content
	 * @param device
	 * @param system
	 * @param articleId
	 * @param request
	 * @return
	 */
	Boolean addNewCommentsOrReplyInfoService(String content, String device,
			String system, String articleId, HttpServletRequest request,
			SjUsers users);

	/**
	 * 根据文章编号获取此文章下所有互动信息的方法【抽象业务逻辑】
	 * 
	 * @param articleId
	 * @return
	 */
	List<SjLeavemessages> getAllCOrRInfoByArticleIdService(Integer articleId);

	/**
	 * 为某个评论/回复点赞的方法（目前不记名）【抽象业务逻辑】
	 * 
	 * @param cOrRId
	 * @return
	 */
	Boolean doPraiseService(Integer cOrRId);
	
	/**
	 * 根据文章编号分页获取此文章下所有互动信息的方法【抽象业务逻辑】
	 * @param articleId
	 * @param pageIndex
	 * @return
	 */
	List<SjLeavemessages> getAllCOrRInfoByArticleIdSplitPageService(Integer articleId,Integer pageIndex);
}
