/*
 * Project Name: SJBlog
 * Class Name: BigDataDao.java
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

/**
 * 大数据接口
 * 
 * Create User: SteveJrong
 * Create Date: 2016年4月3日 下午12:30:29
 * Modify User: SteveJrong
 * Modify Date: 2016年4月3日 下午12:30:29
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public interface BigDataDao {
	/**
	 * 获取本周访客历史记录信息的方法【抽象方法】
	 * 
	 * @return
	 */
	List<Object> getThisWeekGuestsVistedInfo();
}