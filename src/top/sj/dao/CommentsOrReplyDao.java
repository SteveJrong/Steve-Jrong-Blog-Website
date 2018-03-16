/*
 * Project Name: SJBlog
 * Class Name: CommentsOrReplyDao.java
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
package top.sj.dao;

import java.util.List;
import top.sj.entity.SjLeavemessages;

/**
 * 评论/回复接口
 * 
 * Create User: SteveJrong
 * Create Date: 2016年8月24日 下午5:14:40
 * Modify User: SteveJrong
 * Modify Date: 2016年8月24日 下午5:14:40
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public interface CommentsOrReplyDao {
	/**
	 * 添加一个新评论/回复信息的方法【抽象方法】
	 * 
	 * @param leavemessages
	 * @return
	 */
	Boolean addNewCommentsOrReplyInfo(SjLeavemessages leavemessages);

	/**
	 * 根据文章编号获取此文章下所有互动信息的方法【抽象方法】
	 * 
	 * @param articleId
	 * @return
	 */
	List<SjLeavemessages> getAllCOrRInfoByArticleId(Integer articleId);

	/**
	 * 为某个评论/回复点赞的方法（目前不记名）【抽象方法】
	 * 
	 * @param leavemessages
	 * @return
	 */
	Boolean doPraise(SjLeavemessages leavemessages);
	
	/**
	 * 根据文章编号分页获取此文章下所有互动信息的方法【抽象方法】
	 * @param articleId
	 * @param pageIndex
	 * @return
	 */
	List<SjLeavemessages> getAllCOrRInfoByArticleIdSplitPage(Integer articleId,Integer pageIndex);
}