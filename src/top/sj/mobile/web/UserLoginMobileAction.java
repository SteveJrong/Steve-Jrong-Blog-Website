/*
 * Project Name: SJBlog
 * Class Name: UserLoginMobileAction.java
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

import net.sf.json.JSONArray;

import org.codehaus.jettison.json.JSONObject;

import com.opensymphony.xwork2.Action;

import top.sj.common.util.ActionResult;
import top.sj.entity.SjUsers;
import top.sj.mobile.responsebeans.UserLoginResponeBean;
import top.sj.mobile.service.UserService;
import top.sj.mobile.util.ParameterCodecByMobilePlatformUtil;

/**
 * 【移动平台】用户登录相关的Action
 * 
 * Create User: SteveJrong
 * Create Date: 2016年5月15日 下午12:53:23
 * Modify User: SteveJrong
 * Modify Date: 2016年5月15日 下午12:53:23
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class UserLoginMobileAction implements Serializable, Action {

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
		// 测试地址：http://localhost:8888/SJBlog/mobileUserLogin.action?paramJsonDatas={%22name%22:%22%E5%BC%A0%E4%B8%89%22,%22pwd%22:%22123%22}
		JSONObject paramJsonDatas = new JSONObject(ParameterCodecByMobilePlatformUtil.parameterEcode("paramJsonDatas"));
		UserLoginResponeBean responeBean = new UserLoginResponeBean();
		SjUsers user = mobileUserService.doLogin(paramJsonDatas.getString("userNickName"),
				paramJsonDatas.getString("userPassword"));
		responseResult = new HashMap<String, Object>();
		if (null == user) {
			responeBean.setResult(false);
			responeBean.setUserId(null);
		} else {
			responeBean.setResult(true);
			responeBean.setUserId(user.getUId().toString());
		}
		responseResult.put("result", JSONArray.fromObject(responeBean));
		return ActionResult.SUCCESS.getType();
	}
}
