/*
 * Project Name: SJBlog
 * Class Name: ArticlesDao.java
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

import java.util.List;
import top.sj.entity.SjArticles;
import top.sj.util.ArchiveArticlesInfoEntity;

/**
 * 文章接口
 * 
 * Create User: SteveJrong
 * Create Date: 2016-2-17 下午2:08:39
 * Modify User: SteveJrong
 * Modify Date: 2016-2-17 下午2:08:39
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public interface ArticlesDao {
	/**
	 * 获取数据库5条最新文章信息的方法【抽象方法】
	 * 
	 * 方法描述:
	 * 
	 * @return
	 * @returnType List<SjArticles> 创建人： Steve Jrong 创建时间：2016-2-17 下午3:04:34
	 */
	List<SjArticles> getArticlesBriefInfoOfTopFive();

	/**
	 * 获取“最近更新”栏目链接信息的方法【抽象方法】
	 * 
	 * 方法描述:
	 * 
	 * @return
	 * @returnType List<SjArticles> 创建人： Steve Jrong 创建时间：2016-2-17 下午4:17:04
	 */
	List<SjArticles> getRecentUpdatesLinkInfo();

	/**
	 * 获取“文章归档”栏目下按照时间将文章归档信息的方法【抽象方法】
	 * 
	 * 方法描述:
	 * 
	 * @return
	 * @returnType List<ArchiveArticlesInfoEntity> 创建人： Steve Jrong
	 *             创建时间：2016-2-17 下午5:08:53
	 */
	List<ArchiveArticlesInfoEntity> getAccordingToDateForArchiveArticleInfo();

	/**
	 * 根据文章编号获取文章信息的方法【抽象方法】
	 * 
	 * 方法描述:
	 * 
	 * @param id
	 * @return
	 * @returnType SjArticles 创建人： Steve Jrong 创建时间：2016-2-27 下午8:31:26
	 */
	SjArticles getArticleDetailByArticleId(Integer id);

	/**
	 * 分页获取文章信息总数的方法【抽象方法】
	 * 
	 * 方法描述:
	 * 
	 * @return
	 * @returnType Integer 创建人： Steve Jrong 创建时间：2016-2-27 下午9:58:29
	 */
	Integer getAllArticlesOfGetAllCountSplitPage();

	/**
	 * 分页获取文章列表信息的方法【抽象方法】
	 * 
	 * 方法描述:
	 * 
	 * @param pageIndex
	 *            当前页数
	 * @param pageSize
	 *            每页显示的条数
	 * @return
	 * @returnType List<SjArticles> 创建人： Steve Jrong 创建时间：2016-2-27 下午9:59:31
	 */
	List<SjArticles> getAllArticlesSplitPage(Integer pageIndex, Integer pageSize);

	/**
	 * 分页获取指定时间段的文章信息总数的方法【抽象方法】
	 * 
	 * 方法描述:
	 * 
	 * @param datetimePartion
	 * @return
	 * @returnType Integer 创建人： Steve Jrong 创建时间：2016-2-28 下午2:58:32
	 */
	Integer getArticlesAccordingToCreateDateSOfGetAllCountSplitPage(
			String datetimePartion);

	/**
	 * 分页获取指定时间段的文章信息的方法【抽象方法】
	 * 
	 * 方法描述:
	 * 
	 * @param pageIndex
	 * @param pageSize
	 * @param datetimePartion
	 * @return
	 * @returnType List<SjArticles> 创建人： Steve Jrong 创建时间：2016-2-28 下午2:56:24
	 */
	List<SjArticles> getArticlesAccordingToCreateDateSplitPage(
			Integer pageIndex, Integer pageSize, String datetimePartion);

	/**
	 * 分页获取指定类别的文章信息总数的方法【抽象方法】
	 * 
	 * 方法描述:
	 * 
	 * @param articleType
	 * @return
	 * @returnType Integer 创建人： Steve Jrong 创建时间：2016-3-14 下午8:43:34
	 */
	Integer getArticlesAccordingToArticleTypeSOfGetAllCountSplitPage(
			Integer articleType);

	/**
	 * 分页获取指定类别的文章信息的方法【抽象方法】
	 * 
	 * 方法描述:
	 * 
	 * @param pageIndex
	 * @param pageSize
	 * @param articleType
	 * @return
	 * @returnType List<SjArticles> 创建人： Steve Jrong 创建时间：2016-3-14 下午8:43:42
	 */
	List<SjArticles> getArticlesAccordingToArticleTypeSplitPage(
			Integer pageIndex, Integer pageSize, Integer articleType);

	/**
	 * 获取所有博文信息用于建立Lucene文件索引的方法【抽象方法】
	 * 
	 * @return
	 */
	List<SjArticles> getArticlesInfoByBuildLuceneIndexes();
}