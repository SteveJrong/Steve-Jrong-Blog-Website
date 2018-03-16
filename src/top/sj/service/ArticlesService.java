/*
 * Project Name: SJBlog
 * Class Name: ArticlesService.java
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
package top.sj.service;

import java.util.List;

import top.sj.entity.SjArticles;
import top.sj.util.ArchiveArticlesInfoEntity;

/**
 * 文章业务接口
 * 
 * Create User: SteveJrong
 * Create Date: 2016年2月17日 下午3:17:46
 * Modify User: SteveJrong
 * Modify Date: 2016年2月17日 下午3:17:46
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public interface ArticlesService {

	/**
	 * 获取数据库5条最新文章信息的方法【抽象业务逻辑】
	 * 
	 * 方法描述:
	 * 
	 * @return
	 * @returnType List<SjArticles> 创建人： Steve Jrong 创建时间：2016-2-17 下午3:19:16
	 */
	List<SjArticles> getArticlesBriefInfoOfTopFiveService();

	/**
	 * 获取“最近更新”栏目链接信息的方法【抽象业务逻辑】
	 * 
	 * 方法描述:
	 * 
	 * @return
	 * @returnType List<SjArticles> 创建人： Steve Jrong 创建时间：2016-2-17 下午4:19:00
	 */
	List<SjArticles> getRecentUpdatesLinkInfoService();

	/**
	 * 获取“文章归档”栏目下按照时间将文章归档信息的方法【抽象业务逻辑】
	 * 
	 * 方法描述:
	 * 
	 * @return
	 * @returnType List<ArchiveArticlesInfoEntity> 创建人： Steve Jrong
	 *             创建时间：2016-2-17 下午5:13:50
	 */
	List<ArchiveArticlesInfoEntity> getAccordingToDateForArchiveArticleInfoService();

	/**
	 * 根据文章编号获取文章信息的方法【抽象业务逻辑】
	 * 
	 * 方法描述:
	 * 
	 * @param id
	 * @return
	 * @returnType SjArticles 创建人： Steve Jrong 创建时间：2016-2-27 下午8:34:53
	 */
	SjArticles getArticleDetailByArticleIdService(Integer id);

	/**
	 * 分页获取文章信息总数的方法【抽象业务逻辑】
	 * 
	 * 方法描述:
	 * 
	 * @return
	 * @returnType Integer 创建人： Steve Jrong 创建时间：2016-2-27 下午10:09:35
	 */
	Integer getAllArticlesOfGetAllCountSplitPageService();

	/**
	 * 分页获取文章列表信息的方法【抽象业务逻辑】
	 * 
	 * 方法描述:
	 * 
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 * @returnType List<SjArticles> 创建人： Steve Jrong 创建时间：2016-2-27 下午10:09:43
	 */
	List<SjArticles> getAllArticlesSplitPageService(Integer pageIndex,
			Integer pageSize);

	/**
	 * 分页获取指定时间段的文章信息总数的方法【抽象业务逻辑】
	 * 
	 * 方法描述:
	 * 
	 * @param datetimePartion
	 * @return
	 * @returnType Integer 创建人： Steve Jrong 创建时间：2016-2-28 下午4:04:35
	 */
	Integer getArticlesAccordingToCreateDateSOfGetAllCountSplitPageService(
			String datetimePartion);

	/**
	 * 分页获取指定时间段的文章信息的方法【抽象业务逻辑】
	 * 
	 * 方法描述:
	 * 
	 * @param pageIndex
	 * @param pageSize
	 * @param datetimePartion
	 * @return
	 * @returnType List<SjArticles> 创建人： Steve Jrong 创建时间：2016-2-28 下午4:04:25
	 */
	List<SjArticles> getArticlesAccordingToCreateDateSplitPageService(
			Integer pageIndex, Integer pageSize, String datetimePartion);

	/**
	 * 分页获取指定类别的文章信息总数的方法【抽象业务逻辑】
	 * 
	 * 方法描述:
	 * 
	 * @param articleType
	 * @return
	 * @returnType Integer 创建人： Steve Jrong 创建时间：2016-3-14 下午8:46:54
	 */
	Integer getArticlesAccordingToArticleTypeSOfGetAllCountSplitPageService(
			Integer articleType);

	/**
	 * 分页获取指定类别的文章信息的方法【抽象业务逻辑】
	 * 
	 * 方法描述:
	 * 
	 * @param pageIndex
	 * @param pageSize
	 * @param articleType
	 * @return
	 * @returnType List<SjArticles> 创建人： Steve Jrong 创建时间：2016-3-14 下午8:47:00
	 */
	List<SjArticles> getArticlesAccordingToArticleTypeSplitPageService(
			Integer pageIndex, Integer pageSize, Integer articleType);

	/**
	 * 获取所有博文信息用于建立Lucene文件索引的方法【抽象业务逻辑】
	 * 
	 * @return
	 */
	List<SjArticles> getArticlesInfoByBuildLuceneIndexesService();
}
