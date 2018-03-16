/*
 * Project Name: SJBlog
 * Class Name: SpringContextHolder.java
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

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * SpringContextHolder类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年11月14日 下午4:43:07
 * Modify User: SteveJrong
 * Modify Date: 2016年11月14日 下午4:43:07
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class SpringContextHolder implements ApplicationContextAware {
	private static ApplicationContext applicationContext;

	/**
	 * 
	 * 实现ApplicationContextAware接口的context注入函数, 将其存入静态变量.
	 */

	public void setApplicationContext(ApplicationContext applicationContext) {
		SpringContextHolder.applicationContext = applicationContext;
	}

	/**
	 * 
	 * 取得存储在静态变量中的ApplicationContext.
	 */
	public static ApplicationContext getApplicationContext() {
		checkApplicationContext();
		return applicationContext;

	}

	/**
	 * 
	 * 从静态变量ApplicationContext中取得Bean, 自动转型为所赋值对象的类型.
	 */

	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name) {

		checkApplicationContext();

		return (T) applicationContext.getBean(name);

	}

	/**
	 * 
	 * 从静态变量ApplicationContext中取得Bean, 自动转型为所赋值对象的类型.
	 * 
	 * 如果有多个Bean符合Class, 取出第一个.
	 */

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> T getBean(Class<T> clazz) {

		checkApplicationContext();

		Map beanMaps = applicationContext.getBeansOfType(clazz);

		if (beanMaps != null && !beanMaps.isEmpty()) {

			return (T) beanMaps.values().iterator().next();

		} else {

			return null;

		}

	}

	private static void checkApplicationContext() {

		if (applicationContext == null) {

			throw new IllegalStateException(
					"applicaitonContext未注入,请在applicationContext.xml中定义SpringContextHolder");

		}
	}

}
