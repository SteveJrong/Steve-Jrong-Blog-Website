/*
 * Project Name: SJBlog
 * File Name: FullTextIndexesAfter.java
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.AfterReturningAdvice;
import top.sj.manage.service.IndexesService;
import top.sj.tool.DateTimeTool;

/**
 * 全文索引AOP后置切入
 * 
 * Create User: SteveJrong
 * Create Date: 2016年6月16日 下午5:06:29
 * Modify User: SteveJrong
 * Modify Date: 2016年6月16日 下午5:06:29
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class FullTextIndexesAfter implements AfterReturningAdvice {
	private static Logger LOGGER = LoggerFactory
			.getLogger(FullTextIndexesAfter.class);

	/**
	 * 全文索引业务接口类型的属性，用于Spring Ioc
	 */
	private IndexesService mFullTextIndexesService;

	public void setmFullTextIndexesService(
			IndexesService mFullTextIndexesService) {
		this.mFullTextIndexesService = mFullTextIndexesService;
	}

	/**
	 * 后置增强方法
	 */
	@Override
	public void afterReturning(Object object, Method method, Object[] objects,
			Object object2) throws Throwable {
		LOGGER.info("您对博文信息进行了CUD操作，现已侦听到您的动作。触发时间："
				+ DateTimeTool.getNowDateFormatDateTimeTemplateOne());
		mFullTextIndexesService.setReBuildFullTextIndexesFlagService();
	}
}