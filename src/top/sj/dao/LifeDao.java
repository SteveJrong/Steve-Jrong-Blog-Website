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
package top.sj.dao;

import java.util.List;
import top.sj.entity.SjLife;

/**
 * 生活接口（“玩生活”板块）
 * 
 * Create User: SteveJrong
 * Create Date: 2016年5月6日 下午4:40:28
 * Modify User: SteveJrong
 * Modify Date: 2016年5月6日 下午4:40:28
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public interface LifeDao {
	/**
	 * 分页获取博主的所有生活段子信息的方法【抽象方法】
	 * 
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	List<SjLife> getAllLifeInfoSplitPage(Integer pageIndex, Integer pageSize);

	/**
	 * 获取博主所有生活段子信息总数的方法【抽象方法】
	 * 
	 * @return
	 */
	Integer getTotalCountOfAllLifeInfoBySplitPage();
}