/*
 * Project Name: SJBlog
 * Class Name: LifeServiceImpl.java
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
import top.sj.entity.SjLife;
import top.sj.manage.dao.LifeDao;
import top.sj.manage.service.LifeService;
import top.sj.manage.util.LifeManageDataGridNode;
import top.sj.tool.TimestampTool;

/**
 * 生活段子业务接口的实现类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年11月14日 下午3:36:36
 * Modify User: SteveJrong
 * Modify Date: 2016年11月14日 下午3:36:36
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class LifeServiceImpl implements LifeService {

	/**
	 * 生活段子接口类型的属性，用于Spring Ioc
	 */
	private LifeDao mLifeDao;

	public void setmLifeDao(LifeDao mLifeDao) {
		this.mLifeDao = mLifeDao;
	}

	/**
	 * 分页获取所有生活段子信息的方法【业务逻辑】
	 */
	@Override
	public JSONObject getAllLifeInfoSplitPageService(Integer pageIndex,
			Integer pageSize) {
		List<SjLife> sjLifes = mLifeDao.getAllLifeInfoSplitPage(pageIndex,
				pageSize);

		List<LifeManageDataGridNode> lifeManageDataGridNodes = new ArrayList<LifeManageDataGridNode>();
		for (int i = 0; i < sjLifes.size(); i++) {
			lifeManageDataGridNodes.add(new LifeManageDataGridNode(sjLifes
					.get(i).getLId().toString(), TimestampTool
					.toString(sjLifes.get(i).getLPublishdate()), sjLifes.get(i)
					.getLIpaddress(), sjLifes.get(i).getLContents(),
					null == sjLifes.get(i).getLModifydate() ? "暂无修改时间"
							: TimestampTool.toString(sjLifes.get(i)
									.getLModifydate())));
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", this.getTotalCountOfAllLifeInfoBySplitPageService());
		map.put("rows", lifeManageDataGridNodes);

		return JSONObject.fromObject(map);
	}

	/**
	 * 获取所有生活段子信息总数的方法【业务逻辑】
	 */
	@Override
	public Integer getTotalCountOfAllLifeInfoBySplitPageService() {
		return mLifeDao.getTotalCountOfAllLifeInfoBySplitPage();
	}

	/**
	 * 根据生活段子编号获取生活段子详情的方法【业务逻辑】
	 */
	@Override
	public SjLife getDetailInfoOfLifeByIdService(Integer lifeId) {
		return mLifeDao.getDetailInfoOfLifeById(lifeId);
	}

	/**
	 * 添加一个新生活段子的方法【业务逻辑】
	 */
	@Override
	public Boolean addNewLifeInfoService(SjLife life) {
		return mLifeDao.addNewLifeInfo(life);
	}

	/**
	 * 修改生活段子信息的方法【业务逻辑】
	 */
	@Override
	public Boolean updateLifeInfoService(Integer id, String content) {
		SjLife life = this.getDetailInfoOfLifeByIdService(id);
		life.setLContents(content);
		life.setLModifydate(TimestampTool.convertNowDateToStimeStamp());
		return mLifeDao.updateLifeInfo(life);
	}

	/**
	 * 删除一个生活段子信息的方法【业务逻辑】
	 */
	@Override
	public Boolean deleteLifeInfoService(Integer id) {
		SjLife life = this.getDetailInfoOfLifeByIdService(id);
		return mLifeDao.deleteLifeInfo(life);
	}
}
