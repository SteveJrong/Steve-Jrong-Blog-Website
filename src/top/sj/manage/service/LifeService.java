/*
 * Project Name: SJBlog
 * Class Name: LifeService.java
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
import top.sj.entity.SjLife;

/**
 * 生活业务接口（“玩生活”板块）
 * 
 * Create User: SteveJrong
 * Create Date: 2016年7月23日 下午7:25:51
 * Modify User: SteveJrong
 * Modify Date: 2016年7月23日 下午7:25:51
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public interface LifeService {
	/**
	 * 分页获取所有生活段子信息的方法【抽象业务逻辑】
	 * 
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	JSONObject getAllLifeInfoSplitPageService(Integer pageIndex,
			Integer pageSize);

	/**
	 * 获取所有生活段子信息总数的方法【抽象业务逻辑】
	 * 
	 * @return
	 */
	Integer getTotalCountOfAllLifeInfoBySplitPageService();

	/**
	 * 根据生活段子编号获取生活段子详情的方法【抽象业务逻辑】
	 * 
	 * @param lifeId
	 * @return
	 */
	SjLife getDetailInfoOfLifeByIdService(Integer lifeId);

	/**
	 * 添加一个新生活段子的方法【抽象业务逻辑】
	 * 
	 * @param life
	 * @return
	 */
	Boolean addNewLifeInfoService(SjLife life);

	/**
	 * 修改生活段子信息的方法【抽象业务逻辑】
	 * 
	 * @param id
	 * @param content
	 * @return
	 */
	Boolean updateLifeInfoService(Integer id, String content);

	/**
	 * 删除一个生活段子信息的方法【抽象业务逻辑】
	 * 
	 * @param id
	 * @return
	 */
	Boolean deleteLifeInfoService(Integer id);
}
