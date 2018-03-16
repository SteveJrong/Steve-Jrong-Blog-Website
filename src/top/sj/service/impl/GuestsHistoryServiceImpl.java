/*
 * Project Name: SJBlog
 * Class Name: GuestsHistoryServiceImpl.java
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

import top.sj.dao.GuestsHistoryDao;
import top.sj.entity.SjGuestshistory;
import top.sj.service.GuestsHistoryService;

/**
 * 访客历史记录业务接口的实现类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年4月2日 上午12:26:01
 * Modify User: SteveJrong
 * Modify Date: 2016年4月2日 上午12:26:01
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class GuestsHistoryServiceImpl implements GuestsHistoryService {

	/**
	 * 访客历史记录接口的属性，用于Spring Ioc
	 */
	private GuestsHistoryDao guestsHistoryDao;

	public void setGuestsHistoryDao(GuestsHistoryDao guestsHistoryDao) {
		this.guestsHistoryDao = guestsHistoryDao;
	}

	/**
	 * 保存访客历史记录的方法【业务逻辑】
	 */
	@Override
	public Boolean saveGuestsRecordService(SjGuestshistory guestshistory) {
		return guestsHistoryDao.saveGuestsRecord(guestshistory);
	}

	/**
	 * 根据IP地址判断有无记录的方法【业务逻辑】
	 */
	@Override
	public Boolean existsGuestsVisiteInfoService(String ipAddress) {
		return guestsHistoryDao.existsGuestsVisiteInfo(ipAddress);
	}

	/**
	 * 根据IP地址获取一个访客信息的方法【业务逻辑】
	 */
	@Override
	public SjGuestshistory getAGuestInfoByIPAddressService(String ipAddress) {
		return guestsHistoryDao.getAGuestInfoByIPAddress(ipAddress);
	}
}
