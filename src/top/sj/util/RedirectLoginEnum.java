/*
 * Project Name: SJBlog
 * Class Name: RedirectLoginEnum.java
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
 * 登录后跳转枚举
 * 
 * Create User: SteveJrong
 * Create Date: 2016年8月24日 下午2:10:47
 * Modify User: SteveJrong
 * Modify Date: 2016年8月24日 下午2:10:47
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public enum RedirectLoginEnum {
	ARTICLE_DETAIL("articleDetail"), // 文章详情
	MANAGE("manage"), // 后台管理
	HOME_PAGE("homePage");// 主页
	private String type;

	public String getType() {
		return type;
	}

	private RedirectLoginEnum(String type) {
		this.type = type;
	}
}
