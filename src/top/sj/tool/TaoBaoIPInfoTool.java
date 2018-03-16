/*
 * Project Name: SJBlog
 * Class Name: TaoBaoIPInfoTool.java
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

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import top.sj.common.util.GsonUtil;
import top.sj.common.util.HttpNetUtil;
import top.sj.util.TaoBaoIPInfoChildResponseBean;
import top.sj.util.TaoBaoIPInfoParentResponseBean;
import net.sf.json.JSONObject;

/**
 * 淘宝IP地址信息类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年4月7日 下午2:29:34
 * Modify User: SteveJrong
 * Modify Date: 2016年4月7日 下午2:29:34
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class TaoBaoIPInfoTool {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TaoBaoIPInfoTool.class);
	
	/**
	 * 根据请求的IP地址获取IP地址详情的方法
	 * 
	 * @param IP
	 * 
	 *            {@link http://ip.taobao.com/instructions.php}
	 * @see TaoBao IP Libraries for free
	 * @return
	 */
	public static String getIPInfo(String IP) {
//		try {
//			String str = getJsonContent("http://ip.taobao.com/service/getIpInfo.php?ip="
//					+ IP);
//			// System.out.println(str);
//
//			JSONObject obj = JSONObject.fromObject(str);
//			JSONObject obj2 = (JSONObject) obj.get("data");
//			String code = (String) obj.get("code").toString();
//			if (code.equals("0")) {
//
//				resout = obj2.get("country").toString()
//						+ obj2.get("area").toString()
//						+ obj2.get("city").toString()/*
//													 * +
//													 * obj2.get("isp").toString
//													 * ()
//													 */;
//			} else {
//				resout = "IP地址有误";
//			}
//		} catch (Exception e) {
//
//			e.printStackTrace();
//			resout = "获取IP地址异常：" + e.getMessage();
//		}
		
		StringBuffer result= new StringBuffer();
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("ip", IP);
		
		Object visitorInfo = HttpNetUtil.sendGetFollowParamsAndResponseResult("http://ip.taobao.com/service/getIpInfo.php",params);
		//返回成功示例（Unicode解码后）：
			//{"code":0,"data":{"country":"中国","country_id":"CN","area":"华北","area_id":"100000","region":"山西省","region_id":"140000",
			//"city":"太原市","city_id":"140100","county":"","county_id":"-1","isp":"联通","isp_id":"100026","ip":"183.184.250.38"}}
		
		//返回失败示例（Unicode解码后）：
			//{"code":1,"data":"invaild ip."}
		
		LOGGER.info(" -- 淘宝服务器返回的原始IP信息："+visitorInfo+" -- ");
		
		JSONObject resultJson = JSONObject.fromObject(visitorInfo);
		
		//code为0表示返回成功。这里加一个状态码的判断避免返回失败时Gson转换错误
		if (Integer.valueOf(resultJson.get("code").toString()) == 0) {
			TaoBaoIPInfoParentResponseBean resultBean = GsonUtil.getInstance().fromJson(visitorInfo.toString(), TaoBaoIPInfoParentResponseBean.class);
			
			if (null != resultBean && Integer.valueOf(resultBean.getCode()) == 0) {
				result.append(resultBean.getData().getCountry()).append(resultBean.getData().getArea()).append(resultBean.getData().getRegion()).append(resultBean.getData().getCity()).append(resultBean.getData().getIsp());
			}
		}else {
			LOGGER.warn(" -- 未根据IP地址获取到地域信息 -- ");
		}
		
		return result.toString();

	}

//	public static String getJsonContent(String urlStr) {
//		try {// 获取HttpURLConnection连接对象
//			URL url = new URL(urlStr);
//			HttpURLConnection httpConn = (HttpURLConnection) url
//					.openConnection();
//			// 设置连接属性
//			httpConn.setConnectTimeout(3000);
//			httpConn.setDoInput(true);
//			httpConn.setRequestMethod("GET");
//			// 获取相应码
//			int respCode = httpConn.getResponseCode();
//			if (respCode == 200) {
//				return ConvertStream2Json(httpConn.getInputStream());
//			}
//		} catch (MalformedURLException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return "";
//	}
//
//	private static String ConvertStream2Json(InputStream inputStream) {
//		String jsonStr = "";
//		// ByteArrayOutputStream相当于内存输出流
//		ByteArrayOutputStream out = new ByteArrayOutputStream();
//		byte[] buffer = new byte[1024];
//		int len = 0;
//		// 将输入流转移到内存输出流中
//		try {
//			while ((len = inputStream.read(buffer, 0, buffer.length)) != -1) {
//				out.write(buffer, 0, len);
//			}
//			// 将内存流转换为字符串
//			jsonStr = new String(out.toByteArray());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return jsonStr;
//	}
}
