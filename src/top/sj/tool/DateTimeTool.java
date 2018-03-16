/*
 * Project Name: SJBlog
 * Class Name: DateTimeTool.java
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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * DateTime时间工具类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年6月16日 下午5:55:05
 * Modify User: SteveJrong
 * Modify Date: 2016年6月16日 下午5:55:05
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public final class DateTimeTool {

	/**
	 * 时间格式模版1
	 */
	public static final String DATE_TIME_TEMPLATE_ONE = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 时间格式模版2
	 */
	public static final String DATE_TIME_TEMPLATE_TWO = "yyyyMM";
	
	/**
	 * 时间格式模版3
	 */
	public static final String DATE_TIME_TEMPLATE_THREE = "mm:ss";
	
	private static Date nowDate = new Date(System.currentTimeMillis());
	
	/**
	 * 以时间模版一返回格式化的当前时间
	 */
	public static final String getNowDateFormatDateTimeTemplateOne() {
		return new SimpleDateFormat(DATE_TIME_TEMPLATE_ONE).format(new Date(
				System.currentTimeMillis()));
	}
	
	/**
	 * 以时间模版二返回格式化的当前时间
	 */
	public static final String getNowDateFormatDateTimeTemplateTwo() {
		return new SimpleDateFormat(DATE_TIME_TEMPLATE_TWO).format(new Date(
				System.currentTimeMillis()));
	}

	/**
	 * 以时间模板一将字符串类型的时间格式化为java.util.Date类型的时间
	 * 
	 * @param strDateFmt
	 * @return
	 */
	public static Date stringFmtToDateFmtTemplateOne(String strDateFmt) {
		Date newDate = null;
		try {
			newDate = new SimpleDateFormat(DATE_TIME_TEMPLATE_ONE)
					.parse(strDateFmt);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return newDate;
	}
	
	/**
	 * 获取当前系统时间
	 * @return java.util.Date类型的当前系统时间
	 */
	public static Date getNowDate() {
		return nowDate;
	}
	
	/**
	 * 以时间模板三将整型秒为单位的时间格式化为java.util.Date类型的时间
	 * @param time
	 * @return
	 */
	public static Date getDateFormatDateTimeTemplateThree(int time) {
		Date resultDate = null;
        String timeStr = null;
        int hour = 0;
        int minute = 0;
        int second = 0;
        if (time <= 0)
			try {
				resultDate = new SimpleDateFormat(DATE_TIME_TEMPLATE_THREE).parse("00:00");
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		else {
            minute = time / 60;
            if (minute < 60) {
                second = time % 60;
                timeStr = unitFormat(minute) + ":" + unitFormat(second);
            } else {
                hour = minute / 60;
                if (hour > 99)
					try {
						resultDate = new SimpleDateFormat(DATE_TIME_TEMPLATE_THREE).parse("99:59:59");
					} catch (ParseException e) {
						e.printStackTrace();
					}
                minute = minute % 60;
                second = time - hour * 3600 - minute * 60;
                timeStr = unitFormat(hour) + ":" + unitFormat(minute) + ":" + unitFormat(second);
            }
        }
        try {
        	resultDate = new SimpleDateFormat(DATE_TIME_TEMPLATE_THREE).parse(timeStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return resultDate;
    }
	
	private static String unitFormat(int i) {  
        String retStr = null;
        if (i >= 0 && i < 10){
            retStr = "0" + Integer.toString(i);  
        }else{  
            retStr = "" + i;
        }
        return retStr;  
    }
}
