/*
 * Project Name: SJBlog
 * Class Name: UserDao.java
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
package top.sj.dao;

import top.sj.entity.SjUsers;

/**
 * 用户接口
 * 
 * Create User: SteveJrong
 * Create Date: 2016-2-26 下午5:50:09
 * Modify User: SteveJrong
 * Modify Date: 2016-2-26 下午5:50:09
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public interface UserDao {
	/**
	 * 用户登录的方法【抽象方法】
	 * 
	 * 方法描述:
	 * 
	 * @param user
	 * @return
	 * @returnType SjUsers 创建人： Steve Jrong 创建时间：2016-2-26 下午6:15:06
	 */
	SjUsers doLogin(SjUsers user);

	/**
	 * 用户注册的方法【抽象方法】
	 * 
	 * 方法描述:
	 * 
	 * @param user
	 * @return
	 * @returnType Boolean 创建人： Steve Jrong 创建时间：2016-2-26 下午10:19:52
	 */
	Boolean doRegister(SjUsers user);
	
	/**
	 * 更新用户信息的方法【抽象方法】
	 * @param users
	 * @return
	 */
	Boolean updateUserInfo(SjUsers users);
	
	/**
	 * 根据用户编号获取用户信息的方法【抽象方法】
	 * @param userId
	 * @return
	 */
	SjUsers getUserInfoById(Integer userId);
}