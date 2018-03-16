package top.sj.mail;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class Mail {
	private MailSender mailSender;

	/**
	 * 发送简单邮件的方法
	 */
	public void sendSimpleEmail() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		mailSender = (MailSender) ctx.getBean("mailSender");

		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("wangjing4568@hotmail.com");
		message.setTo("1554052208@qq.com");
		message.setSubject("hello！");
		message.setText("Hello,Timo!");
		mailSender.send(message);
	}
}