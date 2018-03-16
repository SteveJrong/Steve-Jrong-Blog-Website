/*
 * Project Name: SJBlog
 * Class Name: ArticleViewsEntityUtil.java
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

import java.util.ArrayList;
import java.util.List;

/**
 * 文章浏览量实体工具类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年10月9日 下午2:53:59
 * Modify User: SteveJrong
 * Modify Date: 2016年10月9日 下午2:53:59
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class ArticleViewsEntityUtil {
	/**
	 * 文章浏览量属性
	 */
	private Integer viewsCount;
	
	/**
	 * 浏览者IP地址属性
	 */
	private List<String> ipAddress = new ArrayList<String>();

	public Integer getViewsCount() {
		return viewsCount;
	}

	public void setViewsCount(Integer viewsCount) {
		this.viewsCount = viewsCount;
	}

	public ArticleViewsEntityUtil() {
	}

	public List<String> getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(List<String> ipAddress) {
		this.ipAddress = ipAddress;
	}

	public ArticleViewsEntityUtil(Integer viewsCount,
			List<String> ipAddress) {
		super();
		this.viewsCount = viewsCount;
		this.ipAddress = ipAddress;
	}
}
