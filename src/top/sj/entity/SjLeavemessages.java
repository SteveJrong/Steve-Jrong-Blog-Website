/*
 * Project Name: SJBlog
 * Class Name: SjLeavemessages.java
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
 * 评论/回复消息表实体类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年11月14日 下午3:07:00
 * Modify User: SteveJrong
 * Modify Date: 2016年11月14日 下午3:07:00
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class SjLeavemessages implements java.io.Serializable {
	private static final long serialVersionUID = 7055775683943950674L;

	/**
	 * 消息编号属性
	 */
	private Integer MId;

	private SjArticles sjArticles;

	/**
	 * （用户回复）消息的接收者属性（可以为空）
	 */
	private SjUsers sjUsersByMReplyId;

	/**
	 * 此消息的评论/回复的发布者属性（不可以为空）（不登录的用户无法留言，后期采用第三方账号快速登录的方式解决）
	 */
	private SjUsers sjUsersByMUId;

	/**
	 * 评论/回复的内容属性
	 */
	private String MComments;

	/**
	 * 评论/回复的发表时间属性
	 */
	private Timestamp MPublishdate;

	/**
	 * 消息类型属性（1 - 评论；2 - 回复；3 - 只读消息）
	 */
	private Integer MMessageType;

	/**
	 * 评论/回复消息的审核状态属性（0 - 未审核，1 - 审核通过，2 - 审核不通过）
	 */
	private Integer MVerifystate;

	/**
	 * 评论/回复时的IP地址属性
	 */
	private String MIpaddress;

	/**
	 * 评论/回复时的设备信息属性
	 */
	private String MDeviceinfo;

	/**
	 * 评论/回复时的操作系统信息属性
	 */
	private String MSysteminfo;

	/**
	 * 点赞数属性
	 */
	private Integer MPraisecount;

	public Integer getMPraisecount() {
		return MPraisecount;
	}

	public void setMPraisecount(Integer mPraisecount) {
		MPraisecount = mPraisecount;
	}

	public SjLeavemessages() {
	}

	public SjLeavemessages(Integer mId, SjArticles sjArticles,
			SjUsers sjUsersByMReplyId, SjUsers sjUsersByMUId, String mComments,
			Timestamp mPublishdate, Integer mMessageType, Integer mVerifystate,
			String mIpaddress, String mDeviceinfo, String mSysteminfo,
			Integer mPraisecount) {
		super();
		MId = mId;
		this.sjArticles = sjArticles;
		this.sjUsersByMReplyId = sjUsersByMReplyId;
		this.sjUsersByMUId = sjUsersByMUId;
		MComments = mComments;
		MPublishdate = mPublishdate;
		MMessageType = mMessageType;
		MVerifystate = mVerifystate;
		MIpaddress = mIpaddress;
		MDeviceinfo = mDeviceinfo;
		MSysteminfo = mSysteminfo;
		MPraisecount = mPraisecount;
	}

	public Integer getMId() {
		return this.MId;
	}

	public void setMId(Integer MId) {
		this.MId = MId;
	}

	public SjArticles getSjArticles() {
		return this.sjArticles;
	}

	public void setSjArticles(SjArticles sjArticles) {
		this.sjArticles = sjArticles;
	}

	public SjUsers getSjUsersByMReplyId() {
		return this.sjUsersByMReplyId;
	}

	public void setSjUsersByMReplyId(SjUsers sjUsersByMReplyId) {
		this.sjUsersByMReplyId = sjUsersByMReplyId;
	}

	public SjUsers getSjUsersByMUId() {
		return this.sjUsersByMUId;
	}

	public void setSjUsersByMUId(SjUsers sjUsersByMUId) {
		this.sjUsersByMUId = sjUsersByMUId;
	}

	public String getMComments() {
		return this.MComments;
	}

	public void setMComments(String MComments) {
		this.MComments = MComments;
	}

	public Timestamp getMPublishdate() {
		return this.MPublishdate;
	}

	public void setMPublishdate(Timestamp MPublishdate) {
		this.MPublishdate = MPublishdate;
	}

	public Integer getMMessageType() {
		return this.MMessageType;
	}

	public void setMMessageType(Integer MMessageType) {
		this.MMessageType = MMessageType;
	}

	public Integer getMVerifystate() {
		return this.MVerifystate;
	}

	public void setMVerifystate(Integer MVerifystate) {
		this.MVerifystate = MVerifystate;
	}

	public String getMIpaddress() {
		return this.MIpaddress;
	}

	public void setMIpaddress(String MIpaddress) {
		this.MIpaddress = MIpaddress;
	}

	public String getMDeviceinfo() {
		return this.MDeviceinfo;
	}

	public void setMDeviceinfo(String MDeviceinfo) {
		this.MDeviceinfo = MDeviceinfo;
	}

	public String getMSysteminfo() {
		return this.MSysteminfo;
	}

	public void setMSysteminfo(String MSysteminfo) {
		this.MSysteminfo = MSysteminfo;
	}
}