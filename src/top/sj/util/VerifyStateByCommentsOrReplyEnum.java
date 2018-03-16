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
package top.sj.util;

/**
 * 评论/回复的消息审核状态枚举
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
public enum VerifyStateByCommentsOrReplyEnum {
	UN_VERIFY(0), // 未审核
	VERIFY_PASS(1), // 审核通过
	VERIFY_REJECT(2);// 审核不通过

	private Integer state;

	public static String getStateOfStringByStateId(Integer stateId) {
		String result = null;
		switch (stateId) {
		case 0:
			result = "未审核";
			break;
		case 1:
			result = "审核通过";
			break;
		case 2:
			result = "审核不通过";
			break;
		}
		return result;
	}

	public static Integer getStateIdByState(String state) {
		Integer result = null;
		switch (state) {
		case "未审核":
			result = 0;
			break;
		case "审核通过":
			result = 1;
			break;
		case "审核不通过":
			result = 2;
			break;
		}
		return result;
	}

	public Integer getState() {
		return state;
	}

	private VerifyStateByCommentsOrReplyEnum(Integer state) {
		this.state = state;
	}
}
