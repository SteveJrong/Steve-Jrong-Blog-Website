/*
 * Project Name: SJBlog
 * Class Name: ProjCommonUtil.java
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

/**
 * 项目通用工具
 * 
 * Create User: SteveJrong
 * Create Date: 2016年8月15日 下午4:00:13
 * Modify User: SteveJrong
 * Modify Date: 2016年8月15日 下午4:00:13
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public final class ProjCommonUtil {

	/**
	 * 根据项目名获取本地项目绝对路径的方法
	 * 
	 * @param projectName
	 * @return
	 */
	public static String getLocalPathByProjectName(String projectName) {
		return System.getProperty(projectName.concat(".root"));
	}
}
