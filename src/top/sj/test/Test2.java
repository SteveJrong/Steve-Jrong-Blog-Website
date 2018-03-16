package top.sj.test;

import java.text.SimpleDateFormat;

import top.sj.tool.CalendarTool;

public class Test2 {

	/**
	 * 
	 * 方法描述:
	 * 
	 * @param args
	 * @returnType void 创建人： Steve Jrong 创建时间：2016-2-28 下午3:53:17
	 */
	public static void main(String[] args) {
		System.out
				.println(new SimpleDateFormat("yyyy-MM-dd").format(CalendarTool
						.getFirstDateTimeFromStringDateResourceAtThisMonth("2015年11月")));

		System.out
				.println(new SimpleDateFormat("yyyy-MM-dd").format(CalendarTool
						.getLastDateTimeFromStringDateResourceAtThisMonth("2015年11月")));
	}
}