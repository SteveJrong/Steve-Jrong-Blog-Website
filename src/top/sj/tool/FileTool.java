/*
 * Project Name: SJBlog
 * Class Name: FileTool.java
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

import java.io.File;

/**
 * 文件工具类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年10月27日 下午3:40:18
 * Modify User: SteveJrong
 * Modify Date: 2016年10月27日 下午3:40:18
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class FileTool {
	
	/**
	 * 检测文件是否存在的方法
	 * @param absoluteFilePath 文件绝对路径
	 * @return 布尔值
	 */
	public static Boolean checkFileExists(String absoluteFilePath) {
		File file = new File(absoluteFilePath);
		return file.exists();
	}
}
