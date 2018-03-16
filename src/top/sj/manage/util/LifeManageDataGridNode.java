/*
 * Project Name: SJBlog
 * Class Name: LifeManageDataGridNode.java
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
package top.sj.manage.util;

/**
 * 生活段子管理的DataGrid实体类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年7月23日 下午7:45:50
 * Modify User: SteveJrong
 * Modify Date: 2016年8月15日 上午10:14:46
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class LifeManageDataGridNode {
	/**
	 * 生活段子编号属性
	 */
	private String lifeId;

	/**
	 * 生活段子发布时间属性
	 */
	private String lifePublishedDate;

	/**
	 * 生活段子修改时间属性
	 */
	private String lifeModifyDate;

	/**
	 * 生活段子发布的IP地址属性
	 */
	private String lifePublishedIp;

	/**
	 * 生活段子内容属性
	 */
	private String lifeContent;

	public String getLifeContent() {
		return lifeContent;
	}

	public void setLifeContent(String lifeContent) {
		this.lifeContent = lifeContent;
	}

	public String getLifeId() {
		return lifeId;
	}

	public void setLifeId(String lifeId) {
		this.lifeId = lifeId;
	}

	public String getLifePublishedDate() {
		return lifePublishedDate;
	}

	public void setLifePublishedDate(String lifePublishedDate) {
		this.lifePublishedDate = lifePublishedDate;
	}

	public String getLifeModifyDate() {
		return lifeModifyDate;
	}

	public void setLifeModifyDate(String lifeModifyDate) {
		this.lifeModifyDate = lifeModifyDate;
	}

	public String getLifePublishedIp() {
		return lifePublishedIp;
	}

	public LifeManageDataGridNode(String lifeId, String lifePublishedDate,
			String lifePublishedIp) {
		super();
		this.lifeId = lifeId;
		this.lifePublishedDate = lifePublishedDate;
		this.lifePublishedIp = lifePublishedIp;
	}

	public LifeManageDataGridNode(String lifeId, String lifePublishedDate,
			String lifePublishedIp, String lifeContent) {
		super();
		this.lifeId = lifeId;
		this.lifePublishedDate = lifePublishedDate;
		this.lifePublishedIp = lifePublishedIp;
		this.lifeContent = lifeContent;
	}

	public LifeManageDataGridNode(String lifeId, String lifePublishedDate,
			String lifePublishedIp, String lifeContent, String lifeModifyDate) {
		super();
		this.lifeId = lifeId;
		this.lifePublishedDate = lifePublishedDate;
		this.lifePublishedIp = lifePublishedIp;
		this.lifeContent = lifeContent;
		this.lifeModifyDate = lifeModifyDate;
	}

	public void setLifePublishedIp(String lifePublishedIp) {
		this.lifePublishedIp = lifePublishedIp;
	}

	public LifeManageDataGridNode() {
	}
}
