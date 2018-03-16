/*
 * Project Name: SJBlog
 * Class Name: UnVerifyCommentsOrReplyMessageDataGridNode.java
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
 * 未审核的评论/回复消息的DataGrid实体类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年8月25日 下午5:39:20
 * Modify User: SteveJrong
 * Modify Date: 2016年8月25日 下午5:39:20
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class UnVerifyCommentsOrReplyMessageDataGridNode {

	/**
	 * 消息编号属性
	 */
	private Integer cOrRId;

	/**
	 * 消息发布者属性（主动方）
	 */
	private String cOrRPublichedPeople;

	/**
	 * 消息接收者属性（被动方）
	 */
	private String cOrRReceivedPeople;

	/**
	 * 消息发布时间属性
	 */
	private String cOrRPublichedDateTime;

	/**
	 * 消息类型属性
	 */
	private String cOrRMsgType;

	/**
	 * 消息内容属性
	 */
	private String cOrRContent;

	/**
	 * 消息审核状态属性
	 */
	private String cOrRVerifyState;

	/**
	 * 消息发布时的IP地址属性
	 */
	private String cOrRPublishedIPAddress;

	/**
	 * 消息发布时的设备信息属性
	 */
	private String cOrRDeviceInfo;

	/**
	 * 消息发布时的操作系统属性
	 */
	private String cOrRSystemInfo;

	public Integer getcOrRId() {
		return cOrRId;
	}

	public void setcOrRId(Integer cOrRId) {
		this.cOrRId = cOrRId;
	}

	public String getcOrRPublichedPeople() {
		return cOrRPublichedPeople;
	}

	public void setcOrRPublichedPeople(String cOrRPublichedPeople) {
		this.cOrRPublichedPeople = cOrRPublichedPeople;
	}

	public String getcOrRReceivedPeople() {
		return cOrRReceivedPeople;
	}

	public void setcOrRReceivedPeople(String cOrRReceivedPeople) {
		this.cOrRReceivedPeople = cOrRReceivedPeople;
	}

	public String getcOrRPublichedDateTime() {
		return cOrRPublichedDateTime;
	}

	public void setcOrRPublichedDateTime(String cOrRPublichedDateTime) {
		this.cOrRPublichedDateTime = cOrRPublichedDateTime;
	}

	public String getcOrRMsgType() {
		return cOrRMsgType;
	}

	public void setcOrRMsgType(String cOrRMsgType) {
		this.cOrRMsgType = cOrRMsgType;
	}

	public String getcOrRVerifyState() {
		return cOrRVerifyState;
	}

	public void setcOrRVerifyState(String cOrRVerifyState) {
		this.cOrRVerifyState = cOrRVerifyState;
	}

	public String getcOrRPublishedIPAddress() {
		return cOrRPublishedIPAddress;
	}

	public void setcOrRPublishedIPAddress(String cOrRPublishedIPAddress) {
		this.cOrRPublishedIPAddress = cOrRPublishedIPAddress;
	}

	public String getcOrRDeviceInfo() {
		return cOrRDeviceInfo;
	}

	public void setcOrRDeviceInfo(String cOrRDeviceInfo) {
		this.cOrRDeviceInfo = cOrRDeviceInfo;
	}

	public String getcOrRSystemInfo() {
		return cOrRSystemInfo;
	}

	public void setcOrRSystemInfo(String cOrRSystemInfo) {
		this.cOrRSystemInfo = cOrRSystemInfo;
	}

	public String getcOrRContent() {
		return cOrRContent;
	}

	public void setcOrRContent(String cOrRContent) {
		this.cOrRContent = cOrRContent;
	}

	public UnVerifyCommentsOrReplyMessageDataGridNode(Integer cOrRId,
			String cOrRPublichedPeople, String cOrRReceivedPeople,
			String cOrRPublichedDateTime, String cOrRMsgType,
			String cOrRContent, String cOrRVerifyState,
			String cOrRPublishedIPAddress, String cOrRDeviceInfo,
			String cOrRSystemInfo) {
		super();
		this.cOrRId = cOrRId;
		this.cOrRPublichedPeople = cOrRPublichedPeople;
		this.cOrRReceivedPeople = cOrRReceivedPeople;
		this.cOrRPublichedDateTime = cOrRPublichedDateTime;
		this.cOrRMsgType = cOrRMsgType;
		this.cOrRContent = cOrRContent;
		this.cOrRVerifyState = cOrRVerifyState;
		this.cOrRPublishedIPAddress = cOrRPublishedIPAddress;
		this.cOrRDeviceInfo = cOrRDeviceInfo;
		this.cOrRSystemInfo = cOrRSystemInfo;
	}

	public UnVerifyCommentsOrReplyMessageDataGridNode() {
	}
}
