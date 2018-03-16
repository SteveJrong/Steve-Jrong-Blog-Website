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
package top.sj.service;

import java.util.List;

import top.sj.dto.PlayLifeDatasDTO;

/**
 * 生活业务接口
 * 
 * Create User: SteveJrong
 * Create Date: 2016年5月6日 下午4:51:29
 * Modify User: SteveJrong
 * Modify Date: 2016年5月6日 下午4:51:29
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public interface LifeService {
	/**
	 * 分页获取博主的所有生活段子信息的方法【抽象业务逻辑】
	 * 
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	List<PlayLifeDatasDTO> getAllLifeInfoSplitPageService(Integer pageIndex,
			Integer pageSize);

	/**
	 * 获取博主所有生活段子信息总数的方法【抽象业务逻辑】
	 * 
	 * @return
	 */
	Integer getTotalCountOfAllLifeInfoBySplitPageService();
}
