/*
 * Project Name: SJBlog
 * Class Name: BuildFullTextSearchDTO.java
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
package top.sj.manage.dto;

import java.io.Serializable;

/**
 * 网站全文搜索引擎传输对象实体类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年6月17日 上午12:12:56
 * Modify User: SteveJrong
 * Modify Date: 2016年6月17日 上午12:12:56
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class BuildFullTextSearchDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 建立标识符的Key
	 */
	private String buildFlagKey;

	/**
	 * 建立标识符Value
	 */
	private Boolean buildFlagValue;

	public String getBuildFlagKey() {
		return buildFlagKey;
	}

	public void setBuildFlagKey(String buildFlagKey) {
		this.buildFlagKey = buildFlagKey;
	}

	public Boolean getBuildFlagValue() {
		return buildFlagValue;
	}

	public void setBuildFlagValue(Boolean buildFlagValue) {
		this.buildFlagValue = buildFlagValue;
	}

	public BuildFullTextSearchDTO(String buildFlagKey, Boolean buildFlagValue) {
		super();
		this.buildFlagKey = buildFlagKey;
		this.buildFlagValue = buildFlagValue;
	}

	public BuildFullTextSearchDTO() {
	}
}
