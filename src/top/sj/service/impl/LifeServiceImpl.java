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
package top.sj.service.impl;

import java.util.ArrayList;
import java.util.List;

import top.sj.dao.LifeDao;
import top.sj.dto.PlayLifeDTO;
import top.sj.dto.PlayLifeDatasDTO;
import top.sj.entity.SjLife;
import top.sj.service.LifeService;
import top.sj.tool.TimestampTool;

/**
 * 生活业务接口的实现类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年5月6日 下午4:52:26
 * Modify User: SteveJrong
 * Modify Date: 2016年5月6日 下午4:52:26
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class LifeServiceImpl implements LifeService {

	/**
	 * 生活接口类型的属性
	 */
	private LifeDao lifeDao;

	public void setLifeDao(LifeDao lifeDao) {
		this.lifeDao = lifeDao;
	}

	/**
	 * 分页获取博主的所有生活段子信息的方法【业务逻辑】
	 */
	@Override
	public List<PlayLifeDatasDTO> getAllLifeInfoSplitPageService(Integer pageIndex,
			Integer pageSize) {
		List<PlayLifeDatasDTO> playLifes = new ArrayList<PlayLifeDatasDTO>();
		
		List<SjLife> lifes = lifeDao.getAllLifeInfoSplitPage(pageIndex, pageSize);
		
		for (SjLife sjLife : lifes) {
			playLifes.add(new PlayLifeDatasDTO(sjLife.getLId(), TimestampTool.toString(sjLife.getLPublishdate()), sjLife.getLContents(), sjLife.getLSysteminfo(), sjLife.getLDeviceinfo()));
		}
		return playLifes;
	}

	/**
	 * 获取博主所有生活段子信息总数的方法【业务逻辑】
	 */
	@Override
	public Integer getTotalCountOfAllLifeInfoBySplitPageService() {
		return lifeDao.getTotalCountOfAllLifeInfoBySplitPage();
	}
}
