/*
 * Project Name: SJBlog
 * Class Name: AccordingToWeekBigDataDTO.java
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
package top.sj.dto;

/**
 * 按周实现访客记录查看的数据传输对象实体类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年4月3日 下午2:12:53
 * Modify User: SteveJrong
 * Modify Date: 2016年4月3日 下午2:12:53
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class WeekBigDataDTO {
	/**
	 * 星期属性
	 */
	private String week;

	/**
	 * 每天的访客量
	 */
	private String visitedCount;

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public String getVisitedCount() {
		return visitedCount;
	}

	public void setVisitedCount(String visitedCount) {
		this.visitedCount = visitedCount;
	}

	public WeekBigDataDTO(String week, String visitedCount) {
		super();
		this.week = week;
		this.visitedCount = visitedCount;
	}

	public WeekBigDataDTO() {
	}
}
