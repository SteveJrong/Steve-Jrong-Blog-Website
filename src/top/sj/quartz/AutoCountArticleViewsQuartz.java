/*
 * Project Name: SJBlog
 * Class Name: AutoCountArticleViewsQuartz.java
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

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import top.sj.entity.SjArticles;
import top.sj.manage.service.ArticlesService;
import top.sj.tool.DateTimeTool;
import top.sj.util.ArticleViewsEntityUtil;
import top.sj.util.ArticleViewsManageUtil;

/**
 * 自动统计文章浏览量的Quartz任务类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年10月10日 下午2:28:26
 * Modify User: SteveJrong
 * Modify Date: 2016年10月10日 下午2:28:26
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class AutoCountArticleViewsQuartz {
	
	private Logger LOGGER = LoggerFactory.getLogger(AutoCountArticleViewsQuartz.class);

	/**
	 * 文章接口类型的属性，用于Spring Ioc【管理】
	 */
	private ArticlesService mArticlesService;
	
	public void setmArticlesService(ArticlesService mArticlesService) {
		this.mArticlesService = mArticlesService;
	}
	
	/**
	 * 文章接口类型的属性，用于Spring Ioc【前台】
	 */
	private top.sj.service.ArticlesService articlesService;
	
	public void setArticlesService(top.sj.service.ArticlesService articlesService) {
		this.articlesService = articlesService;
	}

	/**
	 * 触发器的执行方法
	 */
	protected void execute(){
		Map<Integer, ArticleViewsEntityUtil> entityUtil = ArticleViewsManageUtil.getViewsEntityUtils();
		
		LOGGER.info(" -- 开始执行持久化文章浏览量任务。在 "+DateTimeTool.getNowDateFormatDateTimeTemplateOne()+" -- ");
		
		//当管理集合不为空时进行操作
		if (entityUtil.size() > 0) {
			
			//遍历管理集合
			Iterator<Entry<Integer, ArticleViewsEntityUtil>> iterator = entityUtil.entrySet().iterator();
			while (iterator.hasNext()) {
				Entry<Integer, ArticleViewsEntityUtil> entry = iterator.next();
				try {
					SjArticles article = articlesService.getArticleDetailByArticleIdService(entry.getKey());
					article.setAReadcount(article.getAReadcount() + entry.getValue().getViewsCount());
					mArticlesService.updateArticleInfoService(article);
				} catch (Exception e) {
					LOGGER.info(" -- 执行持久化文章浏览量任务失败。在 "+DateTimeTool.getNowDateFormatDateTimeTemplateOne()+" -- ");
					e.printStackTrace();
					break;
				}
			}
			
			LOGGER.info(" -- 执行持久化文章浏览量任务成功。在 "+DateTimeTool.getNowDateFormatDateTimeTemplateOne()+" -- ");
			entityUtil.clear();
		}else {
			LOGGER.info(" -- 目前没有文章被浏览，任务终止 -- ");
		}
	}
}
