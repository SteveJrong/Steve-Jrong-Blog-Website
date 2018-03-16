/*
 * Project Name: SJBlog
 * Class Name: GuestHistoryRecord.java
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
package top.sj.guest.history;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import top.sj.common.util.HttpNetUtil;
import top.sj.common.util.MemcachedUtil;
import top.sj.dto.GuestsHistoryDTO;
import top.sj.tool.BaiDuIPInfoTool;
import top.sj.tool.ReverseProxyIPInfoTool;
import top.sj.tool.TaoBaoIPInfoTool;

import com.danga.MemCached.MemCachedClient;

/**
 * 访客历史记录类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年3月30日 下午7:40:01
 * Modify User: SteveJrong
 * Modify Date: 2016年3月30日 下午7:40:01
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class GuestHistoryRecord {
	private Logger LOGGER = LoggerFactory.getLogger(GuestHistoryRecord.class);
	
	/**
	 * 过滤网站访客信息的方法
	 * 
	 * @throws UnsupportedEncodingException
	 */
	public void guestsInfoFilter(HttpServletRequest request) throws UnsupportedEncodingException {

		final HttpServletRequest request2 = request;
		
		Thread thread = new Thread(){
			@Override
			public void run() {
				try {
					LOGGER.info(" -- 开始在线程【ID："+Thread.currentThread().getId()+"；Name："+Thread.currentThread().getName()+"】中记录访客信息 -- ");
					try {
						recordGuestInfoInOtherThread(request2);
					} catch (JSONException e) {
						LOGGER.warn(" -- JSON Exception:"+e.getMessage()+" -- ");
					}
					LOGGER.info(" -- 在线程【ID："+Thread.currentThread().getId()+"；Name："+Thread.currentThread().getName()+"】中记录访客信息成功 -- ");
				} catch (UnsupportedEncodingException e) {
					LOGGER.info(" -- 在线程【ID："+Thread.currentThread().getId()+"；Name："+Thread.currentThread().getName()+"】中记录访客信息失败 -- ");
					e.printStackTrace();
				}
			}
		};
		
		thread.start();
	}
	
	
	/**
	 * 在单独的线程中来记录访客信息，避免转到主页时因为去判断访客IP而主线程去长时间等待
	 * @param request
	 * @throws UnsupportedEncodingException
	 */
	public void recordGuestInfoInOtherThread(HttpServletRequest request)
			throws UnsupportedEncodingException {
		MemCachedClient client = MemcachedUtil.getInstance();

//		// 获取用户的IP地址
//		String guestIP = ReverseProxyIPInfoTool.getClientIP(request);
//		LOGGER.info(" -- 通过反向代理工具获取的IP地址："+guestIP+" -- ");
//		
//		// 获取用户的区域信息（已替换为百度API获取地理位置详情）
//		String guestArea = BaiDuIPInfoTool.getIPInfo(
//				"http://apis.baidu.com/apistore/iplookupservice/iplookup",
//				"ip=" + guestIP);
//		LOGGER.info(" -- 通过IP地址获取的地理位置信息："+guestArea+" -- ");
		
		String guestIP,guestArea = null;
		
		guestIP = ReverseProxyIPInfoTool.getClientIP(request);
		LOGGER.info(" -- 通过反向代理工具获取的IP地址："+guestIP+" -- ");

		guestArea = TaoBaoIPInfoTool.getIPInfo(guestIP);
		LOGGER.info(" -- 通过淘宝IP地址信息工具获取的IP信息："+guestArea+" -- ");
		
		// 先进行判断，看Memcached中是否保存有此IP，即此IP访问过网站没有
		Map<String, Object> maps = MemcachedUtil.getMemcachedKVs();

		Iterator<Entry<String, Object>> iterator = maps.entrySet().iterator();

		// 标识默认为false
		Boolean flag = false;

		while (iterator.hasNext()) {
			Entry<String, Object> entry = iterator.next();

			// 如果找到了相同的IP
			if (entry.getKey().equals(guestIP)) {

				// 设置标识为true，表示此IP之前访问过网站
				flag = true;
			}
		}

		// 为true表示访问过网站，更新缓存中的最后一次访问时间且增加一次访问时间记录
		if (flag) {

			GuestsHistoryDTO tempDTO = (GuestsHistoryDTO) client.get(guestIP);

			// 更新最后一次访问时间
			tempDTO.setLastVistedDateTime(new Date(System.currentTimeMillis()));

			// 增加一次访问时间记录
			tempDTO.getVisiteDateTimerecords().add(
					new Date(System.currentTimeMillis()));

			// 先删除原有信息
			client.delete(guestIP);
			// 再添加新信息
			client.add(guestIP, tempDTO);

			// 否则表示从未访问过网站，以新信息放入缓存中
		} else {
			GuestsHistoryDTO tempDTO = new GuestsHistoryDTO();
			tempDTO.setFirstVistedDateTime(new Date(System.currentTimeMillis()));
			tempDTO.setGuestAddress(guestArea);
			tempDTO.setGuestIP(guestIP);
			tempDTO.setLastVistedDateTime(new Date(System.currentTimeMillis()));

			List<Date> tempDates = new ArrayList<Date>();
			tempDates.add(new Date(System.currentTimeMillis()));

			tempDTO.setVisiteDateTimerecords(tempDates);

			client.add(guestIP, tempDTO);
		}
	}
}
