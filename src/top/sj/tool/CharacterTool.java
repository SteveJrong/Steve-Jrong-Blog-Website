/*
 * Project Name: SJBlog
 * Class Name: CharacterTool.java
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

/**
 * 字符工具
 * 
 * Create User: SteveJrong
 * Create Date: 2016年3月17日 17:54:43
 * Modify User: SteveJrong
 * Modify Date: 2016年3月17日 17:54:43
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class CharacterTool {
	/**
	 * 根据char[]类型的密码返回完整的字符串密码的方法 2016年3月17日17:45:12
	 * 
	 * @param pwds
	 * @return
	 */
	public static StringBuffer getStringPwdByCharPwd(char[] pwds) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < pwds.length; i++) {
			sb.append(pwds[i]);
		}
		return sb;
	}
}
