/*
 * Project Name: SJBlog
 * Class Name: GsonUtil.java
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

import com.google.gson.Gson;

/**
 * Gson工具类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年5月16日 下午12:21:59
 * Modify User: SteveJrong
 * Modify Date: 2016年5月16日 下午12:21:59
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class GsonUtil {
	private static Gson gson = null;

	/**
	 * 实例化Gson对象的方法
	 * 
	 * @return
	 */
	public static Gson getInstance() {
		if (null == gson) {
			gson = new Gson();
		}
		return gson;
	}
}
