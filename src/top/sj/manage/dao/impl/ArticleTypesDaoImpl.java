/*
 * Project Name: SJBlog
 * Class Name: ArticleTypesDaoImpl.java
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

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import top.sj.entity.SjArticletypes;
import top.sj.manage.dao.ArticleTypesDao;

/**
 * 文章类型接口的实现类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年3月26日 上午1:27:47
 * Modify User: SteveJrong
 * Modify Date: 2016年3月26日 上午1:27:47
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class ArticleTypesDaoImpl extends HibernateDaoSupport implements
		ArticleTypesDao {

	/**
	 * 根据文章类型编号获取文章类型信息的方法
	 */
	@Override
	public SjArticletypes getSingleArticleTypeInfoById(Integer id) {

		SjArticletypes sjArticletypes = null;

		try {
			sjArticletypes = super.getHibernateTemplate().get(
					SjArticletypes.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return sjArticletypes;
	}

	/**
	 * 分页获取所有博文类型信息的方法
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<SjArticletypes> getAllArticleTypesInfo(final Integer pageIndex,
			final Integer pageSize) {
		List<SjArticletypes> articletypes = null;
		try {
			articletypes = super.getHibernateTemplate().executeFind(
					new HibernateCallback<List<SjArticletypes>>() {
						@Override
						public List<SjArticletypes> doInHibernate(
								Session session) throws HibernateException,
								SQLException {
							return session.createCriteria(SjArticletypes.class)
									.setCacheable(true)
									.setFirstResult((pageIndex - 1) * pageSize)
									.setMaxResults(pageSize).list();
						}
					});
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return articletypes;
	}

	/**
	 * 分页获取所有博文类型信息总数的方法
	 */
	@Override
	public Integer getArticleTypesInfoAllCountOfSplitPage() {
		Integer total = 0;
		try {
			total = super.getHibernateTemplate().execute(
					new HibernateCallback<Integer>() {
						@Override
						public Integer doInHibernate(Session session)
								throws HibernateException, SQLException {
							return (Integer) session
									.createCriteria(SjArticletypes.class)
									.setCacheable(true)
									.setProjection(Projections.rowCount())
									.uniqueResult();
						}
					});
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return total;
	}

	/**
	 * 根据博文类型和名称修改博文类型信息的方法
	 */
	@Override
	public Boolean updateArticleTypeInfoByTypeIdAndTypeName(Integer id,
			String name) {
		try {
			SjArticletypes articletypes = this.getSingleArticleTypeInfoById(id);
			articletypes.setTName(name);
			super.getHibernateTemplate().update(articletypes);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
			return false;
		}
		return true;
	}

	/**
	 * 根据文章类型编号判断此文章类型下是否存在博文
	 */
	@Override
	public Boolean getExistsArticlesAtThisArticleType(
			final Integer articleTypeId) {
		Integer count = 0;
		try {
			count = super.getHibernateTemplate().execute(
					new HibernateCallback<Integer>() {
						@Override
						public Integer doInHibernate(Session session)
								throws HibernateException, SQLException {
							return new Long(
									(long) session
											.createQuery(
													"select count(a) from SjArticles a where a.sjArticletypes.TId = :id")
											.setCacheable(true)
											.setParameter("id", articleTypeId)
											.uniqueResult()).intValue();
						}
					});
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}

		// 为0表示此类型下没有博文，可以删除
		return count == 0 ? true : false;
	}

	/**
	 * 根据博文类型编号删除博文类型信息的方法
	 */
	@Override
	public Boolean deleteArticleTypeInfoById(Integer id) {
		try {
			if (this.getExistsArticlesAtThisArticleType(id)) {
				SjArticletypes articletypes = this
						.getSingleArticleTypeInfoById(id);
				super.getHibernateTemplate().delete(articletypes);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return false;
	}

	/**
	 * 根据博文类型名称新增博文类型信息的方法
	 */
	@Override
	public Boolean addNewArticleTypeInfo(String typeName) {
		try {
			SjArticletypes articletypes = new SjArticletypes();
			articletypes.setTName(typeName);
			super.getHibernateTemplate().save(articletypes);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
			return false;
		}
		return true;
	}
}
