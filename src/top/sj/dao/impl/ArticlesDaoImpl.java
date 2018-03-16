/*
 * Project Name: SJBlog
 * Class Name: ArticlesDaoImpl.java
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
package top.sj.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.Expression;

import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import top.sj.common.util.Constants;
import top.sj.dao.ArticlesDao;
import top.sj.entity.SjArticles;
import top.sj.tool.CalendarTool;
import top.sj.util.ArchiveArticlesInfoEntity;

/**
 * 文章接口的实现类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年2月17日 下午3:23:07
 * Modify User: SteveJrong
 * Modify Date: 2016年2月17日 下午3:23:07
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class ArticlesDaoImpl extends HibernateDaoSupport implements ArticlesDao {

	/**
	 * 获取数据库5条最新文章信息的方法
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<SjArticles> getArticlesBriefInfoOfTopFive() {
		List<SjArticles> articles = null;
		try {
			articles = super.getHibernateTemplate().executeFind(
					new HibernateCallback<List<SjArticles>>() {
						public List<SjArticles> doInHibernate(Session session) {
							return session.createCriteria(SjArticles.class,"a").createAlias("a.sjArticletypes", "t")
									.setCacheable(true)
									.addOrder(Order.desc("a.AId")).add(Restrictions.ne("t.TName", Constants.HOME_FILTER_GeRenRiJi.getValue())).list()
									.subList(0, 5);
						}
					});
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}

		return articles;
	}

	/**
	 * 获取“最近更新”栏目链接信息的方法
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<SjArticles> getRecentUpdatesLinkInfo() {
		List<SjArticles> articles = null;
		try {
			articles = super.getHibernateTemplate().executeFind(
					new HibernateCallback<List<SjArticles>>() {
						public List<SjArticles> doInHibernate(Session session) {
							return session.createCriteria(SjArticles.class)
									.setCacheable(true)
									.addOrder(Order.desc("AId")).list()
									.subList(0, 6);
						}
					});
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return articles;
	}

	/**
	 * 获取“文章归档”栏目下按照时间将文章归档信息的方法
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public List<ArchiveArticlesInfoEntity> getAccordingToDateForArchiveArticleInfo() {
		final List<ArchiveArticlesInfoEntity> archiveArticlesInfoEntities = new ArrayList<ArchiveArticlesInfoEntity>();
		try {
			super.getHibernateTemplate().executeFind(new HibernateCallback() {
				@SuppressWarnings("unchecked")
				public Object doInHibernate(Session session) {
					List<Object> resultCollection = session
							.createSQLQuery(
									"SELECT COUNT(*),DATE_FORMAT(A_CREATEDATE,'%Y-%m') AS a_month FROM sj_articles GROUP BY a_month")
							.list();

					for (int i = 0; i < resultCollection.size(); i++) {
						Object[] item = (Object[]) resultCollection.toArray()[i];
						archiveArticlesInfoEntities.add(new ArchiveArticlesInfoEntity(
								new Integer(item[0].toString()), item[1]
										.toString()));
					}

					return null;
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return archiveArticlesInfoEntities;
	}

	/**
	 * 根据文章编号获取文章信息的方法
	 */
	@Override
	public SjArticles getArticleDetailByArticleId(final Integer id) {
		SjArticles article = null;
		try {
			article = super.getHibernateTemplate().execute(
					new HibernateCallback<SjArticles>() {
						public SjArticles doInHibernate(Session session) {
							return (SjArticles) session
									.createCriteria(SjArticles.class)
									.setCacheable(true)
									.add(Restrictions.eq("AId", id))
									.uniqueResult();
						}
					});
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return article;
	}

	/**
	 * 分页获取文章信息总数的方法
	 */
	@Override
	public Integer getAllArticlesOfGetAllCountSplitPage() {
		Integer totalCount = 0;
		try {
			totalCount = super.getHibernateTemplate().execute(
					new HibernateCallback<Integer>() {
						public Integer doInHibernate(Session session) {
							return new Integer(session
									.createCriteria(SjArticles.class)
									.setCacheable(true)
									.setProjection(Projections.rowCount())
									.uniqueResult().toString());
						}
					});
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return totalCount;
	}

	/**
	 * 分页获取文章列表信息的方法
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<SjArticles> getAllArticlesSplitPage(final Integer pageIndex,
			final Integer pageSize) {
		List<SjArticles> articles = null;
		try {
			articles = super.getHibernateTemplate().executeFind(
					new HibernateCallback<List<SjArticles>>() {
						public List<SjArticles> doInHibernate(Session session) {
							return session.createCriteria(SjArticles.class)
									.setCacheable(true)
									.setFirstResult((pageIndex - 1) * pageSize)
									.setMaxResults(pageSize).list();
						}
					});
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return articles;
	}

	/**
	 * 分页获取指定时间段的文章信息总数的方法
	 */
	@Override
	public Integer getArticlesAccordingToCreateDateSOfGetAllCountSplitPage(
			final String datetimePartion) {
		Integer totalCount = 0;

		// 获取某月的开始时间
		final Date startDate = CalendarTool
				.getFirstDateTimeFromStringDateResourceAtThisMonth(datetimePartion);

		// 获取某月的结束时间
		final Date endDate = CalendarTool
				.getLastDateTimeFromStringDateResourceAtThisMonth(datetimePartion);

		try {
			totalCount = super.getHibernateTemplate().execute(
					new HibernateCallback<Integer>() {
						public Integer doInHibernate(Session session) {

							return new Integer(session
									.createCriteria(SjArticles.class)
									.setCacheable(true)
									.add(Restrictions.between("ACreatedate",
											startDate, endDate))
									.setProjection(Projections.rowCount())
									.uniqueResult().toString());
						}
					});
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return totalCount;
	}

	/**
	 * 分页获取指定时间段的文章信息的方法
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<SjArticles> getArticlesAccordingToCreateDateSplitPage(
			final Integer pageIndex, final Integer pageSize,
			String datetimePartion) {
		List<SjArticles> articles = null;
		// 获取某月的开始时间
		final Date startDate = CalendarTool
				.getFirstDateTimeFromStringDateResourceAtThisMonth(datetimePartion);

		// 获取某月的结束时间
		final Date endDate = CalendarTool
				.getLastDateTimeFromStringDateResourceAtThisMonth(datetimePartion);

		try {
			articles = super.getHibernateTemplate().executeFind(
					new HibernateCallback<List<SjArticles>>() {
						public List<SjArticles> doInHibernate(Session session) {
							return session
									.createCriteria(SjArticles.class)
									.setCacheable(true)
									.add(Restrictions.between("ACreatedate",
											startDate, endDate))
									.setFirstResult((pageIndex - 1) * pageSize)
									.setMaxResults(pageSize).list();
						}
					});
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}

		return articles;
	}

	/**
	 * 分页获取指定类别的文章信息总数的方法
	 */
	@Override
	public Integer getArticlesAccordingToArticleTypeSOfGetAllCountSplitPage(
			final Integer articleType) {
		Integer totalCount = null;
		try {
			totalCount = super.getHibernateTemplate().execute(
					new HibernateCallback<Integer>() {
						public Integer doInHibernate(Session session) {
							return new Integer(session
									.createCriteria(SjArticles.class, "a")
									.createAlias("a.sjArticletypes", "t")
									.setCacheable(true)
									.add(Restrictions.eq("t.TId", articleType))
									.setProjection(Projections.rowCount())
									.uniqueResult().toString());
						}
					});
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return totalCount;
	}

	/**
	 * 分页获取指定类别的文章信息的方法
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<SjArticles> getArticlesAccordingToArticleTypeSplitPage(
			final Integer pageIndex, final Integer pageSize,
			final Integer articleType) {
		List<SjArticles> sjArticles = null;
		try {
			sjArticles = super.getHibernateTemplate().executeFind(
					new HibernateCallback<List<SjArticles>>() {
						public List<SjArticles> doInHibernate(Session session) {
							return session
									.createCriteria(SjArticles.class, "a")
									.createAlias("a.sjArticletypes", "t")
									.setCacheable(true)
									.add(Restrictions.eq("t.TId", articleType))
									.setFirstResult((pageIndex - 1) * pageSize)
									.setMaxResults(pageSize).list();
						}
					});
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return sjArticles;
	}

	/**
	 * 获取所有博文信息用于建立Lucene文件索引的方法
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<SjArticles> getArticlesInfoByBuildLuceneIndexes() {
		List<SjArticles> articles = null;
		try {
			articles = super.getHibernateTemplate().executeFind(
					new HibernateCallback<List<SjArticles>>() {
						public List<SjArticles> doInHibernate(Session session) {
							return session.createCriteria(SjArticles.class)
									.setCacheable(true)
									.addOrder(Order.desc("AId")).list();
						}
					});
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}

		return articles;
	}
}