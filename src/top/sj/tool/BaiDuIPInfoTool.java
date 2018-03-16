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

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import net.sf.json.JSONObject;

/**
 * 百度IP地址信息类
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
public class BaiDuIPInfoTool {

	/**
	 * 根据请求的IP地址和请求参数获取IP地址详情的方法
	 * 
	 * @param httpUrl
	 * @param httpArg
	 *            {@link http
	 *            ://apistore.baidu.com/apiworks/servicedetail/114.html}
	 * @see Baidu IP Search API for free
	 * @return
	 */
	public static String getIPInfo(String httpUrl, String httpArg) {
		BufferedReader reader = null;
		String result = null;
		StringBuffer sbf = new StringBuffer();
		httpUrl = httpUrl + "?" + httpArg;

		try {
			URL url = new URL(httpUrl);
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setRequestMethod("GET");
			connection
					.setRequestProperty(
							"apikey",
							PropertiesTool
									.getPropertiesFileAsObject(
											"baidu_api.properties")
									.get("com.baidu.apikey").toString());
			connection.connect();
			InputStream is = connection.getInputStream();
			reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			String strRead = null;
			while ((strRead = reader.readLine()) != null) {
				sbf.append(strRead);
				sbf.append("\r\n");
			}
			reader.close();
			result = sbf.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}

		JSONObject jsonDatas = JSONObject.fromObject(result);
		
		// 错误返回示例： {"errNum":1,"errMsg":"success","retData":["无效的IP地址"]}

		// 正确返回示例： {errNum=0, errMsg=success,
		// retData={"ip":"127.0.0.1","country":"","province":"None","city":"None","district":"None","carrier":"未知"}}

		return Integer.parseInt(jsonDatas.get("errNum").toString()) != 0 ? ""
				: JSONObject.fromObject(jsonDatas.get("retData"))
						.get("country").toString()
						+ JSONObject.fromObject(jsonDatas.get("retData"))
								.get("province").toString()
						+ JSONObject.fromObject(jsonDatas.get("retData"))
								.get("city").toString()
						+ JSONObject.fromObject(jsonDatas.get("retData"))
								.get("district").toString();
	}
}
