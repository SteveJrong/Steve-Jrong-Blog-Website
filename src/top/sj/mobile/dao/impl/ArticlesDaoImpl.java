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
package top.sj.mobile.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import top.sj.entity.SjArticles;
import top.sj.mobile.dao.ArticlesDao;

/**
 * 【移动平台】博文接口的实现类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年5月23日 下午7:57:00
 * Modify User: SteveJrong
 * Modify Date: 2016年5月23日 下午7:57:00
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class ArticlesDaoImpl extends HibernateDaoSupport implements Serializable, ArticlesDao {

	private static final long serialVersionUID = 683119020930694834L;

	/**
	 * 分页获取所有博文信息的方法
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<SjArticles> getAllArticlesInfoBySplitPage(final Integer pageIndex) {
		List<SjArticles> articles = null;
		try {
			articles = super.getHibernateTemplate().executeFind(new HibernateCallback<List<SjArticles>>() {
				public List<SjArticles> doInHibernate(Session session) {
					return session.createCriteria(SjArticles.class).setCacheable(true)
							.setFirstResult((pageIndex - 1) * 10).setMaxResults(10).list();
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return articles;
	}
}
