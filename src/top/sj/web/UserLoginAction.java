/*
 * Project Name: SJBlog
 * Class Name: UserLoginAction.java
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

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.WebUtils;
import org.apache.struts2.ServletActionContext;

import top.sj.common.util.ActionResult;
import top.sj.common.util.JCaptchaBusinessUtil;
import top.sj.common.util.ShiroExceptionEnum;
import top.sj.entity.SjUsers;
import top.sj.inputscope.SessionScope;
import top.sj.service.UserService;
import top.sj.tool.DateTimeTool;
import top.sj.tool.TimestampTool;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 用户登录相关的Action
 * 
 * Create User: SteveJrong
 * Create Date: 2016年2月26日 下午8:53:44
 * Modify User: SteveJrong
 * Modify Date: 2016年2月26日 下午8:53:44
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class UserLoginAction implements Action,Serializable {

	private static final Logger logger = Logger
			.getLogger(UserLoginAction.class);

	private static final long serialVersionUID = -1249804500791005642L;

	/**
	 * 用户实体类型的属性
	 */
	private SjUsers users;

	public SjUsers getUsers() {
		return users;
	}

	public void setUsers(SjUsers users) {
		this.users = users;
	}

	/**
	 * 验证码属性
	 */
	private String checkedCode;

	public String getCheckedCode() {
		return checkedCode;
	}

	public void setCheckedCode(String checkedCode) {
		this.checkedCode = checkedCode;
	}

	/**
	 * 用户业务接口类型的属性，用于Spring Ioc
	 */
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * 源URL属性
	 */
	private String refererUrl;

	public String getRefererUrl() {
		return refererUrl;
	}

	public void setRefererUrl(String refererUrl) {
		this.refererUrl = refererUrl;
	}

	/**
	 * 重定向URL路径属性
	 */
	private String redirectUrl;

	public String getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

	/**
	 * 默认执行的方法
	 */
	public synchronized String execute() throws Exception {
		boolean TorF = false;
		SjUsers user = null;
		
		/**
		 * 随机验证码验证
		 */
		HttpServletRequest request = ServletActionContext.getRequest();
		String sessionId = request.getSession().getId();
		String captchaId = sessionId;

		String validateCode = checkedCode;

		// 根据每一次发出请求的sessionid和用户填入的验证码进行匹配结果是否正确
		boolean validateResult = /*JCaptchaBusinessUtil.getService()
				.validateResponseForID(captchaId, validateCode)*/true;
		if (validateResult) {
			TorF = true;
		}

		if (TorF == true) {

			// 登录失败后的消息提示变量
			StringBuffer msg = new StringBuffer();

			// 创建一个带有用户名和密码的令牌
			UsernamePasswordToken token = new UsernamePasswordToken(
					users.getUNickname(),
					DigestUtils.sha256Hex(users.getUPwd()));
			Subject subject = SecurityUtils.getSubject();
			synchronized (this) {
				try {
					// 进行登录验证
					subject.login(token);
	
					// 对users对象中的用户密码进行加密处理
					users.setUPwd(DigestUtils.sha256Hex(users.getUPwd()));
					// 如果走到这一步，进行查询用户信息的时候，那就表明用户已经成功登录（走不到这一步就表明登录失败了）
					user = userService.doLoginService(users);
					
					// 把用户信息放入Session域中
					SessionScope.putUserInfoOnSessionScope(user);
					
					user.setULastlogontime(TimestampTool.convertNowDateToStimeStamp());
					//设置最后一次的登录时间
					userService.updateUserInfoService(user);
	
					logger.info(" -- user login was successed at "
							+ DateTimeTool.getNowDateFormatDateTimeTemplateOne()
							+ " -- ");
	
					/****************************** 目前存在的三种登录方式 ******************************/
					/**
					 * 文章详情拦截登录
					 */
					if (null != refererUrl && refererUrl.contains("detail")) {
						redirectUrl = refererUrl;
						return ActionResult.SUCCESS.getType();
					}
	
					/**
					 * 后台管理拦截登录
					 */
					Object shiroRequest = WebUtils.getSavedRequest(request);
					String interceptBeforeUrl = null;
					if (null != shiroRequest) {
						try {
							interceptBeforeUrl = WebUtils.getSavedRequest(request)
									.getRequestURI();
							logger.info(" -- interceptor before url is 【"
									+ interceptBeforeUrl + "】 -- ");
						} catch (Exception e) {
							e.printStackTrace();
						}
	
						if (interceptBeforeUrl.contains("manage")) {
							redirectUrl = "/manage";
							return ActionResult.SUCCESS.getType();
						}
					}
	
					/**
					 * 普通登录（直接走正常的登录流程非拦截登录）
					 */
					if (null == shiroRequest
							&& (refererUrl.contains("home") || refererUrl
									.contains("dologin"))) {
						redirectUrl = "/home";
						return ActionResult.SUCCESS.getType();
					}
					/****************************** 目前存在的三种登录方式 ******************************/
	
					// 否则就会抛出各种各样的异常，根据抛出的异常可判断用户是因为何种原因登录失败的
				} catch (IncorrectCredentialsException e) {
					logger.warn("登录密码错误. Password for account "
							+ token.getPrincipal() + " was incorrect.");
					msg.append(ShiroExceptionEnum.PASSWORDERROR.getType());
				} catch (ExcessiveAttemptsException e) {
					logger.warn("登录失败次数过多");
					msg.append(ShiroExceptionEnum.LOGINFAILEDMAXCOUNTS.getType());
				} catch (LockedAccountException e) {
					logger.warn("帐号已被锁定. The account for username "
							+ token.getPrincipal() + " was locked.");
					msg.append(ShiroExceptionEnum.ACCOUNTISLOCKED.getType());
				} catch (DisabledAccountException e) {
					logger.warn("帐号已被禁用. The account for username "
							+ token.getPrincipal() + " was disabled.");
					msg.append(ShiroExceptionEnum.ACCOUNTISDISABLED.getType());
					System.out.println(msg);
				} catch (ExpiredCredentialsException e) {
					logger.warn("帐号已过期. the account for username "
							+ token.getPrincipal() + "  was expired.");
					msg.append(ShiroExceptionEnum.ACCOUNTEXPIRED.getType());
				} catch (UnknownAccountException e) {
					logger.warn("帐号不存在. There is no user with username of "
							+ token.getPrincipal());
					msg.append(ShiroExceptionEnum.ACCOUNTNOTEXISTS.getType());
				} catch (UnauthorizedException e) {
					logger.warn("您没有得到相应的授权！You do not have authorization from the appropriate.");
					msg.append(ShiroExceptionEnum.ACCOUNTUNAUTHORIZED.getType());
				} catch (Exception e) {
					logger.warn("其他未知异常，请联系管理员解决。Other exceptions,please connect to administrators.\n异常信息："+e.getMessage());
					msg.append(ShiroExceptionEnum.OTHER.getType().concat("异常信息：").concat(e.getMessage()));
				}finally {
					if (null != msg) {
						// 将错误信息放入request域中
						request.setAttribute("message", msg.toString());
					}
				}
			}
		} else {
			// 将错误信息放入request域中
			request.setAttribute("message", "验证码输入错误，请重新输入");
		}

		logger.error(" -- user login was failed at "
				+ DateTimeTool.getNowDateFormatDateTimeTemplateOne() + " -- ");

		// 否则用户不存在
		return ActionResult.FAILED.getType();
	}
}
