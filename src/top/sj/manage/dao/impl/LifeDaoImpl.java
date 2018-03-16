/*
 * Project Name: SJBlog
 * Class Name: LifeDaoImpl.java
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
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import top.sj.entity.SjLife;
import top.sj.manage.dao.LifeDao;

/**
 * 生活接口（“玩生活”板块）的实现类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年7月23日 下午7:19:43
 * Modify User: SteveJrong
 * Modify Date: 2016年7月23日 下午7:19:43
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class LifeDaoImpl extends HibernateDaoSupport implements LifeDao {

	/**
	 * 分页获取所有生活段子信息的方法
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<SjLife> getAllLifeInfoSplitPage(final Integer pageIndex,
			final Integer pageSize) {
		return super.getHibernateTemplate().executeFind(
				new HibernateCallback<List<SjLife>>() {
					@Override
					public List<SjLife> doInHibernate(Session session)
							throws HibernateException, SQLException {
						return session.createCriteria(SjLife.class)
								.setCacheable(true)
								.setFirstResult((pageIndex - 1) * pageSize)
								.setMaxResults(pageSize).list();
					}
				});
	}

	@Override
	public Integer getTotalCountOfAllLifeInfoBySplitPage() {
		return super.getHibernateTemplate().execute(
				new HibernateCallback<Integer>() {
					@Override
					public Integer doInHibernate(Session session)
							throws HibernateException, SQLException {
						return new Long(session.createCriteria(SjLife.class)
								.setCacheable(true)
								.setProjection(Projections.rowCount())
								.uniqueResult().toString()).intValue();
					}
				});
	}

	/**
	 * 根据生活段子编号获取生活段子详情的方法
	 */
	@Override
	public SjLife getDetailInfoOfLifeById(final Integer lifeId) {
		return super.getHibernateTemplate().execute(
				new HibernateCallback<SjLife>() {
					@Override
					public SjLife doInHibernate(Session session)
							throws HibernateException, SQLException {
						return (SjLife) session.createCriteria(SjLife.class)
								.setCacheable(true)
								.add(Restrictions.eq("LId", lifeId))
								.uniqueResult();
					}
				});
	}

	/**
	 * 添加一个新生活段子的方法
	 */
	@Override
	public Boolean addNewLifeInfo(SjLife life) {
		try {
			super.getHibernateTemplate().save(life);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 修改生活段子信息的方法
	 */
	@Override
	public Boolean updateLifeInfo(SjLife life) {
		try {
			super.getHibernateTemplate().update(life);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 删除一个生活段子信息的方法
	 */
	@Override
	public Boolean deleteLifeInfo(SjLife life) {
		try {
			super.getHibernateTemplate().delete(life);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
