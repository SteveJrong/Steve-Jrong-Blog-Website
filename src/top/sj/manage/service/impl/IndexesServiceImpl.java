/*
 * Project Name: SJBlog
 * Class Name: IndexesServiceImpl.java
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
package top.sj.manage.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import top.sj.common.util.MemcachedUtil;
import top.sj.manage.dto.BuildFullTextSearchDTO;
import top.sj.manage.service.IndexesService;
import top.sj.tool.DateTimeTool;

import com.danga.MemCached.MemCachedClient;

/**
 * 全文索引业务接口的实现类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年6月16日 下午4:30:42
 * Modify User: SteveJrong
 * Modify Date: 2016年6月16日 下午4:30:42
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class IndexesServiceImpl implements IndexesService {
	private static Logger LOGGER = LoggerFactory
			.getLogger(IndexesServiceImpl.class);

	/**
	 * 设置重建全文索引标识符的方法【业务逻辑】
	 */
	@Override
	public Boolean setReBuildFullTextIndexesFlagService() {
		// 获取Memcached对象的实例
		try {
			MemCachedClient client = MemcachedUtil.getInstance();
			client.add("rebuild_full_text_indexes", new BuildFullTextSearchDTO(
					"rebuild_full_text_indexes", true));
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("建立重建索引标识符失败！详细信息：" + e.getMessage());
			return false;
		}
		LOGGER.info("建立重建索引标识符成功。建立时间："
				+ DateTimeTool.getNowDateFormatDateTimeTemplateOne());
		return true;
	}
}
