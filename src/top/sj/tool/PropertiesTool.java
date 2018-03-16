/*
 * Project Name: SJBlog
 * Class Name: PropertiesTool.java
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
package top.sj.tool;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 属性文件工具类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年4月7日 下午2:58:00
 * Modify User: SteveJrong
 * Modify Date: 2016年4月7日 下午2:58:00
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class PropertiesTool {

	/**
	 * 根据属性文件名称路径获取属性信息的方法 【Properties属性文件必须放在项目的src目录下】
	 * 
	 * @param propertiesPath
	 * @return
	 */
	public static Properties getPropertiesFileAsObject(String propertiesFileName) {
		Properties pps = new Properties();

		InputStream in;
		try {
			String path = Thread.currentThread().getContextClassLoader()
					.getResource("").getPath().replace("%20", " ")
					+ propertiesFileName;
			in = new BufferedInputStream(new FileInputStream(new String(
					path.substring(path.indexOf("/")))));
			pps.load(in);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}

		return pps;
	}
}
