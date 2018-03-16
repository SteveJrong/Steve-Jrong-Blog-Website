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
package top.sj.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import top.sj.dao.CommentsOrReplyDao;
import top.sj.entity.SjLeavemessages;
import top.sj.util.VerifyStateByCommentsOrReplyEnum;

/**
 * 评论/回复接口的实现类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年8月24日 下午5:16:59
 * Modify User: SteveJrong
 * Modify Date: 2016年8月24日 下午5:16:59
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class CommentsOrReplyDaoImpl extends HibernateDaoSupport implements
		CommentsOrReplyDao {

	/**
	 * 添加一个新评论/回复信息的方法
	 */
	@Override
	public Boolean addNewCommentsOrReplyInfo(SjLeavemessages leavemessages) {
		try {
			super.getHibernateTemplate().save(leavemessages);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 根据文章编号获取此文章下所有互动信息的方法
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<SjLeavemessages> getAllCOrRInfoByArticleId(
			final Integer articleId) {
		List<SjLeavemessages> leavemessages = null;
		try {
			leavemessages = super.getHibernateTemplate().executeFind(
					new HibernateCallback<List<SjLeavemessages>>() {
						@Override
						public List<SjLeavemessages> doInHibernate(
								Session session) throws HibernateException,
								SQLException {
							return session
									.createCriteria(SjLeavemessages.class, "l")
									.createAlias("l.sjArticles", "a")
									.setCacheable(true)
									.add(Restrictions.eq("a.AId", articleId))
									.add(Restrictions.eq("l.MMessageType", 1))
									.add(Restrictions
											.eq("l.MVerifystate",
													VerifyStateByCommentsOrReplyEnum.VERIFY_PASS
															.getState()))
									.list();
						}

					});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return leavemessages;
	}

	/**
	 * 为某个评论/回复点赞的方法（目前不记名）
	 */
	@Override
	public Boolean doPraise(SjLeavemessages leavemessages) {
		try {
			super.getHibernateTemplate().update(leavemessages);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 根据文章编号分页获取此文章下所有互动信息的方法
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<SjLeavemessages> getAllCOrRInfoByArticleIdSplitPage(
			final Integer articleId, final Integer pageIndex) {
		List<SjLeavemessages> leavemessages = null;
		try {
			leavemessages = super.getHibernateTemplate().executeFind(
					new HibernateCallback<List<SjLeavemessages>>() {
						public List<SjLeavemessages> doInHibernate(
								Session session) {
							Integer verifyState = VerifyStateByCommentsOrReplyEnum.VERIFY_PASS.getState();
							Criteria criteria = session.createCriteria(
									SjLeavemessages.class,"l").createAlias("l.sjArticles", "a").setCacheable(true).add(Restrictions.eq("a.AId", articleId)).add(Restrictions.eq("l.MVerifystate", verifyState));
							return criteria.setFirstResult((pageIndex - 1) * 10).setMaxResults(10).list();
						}
					});
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return leavemessages;
	}
}
