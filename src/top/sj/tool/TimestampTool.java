/*
 * Project Name: SJBlog
 * Class Name: TimestampTool.java
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

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * java.sql.Timestamp类型转换器类
 * 
 * Create User: SteveJrong
 * Create Date: 2015年12月27日 下午12:56:29
 * Modify User: SteveJrong
 * Modify Date: 2016年11月25日 17:23:37
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public final class TimestampTool {
	/**
	 * java.sql.Timestamp类型转换为java.util.Date类型的方法
	 * 
	 * 方法描述:
	 * 
	 * @param timestampDate Timestamp类型的时间
	 * @return
	 * @returnType Date 创建人： wangj 创建时间：2015-12-27 下午12:58:40
	 */
	public static final Date toDate(Timestamp timestampDate) {
		Date newDateFormat = new Date();
		try {
			newDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
					.parse(timestampDate.toString());
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return newDateFormat;
	}

	/**
	 * java.sql.Timestamp类型转换为java.util.Date类型的方法
	 * 
	 * 方法描述:
	 * 
	 * @param timestampDate
	 *            Timestamp类型的时间
	 * @return
	 * @returnType Date 创建人： wangj 创建时间：2015-12-27 下午12:58:40
	 */
	public static final Date toDate(Date date) {
		Date newDateFormat = new Date();
		try {
			newDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
					.parse(date.toString());
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return newDateFormat;
	}

	/**
	 * java.sql.Timestamp类型转换为java.lang.String类型的方法
	 * 
	 * 方法描述:
	 * 
	 * @param timestampDate
	 *            timestampDate Timestamp类型的时间
	 * @return
	 * @returnType String 创建人： wangj 创建时间：2015-12-27 下午1:03:12
	 */
	public static final String toString(Timestamp timestampDate) {
		String newDateFormat = null;
		try {
			newDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
					.format(timestampDate);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return newDateFormat;
	}

	/**
	 * java.sql.Timestamp类型转换为java.lang.String类型的方法
	 * 
	 * 方法描述:
	 * 
	 * @param timestampDate
	 *            timestampDate Timestamp类型的时间
	 * @return
	 * @returnType String 创建人： wangj 创建时间：2015-12-27 下午1:03:12
	 */
	public static final String toString(Date date) {
		String newDateFormat = null;
		try {
			newDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
					.format(date);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return newDateFormat;
	}

	/**
	 * java.util.Date类型转换为java.sql.Timestamp类型的方法
	 * 
	 * 方法描述:
	 * 
	 * @param date
	 *            java.util.Date类型的时间
	 * @return
	 * @returnType String 创建人： wangj 创建时间：2016年4月2日 00:41:53
	 */
	public static final Timestamp convertDateToTimeStamp(Date date) {
		Timestamp timestamp = new Timestamp(date.getTime());
		return timestamp;
	}

	/**
	 * 将当前系统时间转换为java.sql.Timestamp类型的方法
	 * 
	 * @return
	 */
	public static final Timestamp convertNowDateToStimeStamp() {
		return new Timestamp(System.currentTimeMillis());
	}
}
