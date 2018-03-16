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
package top.sj.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import top.sj.dao.FileAttachmentsDao;
import top.sj.entity.SjFileAttachments;

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
	 * 根据文章编号获取所有文件附件信息的方法
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<SjFileAttachments> getAllFilesByArticleId(final Integer articleId) {
		List<SjFileAttachments> attachments = null;
		try {
			attachments = super.getHibernateTemplate().executeFind(new HibernateCallback<List<SjFileAttachments>>() {
				@Override
				public List<SjFileAttachments> doInHibernate(Session session)
						throws HibernateException, SQLException {
					return session.createCriteria(SjFileAttachments.class,"fa").createAlias("fa.sjArticles", "a").setCacheable(Boolean.TRUE).add(Restrictions.eq("a.AId", articleId)).list();
				}
			});
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return attachments;
	}

	/**
	 * 根据文件附件编号获取文件信息的方法
	 */
	@Override
	public SjFileAttachments getFileInfoByFileId(Integer fileAttachmentId) {
		return super.getHibernateTemplate().get(SjFileAttachments.class, fileAttachmentId);
	}
}
