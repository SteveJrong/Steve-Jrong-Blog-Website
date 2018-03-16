/*
 * Project Name: SJBlog
 * Class Name: LifeDao.java
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

import java.util.List;

import top.sj.entity.SjLife;

/**
 * 生活接口（“玩生活”板块）
 * 
 * Create User: SteveJrong
 * Create Date: 2016年7月23日 下午7:16:53
 * Modify User: SteveJrong
 * Modify Date: 2016年7月23日 下午7:16:53
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public interface LifeDao {
	/**
	 * 分页获取所有生活段子信息的方法【抽象方法】
	 * 
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	List<SjLife> getAllLifeInfoSplitPage(Integer pageIndex, Integer pageSize);

	/**
	 * 获取所有生活段子信息总数的方法【抽象方法】
	 * 
	 * @return
	 */
	Integer getTotalCountOfAllLifeInfoBySplitPage();

	/**
	 * 根据生活段子编号获取生活段子详情的方法【抽象方法】
	 * 
	 * @param lifeId
	 * @return
	 */
	SjLife getDetailInfoOfLifeById(Integer lifeId);

	/**
	 * 添加一个新生活段子的方法【抽象方法】
	 * 
	 * @param life
	 * @return
	 */
	Boolean addNewLifeInfo(SjLife life);

	/**
	 * 修改生活段子信息的方法【抽象方法】
	 * 
	 * @param life
	 * @return
	 */
	Boolean updateLifeInfo(SjLife life);

	/**
	 * 删除一个生活段子信息的方法【抽象方法】
	 * 
	 * @param life
	 * @return
	 */
	Boolean deleteLifeInfo(SjLife life);
}
