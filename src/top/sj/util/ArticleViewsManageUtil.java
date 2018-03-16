/*
 * Project Name: SJBlog
 * Class Name: ArticleViewsManageUtil.java
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
package top.sj.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 文章浏览量的管理类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年10月9日 下午2:56:01
 * Modify User: SteveJrong
 * Modify Date: 2016年10月9日 下午2:56:01
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class ArticleViewsManageUtil {
	/**
	 * 文章浏览量管理集合属性
	 */
	private static Map<Integer,ArticleViewsEntityUtil> viewsEntityUtils = new ConcurrentHashMap<Integer, ArticleViewsEntityUtil>();

	public static Map<Integer, ArticleViewsEntityUtil> getViewsEntityUtils() {
		return viewsEntityUtils;
	}

	public static void setViewsEntityUtils(
			Map<Integer, ArticleViewsEntityUtil> viewsEntityUtils) {
		ArticleViewsManageUtil.viewsEntityUtils = viewsEntityUtils;
	}
}
