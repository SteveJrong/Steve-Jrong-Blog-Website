/*
 * Project Name: SJBlog
 * Class Name: DoPraiseEntityUtil.java
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
 * 点赞/取消点赞的实体工具类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年9月16日 下午6:03:22
 * Modify User: SteveJrong
 * Modify Date: 2016年9月16日 下午6:03:22
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class DoPraiseEntityUtil {
	/**
	 * 评论/回复的消息编号
	 */
	private Integer cOrRId;
	
	/**
	 * 是否点赞过
	 */
	private Boolean isDoPraised;
	
	/**
	 * IP地址
	 */
	private String ipAddress;

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public Integer getcOrRId() {
		return cOrRId;
	}

	public void setcOrRId(Integer cOrRId) {
		this.cOrRId = cOrRId;
	}

	public Boolean getIsDoPraised() {
		return isDoPraised;
	}

	public void setIsDoPraised(Boolean isDoPraised) {
		this.isDoPraised = isDoPraised;
	}

	public DoPraiseEntityUtil(Integer cOrRId, Boolean isDoPraised, String ipAddress) {
		super();
		this.cOrRId = cOrRId;
		this.isDoPraised = isDoPraised;
		this.ipAddress = ipAddress;
	}

	public DoPraiseEntityUtil() {
	}
}
