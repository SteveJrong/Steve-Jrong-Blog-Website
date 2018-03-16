/*
 * Project Name: SJBlog
 * Class Name: FileAttachmentsDaoImpl.java
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
package top.sj.manage.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import top.sj.entity.SjFileAttachments;
import top.sj.manage.dao.FileAttachmentsDao;

/**
 * 文件附件接口的实现类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年10月27日 上午9:45:05
 * Modify User: SteveJrong
 * Modify Date: 2016年10月27日 上午9:45:05
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class FileAttachmentsDaoImpl extends HibernateDaoSupport implements FileAttachmentsDao {

	/**
	 * 添加一个新文件附件的方法
	 */
	@Override
	public Boolean addNewFileAttachment(SjFileAttachments attachments) {
		try {
			super.getHibernateTemplate().save(attachments);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
			return false;
		}
		return true;
	}
}
