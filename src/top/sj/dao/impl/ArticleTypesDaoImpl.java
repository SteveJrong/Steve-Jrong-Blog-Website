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
package top.sj.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import top.sj.dao.ArticleTypesDao;
import top.sj.entity.SjArticletypes;

/**
 * 文章类型接口的实现类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年2月17日 下午6:23:07
 * Modify User: SteveJrong
 * Modify Date: 2016年2月17日 下午6:23:07
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class ArticleTypesDaoImpl extends HibernateDaoSupport implements
		ArticleTypesDao {

	/**
	 * 获取文章类型信息的方法
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<SjArticletypes> getArticleTypeInfo() {
		List<SjArticletypes> articletypes = null;
		try {
			articletypes = super.getHibernateTemplate().executeFind(
					new HibernateCallback<List<SjArticletypes>>() {
						public List<SjArticletypes> doInHibernate(
								Session session) {
							return session.createCriteria(SjArticletypes.class)
									.setCacheable(true).list();
						}
					});
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return articletypes;
	}
}