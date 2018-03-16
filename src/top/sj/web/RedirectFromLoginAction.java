/*
 * Project Name: SJBlog
 * Class Name: RedirectFromLoginAction.java
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
package top.sj.web;

import java.io.Serializable;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import top.sj.util.RedirectLoginEnum;

import com.opensymphony.xwork2.Action;

/**
 * 登录后重定向相关的Action
 * 
 * Create User: SteveJrong
 * Create Date: 2016年8月24日 上午10:54:26
 * Modify User: SteveJrong
 * Modify Date: 2016年8月24日 上午10:54:26
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class RedirectFromLoginAction implements Action, Serializable {

	private static final long serialVersionUID = -6015580097892257576L;

	private Logger LOGGER = LoggerFactory.getLogger(RedirectFromLoginAction.class);

	private String articleId;

	public String getArticleId() {
		return articleId;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}

	/**
	 * 默认执行的方法
	 */
	@Override
	public String execute() throws Exception {

		Map<String, String[]> requestParams = ServletActionContext.getRequest()
				.getParameterMap();

		if (null != requestParams && requestParams.size() > 0) {
			String redirectType = requestParams.get("redirectType").toString();

			// 文章详情
			if (redirectType.equals(RedirectLoginEnum.ARTICLE_DETAIL.getType())) {
				String url = ServletActionContext.getRequest()
						.getParameter("refererUrl").toString();

				if (null != url) {
					articleId = url.substring(url.indexOf("_") + 1);
					LOGGER.info(" -- article identity by login success after is "
							+ articleId + " -- ");
					return RedirectLoginEnum.ARTICLE_DETAIL.getType();
				}
				// 主页
			} else if (redirectType.equals(RedirectLoginEnum.HOME_PAGE
					.getType())) {

			}
		}

		return null;
	}
}
