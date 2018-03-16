/*
 * Project Name: SJBlog
 * Class Name: LoadAddNewArticleInfoAction.java
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
package top.sj.manage.web;

import java.io.Serializable;
import java.util.List;

import top.sj.common.util.ActionResult;
import top.sj.entity.SjArticletypes;
import top.sj.entity.SjUsers;
import top.sj.manage.service.ArticlesService;
import top.sj.manage.service.UsersService;

import com.opensymphony.xwork2.Action;

/**
 * 载入新增博文信息页相关的Action
 * 
 * Create User: SteveJrong
 * Create Date: 2016年3月25日 下午11:11:09
 * Modify User: SteveJrong
 * Modify Date: 2016年3月25日 下午11:11:09
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class LoadAddNewArticleInfoAction implements Action, Serializable {

	private static final long serialVersionUID = 2134299403037977356L;

	/**
	 * 文章业务类型的接口，用于Spring Ioc
	 */
	private ArticlesService mArticlesService;

	/**
	 * 用户业务类型的接口，用于Spring Ioc
	 */
	private UsersService mUsersService;

	public void setmUsersService(UsersService mUsersService) {
		this.mUsersService = mUsersService;
	}

	/**
	 * 博文类型的集合
	 */
	private List<SjArticletypes> types;

	/**
	 * 管理员用户的集合
	 */
	private List<SjUsers> users;

	public List<SjUsers> getUsers() {
		return users;
	}

	public void setUsers(List<SjUsers> users) {
		this.users = users;
	}

	public List<SjArticletypes> getTypes() {
		return types;
	}

	public void setTypes(List<SjArticletypes> types) {
		this.types = types;
	}

	public void setmArticlesService(ArticlesService mArticlesService) {
		this.mArticlesService = mArticlesService;
	}

	/**
	 * 默认执行的方法
	 */
	@Override
	public String execute() throws Exception {
		types = mArticlesService.getArticleTypesInfoService();
		users = mUsersService.getAllAdminstratorsAccountService();
		
		if (null != types && null != users) {
			return ActionResult.SUCCESS.getType();
		} else {
			return ActionResult.NULL.getType();
		}
	}
}
