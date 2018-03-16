/*
 * Project Name: SJBlog
 * Class Name: HibernateJsonBeanProcessorMatcher.java
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

import java.util.Set;

import org.apache.log4j.Logger;

import net.sf.json.processors.JsonBeanProcessorMatcher;

/**
 * HibernateJsonBeanProcessorMatcher类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年11月14日 下午4:37:22
 * Modify User: SteveJrong
 * Modify Date: 2016年11月14日 下午4:37:22
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class HibernateJsonBeanProcessorMatcher extends JsonBeanProcessorMatcher {
	private static Logger LOGGER = Logger.getLogger(HibernateJsonBeanProcessorMatcher.class);

	@SuppressWarnings("rawtypes")
	@Override
	public Object getMatch(Class target, Set set) {

		if (target.getName().contains("$$EnhancerByCGLIB$$")) {
			LOGGER.warn("Found Lazy-References in Hibernate object " + target.getName());
			return org.hibernate.proxy.HibernateProxy.class;
		}
		return DEFAULT.getMatch(target, set);
	}
}
