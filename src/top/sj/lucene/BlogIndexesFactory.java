/*
 * Project Name: SJBlog
 * Class Name: BlogIndexesFactory.java
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
package top.sj.lucene;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import top.sj.entity.SjArticles;
import top.sj.service.ArticlesService;

/**
 * 博客索引工厂类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年6月13日 下午9:54:54
 * Modify User: SteveJrong
 * Modify Date: 2016年6月13日 下午9:54:54
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class BlogIndexesFactory {

	private static Logger LOGGER = Logger.getLogger(BlogIndexesFactory.class);

	/**
	 * 创建博客索引的方法
	 */
	public void buildIndexes() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		ArticlesService service = (ArticlesService) context
				.getBean("articlesService");
		List<SjArticles> articles = service
				.getArticlesBriefInfoOfTopFiveService();

		String[][] datas = new String[articles.size()][8];

		for (int i = 0; i < articles.size(); i++) {
			// 主键
			datas[i][0] = "AId";
			datas[i][1] = articles.get(i).getAId().toString();
			// 博文简略内容
			datas[i][2] = "ABriefcontents";
			datas[i][3] = articles.get(i).getABriefcontents().toString();
			// 博文正文内容
			datas[i][4] = "ABodycontents";
			datas[i][5] = articles.get(i).getABodycontents().toString();
			// 博文标题
			datas[i][6] = "AName";
			datas[i][7] = articles.get(i).getAName().toString();
		}

		try {
			LuceneIndexesUtil.buildFileIndexes(datas);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
			LOGGER.error("博客全文索引建立失败！原因：" + e.getMessage());
		}
		LOGGER.info("博客全文索引建立成功。");
	}
}
