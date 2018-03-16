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
package top.sj.manage.service;

import net.sf.json.JSONObject;
import top.sj.entity.SjLeavemessages;

/**
 * 评论/回复业务接口
 * 
 * Create User: SteveJrong
 * Create Date: 2016年8月25日 下午5:33:01
 * Modify User: SteveJrong
 * Modify Date: 2016年8月25日 下午5:33:01
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public interface CommentsOrReplyService {

	/**
	 * 分页获取未审核的评论/回复信息的方法【抽象方法】
	 * 
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	JSONObject getUnverifyCOrRInfoBySplitPageService(Integer pageIndex,
			Integer pageSize);

	/**
	 * 获取未审核的评论/回复信息总数的方法【抽象方法】
	 * 
	 * @return
	 */
	Integer getUnverifyCOrRInfoAllCountOfSplitPageService();

	/**
	 * 审核评论/回复消息的方法【抽象业务逻辑】
	 * 
	 * @param cOrRId
	 * @param verifyResult
	 * @return
	 */
	Boolean verifycOrRInfoService(Integer cOrRId, Boolean verifyResult);

	/**
	 * 根据编号查询一个评论/回复消息实体的方法【抽象业务逻辑】
	 * 
	 * @param id
	 * @return
	 */
	SjLeavemessages getCOrRInfoByIdService(Integer id);

	/**
	 * 分页获取所有评论/回复信息的方法【抽象业务逻辑】
	 * 
	 * @param pageIndex
	 * @param pageSize
	 * @param searchStartDate
	 * @param searchEndDate
	 * @param searchVerifyStatus
	 * @return
	 */
	JSONObject getCOrRInfoBySplitPageService(Integer pageIndex,
			Integer pageSize, String searchStartDate, String searchEndDate,
			String searchVerifyStatus);

	/**
	 * 获取所有评论/回复信息总数的方法【抽象业务逻辑】
	 * 
	 * @return
	 */
	Integer getCOrRInfoAllCountOfSplitPageService();

	/**
	 * 删除一个评论/回复信息的方法【抽象业务逻辑】
	 * 
	 * @param cOrRId
	 * @return
	 */
	Boolean delCOrRInfoByIdService(Integer cOrRId);
}
