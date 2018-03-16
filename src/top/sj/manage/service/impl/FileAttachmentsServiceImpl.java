/*
 * Project Name: SJBlog
 * Class Name: FileAttachmentsServiceImpl.java
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

import top.sj.entity.SjFileAttachments;
import top.sj.manage.dao.FileAttachmentsDao;
import top.sj.manage.service.FileAttachmentsService;

/**
 * 文件附件业务接口的实现类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年10月27日 上午9:47:50
 * Modify User: SteveJrong
 * Modify Date: 2016年10月27日 上午9:47:50
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class FileAttachmentsServiceImpl implements FileAttachmentsService {

	/**
	 * 文件附件接口类型的属性，用于Spring Ioc
	 */
	private FileAttachmentsDao mFileAttachmentsDao;
	
	public void setmFileAttachmentsDao(FileAttachmentsDao mFileAttachmentsDao) {
		this.mFileAttachmentsDao = mFileAttachmentsDao;
	}

	/**
	 * 添加一个新文件附件的方法【业务逻辑】
	 */
	@Override
	public Boolean addNewFileAttachmentService(SjFileAttachments attachments) {
		return mFileAttachmentsDao.addNewFileAttachment(attachments);
	}
}
