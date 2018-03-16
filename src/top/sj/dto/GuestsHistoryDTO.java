/*
 * Project Name: SJBlog
 * Class Name: GuestsHistoryDTO.java
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

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 网站访客DTO实体类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年4月1日 下午8:59:29
 * Modify User: SteveJrong
 * Modify Date: 2016年4月1日 下午8:59:29
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class GuestsHistoryDTO implements Serializable {
	private static final long serialVersionUID = -6723448611048234077L;

	/**
	 * 访客IP地址属性
	 */
	private String guestIP;

	/**
	 * 访客区域信息属性
	 */
	private String guestAddress;

	/**
	 * 访客首次访问时间属性
	 */
	private Date firstVistedDateTime;

	/**
	 * 访客最后一次访问时间属性
	 */
	private Date lastVistedDateTime;

	/**
	 * 访客访问时间记录集合属性
	 */
	private List<Date> visiteDateTimerecords;

	public List<Date> getVisiteDateTimerecords() {
		return visiteDateTimerecords;
	}

	public void setVisiteDateTimerecords(List<Date> visiteDateTimerecords) {
		this.visiteDateTimerecords = visiteDateTimerecords;
	}

	public String getGuestIP() {
		return guestIP;
	}

	public void setGuestIP(String guestIP) {
		this.guestIP = guestIP;
	}

	public String getGuestAddress() {
		return guestAddress;
	}

	public void setGuestAddress(String guestAddress) {
		this.guestAddress = guestAddress;
	}

	public Date getFirstVistedDateTime() {
		return firstVistedDateTime;
	}

	public void setFirstVistedDateTime(Date firstVistedDateTime) {
		this.firstVistedDateTime = firstVistedDateTime;
	}

	public Date getLastVistedDateTime() {
		return lastVistedDateTime;
	}

	public void setLastVistedDateTime(Date lastVistedDateTime) {
		this.lastVistedDateTime = lastVistedDateTime;
	}

	public GuestsHistoryDTO(String guestIP, String guestAddress,
			Date firstVistedDateTime, Date lastVistedDateTime) {
		super();
		this.guestIP = guestIP;
		this.guestAddress = guestAddress;
		this.firstVistedDateTime = firstVistedDateTime;
		this.lastVistedDateTime = lastVistedDateTime;
	}

	public GuestsHistoryDTO() {
	}

}
