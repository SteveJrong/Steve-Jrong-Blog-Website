/*
 * Project Name: SJBlog
 * Class Name: SJBlogFullTextIndexesQuartz.java
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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import top.sj.common.util.MemcachedUtil;
import top.sj.entity.SjArticles;
import top.sj.lucene.LuceneIndexesUtil;
import top.sj.manage.dto.BuildFullTextSearchDTO;
import top.sj.service.ArticlesService;

import com.danga.MemCached.MemCachedClient;

/**
 * 博客数据库自动 建立/重建/更新 全文索引的Quartz任务类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年6月16日 下午4:45:06
 * Modify User: SteveJrong
 * Modify Date: 2016年6月16日 下午4:45:06
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class SJBlogFullTextIndexesQuartz {
	
	private static Logger LOGGER = LoggerFactory.getLogger(SJBlogFullTextIndexesQuartz.class);

	/**
	 * 博文业务接口类型的属性，用于Spring Ioc
	 */
	private ArticlesService articlesService;

	public void setArticlesService(ArticlesService articlesService) {
		this.articlesService = articlesService;
	}

	/**
	 * 触发器的执行方法
	 * 
	 * @throws UnsupportedEncodingException
	 */
	protected synchronized void execute() throws UnsupportedEncodingException {

		// 获取Memcached实例
		MemCachedClient client = MemcachedUtil.getInstance();

		// 获取Memcached中的Map集合
		Map<String, Object> maps = MemcachedUtil.getMemcachedKVs();

		Iterator<Entry<String, Object>> iterator = maps.entrySet().iterator();

		while (iterator.hasNext()) {
			Entry<String, Object> entry = iterator.next();

			// 这里需要判断：如果本次进来获取key后为空，那么继续循环，避免本次如果获取的key为空之后继续往后执行而报错
			if (null == client.get(entry.getKey()))
				continue;

			if (client.get(entry.getKey()) instanceof BuildFullTextSearchDTO) {

				// 如果存在重建索引的标识符
				if (((BuildFullTextSearchDTO) client.get(entry.getKey()))
						.getBuildFlagValue() == true) {
					// 那么就重建索引
					List<SjArticles> articles = articlesService
							.getArticlesInfoByBuildLuceneIndexesService();

					String[][] datas = new String[articles.size()][8];

					for (int i = 0; i < articles.size(); i++) {
						datas[i][0] = "AId";
						datas[i][1] = articles.get(i).getAId().toString();
						datas[i][2] = "ABriefcontents";
						datas[i][3] = articles.get(i).getABriefcontents()
								.toString();
						datas[i][4] = "ABodycontents";
						datas[i][5] = articles.get(i).getABodycontents()
								.toString();
						datas[i][6] = "AName";
						datas[i][7] = articles.get(i).getAName().toString();
					}

					try {
						LuceneIndexesUtil.buildFileIndexes(datas);
						LOGGER.info("Build full text search indexes was been successed!");
					} catch (Exception e) {
						LOGGER.error("Build full text search indexes was been failed!");
					}
				} else {
					LOGGER.warn("Needn't build or rebuild full text search indexes now.");
				}
			}
		}
	}
}
