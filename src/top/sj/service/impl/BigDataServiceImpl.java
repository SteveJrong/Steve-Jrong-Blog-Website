/*
 * Project Name: SJBlog
 * Class Name: BigDataServiceImpl.java
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
package top.sj.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import top.sj.dao.BigDataDao;
import top.sj.service.BigDataService;

/**
 * 大数据业务接口的实现类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年11月14日 下午4:16:42
 * Modify User: SteveJrong
 * Modify Date: 2016年11月14日 下午4:16:42
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class BigDataServiceImpl implements BigDataService {

	/**
	 * 大数据接口类型的属性，用于Spring Ioc
	 */
	private BigDataDao bigDataDao;

	public void setBigDataDao(BigDataDao bigDataDao) {
		this.bigDataDao = bigDataDao;
	}

	/**
	 * 获取本周访客历史记录信息的方法【业务逻辑】
	 */
	@Override
	public JSONObject getThisWeekGuestsVistedInfoService() {
		List<Object> objects = bigDataDao.getThisWeekGuestsVistedInfo();

		List<String> weekCollection = new ArrayList<String>();
		List<String> visitCollection = new ArrayList<String>();

		// 整周每一天的标识符
		boolean sunday = true, monday = true, tuesday = true, wednesday = true, thursday = true, friday = true, saturday = true;

		ListIterator<Object> iterator = objects.listIterator();

		while (iterator.hasNext()) {
			Object[] tempObj = (Object[]) iterator.next();

			weekCollection.add(getDayNameByDayOfWeekId(tempObj[0].toString()));
			visitCollection.add(tempObj[1].toString());
			// 根据星期中的天的标识符进行判断
			switch (tempObj[0].toString()) {
			case "0":
				sunday = false;
				continue;
			case "1":
				monday = false;
				continue;
			case "2":
				tuesday = false;
				continue;
			case "3":
				wednesday = false;
				continue;
			case "4":
				thursday = false;
				continue;
			case "5":
				friday = false;
				continue;
			case "6":
				saturday = false;
				continue;
			}
		}

		if (sunday) {
			weekCollection.add(0, getDayNameByDayOfWeekId("0"));
			visitCollection.add(0, "0");
		}

		if (monday) {
			weekCollection.add(1, getDayNameByDayOfWeekId("1"));
			visitCollection.add(1, "0");
		}

		if (tuesday) {
			weekCollection.add(2, getDayNameByDayOfWeekId("2"));
			visitCollection.add(2, "0");
		}

		if (wednesday) {
			weekCollection.add(3, getDayNameByDayOfWeekId("3"));
			visitCollection.add(3, "0");
		}

		if (thursday) {
			weekCollection.add(4, getDayNameByDayOfWeekId("4"));
			visitCollection.add(4, "0");
		}

		if (friday) {
			weekCollection.add(5, getDayNameByDayOfWeekId("5"));
			visitCollection.add(5, "0");
		}

		if (saturday) {
			weekCollection.add(6, getDayNameByDayOfWeekId("6"));
			visitCollection.add(6, "0");
		}

		Map<String, Object> maps = new HashMap<String, Object>();
		maps.put("dates", JSONArray.fromObject(weekCollection));
		maps.put("values", JSONArray.fromObject(visitCollection));

		System.out.println(JSONObject.fromObject(maps));

		return JSONObject.fromObject(maps);
	}

	/**
	 * 根据星期中标识的天返回这一天的星期名称的方法
	 * 
	 * @param id
	 * @return
	 */
	private String getDayNameByDayOfWeekId(String id) {
		switch (id) {
		case "0":
			return "星期日";
		case "1":
			return "星期一";
		case "2":
			return "星期二";
		case "3":
			return "星期三";
		case "4":
			return "星期四";
		case "5":
			return "星期五";
		case "6":
			return "星期六";
		}
		return null;
	}
}
