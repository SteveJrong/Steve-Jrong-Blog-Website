package top.sj.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import top.sj.entity.SjUsers;

import com.danga.MemCached.MemCachedClient;

public class Test3 {

	public static void main(String[] args) {
		ApplicationContext ctx = new FileSystemXmlApplicationContext(
				new String[] {
						System.getProperty("user.dir")
								+ "/src/spring-memcache.xml",
						System.getProperty("user.dir")
								+ "/src/applicationContext.xml" });

		// SockIOPool s = SpringContextHolder.getBean("memcachedPool");
		// System.out.println("s=" + s.getInitConn());

		MemCachedClient client = (MemCachedClient) ctx
				.getBean("memcachedClient");

		// 将数据放入缓存
		SjUsers bean = new SjUsers();
		bean.setUNickname("Steve Jrong");
		bean.setUAge(25);
		client.add("bean1", bean);

		// 获取缓存数据
		SjUsers beanClient = (SjUsers) client.get("bean1");
		System.out.println(beanClient.getUAge());
	}
}