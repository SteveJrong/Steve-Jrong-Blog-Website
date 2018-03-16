/*
 * Project Name: SJBlog
 * Class Name: UserRegisterMobileAction.java
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
package top.sj.mobile.web;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import top.sj.common.util.ActionResult;
import top.sj.mobile.service.UserService;
import top.sj.mobile.util.ParameterCodecByMobilePlatformUtil;

import com.opensymphony.xwork2.Action;

/**
 * 【移动平台】用户注册相关的Action
 * 
 * Create User: SteveJrong
 * Create Date: 2016年5月16日 下午12:33:56
 * Modify User: SteveJrong
 * Modify Date: 2016年5月16日 下午12:33:56
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class UserRegisterMobileAction implements Serializable, Action {

	private static final long serialVersionUID = 3181774808501303900L;

	/**
	 * 用户业务接口类型的属性，用于Spring Ioc
	 */
	private UserService mobileUserService;

	public void setMobileUserService(UserService mobileUserService) {
		this.mobileUserService = mobileUserService;
	}

	/**
	 * 结果集属性
	 */
	private Map<String, Object> responseResult;

	public Map<String, Object> getResponseResult() {
		return responseResult;
	}

	public void setResponseResult(Map<String, Object> responseResult) {
		this.responseResult = responseResult;
	}

	/**
	 * 默认执行的方法
	 */
	@Override
	public String execute() throws Exception {
		// 测试地址：http://localhost:8888/SJBlog/mobileUserRegister.action?paramJsonDatas={%22userNickName%22:%22%E5%BC%A0%E4%B8%89%22,%22userGender%22:%22%E7%94%B7%22,%22userRole%22:%22%E7%94%A8%E6%88%B7%22,%22userAge%22:22,%22userPassword%22:%22123%22,%22userSecurityQuestionAnswer%22:%22%E7%8E%8B%E5%B9%B3%22,%22userState%22:%22%E6%AD%A3%E5%B8%B8%22,%22userLevel%22:1,%22userEmail%22:%22123@qq.com%22,%22userQQNumber%22:123456789,%22userLocation%22:%22%E5%8C%97%E4%BA%AC%E5%B8%82%E6%9C%9D%E9%98%B3%E5%8C%BA%22}
		responseResult = new HashMap<String, Object>();
		if (mobileUserService.doRegister(ParameterCodecByMobilePlatformUtil
				.parameterEcode("paramJsonDatas").toString())) {
			responseResult.put("result", true);
		} else {
			responseResult.put("result", false);
		}
		return ActionResult.SUCCESS.getType();
	}
}
