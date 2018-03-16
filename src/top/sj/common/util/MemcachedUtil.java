/*
 * Project Name: SJBlog
 * Class Name: MemcachedUtil.java
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
package top.sj.common.util;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.util.ResourceUtils;

import top.sj.dto.GuestsHistoryDTO;
import top.sj.manage.dto.BuildFullTextSearchDTO;
import top.sj.tool.DateTimeTool;

import com.danga.MemCached.MemCachedClient;

/**
 * Memcached工具类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年3月31日 上午9:03:50
 * Modify User: SteveJrong
 * Modify Date: 2016年3月31日 上午9:03:50
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class MemcachedUtil {
	private static Logger LOGGER = LoggerFactory.getLogger(MemcachedUtil.class);

	private static MemCachedClient client;

	/**
	 * 初始化Memcached
	 */
	public static MemCachedClient getInstance() {
		if (client == null) {

//			String path1 = Thread.currentThread().getContextClassLoader()
//					.getResource("").getPath()
//					+ "/spring-memcache.xml";
//
//			String path2 = Thread.currentThread().getContextClassLoader()
//					.getResource("").getPath()
//					+ "/applicationContext.xml";
			
//			String /*path1 = null,*/path2 = null;
			
//			try {
//				path1 = ResourceUtils.getFile("classpath:spring-memcache.xml").getPath();
//			} catch (FileNotFoundException e) {
//				e.printStackTrace();
//			}
			
//			try {
//				path2 = ResourceUtils.getFile("applicationContext.xml").getPath();
//			} catch (FileNotFoundException e) {
//				e.printStackTrace();
//			}

//			LOGGER.info("1 MemcachedUtil中的path1："+path1);
//			LOGGER.info("1 MemcachedUtil中的path2："+path2);
			
//			ApplicationContext ctx = new FileSystemXmlApplicationContext(
//					new String[] { path1.substring(path1.indexOf("/")),
//							path2.substring(path2.indexOf("/")) });
			
//			ApplicationContext ctx = new FileSystemXmlApplicationContext(
//					new String[] { /*path1, */path2 });
			
			client = SpringContextHolder.getBean("memcachedClient");

			return client;
		}
		return client;
	}

	/**
	 * 从Memcached中获取所有缓存键值对的方法
	 * 
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static Map<String, Object> getMemcachedKVs()
			throws UnsupportedEncodingException {

		Map<String, Object> memcachedMaps = new HashMap<String, Object>();

		MemCachedClient client = MemcachedUtil.getInstance();
		Map<String, Map<String, String>> statsItems = MemcachedUtil
				.getInstance().statsItems();
		Map<String, String> statsItems_sub = null;
		String statsItems_sub_key = null;
		int items_number = 0;
		String server = null;
		Map<String, Map<String, String>> statsCacheDump = null;
		Map<String, String> statsCacheDump_sub = null;
		String statsCacheDumpsub_key = null;
		GuestsHistoryDTO statsCacheDumpsub_key_value = null;
		BuildFullTextSearchDTO full_text_search_key_value = null;

		for (Iterator<String> iterator = statsItems.keySet().iterator(); iterator
				.hasNext();) {
			server = (String) iterator.next();
			statsItems_sub = statsItems.get(server);
			for (Iterator<String> iterator_item = statsItems_sub.keySet()
					.iterator(); iterator_item.hasNext();) {
				statsItems_sub_key = (String) iterator_item.next();
				if (statsItems_sub_key.toUpperCase().startsWith(
						"items:".toUpperCase())
						&& statsItems_sub_key.toUpperCase().endsWith(
								":number".toUpperCase())) {
					items_number = Integer.parseInt(statsItems_sub.get(
							statsItems_sub_key).trim());
					statsCacheDump = MemcachedUtil.getInstance()
							.statsCacheDump(
									new String[] { server },
									Integer.parseInt(statsItems_sub_key
											.split(":")[1].trim()),
									items_number);

					for (Iterator<String> statsCacheDump_iterator = statsCacheDump
							.keySet().iterator(); statsCacheDump_iterator
							.hasNext();) {
						statsCacheDump_sub = statsCacheDump
								.get(statsCacheDump_iterator.next());
						for (Iterator<String> iterator_keys = statsCacheDump_sub
								.keySet().iterator(); iterator_keys.hasNext();) {
							statsCacheDumpsub_key = (String) iterator_keys
									.next();

							if (client.get(statsCacheDumpsub_key) instanceof GuestsHistoryDTO) {
								statsCacheDumpsub_key_value = (GuestsHistoryDTO) client
										.get(statsCacheDumpsub_key);

								memcachedMaps.put(URLDecoder.decode(
										statsCacheDumpsub_key, "UTF-8"),
										statsCacheDumpsub_key_value);

								LOGGER.info("Guest history:Key is"
										+ URLDecoder.decode(
												statsCacheDumpsub_key, "UTF-8")
										+ ",value is"
										+ statsCacheDumpsub_key_value
										+ ". added date was"
										+ DateTimeTool
												.getNowDateFormatDateTimeTemplateOne());
							}

							if (client.get(statsCacheDumpsub_key) instanceof BuildFullTextSearchDTO) {
								full_text_search_key_value = (BuildFullTextSearchDTO) client
										.get(statsCacheDumpsub_key);

								memcachedMaps
										.put(URLDecoder.decode(
												statsCacheDumpsub_key, "UTF-8"),
												full_text_search_key_value
														.getBuildFlagValue()
														.toString());

								LOGGER.info("Full test search:Key is"
										+ URLDecoder.decode(
												statsCacheDumpsub_key, "UTF-8")
										+ ",value is"
										+ full_text_search_key_value
												.getBuildFlagValue().toString()
										+ ". added date was"
										+ DateTimeTool
												.getNowDateFormatDateTimeTemplateOne());
							}

							// Key
							// System.out.println(URLDecoder.decode(
							// statsCacheDumpsub_key, "UTF-8"));

							// Value
							// System.out.println(statsCacheDumpsub_key_value);

						}
					}
				}

			}
		}
		return memcachedMaps;
	}
}
