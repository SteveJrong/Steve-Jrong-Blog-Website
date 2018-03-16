/*
 * Project Name: SJBlog
 * Class Name: CommentsOrRepliesResponeBean.java
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
package top.sj.mobile.responsebeans;

import java.io.Serializable;

/**
 * 【移动平台】评论/回复DTO Bean
 * 
 * Create User: SteveJrong
 * Create Date: 2016年10月17日 上午9:35:20
 * Modify User: SteveJrong
 * Modify Date: 2016年10月17日 上午9:35:20
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class CommentsOrRepliesResponeBean implements Serializable {
	private static final long serialVersionUID = -4959656216403672749L;
	
	/**
	 * 评论/回复编号属性
	 */
	private Long id;
	
	/**
	 * 评论/回复内容属性
	 */
	private String content; 
	
	/**
	 * 评论/回复的发表时间属性
	 */
	private String publishDate;
	
	/**
	 * 评论/回复的消息类型属性
	 */
	private Integer messageType;
	
	/**
	 * 评论/回复发布时的设备信息属性
	 */
	private String publishedDeviceInfo;
	
	/**
	 * 评论/回复发布时的系统信息属性
	 */
	private String publishedSystemInfo;
	
	/**
	 * 评论/回复消息的点赞数属性
	 */
	private Long praiseCount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public Integer getMessageType() {
		return messageType;
	}

	public void setMessageType(Integer messageType) {
		this.messageType = messageType;
	}

	public String getPublishedDeviceInfo() {
		return publishedDeviceInfo;
	}

	public void setPublishedDeviceInfo(String publishedDeviceInfo) {
		this.publishedDeviceInfo = publishedDeviceInfo;
	}

	public String getPublishedSystemInfo() {
		return publishedSystemInfo;
	}

	public void setPublishedSystemInfo(String publishedSystemInfo) {
		this.publishedSystemInfo = publishedSystemInfo;
	}

	public Long getPraiseCount() {
		return praiseCount;
	}

	public void setPraiseCount(Long praiseCount) {
		this.praiseCount = praiseCount;
	}

	public CommentsOrRepliesResponeBean(Long id, String content,
			String publishDate, Integer messageType,
			String publishedDeviceInfo, String publishedSystemInfo,
			Long praiseCount) {
		super();
		this.id = id;
		this.content = content;
		this.publishDate = publishDate;
		this.messageType = messageType;
		this.publishedDeviceInfo = publishedDeviceInfo;
		this.publishedSystemInfo = publishedSystemInfo;
		this.praiseCount = praiseCount;
	}
	
	public CommentsOrRepliesResponeBean() {
	}
}
