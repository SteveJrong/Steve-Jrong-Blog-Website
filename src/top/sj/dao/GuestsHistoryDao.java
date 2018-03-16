/*
 * Project Name: SJBlog
 * Class Name: GuestsHistoryDao.java
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

import top.sj.entity.SjGuestshistory;

/**
 * 访客历史记录接口
 * 
 * Create User: SteveJrong
 * Create Date: 2016年4月2日 上午12:20:12
 * Modify User: SteveJrong
 * Modify Date: 2016年4月2日 上午12:20:12
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public interface GuestsHistoryDao {
	/**
	 * 保存访客历史记录的方法【抽象方法】
	 * 
	 * @param guestshistory
	 * @return
	 */
	Boolean saveGuestsRecord(SjGuestshistory guestshistory);

	/**
	 * 根据IP地址判断有无记录的方法【抽象方法】
	 * 
	 * @param ipAddress
	 * @return
	 */
	Boolean existsGuestsVisiteInfo(String ipAddress);

	/**
	 * 根据IP地址获取一个访客信息的方法【抽象方法】
	 * 
	 * @param ipAddress
	 * @return
	 */
	SjGuestshistory getAGuestInfoByIPAddress(String ipAddress);
}