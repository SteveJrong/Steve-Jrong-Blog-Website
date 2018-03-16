/*
 * Project Name: SJBlog
 * Class Name: MessageTypeByCommentsOrReplyEnum.java
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
 * 评论/回复的消息类型枚举
 * 
 * Create User: SteveJrong
 * Create Date: 2016年8月24日 下午5:49:01
 * Modify User: SteveJrong
 * Modify Date: 2016年8月24日 下午5:49:01
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public enum MessageTypeByCommentsOrReplyEnum {
	COMMENT(1), // 评论
	REPLY(2), // 回复
	READONLY(3); // 只读消息

	private Integer msgType;

	public Integer getMsgType() {
		return msgType;
	}

	public static String getMsgTypeByTypeId(Integer msgTypeId) {
		String result = null;
		switch (msgTypeId) {
		case 1:
			result = "评论";
			break;
		case 2:
			result = "回复";
			break;
		case 3:
			result = "只读消息";
			break;
		}
		return result;
	}

	private MessageTypeByCommentsOrReplyEnum(Integer type) {
		this.msgType = type;
	}
}
