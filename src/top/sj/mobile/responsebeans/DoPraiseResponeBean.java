/*
 * Project Name: SJBlog
 * Class Name: DoPraiseResponeBean.java
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
 * 【移动平台】为评论/回复消息点赞的DTO Bean
 * 
 * Create User: SteveJrong
 * Create Date: 2016年10月18日 下午3:52:42
 * Modify User: SteveJrong
 * Modify Date: 2016年10月18日 下午3:52:42
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class DoPraiseResponeBean implements Serializable {
	private static final long serialVersionUID = -2709815147212690959L;

	/**
	 * 返回结果标识符属性
	 */
	private Boolean result;
	
	/**
	 * 是否点赞过标识符属性
	 */
	private Boolean isParised;

	public Boolean getResult() {
		return result;
	}

	public void setResult(Boolean result) {
		this.result = result;
	}

	public Boolean getIsParised() {
		return isParised;
	}

	public void setIsParised(Boolean isParised) {
		this.isParised = isParised;
	}

	public DoPraiseResponeBean(Boolean result, Boolean isParised) {
		super();
		this.result = result;
		this.isParised = isParised;
	}
	
	public DoPraiseResponeBean() {
	}
}
