/*
 * Project Name: SJBlog
 * Class Name: CommentsOrReplyDaoImpl.java
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

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import top.sj.entity.SjLeavemessages;
import top.sj.manage.dao.CommentsOrReplyDao;
import top.sj.util.VerifyStateByCommentsOrReplyEnum;

/**
 * 评论/回复接口的实现类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年8月25日 下午5:31:09
 * Modify User: SteveJrong
 * Modify Date: 2016年8月25日 下午5:31:09
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class CommentsOrReplyDaoImpl extends HibernateDaoSupport implements
		CommentsOrReplyDao {

	/**
	 * 分页获取未审核的评论/回复信息的方法
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<SjLeavemessages> getUnverifyCOrRInfoBySplitPage(
			final Integer pageIndex, final Integer pageSize) {
		List<SjLeavemessages> leavemessages = null;
		try {
			leavemessages = super.getHibernateTemplate().executeFind(
					new HibernateCallback<List<SjLeavemessages>>() {
						public List<SjLeavemessages> doInHibernate(
								Session session) {
							return session
									.createCriteria(SjLeavemessages.class)
									.setCacheable(true)
									.add(Restrictions
											.eq("MVerifystate",
													VerifyStateByCommentsOrReplyEnum.UN_VERIFY
															.getState()))
									.setFirstResult((pageIndex - 1) * pageSize)
									.setMaxResults(pageSize).list();
						}
					});
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return leavemessages;
	}

	/**
	 * 获取未审核的评论/回复信息总数的方法
	 */
	@Override
	public Integer getUnverifyCOrRInfoAllCountOfSplitPage() {
		Integer totalCount = 0;
		try {
			totalCount = super.getHibernateTemplate().execute(
					new HibernateCallback<Integer>() {
						public Integer doInHibernate(Session session) {
							return Integer.valueOf(session
									.createCriteria(SjLeavemessages.class)
									.add(Restrictions
											.eq("MVerifystate",
													VerifyStateByCommentsOrReplyEnum.UN_VERIFY
															.getState()))
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
	 * 审核评论/回复消息的方法
	 */
	@Override
	public Boolean verifycOrRInfo(SjLeavemessages leavemessages) {
		try {
			super.getHibernateTemplate().update(leavemessages);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
			return false;
		}
		return true;
	}

	/**
	 * 根据编号查询一个评论/回复消息实体的方法
	 */
	@Override
	public SjLeavemessages getCOrRInfoById(Integer id) {
		return super.getHibernateTemplate().get(SjLeavemessages.class, id);
	}

	/**
	 * 分页获取所有评论/回复信息的方法
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<SjLeavemessages> getCOrRInfoBySplitPage(
			final Integer pageIndex, final Integer pageSize,
			final Date searchStartDate, final Date searchEndDate,
			final Integer searchVerifyStatusId) {
		List<SjLeavemessages> leavemessages = null;
		try {
			leavemessages = super.getHibernateTemplate().executeFind(
					new HibernateCallback<List<SjLeavemessages>>() {
						public List<SjLeavemessages> doInHibernate(
								Session session) {
							Criteria criteria = session.createCriteria(
									SjLeavemessages.class).setCacheable(true);
							if (null != searchStartDate
									&& null != searchEndDate) {
								criteria.add(Restrictions.between(
										"MPublishdate", searchStartDate,
										searchEndDate));
							} else if (null != searchStartDate) {
								criteria.add(Restrictions.ge("MPublishdate",
										searchStartDate));
							}
							if (null != searchVerifyStatusId) {
								criteria.add(Restrictions.eq("MVerifystate",
										searchVerifyStatusId));
							}

							return criteria
									.setFirstResult((pageIndex - 1) * pageSize)
									.setMaxResults(pageSize).list();
						}
					});
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return leavemessages;
	}

	/**
	 * 获取所有评论/回复信息总数的方法
	 */
	@Override
	public Integer getCOrRInfoAllCountOfSplitPage() {
		Integer totalCount = 0;
		try {
			totalCount = super.getHibernateTemplate().execute(
					new HibernateCallback<Integer>() {
						public Integer doInHibernate(Session session) {
							return Integer.valueOf(session
									.createCriteria(SjLeavemessages.class)
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
	 * 删除一个评论/回复信息的方法
	 */
	@Override
	public Boolean delCOrRInfoById(SjLeavemessages leavemessages) {
		try {
			super.getHibernateTemplate().delete(leavemessages);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
			return false;
		}
		return true;
	}
}
