/*
 * Project Name: SJBlog
 * Class Name: EmailServiceImpl.java
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
package top.sj.manage.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import top.sj.manage.service.EmailService;
import top.sj.tool.DateTimeTool;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * 电子邮件业务接口的实现类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年6月17日 下午3:59:22
 * Modify User: SteveJrong
 * Modify Date: 2016年6月17日 下午3:59:22
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class EmailServiceImpl implements EmailService {

	/**
	 * 电子邮件发送对象属性
	 */
	private JavaMailSender javaMailSender;

	/**
	 * Freemarker技术类对象的属性
	 */
	private FreeMarkerConfigurer freeMarkerConfigurer;

	public void setJavaMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public void setFreeMarkerConfigurer(
			FreeMarkerConfigurer freeMarkerConfigurer) {
		this.freeMarkerConfigurer = freeMarkerConfigurer;
	}

	/**
	 * 发送邮件的方法【业务逻辑】 目前使用QQ邮箱向微软Hotmail邮箱发送邮件
	 * 
	 * @throws MessagingException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws TemplateException
	 * @throws IOException
	 */
	@Override
	public Boolean sendEmailService() throws MessagingException,
			InstantiationException, IllegalAccessException, IOException,
			TemplateException {
		Template tpl = freeMarkerConfigurer.getConfiguration().getTemplate(
				"default_mail_template.ftl");
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("user", "张三");
		String htmlText = FreeMarkerTemplateUtils.processTemplateIntoString(
				tpl, paramMap);

		// 建立邮件消息,发送简单邮件和html邮件的区别
		MimeMessage mailMessage = javaMailSender.createMimeMessage();
		// 注意这里的boolean,等于真的时候才能嵌套图片，在构建MimeMessageHelper时候，所给定的值是true表示启用，
		MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage,
				true, "GBK");
		// 接收者邮箱
		messageHelper.setTo("wangjing4568@hotmail.com");
		// 发送者邮箱
		messageHelper.setFrom("1554052208@qq.com");
		// 邮件标题
		messageHelper.setSubject("Steve Jrong's Blog Test Email:"
				+ DateTimeTool.getNowDateFormatDateTimeTemplateOne());
		// 邮件内容
		messageHelper.setText(htmlText, true);
		// 发送邮件
		javaMailSender.send(mailMessage);
		System.out.println("邮件发送成功！");
		return true;
	}
}
