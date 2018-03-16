/*
 * Project Name: SJBlog
 * Class Name: HibernateJsonBeanProcessor.java
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

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonBeanProcessor;

/**
 * HibernateJsonBeanProcessor类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年11月14日 下午4:36:54
 * Modify User: SteveJrong
 * Modify Date: 2016年11月14日 下午4:36:54
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class HibernateJsonBeanProcessor implements JsonBeanProcessor {
	@Override
	public JSONObject processBean(Object arg0, JsonConfig arg1) {
		return new JSONObject();
	}
}
