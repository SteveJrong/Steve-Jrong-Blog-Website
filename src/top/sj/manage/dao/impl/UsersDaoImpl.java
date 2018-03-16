/*
 * Project Name: SJBlog
 * Class Name: .java
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
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import top.sj.common.util.SysRoleEnum;
import top.sj.entity.SjUsers;
import top.sj.manage.dao.UsersDao;

/**
 * 用户接口的实现类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年3月25日 下午11:17:27
 * Modify User: SteveJrong
 * Modify Date: 2016年3月25日 下午11:17:27
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class UsersDaoImpl extends HibernateDaoSupport implements UsersDao {

	/**
	 * 获取所有管理员账户信息的方法
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<SjUsers> getAllAdminstratorsAccount() {

		List<SjUsers> sjUsers = null;

		try {
			sjUsers = super.getHibernateTemplate().executeFind(
					new HibernateCallback<List<SjUsers>>() {
						@Override
						public List<SjUsers> doInHibernate(Session session)
								throws HibernateException, SQLException {
							return session.createCriteria(SjUsers.class)
									.setCacheable(true)
									.add(Restrictions.eq("URole", "系统管理员"))
									.list();
						}
					});
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return sjUsers;
	}

	/**
	 * 根据用户编号获取用户信息的方法
	 */
	@Override
	public SjUsers getSingleUserInfoById(Integer id) {
		SjUsers users = null;
		try {
			users = super.getHibernateTemplate().get(SjUsers.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return users;
	}

	/**
	 * 管理员登录后台管理系统的方法
	 */
	@Override
	public SjUsers doLogin(final String userName, final String pwd) {
		SjUsers users = null;
		try {
			users = super.getHibernateTemplate().execute(
					new HibernateCallback<SjUsers>() {
						@Override
						public SjUsers doInHibernate(Session session)
								throws HibernateException, SQLException {
							return (SjUsers) session
									.createCriteria(SjUsers.class)
									.setCacheable(true)
									.add(Restrictions.eq("UNickname", userName))
									.add(Restrictions.eq("UPwd", pwd))
									.add(Restrictions.eq("URole",
											SysRoleEnum.ADMINSTRATOR.getType()))
									.uniqueResult();
						}
					});
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return users;
	}

	/**
	 * 根据用户昵称（登录名）获取单个用户信息的方法
	 */
	@Override
	public SjUsers getSingleUserInfoByUserNickName(final String nickName) {
		SjUsers users = null;
//		users = (SjUsers) super.getHibernateTemplate().find("from SjUsers where UNickname = '"+nickName+"'").get(0);
		try {
			users = super.getHibernateTemplate().execute(
					new HibernateCallback<SjUsers>() {
						@Override
						public SjUsers doInHibernate(Session session)
								throws HibernateException, SQLException {
							return (SjUsers) session
									.createCriteria(SjUsers.class)
									.setCacheable(true)
									.add(Restrictions.eq("UNickname", nickName))
									.uniqueResult();
						}
					});
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return users;
	}

	/**
	 * 分页获取用户信息的方法
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<SjUsers> getAllUsersInfoBySplitPage(final Integer pageIndex,
			final Integer pageSize) {
		List<SjUsers> users = null;
		try {
			users = super.getHibernateTemplate().executeFind(
					new HibernateCallback<List<SjUsers>>() {
						@Override
						public List<SjUsers> doInHibernate(Session session)
								throws HibernateException, SQLException {
							return session.createCriteria(SjUsers.class)
									.setCacheable(true)
									.setFirstResult((pageIndex - 1) * pageSize)
									.setMaxResults(pageSize).list();
						}
					});
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return users;
	}

	/**
	 * 分页获取用户总数的方法
	 */
	@Override
	public Integer getUsersInfoAllCountOfSplitPage() {
		Object result = super.getHibernateTemplate().findByCriteria(
				DetachedCriteria.forClass(SjUsers.class).setProjection(
						Projections.rowCount()));
		return Integer.parseInt(result.toString().replace("[", "")
				.replace("]", ""));
	}

	/**
	 * 根据用户编号删除用户信息的方法
	 */
	@Override
	public Boolean deleteUserInfoById(Integer userId) {
		try {
			if (this.getSingleUserInfoById(userId).getURole()
					.equals(SysRoleEnum.ADMINSTRATOR.getType())) {
				return false;
			} else {
				super.getHibernateTemplate().delete(
						this.getSingleUserInfoById(userId));

				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return false;
	}
}
