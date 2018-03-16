/*
 * Project Name: SJBlog
 * Class Name: LoadUserInfoAction.java
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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.Action;

import top.sj.common.util.ActionResult;
import top.sj.inputscope.SessionScope;

/**
 * 载入“用户中心”页相关的Action
 * 
 * Create User: SteveJrong
 * Create Date: 2016年11月30日 14:43:09
 * Modify User: SteveJrong
 * Modify Date: 2016年11月30日 14:43:09
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class LoadPersonalCenterAction implements Action, Serializable {

	private static final long serialVersionUID = 4230471517329273108L;
	@SuppressWarnings("unused")
	private static final Logger LOGGER = LoggerFactory.getLogger(LoadPersonalCenterAction.class);
	
	/**
	 * 用户编号属性
	 */
	private Integer userId;
	
	/**
	 * 用户头像文件属性
	 */
	private String userHeaderFilePath;
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public String getUserHeaderFilePath() {
		return userHeaderFilePath;
	}

	public void setUserHeaderFilePath(String userHeaderFilePath) {
		this.userHeaderFilePath = userHeaderFilePath;
	}

	/**
	 * 默认执行的方法
	 */
	public String execute() {
		userId = SessionScope.getUserEntityInfoOnSessionScope().getUId();
		userHeaderFilePath = SessionScope.getUserEntityInfoOnSessionScope().getUHeader();
		return ActionResult.SUCCESS.getType();
	}
}
