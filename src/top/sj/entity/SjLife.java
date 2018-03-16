/*
 * Project Name: SJBlog
 * Class Name: SjLife.java
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
package top.sj.entity;

import java.sql.Timestamp;

/**
 * 生活（“玩生活”板块）实体类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年11月14日 下午3:07:21
 * Modify User: SteveJrong
 * Modify Date: 2016年11月14日 下午3:07:21
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class SjLife  implements java.io.Serializable {
	private static final long serialVersionUID = -427472253418941367L;

	/**
	 * 生活段子编号属性
	 */
	private Integer LId;

	private SjUsers sjUsers;

	/**
	 * 生活段子内容属性
	 */
	private String LContents;

	/**
	 * 生活段子发布时间属性
	 */
	private Timestamp LPublishdate;

	/**
	 * 生活段子修改时间属性
	 */
	private Timestamp LModifydate;

	/**
	 * 生活段子发布时的IP地址属性
	 */
	private String LIpaddress;

	/**
	 * 生活段子发布时的设备信息属性
	 */
	private String LDeviceinfo;

	/**
	 * 生活段子发布时的操作系统信息属性
	 */
	private String LSysteminfo;

	public SjLife() {
	}

	public SjLife(SjUsers sjUsers, String LContents, Timestamp LPublishdate, Timestamp LModifydate, String LIpaddress, String LDeviceinfo, String LSysteminfo) {
		this.sjUsers = sjUsers;
		this.LContents = LContents;
		this.LPublishdate = LPublishdate;
		this.LModifydate = LModifydate;
		this.LIpaddress = LIpaddress;
		this.LDeviceinfo = LDeviceinfo;
		this.LSysteminfo = LSysteminfo;
	}

	public Integer getLId() {
		return this.LId;
	}

	public void setLId(Integer LId) {
		this.LId = LId;
	}

	public SjUsers getSjUsers() {
		return this.sjUsers;
	}

	public void setSjUsers(SjUsers sjUsers) {
		this.sjUsers = sjUsers;
	}

	public String getLContents() {
		return this.LContents;
	}

	public void setLContents(String LContents) {
		this.LContents = LContents;
	}

	public Timestamp getLPublishdate() {
		return this.LPublishdate;
	}

	public void setLPublishdate(Timestamp LPublishdate) {
		this.LPublishdate = LPublishdate;
	}

	public Timestamp getLModifydate() {
		return this.LModifydate;
	}

	public void setLModifydate(Timestamp LModifydate) {
		this.LModifydate = LModifydate;
	}

	public String getLIpaddress() {
		return this.LIpaddress;
	}

	public void setLIpaddress(String LIpaddress) {
		this.LIpaddress = LIpaddress;
	}

	public String getLDeviceinfo() {
		return this.LDeviceinfo;
	}

	public void setLDeviceinfo(String LDeviceinfo) {
		this.LDeviceinfo = LDeviceinfo;
	}

	public String getLSysteminfo() {
		return this.LSysteminfo;
	}

	public void setLSysteminfo(String LSysteminfo) {
		this.LSysteminfo = LSysteminfo;
	}
}