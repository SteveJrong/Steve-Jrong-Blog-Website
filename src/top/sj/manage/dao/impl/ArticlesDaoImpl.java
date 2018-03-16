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
package top.sj.manage.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import top.sj.entity.SjArticles;
import top.sj.entity.SjArticletypes;
import top.sj.manage.dao.ArticlesDao;

/**
 * 文章接口的实现类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年3月22日 下午9:50:50
 * Modify User: SteveJrong
 * Modify Date: 2016年3月22日 下午9:50:50
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class ArticlesDaoImpl extends HibernateDaoSupport implements ArticlesDao {

	/**
	 * 分页获取文章信息的方法
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<SjArticles> getArticlesInfoBySplitPage(final Integer pageIndex,
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
	 * 获取分页时文章信息总数的方法
	 */
	@Override
	public Integer getArticlesInfoAllCountOfSplitPage() {
		Integer count = null;
		try {
			count = super.getHibernateTemplate().execute(
					new HibernateCallback<Integer>() {
						public Integer doInHibernate(Session session) {
							return (Integer) session
									.createCriteria(SjArticles.class)
									.setCacheable(true)
									.setProjection(Projections.rowCount())
									.uniqueResult();
						}
					});
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return count;
	}

	/**
	 * 获取所有文章类型信息的方法
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<SjArticletypes> getArticleTypesInfo() {

		List<SjArticletypes> sjArticletypes = null;

		try {
			sjArticletypes = super.getHibernateTemplate().executeFind(
					new HibernateCallback<List<SjArticletypes>>() {
						@Override
						public List<SjArticletypes> doInHibernate(
								Session session) {
							return session.createCriteria(SjArticletypes.class)
									.setCacheable(true).list();
						}
					});
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return sjArticletypes;
	}

	/**
	 * 添加新博文信息的方法
	 */
	@Override
	public Boolean addNewArticlesInfo(SjArticles articles) {

		try {
			super.getHibernateTemplate().save(articles);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
			return false;
		}

		return true;
	}

	/**
	 * 根据文章编号删除文章信息的方法
	 */
	@Override
	public Boolean delArticleInfoById(Integer id) {
		try {
			super.getHibernateTemplate().delete(getSingleArticleInfoById(id));
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
			return false;
		}
		return true;
	}

	/**
	 * 根据文章编号获取单个文章信息的方法
	 */
	@Override
	public SjArticles getSingleArticleInfoById(Integer id) {
		SjArticles articles = null;
		try {
			articles = super.getHibernateTemplate().get(SjArticles.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return articles;
	}

	/**
	 * 更新文章信息的方法
	 */
	@Override
	public Boolean updateArticleInfo(SjArticles articles) {
		try {
			super.getHibernateTemplate().update(articles);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
			return false;
		}
		return true;
	}

	/**
	 * 根据文章编号获取文章信息的方法
	 */
	@Override
	public SjArticles getArticleInfoByArticleId(Integer articleId) {
		return super.getHibernateTemplate().get(SjArticles.class, articleId);
	}
}
