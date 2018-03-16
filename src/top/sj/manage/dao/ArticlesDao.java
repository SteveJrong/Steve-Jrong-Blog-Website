/*
 * Project Name: SJBlog
 * Class Name: ArticleDao.java
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
package top.sj.manage.dao;

import java.util.List;

import top.sj.entity.SjArticles;
import top.sj.entity.SjArticletypes;

/**
 * 文章接口
 * 
 * Create User: SteveJrong
 * Create Date: 2016年3月22日 下午9:41:58
 * Modify User: SteveJrong
 * Modify Date: 2016年3月22日 下午9:41:58
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public interface ArticlesDao {

	/**
	 * 分页获取文章信息的方法【抽象方法】
	 * 
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	List<SjArticles> getArticlesInfoBySplitPage(Integer pageIndex,
			Integer pageSize);

	/**
	 * 获取分页时文章信息总数的方法【抽象方法】
	 * 
	 * @return
	 */
	Integer getArticlesInfoAllCountOfSplitPage();

	/**
	 * 获取所有文章类型信息的方法【抽象方法】
	 * 
	 * @return
	 */
	List<SjArticletypes> getArticleTypesInfo();

	/**
	 * 添加新博文信息的方法【抽象方法】
	 * 
	 * @param articles
	 * @return
	 */
	Boolean addNewArticlesInfo(SjArticles articles);

	/**
	 * 根据文章编号删除文章信息的方法【抽象方法】
	 * 
	 * @param id
	 * @return
	 */
	Boolean delArticleInfoById(Integer id);

	/**
	 * 根据文章编号获取单个文章信息的方法【抽象方法】
	 * 
	 * @return
	 */
	SjArticles getSingleArticleInfoById(Integer id);
	
	/**
	 * 更新文章信息的方法【抽象方法】
	 * @param articles
	 * @return
	 */
	Boolean updateArticleInfo(SjArticles articles);
	
	/**
	 * 根据文章编号获取文章信息的方法【抽象方法】
	 * @param articleId
	 * @return
	 */
	SjArticles getArticleInfoByArticleId(Integer articleId);
}
