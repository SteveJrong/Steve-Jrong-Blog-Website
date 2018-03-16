/*
 * Project Name: SJBlog
 * Class Name: DoPraiseManageUtil.java
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

import java.util.ArrayList;
import java.util.List;

/**
 * 点赞/取消点赞的管理类（用于限制用户一天内频繁点赞）
 * 
 * Create User: SteveJrong
 * Create Date: 2016年9月9日 上午9:24:30
 * Modify User: SteveJrong
 * Modify Date: 2016年9月9日 上午9:24:30
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class DoPraiseManageUtil {
	private static List<DoPraiseEntityUtil> doPraiseEntityUtils = new ArrayList<DoPraiseEntityUtil>();

	public static List<DoPraiseEntityUtil> getDoPraiseEntityUtils() {
		return doPraiseEntityUtils;
	}

	public static void setDoPraiseEntityUtils(List<DoPraiseEntityUtil> doPraiseEntityUtils) {
		DoPraiseManageUtil.doPraiseEntityUtils = doPraiseEntityUtils;
	}
}
