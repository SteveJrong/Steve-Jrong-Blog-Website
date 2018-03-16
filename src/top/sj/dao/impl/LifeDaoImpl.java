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
package top.sj.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import top.sj.dao.LifeDao;
import top.sj.entity.SjLife;

/**
 * 生活接口的实现类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年5月6日 下午4:45:31
 * Modify User: SteveJrong
 * Modify Date: 2016年5月6日 下午4:45:31
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class LifeDaoImpl extends HibernateDaoSupport implements LifeDao {

	/**
	 * 分页获取博主的所有生活段子信息的方法
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<SjLife> getAllLifeInfoSplitPage(final Integer pageIndex,
			final Integer pageSize) {
		return super.getHibernateTemplate().executeFind(
				new HibernateCallback<List<SjLife>>() {
					public List<SjLife> doInHibernate(Session session) {
						return session.createCriteria(SjLife.class)
								.setCacheable(true)
								.setFirstResult((pageIndex - 1) * pageSize)
								.setMaxResults(pageSize).addOrder(Order.desc("LPublishdate")).list();
					}
				});
	}

	/**
	 * 获取博主所有生活段子信息总数的方法
	 */
	@Override
	public Integer getTotalCountOfAllLifeInfoBySplitPage() {
		return super.getHibernateTemplate().execute(
				new HibernateCallback<Integer>() {
					public Integer doInHibernate(Session session) {
						return new Long(session.createCriteria(SjLife.class)
								.setCacheable(true)
								.setProjection(Projections.rowCount())
								.uniqueResult().toString()).intValue();
					}
				});
	}
}
