/*
 * Project Name: SJBlog
 * Class Name: MemcachedBefore.java
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
package top.sj.aop;

import java.lang.reflect.Method;
import org.apache.log4j.Logger;
import org.springframework.aop.MethodBeforeAdvice;

import com.danga.MemCached.MemCachedClient;

import top.sj.common.util.MemcachedUtil;


/**
 * Memcached AOP前置切入【暂时弃用】
 * 
 * Create User: SteveJrong
 * Create Date: 2016年3月30日 下午9:31:39
 * Modify User: SteveJrong
 * Modify Date: 2016年3月30日 下午9:31:39
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class MemcachedBefore implements MethodBeforeAdvice {

	private static final Logger LOGGER = Logger.getLogger(MemcachedBefore.class);

	/**
	 * 前置增强方法
	 */
	@Override
	public void before(Method method, Object[] arguements, Object target)
			throws Throwable {
		MemCachedClient client = MemcachedUtil.getInstance();
		client.add("demoParam", "test");
		LOGGER.info("Initialized Memcached was been successfully!");
	}
}