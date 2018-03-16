/*
 * Project Name: SJBlog
 * Class Name: BigDataDaoImpl.java
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

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import top.sj.dao.BigDataDao;

/**
 * 大数据接口的实现类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年4月3日 下午12:35:29
 * Modify User: SteveJrong
 * Modify Date: 2016年4月3日 下午12:35:29
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class BigDataDaoImpl extends HibernateDaoSupport implements BigDataDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> getThisWeekGuestsVistedInfo() {

		List<Object> objects = null;

		final StringBuffer sbSql = new StringBuffer();
		sbSql.append(" SELECT ");
		sbSql.append(" CASE DAYOFWEEK(sd.GD_VISTEDDATETIME) ");
		sbSql.append(" WHEN 1 THEN 0 ");
		sbSql.append(" WHEN 2 THEN 1 ");
		sbSql.append(" WHEN 3 THEN 2 ");
		sbSql.append(" WHEN 4 THEN 3 ");
		sbSql.append(" WHEN 5 THEN 4 ");
		sbSql.append(" WHEN 6 THEN 5 ");
		sbSql.append(" WHEN 7 THEN 6");
		sbSql.append(" END AS weeks, ");
		sbSql.append(" COUNT(DAYOFWEEK(sd.GD_VISTEDDATETIME)) AS visited ");
		sbSql.append(" FROM sj_guestshistory s,sj_guestsdatehistorydetail sd ");
		sbSql.append(" WHERE sd.GD_G_ID = s.G_ID ");
		sbSql.append(" AND ");
		sbSql.append(" sd.GD_VISTEDDATETIME BETWEEN DATE_ADD(CURDATE(),INTERVAL -WEEKDAY(CURDATE())-1 DAY) AND DATE_SUB(CURDATE(),INTERVAL WEEKDAY(CURDATE()) - 5 DAY) ");
		sbSql.append(" GROUP BY weeks ASC ");

		try {
			objects = super.getHibernateTemplate().executeFind(
					new HibernateCallback<List<Object>>() {
						@Override
						public List<Object> doInHibernate(Session session)
								throws HibernateException, SQLException {
							Query query = session.createSQLQuery(sbSql
									.toString());
							return query.list();
						}
					});
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return objects;
	}
}