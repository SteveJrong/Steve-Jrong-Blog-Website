/*
 * Project Name: SJBlog
 * Class Name: EmailService.java
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
package top.sj.manage.service;

import java.io.IOException;

import javax.mail.MessagingException;

import freemarker.template.TemplateException;

/**
 * 电子邮件业务接口
 * 
 * Create User: SteveJrong
 * Create Date: 2016年6月17日 下午3:58:13
 * Modify User: SteveJrong
 * Modify Date: 2016年6月17日 下午3:58:13
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public interface EmailService {
	/**
	 * 发送邮件的方法【抽象业务逻辑】
	 * 
	 * @return
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws TemplateException
	 * @throws IOException
	 */
	Boolean sendEmailService() throws MessagingException,
			InstantiationException, IllegalAccessException, IOException,
			TemplateException;
}
