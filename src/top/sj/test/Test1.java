package top.sj.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Test1 {

	/**
	 * 
	 * 方法描述:
	 * 
	 * @param args
	 * @returnType void 创建人： Steve Jrong 创建时间：2016-2-28 下午3:20:35
	 */
	public static void main(String[] args) {
		String date = "2015年02月";
		String year = date.substring(0, date.indexOf("年"));
		String month = date.substring(date.indexOf("年") + 1, date.indexOf("月"));
		System.out.println(year);
		System.out.println(month);

		Calendar cal = Calendar.getInstance();
		// 设置年份
		cal.set(Calendar.YEAR, Integer.parseInt(year));
		// 设置月份
		cal.set(Calendar.MONTH, Integer.parseInt(month) - 1);
		// 获取某月最大天数
		int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		// 获取某月最小天数
		int firstDay = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
		// 设置日历中月份的最大天数
		cal.set(Calendar.DAY_OF_MONTH, lastDay);
		// 格式化日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String lastDayOfMonth = sdf.format(cal.getTime());
		System.out.println(lastDayOfMonth);

		cal.set(Calendar.DAY_OF_MONTH, firstDay);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(cal
				.getTime()));

	}
}