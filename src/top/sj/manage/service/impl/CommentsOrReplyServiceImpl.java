/*
 * Project Name: SJBlog
 * Class Name: .java
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
package top.sj.manage.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;
import top.sj.entity.SjLeavemessages;
import top.sj.manage.dao.CommentsOrReplyDao;
import top.sj.manage.service.CommentsOrReplyService;
import top.sj.manage.util.MessageTypeByCommentsOrReplyEnum;
import top.sj.manage.util.UnVerifyCommentsOrReplyMessageDataGridNode;
import top.sj.tool.DateTimeTool;
import top.sj.tool.TimestampTool;
import top.sj.util.VerifyStateByCommentsOrReplyEnum;

/**
 * 评论/回复业务接口的实现类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年8月25日 下午5:34:42
 * Modify User: SteveJrong
 * Modify Date: 2016年8月25日 下午5:34:42
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class CommentsOrReplyServiceImpl implements CommentsOrReplyService {

	/**
	 * 评论/回复接口类型的属性，用于Spring Ioc
	 */
	private CommentsOrReplyDao mCommentsOrReplyDao;

	public void setmCommentsOrReplyDao(CommentsOrReplyDao mCommentsOrReplyDao) {
		this.mCommentsOrReplyDao = mCommentsOrReplyDao;
	}

	@Override
	public JSONObject getUnverifyCOrRInfoBySplitPageService(Integer pageIndex,
			Integer pageSize) {
		List<SjLeavemessages> leavemessages = mCommentsOrReplyDao
				.getUnverifyCOrRInfoBySplitPage(pageIndex, pageSize);
		List<UnVerifyCommentsOrReplyMessageDataGridNode> verifyCommentsOrReplyMessageDataGridNodes = new ArrayList<UnVerifyCommentsOrReplyMessageDataGridNode>();
		for (int i = 0; i < leavemessages.size(); i++) {
			verifyCommentsOrReplyMessageDataGridNodes
					.add(new UnVerifyCommentsOrReplyMessageDataGridNode(
							leavemessages.get(i).getMId(),
							leavemessages.get(i).getSjUsersByMUId()
									.getUNickname(),
							null == leavemessages.get(i).getSjUsersByMReplyId() ? " -- "
									: leavemessages.get(i)
											.getSjUsersByMReplyId()
											.getUNickname(), TimestampTool
									.toString(leavemessages.get(i)
											.getMPublishdate()),
							MessageTypeByCommentsOrReplyEnum
									.getMsgTypeByTypeId(leavemessages.get(i)
											.getMMessageType()), leavemessages
									.get(i).getMComments(),
							VerifyStateByCommentsOrReplyEnum
									.getStateOfStringByStateId(leavemessages
											.get(i).getMVerifystate()),
							leavemessages.get(i).getMIpaddress(), leavemessages
									.get(i).getMDeviceinfo(), leavemessages
									.get(i).getMSysteminfo()));
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", this.getUnverifyCOrRInfoAllCountOfSplitPageService());
		map.put("rows", verifyCommentsOrReplyMessageDataGridNodes);
		return JSONObject.fromObject(map);
	}

	@Override
	public Integer getUnverifyCOrRInfoAllCountOfSplitPageService() {
		return mCommentsOrReplyDao.getUnverifyCOrRInfoAllCountOfSplitPage();
	}

	/**
	 * 审核评论/回复消息的方法【业务逻辑】
	 */
	@Override
	public Boolean verifycOrRInfoService(Integer cOrRId, Boolean verifyResult) {
		SjLeavemessages leavemessages = getCOrRInfoByIdService(cOrRId);
		// 1表示审核通过，2表示审核不通过
		leavemessages.setMVerifystate(verifyResult == true ? 1 : 2);
		return mCommentsOrReplyDao.verifycOrRInfo(leavemessages);
	}

	/**
	 * 根据编号查询一个评论/回复消息实体的方法【业务逻辑】
	 */
	@Override
	public SjLeavemessages getCOrRInfoByIdService(Integer id) {
		return mCommentsOrReplyDao.getCOrRInfoById(id);
	}

	/**
	 * 分页获取所有评论/回复信息的方法【业务逻辑】
	 */
	@Override
	public JSONObject getCOrRInfoBySplitPageService(Integer pageIndex,
			Integer pageSize, String searchStartDate, String searchEndDate,
			String searchVerifyStatus) {
		List<SjLeavemessages> leavemessages = mCommentsOrReplyDao
				.getCOrRInfoBySplitPage(
						pageIndex,
						pageSize,
						null != searchStartDate && !searchStartDate.equals("") ? DateTimeTool
								.stringFmtToDateFmtTemplateOne(searchStartDate
										.replace("\"", "")) : null,
						null != searchEndDate && !searchEndDate.equals("") ? DateTimeTool
								.stringFmtToDateFmtTemplateOne(searchEndDate
										.replace("\"", "")) : null,
						null != searchVerifyStatus ? VerifyStateByCommentsOrReplyEnum
								.getStateIdByState(searchVerifyStatus) : null);
		List<UnVerifyCommentsOrReplyMessageDataGridNode> verifyCommentsOrReplyMessageDataGridNodes = new ArrayList<UnVerifyCommentsOrReplyMessageDataGridNode>();
		for (int i = 0; i < leavemessages.size(); i++) {
			verifyCommentsOrReplyMessageDataGridNodes
					.add(new UnVerifyCommentsOrReplyMessageDataGridNode(
							leavemessages.get(i).getMId(),
							leavemessages.get(i).getSjUsersByMUId()
									.getUNickname(),
							null == leavemessages.get(i).getSjUsersByMReplyId() ? " -- "
									: leavemessages.get(i)
											.getSjUsersByMReplyId()
											.getUNickname(), TimestampTool
									.toString(leavemessages.get(i)
											.getMPublishdate()),
							MessageTypeByCommentsOrReplyEnum
									.getMsgTypeByTypeId(leavemessages.get(i)
											.getMMessageType()), leavemessages
									.get(i).getMComments(),
							VerifyStateByCommentsOrReplyEnum
									.getStateOfStringByStateId(leavemessages
											.get(i).getMVerifystate()),
							leavemessages.get(i).getMIpaddress(), leavemessages
									.get(i).getMDeviceinfo(), leavemessages
									.get(i).getMSysteminfo()));
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", this.getCOrRInfoAllCountOfSplitPageService());
		map.put("rows", verifyCommentsOrReplyMessageDataGridNodes);
		return JSONObject.fromObject(map);
	}

	/**
	 * 获取所有评论/回复信息总数的方法【业务逻辑】
	 */
	@Override
	public Integer getCOrRInfoAllCountOfSplitPageService() {
		return mCommentsOrReplyDao.getCOrRInfoAllCountOfSplitPage();
	}

	/**
	 * 删除一个评论/回复信息的方法【业务逻辑】
	 */
	@Override
	public Boolean delCOrRInfoByIdService(Integer cOrRId) {
		return mCommentsOrReplyDao.delCOrRInfoById(mCommentsOrReplyDao
				.getCOrRInfoById(cOrRId));
	}
}
