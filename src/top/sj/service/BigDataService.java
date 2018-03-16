/*
 * Project Name: SJBlog
 * Class Name: BigDataService.java
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
package top.sj.service;

import net.sf.json.JSONObject;

/**
 * 大数据业务接口
 * 
 * Create User: SteveJrong
 * Create Date: 2016年4月3日 下午2:08:41
 * Modify User: SteveJrong
 * Modify Date: 2016年4月3日 下午2:08:41
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public interface BigDataService {
	/**
	 * 获取本周访客历史记录信息的方法【抽象业务逻辑】
	 * 
	 * @return
	 */
	JSONObject getThisWeekGuestsVistedInfoService();
}
