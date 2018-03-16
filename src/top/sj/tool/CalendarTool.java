/*
 * Project Name: SJBlog
 * Class Name: CalendarTool.java
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

import java.util.Calendar;
import java.util.Date;

/**
 * 日历工具类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年2月28日 下午3:46:48
 * Modify User: SteveJrong
 * Modify Date: 2016年2月28日 下午3:46:48
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class CalendarTool {
	/**
	 * 根据时间字符串资源获取当前月的第一日
	 * 
	 * 方法描述:
	 * 
	 * @param dateResource
	 * @return
	 * @returnType Date 创建人： Steve Jrong 创建时间：2016-2-28 下午3:49:06
	 */
	public static Date getFirstDateTimeFromStringDateResourceAtThisMonth(
			String dateResource) {
		String year = dateResource.substring(0, dateResource.indexOf("-"));
		String month = dateResource
				.substring(dateResource.indexOf("-") + 1/*
														 * ,
														 * dateResource.indexOf
														 * ("m")
														 */);

		Calendar cal = Calendar.getInstance();
		// 设置年份
		cal.set(Calendar.YEAR, Integer.parseInt(year));
		// 设置月份
		cal.set(Calendar.MONTH, Integer.parseInt(month) - 1);
		// 获取某月最小天数
		Integer firstDay = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
		// 设置日历中月份的最小天数
		cal.set(Calendar.DAY_OF_MONTH, firstDay);

		return cal.getTime();
	}

	/**
	 * 根据时间字符串资源获取当前月的最后一日
	 * 
	 * 方法描述:
	 * 
	 * @param dateResource
	 * @return
	 * @returnType Date 创建人： Steve Jrong 创建时间：2016-2-28 下午3:49:06
	 */
	public static Date getLastDateTimeFromStringDateResourceAtThisMonth(
			String dateResource) {
		String year = dateResource.substring(0, dateResource.indexOf("-"));
		String month = dateResource
				.substring(dateResource.indexOf("-") + 1/*
														 * ,
														 * dateResource.indexOf
														 * ("m")
														 */);

		Calendar cal = Calendar.getInstance();
		// 设置年份
		cal.set(Calendar.YEAR, Integer.parseInt(year));
		// 设置月份
		cal.set(Calendar.MONTH, Integer.parseInt(month) - 1);
		// 获取某月最大天数
		Integer lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		// 设置日历中月份的最大天数
		cal.set(Calendar.DAY_OF_MONTH, lastDay);

		return cal.getTime();
	}
}
