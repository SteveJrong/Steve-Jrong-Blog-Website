/*
 * Project Name: SJBlog
 * Class Name: ArticlesServiceImpl.java
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
package top.sj.service.impl;

import java.util.List;

import top.sj.dao.ArticlesDao;
import top.sj.entity.SjArticles;
import top.sj.service.ArticlesService;
import top.sj.util.ArchiveArticlesInfoEntity;

/**
 * 文章业务接口的实现类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年2月17日 下午3:22:53
 * Modify User: SteveJrong
 * Modify Date: 2016年2月17日 下午3:22:53
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class ArticlesServiceImpl implements ArticlesService {

	/**
	 * 文章接口类型的属性，用于Spring Ioc
	 */
	private ArticlesDao articlesDao;

	public void setArticlesDao(ArticlesDao articlesDao) {
		this.articlesDao = articlesDao;
	}

	/**
	 * 获取数据库5条最新文章信息的方法【业务逻辑】
	 */
	@Override
	public List<SjArticles> getArticlesBriefInfoOfTopFiveService() {
		return articlesDao.getArticlesBriefInfoOfTopFive();
	}

	/**
	 * 获取“最近更新”栏目链接信息的方法【业务逻辑】
	 */
	@Override
	public List<SjArticles> getRecentUpdatesLinkInfoService() {
		return articlesDao.getRecentUpdatesLinkInfo();
	}

	/**
	 * 获取“文章归档”栏目下按照时间将文章归档信息的方法【业务逻辑】
	 */
	@Override
	public List<ArchiveArticlesInfoEntity> getAccordingToDateForArchiveArticleInfoService() {
		return articlesDao.getAccordingToDateForArchiveArticleInfo();
	}

	/**
	 * 根据文章编号获取文章信息的方法【业务逻辑】
	 */
	@Override
	public SjArticles getArticleDetailByArticleIdService(Integer id) {
		return articlesDao.getArticleDetailByArticleId(id);
	}

	/**
	 * 分页获取文章信息总数的方法【业务逻辑】
	 */
	@Override
	public Integer getAllArticlesOfGetAllCountSplitPageService() {
		return articlesDao.getAllArticlesOfGetAllCountSplitPage();
	}

	/**
	 * 分页获取文章列表信息的方法【业务逻辑】
	 */
	@Override
	public List<SjArticles> getAllArticlesSplitPageService(Integer pageIndex,
			Integer pageSize) {
		return articlesDao.getAllArticlesSplitPage(pageIndex, pageSize);
	}

	/**
	 * 分页获取指定时间段的文章信息总数的方法【业务逻辑】
	 */
	@Override
	public Integer getArticlesAccordingToCreateDateSOfGetAllCountSplitPageService(
			String datetimePartion) {
		return articlesDao
				.getArticlesAccordingToCreateDateSOfGetAllCountSplitPage(datetimePartion);
	}

	/**
	 * 分页获取指定时间段的文章信息的方法【业务逻辑】
	 */
	@Override
	public List<SjArticles> getArticlesAccordingToCreateDateSplitPageService(
			Integer pageIndex, Integer pageSize, String datetimePartion) {
		return articlesDao.getArticlesAccordingToCreateDateSplitPage(pageIndex,
				pageSize, datetimePartion);
	}

	/**
	 * 分页获取指定类别的文章信息总数的方法【业务逻辑】
	 */
	@Override
	public Integer getArticlesAccordingToArticleTypeSOfGetAllCountSplitPageService(
			Integer articleType) {
		return articlesDao
				.getArticlesAccordingToArticleTypeSOfGetAllCountSplitPage(articleType);
	}

	/**
	 * 分页获取指定类别的文章信息的方法【业务逻辑】
	 */
	@Override
	public List<SjArticles> getArticlesAccordingToArticleTypeSplitPageService(
			Integer pageIndex, Integer pageSize, Integer articleType) {
		return articlesDao.getArticlesAccordingToArticleTypeSplitPage(
				pageIndex, pageSize, articleType);
	}

	/**
	 * 获取所有博文信息用于建立Lucene文件索引的方法【业务逻辑】
	 */
	@Override
	public List<SjArticles> getArticlesInfoByBuildLuceneIndexesService() {
		return articlesDao.getArticlesInfoByBuildLuceneIndexes();
	}
}
