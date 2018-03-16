/*
 * Project Name: SJBlog
 * Class Name: UsersService.java
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
package top.sj.manage.service;

import java.util.List;

import net.sf.json.JSONObject;
import top.sj.entity.SjUsers;

/**
 * 用户业务接口
 * 
 * Create User: SteveJrong
 * Create Date: 2016年3月25日 下午11:19:43
 * Modify User: SteveJrong
 * Modify Date: 2016年3月25日 下午11:19:43
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public interface UsersService {
	/**
	 * 获取所有管理员账户信息的方法【抽象业务逻辑】
	 * 
	 * @return
	 */
	List<SjUsers> getAllAdminstratorsAccountService();

	/**
	 * 根据用户编号获取用户信息的方法【抽象业务逻辑】
	 * 
	 * @param id
	 * @return
	 */
	SjUsers getSingleUserInfoByIdService(Integer id);

	/**
	 * 管理员登录后台管理系统的方法【抽象业务逻辑】
	 * 
	 * @param userName
	 * @param pwd
	 * @return
	 */
	SjUsers doLoginService(String userName, String pwd);

	/**
	 * 根据用户昵称（登录名）获取单个用户信息的方法【抽象业务逻辑】
	 * 
	 * @param nickName
	 * @return
	 */
	SjUsers getSingleUserInfoByUserNickNameService(String nickName);

	/**
	 * 分页获取用户信息的方法【抽象业务逻辑】
	 * 
	 * @return
	 */
	JSONObject getAllUsersInfoBySplitPageService(Integer pageIndex,
			Integer pageSize);

	/**
	 * 分页获取用户总数的方法【抽象业务逻辑】
	 * 
	 * @return
	 */
	Integer getUsersInfoAllCountOfSplitPageService();

	/**
	 * 根据用户编号删除用户信息的方法【抽象业务逻辑】
	 * 
	 * @param userId
	 * @return
	 */
	Boolean deleteUserInfoByIdService(Integer userId);
}
