/*
 * Project Name: SJBlog
 * Class Name: UserDaoImpl.java
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

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import top.sj.dao.UserDao;
import top.sj.entity.SjUsers;

/**
 * 用户接口的实现类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年2月26日 下午6:13:47
 * Modify User: SteveJrong
 * Modify Date: 2016年2月26日 下午6:13:47
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	/**
	 * 用户登录的方法
	 */
	@Override
	public SjUsers doLogin(final SjUsers user) {
		SjUsers userInfo = null;
		try {
			userInfo = super.getHibernateTemplate().execute(
					new HibernateCallback<SjUsers>() {
						public SjUsers doInHibernate(Session session) {

							return (SjUsers) session
									.createCriteria(SjUsers.class)
									.add(Restrictions.eq("UNickname",
											user.getUNickname()))
									.add(Restrictions.eq("UPwd", user.getUPwd()))
									.uniqueResult();
						}
					});
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return userInfo;
	}

	/**
	 * 用户注册的方法
	 */
	@Override
	public Boolean doRegister(SjUsers user) {
		try {
			super.getHibernateTemplate().save(user);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
			return false;
		}
		return true;
	}

	/**
	 * 更新用户信息的方法
	 */
	@Override
	public Boolean updateUserInfo(SjUsers users) {
		try {
			super.getHibernateTemplate().update(users);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
			return false;
		}
		return true;
	}

	/**
	 * 根据用户编号获取用户信息的方法
	 */
	@Override
	public SjUsers getUserInfoById(Integer userId) {
		return super.getHibernateTemplate().get(SjUsers.class, userId);
	}
}
