/*
 * Project Name: SJBlog
 * Class Name: UserService.java
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
package top.sj.service;

import net.sf.json.JSONObject;
import top.sj.entity.SjUsers;
import top.sj.util.PersonalCenterDataGridNode;

/**
 * 用户服务接口
 * 
 * Create User: SteveJrong
 * Create Date: 2016年2月26日 下午8:54:39
 * Modify User: SteveJrong
 * Modify Date: 2016年2月26日 下午8:54:39
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public interface UserService {
	/**
	 * 用户登录的方法【抽象业务逻辑】
	 * 
	 * 方法描述:
	 * 
	 * @param users
	 * @return
	 * @returnType SjUsers 创建人： Steve Jrong 创建时间：2016-2-26 下午8:55:16
	 */
	SjUsers doLoginService(SjUsers users);

	/**
	 * 用户注册的方法【抽象业务逻辑】
	 * 
	 * 方法描述:
	 * 
	 * @param user
	 * @return
	 * @returnType Boolean 创建人： Steve Jrong 创建时间：2016-2-26 下午10:22:34
	 */
	Boolean doRegisterService(SjUsers user);
	
	/**
	 * 更新用户信息的方法【抽象业务逻辑】
	 * @param users
	 * @return
	 */
	Boolean updateUserInfoService(SjUsers users);
	
	/**
	 * 根据用户编号获取用户信息的方法【抽象业务逻辑】
	 * @param userId
	 * @return
	 */
	SjUsers getUserInfoByIdService(Integer userId);
	
	/**
	 * 根据个人中心DTO更新用户信息的方法【抽象业务逻辑】
	 * @param personalCenterDTO PersonalCenterDataGridNode对象
	 * @return
	 */
	Boolean updateUserInfoByUserIdAndPersonalCenterDTO(PersonalCenterDataGridNode personalCenterDTO);
	
	/**
	 * 根据用户编号获取基于个人信息DataGridNode的JSON数据的方法【抽象业务逻辑】
	 * @param userId
	 * @return
	 */
	JSONObject getUserInfoBasedOnPersonalCenterDataGridNodeByUserId(Integer userId);
}
