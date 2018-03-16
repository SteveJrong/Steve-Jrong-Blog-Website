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
package top.sj.manage.dao;

import java.util.Date;
import java.util.List;

import top.sj.entity.SjLeavemessages;

/**
 * 评论/回复接口
 * 
 * Create User: SteveJrong
 * Create Date: 2016年8月25日 下午5:28:01
 * Modify User: SteveJrong
 * Modify Date: 2016年8月25日 下午5:28:01
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public interface CommentsOrReplyDao {

	/**
	 * 分页获取未审核的评论/回复信息的方法【抽象方法】
	 * 
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	List<SjLeavemessages> getUnverifyCOrRInfoBySplitPage(Integer pageIndex,
			Integer pageSize);

	/**
	 * 获取未审核的评论/回复信息总数的方法【抽象方法】
	 * 
	 * @return
	 */
	Integer getUnverifyCOrRInfoAllCountOfSplitPage();

	/**
	 * 审核评论/回复消息的方法【抽象方法】
	 * 
	 * @param leavemessages
	 * @return
	 */
	Boolean verifycOrRInfo(SjLeavemessages leavemessages);

	/**
	 * 根据编号查询一个评论/回复消息实体的方法【抽象方法】
	 * 
	 * @param id
	 * @return
	 */
	SjLeavemessages getCOrRInfoById(Integer id);

	/**
	 * 分页获取所有评论/回复信息的方法【抽象方法】
	 * 
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	List<SjLeavemessages> getCOrRInfoBySplitPage(Integer pageIndex,
			Integer pageSize, Date searchStartDate, Date searchEndDate,
			Integer searchVerifyStatusId);

	/**
	 * 获取所有评论/回复信息总数的方法【抽象方法】
	 * 
	 * @return
	 */
	Integer getCOrRInfoAllCountOfSplitPage();

	/**
	 * 删除一个评论/回复信息的方法【抽象方法】
	 * 
	 * @param leavemessages
	 * @return
	 */
	Boolean delCOrRInfoById(SjLeavemessages leavemessages);
}
