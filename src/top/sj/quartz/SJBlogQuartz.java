/*
 * Project Name: SJBlog
 * Class Name: SJBlogQuartz.java
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
package top.sj.quartz;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import top.sj.common.util.MemcachedUtil;
import top.sj.dto.GuestsHistoryDTO;
import top.sj.entity.SjGuestsdatehistorydetail;
import top.sj.entity.SjGuestshistory;
import top.sj.service.GuestsHistoryService;
import top.sj.tool.DateTimeTool;
import top.sj.tool.TimestampTool;
import top.sj.util.DoPraiseManageUtil;

import com.danga.MemCached.MemCachedClient;

/**
 * Quartz任务类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年4月2日 下午10:56:57
 * Modify User: SteveJrong
 * Modify Date: 2016年4月2日 下午10:56:57
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class SJBlogQuartz {

	private static Logger logger = Logger.getLogger(SJBlogQuartz.class);

	/**
	 * 访客历史记录业务接口类型的属性，用于Spring Ioc
	 */
	private GuestsHistoryService guestsHistoryService;

	public void setGuestsHistoryService(
			GuestsHistoryService guestsHistoryService) {
		this.guestsHistoryService = guestsHistoryService;
	}

	/**
	 * 触发器的执行方法
	 * 
	 * @throws UnsupportedEncodingException
	 */
	protected void execute() throws UnsupportedEncodingException {
		resetDoPraiseManagePool();
		
		saveGuestsHistory();
	}

	/**
	 * 重置点赞/取消点赞管理池
	 */
	private void resetDoPraiseManagePool() {
		if (null != DoPraiseManageUtil.getDoPraiseEntityUtils() && DoPraiseManageUtil.getDoPraiseEntityUtils().size() > 0) {
			DoPraiseManageUtil.getDoPraiseEntityUtils().clear();
			logger.info("在"+DateTimeTool.getNowDateFormatDateTimeTemplateOne()+"重置点赞管理池成功！");
		}
	}

	/**
	 * 保存访客记录信息的方法
	 * @throws UnsupportedEncodingException
	 */
	@SuppressWarnings("unchecked")
	private void saveGuestsHistory() throws UnsupportedEncodingException {
		/**
		 * 每天零点对Memcached缓存中的访客数据进行保存
		 */
		MemCachedClient client = MemcachedUtil.getInstance();

		synchronized (this) {

			// 获取Memcached中的Map集合
			Map<String, Object> maps = MemcachedUtil.getMemcachedKVs();

			Iterator<Entry<String, Object>> iterator = maps.entrySet()
					.iterator();

			while (iterator.hasNext()) {
				Entry<String, Object> entry = iterator.next();

				// 这里需要判断：如果本次进来获取key后为空，那么继续循环，避免本次如果获取的key为空之后继续往后执行而报错
				if (null == client.get(entry.getKey()))
					continue;

				if (client.get(entry.getKey()) instanceof GuestsHistoryDTO) {

					GuestsHistoryDTO tempHistoryDTO = (GuestsHistoryDTO) client
							.get(entry.getKey());

					SjGuestshistory guestshistory = new SjGuestshistory();

					// 需要先到数据库中根据IP地址进行查询，如果有记录则执行更新而不是新增
					if (guestsHistoryService
							.existsGuestsVisiteInfoService(tempHistoryDTO
									.getGuestIP())) {
						// 数据库中有记录，更新
						guestshistory = guestsHistoryService
								.getAGuestInfoByIPAddressService(tempHistoryDTO
										.getGuestIP());

						// 更新最后一次访问时间
						guestshistory.setGLastvisitordate(TimestampTool
								.convertDateToTimeStamp(new Date(System
										.currentTimeMillis())));

						for (Date item : tempHistoryDTO
								.getVisiteDateTimerecords()) {
							SjGuestsdatehistorydetail detail = new SjGuestsdatehistorydetail();
							detail.setGdVisteddatetime(TimestampTool
									.convertDateToTimeStamp(item));
							guestshistory.getSjGuestsdatehistorydetails().add(
									detail);
							detail.setSjGuestshistory(guestshistory);
						}
					} else {
						// 数据库中无记录，新增
						guestshistory.setGFirstvisitordate(TimestampTool
								.convertDateToTimeStamp(tempHistoryDTO
										.getFirstVistedDateTime()));
						guestshistory
								.setGIpaddress(tempHistoryDTO.getGuestIP());
						guestshistory.setGLastvisitordate(TimestampTool
								.convertDateToTimeStamp(tempHistoryDTO
										.getLastVistedDateTime()));
						guestshistory.setGProvinceandcity(tempHistoryDTO
								.getGuestAddress());

						for (Date item : tempHistoryDTO
								.getVisiteDateTimerecords()) {

							SjGuestsdatehistorydetail detail = new SjGuestsdatehistorydetail();

							detail.setGdVisteddatetime(TimestampTool
									.convertDateToTimeStamp(item));
							guestshistory.getSjGuestsdatehistorydetails().add(
									detail);
							detail.setSjGuestshistory(guestshistory);
						}
					}

					if (!guestsHistoryService
							.saveGuestsRecordService(guestshistory)) {
						logger.error("保存访客信息记录时出现错误，请检查！");
						return;
					}
				}
			}
		}

		logger.info("在"
				+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(
						System.currentTimeMillis())) + "保存访客信息记录成功！");
		// 成功之后删除今天缓存的数据
		client.flushAll();
		//
		// // 获取Memcached中的Map集合
		// Map<String, Object> maps = MemcachedUtil.getMemcachedKVs();
		//
		// Iterator<Entry<String, Object>> iterator =
		// maps.entrySet().iterator();
		//
		// while (iterator.hasNext()) {
		// Entry<String, Object> entry = iterator.next();
		// System.out.println(entry.getKey() + "\t" + entry.getValue());
		// }
		//
		// System.out.println("没有数据！");
	}
}
