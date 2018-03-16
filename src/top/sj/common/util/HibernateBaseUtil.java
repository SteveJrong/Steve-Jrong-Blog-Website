/*
 * Project Name: SJBlog
 * Class Name: HibernateBaseUtil.java
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
package top.sj.common.util;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibrnate工具类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年11月14日 下午4:36:24
 * Modify User: SteveJrong
 * Modify Date: 2016年11月14日 下午4:36:24
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class HibernateBaseUtil implements Serializable {
	private static final long serialVersionUID = 1402273187582246647L;
	private static final ThreadLocal<Session> THREAD_LOCAL = new ThreadLocal<Session>();
	private static final Configuration CONFIGURATION = new Configuration().configure();
	private static SessionFactory sessionFactory;

	public static Session getCurrectSession() {
		Session session = THREAD_LOCAL.get();
		if (session == null || session.isOpen() == false) {
			if (null == sessionFactory) {
				try {
					sessionFactory = CONFIGURATION.buildSessionFactory();
				} catch (Exception e) {
					e.printStackTrace();
					System.err.println(e.getMessage());
				}
			}

			session = sessionFactory.openSession();
			THREAD_LOCAL.set(session);
		}
		return session;
	}

}
