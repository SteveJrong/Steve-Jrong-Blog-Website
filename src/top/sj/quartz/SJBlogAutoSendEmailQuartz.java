/*
 * Project Name: SJBlog
 * Class Name: SJBlogAutoSendEmailQuartz.java
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
package top.sj.quartz;

import java.io.IOException;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import top.sj.manage.service.EmailService;
import freemarker.template.TemplateException;

/**
 * 博客自动发送电子邮件的Quartz任务类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年7月21日 上午11:02:53
 * Modify User: SteveJrong
 * Modify Date: 2016年7月21日 上午11:02:53
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class SJBlogAutoSendEmailQuartz {

	private Logger LOGGER = LoggerFactory.getLogger(SJBlogAutoSendEmailQuartz.class);

	private EmailService emailService;

	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
	}

	/**
	 * 触发器的执行方法
	 * 
	 * @throws TemplateException
	 * @throws IOException
	 * @throws MessagingException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	protected void execute() throws InstantiationException,
			IllegalAccessException, MessagingException, IOException,
			TemplateException {
//		if (emailService.sendEmailService()) {
//			LOGGER.info(DateTimeTool.getNowDateFormatDateTimeTemplateOne()
//					.concat(" -- 自动发送电子邮件成功！ -- "));
//		} else {
//			LOGGER.error(DateTimeTool.getNowDateFormatDateTimeTemplateOne()
//					.concat(" -- 自动发送电子邮件失败！ -- "));
//		}
	}
}
