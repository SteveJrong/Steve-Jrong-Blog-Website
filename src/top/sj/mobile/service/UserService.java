/*
 * Project Name: SJBlog
 * Class Name: UserServiceResponseBean.java
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
package top.sj.mobile.service;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;

import top.sj.entity.SjUsers;

/**
 * 【移动平台】用户业务接口
 * 
 * Create User: SteveJrong
 * Create Date: 2016年5月15日 上午10:26:30
 * Modify User: SteveJrong
 * Modify Date: 2016年5月15日 上午10:26:30
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public interface UserService extends Serializable {
	/**
	 * 用户登录的方法【抽象业务逻辑】
	 * 
	 * @param object
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	SjUsers doLogin(String username, String pwd) throws UnsupportedEncodingException;

	/**
	 * 用户注册的方法【抽象业务逻辑】
	 * 
	 * @param jsonParam
	 * @return
	 */
	Boolean doRegister(String jsonParam);
}
