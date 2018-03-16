/*
 * Project Name: SJBlog
 * Class Name: BaiDuIPInfoTool.java
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
import java.io.FileInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * MD5工具类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年4月7日 下午2:29:22
 * Modify User: SteveJrong
 * Modify Date: 2016年4月7日 下午2:29:22
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class MD5Tool {

	
	
	/**
	 * 根据文件对象获取文件MD5值的方法
	 * @param file
	 * @return
	 */
	public static String getFileMD5(File file) {
		if (!file.exists() || !file.isFile()) {  
			return null;  
		}  
		MessageDigest digest = null;  
		FileInputStream in = null;  
		byte buffer[] = new byte[1024];  
		int len;  
		try {  
			digest = MessageDigest.getInstance("MD5");  
			in = new FileInputStream(file);  
			while ((len = in.read(buffer, 0, 1024)) != -1) {  
				digest.update(buffer, 0, len);  
			}  
			in.close();  
		} catch (Exception e) {  
			e.printStackTrace();  
			return null;  
		}  
		BigInteger bigInt = new BigInteger(1, digest.digest());  
		return bigInt.toString(16);  
	}
}
