/*
 * Project Name: SJBlog
 * Class Name: UserRegisterAction.java
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
import java.sql.Timestamp;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import top.sj.common.util.ActionResult;
import top.sj.common.util.Constants;
import top.sj.entity.SjUsers;
import top.sj.service.UserService;
import top.sj.tool.BaiDuIPInfoTool;
import top.sj.tool.ProjectPropertiesTool;
import top.sj.tool.PropertiesTool;
import top.sj.tool.ReverseProxyIPInfoTool;
import top.sj.tool.TaoBaoIPInfoTool;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 用户注册相关的Action
 * 
 * Create User: SteveJrong
 * Create Date: 2016年2月26日 下午10:23:46
 * Modify User: SteveJrong
 * Modify Date: 2016年2月26日 下午10:23:46
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class UserRegisterAction extends ActionSupport implements Serializable {
	private static final long serialVersionUID = 1704716736272354720L;
	
	private static Logger LOGGER = LoggerFactory.getLogger(UserRegisterAction.class);

	/**
	 * 用户业务接口类型的属性，用于Spring Ioc
	 */
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * 用户实体属性
	 */
	private SjUsers user;

	/**
	 * 用户QQ号码属性
	 */
	private String qqNum;

	public String getQqNum() {
		return qqNum;
	}

	public void setQqNum(String qqNum) {
		this.qqNum = qqNum;
	}

	public SjUsers getUser() {
		return user;
	}

	public void setUser(SjUsers user) {
		this.user = user;
	}

	/**
	 * 默认执行的方法
	 */
	@Override
	public String execute() throws Exception {
		// 加密用户的密码
		user.setUPwd(DigestUtils.sha256Hex(user.getUPwd()));
		user.setURole(Constants.USER_ROLE_OF_NORMAL.getValue());
		user.setUState(Constants.USER_STATE_OF_NORMAL.getValue());
		user.setULevel(1);
		user.setUQqnum(Integer.parseInt(qqNum));
		user.setUCreatetime(new Timestamp(System.currentTimeMillis()));
		user.setUHeader(Constants.USER_HEADER_FILE_PATH_OF_DEFAULT.getValue());
		
		String guestIP,guestArea = null;
		
		guestIP = ReverseProxyIPInfoTool.getClientIP(ServletActionContext.getRequest());
		LOGGER.info(" -- 通过反向代理工具获取的IP地址："+guestIP+" -- ");

		guestArea = TaoBaoIPInfoTool.getIPInfo(guestIP);
		LOGGER.info(" -- 通过淘宝IP地址信息工具获取的IP信息："+guestArea+" -- ");
		
		user.setUProvinceandcity(guestArea);
		
		if (userService.doRegisterService(user)) {
			return ActionResult.HOMEPAGE.getType();
		}
		return ActionResult.FAILED.getType();
	}
}
