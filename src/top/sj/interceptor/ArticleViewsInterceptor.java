/*
 * Project Name: SJBlog
 * Class Name: ArticleViewsInterceptor.java
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
package top.sj.interceptor;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import top.sj.util.ArticleViewsEntityUtil;
import top.sj.util.ArticleViewsManageUtil;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 文章浏览量拦截器
 * 
 * Create User: SteveJrong
 * Create Date: 2016年10月9日 下午2:15:01
 * Modify User: SteveJrong
 * Modify Date: 2016年10月9日 下午2:15:01
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class ArticleViewsInterceptor extends AbstractInterceptor {
	
	private static final long serialVersionUID = 3162396505763292562L;

	/**
	 * 拦截方法
	 */
	@SuppressWarnings({ "unused", "static-access" })
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		String result = invocation.invoke();
		Integer articleId = Integer.valueOf(invocation.getInvocationContext().getContext().getValueStack().findString("articleId").toString());
		String guestIP = invocation.getInvocationContext().getContext().getValueStack().findString("guestIP");
		
		Map<Integer, ArticleViewsEntityUtil> articleViews = ArticleViewsManageUtil.getViewsEntityUtils();
		
		/*结构：
		
		Key				Value
		文章编号			IP地址		浏览量
						/	\
					[IP1,IP2……IPn]*/
		
		/*例如：
		
		文章编号：38		IP地址：127.0.0.1		浏览量：2
								192.168.6.188
								
		文章编号：39		IP地址：127.0.0.1		浏览量：3
								192.168.6.188
								192.168.1.1*/
		
		
		//如果集合为空，则直接添加新的记录
		if (articleViews.size() <= 0) {
			ArticleViewsEntityUtil entityUtil = new ArticleViewsEntityUtil();
			
			//添加当前IP地址到IP地址集合中
			entityUtil.getIpAddress().add(guestIP);
			
			//设置访客量默认为1
			entityUtil.setViewsCount(1);
			
			//添加到管理集合中
			articleViews.put(articleId, entityUtil);
		}else {
			//如果集合不为空
			
			Boolean existsThisArticle = false;
			//根据文章编号查找到对应的Key
			Iterator<Entry<Integer, ArticleViewsEntityUtil>> iterator = articleViews.entrySet().iterator();
			while (iterator.hasNext()) {
				Entry<Integer, ArticleViewsEntityUtil> entry = iterator.next();
				
				//如果存在则设置标识符为true
				if (entry.getKey() == articleId) {
					existsThisArticle = true;
				}
			}
			
			//如果没找到对应的Key，说明是新文章
			if (existsThisArticle == false) {
				ArticleViewsEntityUtil entityUtil = new ArticleViewsEntityUtil();
				
				//添加当前IP地址到IP地址集合中
				entityUtil.getIpAddress().add(guestIP);
				
				//设置访客量默认为1
				entityUtil.setViewsCount(1);
				
				//添加到管理集合中
				articleViews.put(articleId, entityUtil);
			}else {
				//如果找到了对应的Key，则要进行判断
				//首先遍历管理集合
				Iterator<Entry<Integer, ArticleViewsEntityUtil>> hasIterator = articleViews.entrySet().iterator();
				while (hasIterator.hasNext()) {
					Entry<Integer, ArticleViewsEntityUtil> entry = hasIterator.next();
					
					//如果集合中迭代到了当前文章的编号
					if (entry.getKey() == articleId) {
						
						//再遍历当前Key为文章ID的IP地址集合判断是否存在过此IP地址
						
						Boolean existsThisIpAddress = false;
						
						for (String ipAddress : entry.getValue().getIpAddress()) {
							if (ipAddress.equals(guestIP)) {
								existsThisIpAddress = true;
							}
						}
						
						//存在过此IP地址，则跳过不计数
						if (existsThisIpAddress == true) {
							break;
						}else {
							//不存在此IP地址，添加此IP地址并且将此文章浏览量加1
							entry.getValue().getIpAddress().add(guestIP);
							entry.getValue().setViewsCount(entry.getValue().getViewsCount()+1);
						}
						
						break;
					}
				}
			}
		}
		
		Iterator<Entry<Integer, ArticleViewsEntityUtil>> it = ArticleViewsManageUtil.getViewsEntityUtils().entrySet().iterator();
		while (it.hasNext()) {
			Entry<Integer, ArticleViewsEntityUtil> entry = it.next();
			System.out.print("AId:"+entry.getKey());
			for (String ip : entry.getValue().getIpAddress()) {
				System.out.print("\tIP:"+ip);
			}
			System.out.println("\tViews:"+entry.getValue().getViewsCount());
		}
		
		return null;
	}
}
