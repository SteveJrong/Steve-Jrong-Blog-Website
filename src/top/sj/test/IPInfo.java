/*
 * Project Name: SJBlog
 * Class Name: IPInfo.java
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
package top.sj.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

/**
 * IP地址信息类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年2月15日 下午9:36:52
 * Modify User: SteveJrong
 * Modify Date: 2016年2月15日 下午9:36:52
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class IPInfo {

	/**
	 * 向指定URL发送GET方法的请求
	 * 
	 * @param url
	 *            发送请求的URL
	 * @param param
	 *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @return URL 所代表远程资源的响应结果
	 */
	public static String sendGet(String url, String param) {
		String result = "";
		BufferedReader in = null;
		try {
			String urlNameString = url + "?" + param;
			URL realUrl = new URL(urlNameString);
			// 打开和URL之间的连接
			URLConnection connection = realUrl.openConnection();
			// 设置通用的请求属性
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 建立实际的连接
			connection.connect();
			// 获取所有响应头字段
			Map<String, List<String>> map = connection.getHeaderFields();
			// 遍历所有的响应头字段
			for (String key : map.keySet()) {
				System.out.println(key + "--->" + map.get(key));
			}
			// 定义 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送GET请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 获取发布者省市名称的方法
	 * 
	 * 方法描述:
	 * 
	 * @return
	 * @returnType String 创建人： Steve Jrong 创建时间：2016-2-27 下午5:13:18
	 */
	@SuppressWarnings("static-access")
	public static String getPublishedProvinceAndCity() {
		String info = new IPInfo().sendGet("http://pv.sohu.com/cityjson", "");

		JSONObject json = JSONObject.fromObject(info.substring(info
				.indexOf("{")));

		return json.get("cname").toString();
	}

	// /**
	// *
	// * 方法描述:
	// *
	// * @param args
	// * @returnType void 创建人： Steve Jrong 创建时间：2016-2-15 下午9:31:59
	// */
	// @SuppressWarnings("static-access")
	// public static void main(String[] args) {
	// String info = new IPInfo().sendGet("http://pv.sohu.com/cityjson", "");
	//
	// JSONObject json = JSONObject.fromObject(info.substring(info
	// .indexOf("{")));
	//
	// System.out.println("城市编号：" + json.get("cid") + "\n省市名称："
	// + json.get("cname") + "\n所在地IP：" + json.get("cip"));
	// }
}
