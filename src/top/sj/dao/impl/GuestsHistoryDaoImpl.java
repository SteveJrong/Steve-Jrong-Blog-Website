/*
 * Project Name: SJBlog
 * Class Name: GuestsHistoryDaoImpl.java
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

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import top.sj.dao.GuestsHistoryDao;
import top.sj.entity.SjGuestshistory;

/**
 * 访客历史记录接口的实现类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年4月2日 上午12:23:35
 * Modify User: SteveJrong
 * Modify Date: 2016年4月2日 上午12:23:35
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class GuestsHistoryDaoImpl extends HibernateDaoSupport implements
		GuestsHistoryDao {

	/**
	 * 保存访客历史记录的方法
	 */
	@Override
	public Boolean saveGuestsRecord(SjGuestshistory guestshistory) {
		try {
			super.getHibernateTemplate().merge(guestshistory);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/**
	 * 根据IP地址判断有无记录的方法
	 */
	@Override
	public Boolean existsGuestsVisiteInfo(final String ipAddress) {
		SjGuestshistory history = null;
		try {
			history = super.getHibernateTemplate().execute(
					new HibernateCallback<SjGuestshistory>() {

						@Override
						public SjGuestshistory doInHibernate(Session session)
								throws HibernateException, SQLException {
							return (SjGuestshistory) session
									.createCriteria(SjGuestshistory.class)
									.add(Restrictions.eq("GIpaddress",
											ipAddress)).uniqueResult();
						}
					});
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return null != history ? true : false;
	}

	/**
	 * 根据IP地址获取一个访客信息的方法
	 */
	@Override
	public SjGuestshistory getAGuestInfoByIPAddress(final String ipAddress) {
		SjGuestshistory history = null;
		try {
			history = super.getHibernateTemplate().execute(
					new HibernateCallback<SjGuestshistory>() {

						@Override
						public SjGuestshistory doInHibernate(Session session)
								throws HibernateException, SQLException {
							return (SjGuestshistory) session
									.createCriteria(SjGuestshistory.class)
									.add(Restrictions.eq("GIpaddress",
											ipAddress)).uniqueResult();
						}
					});
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return history;
	}
}
