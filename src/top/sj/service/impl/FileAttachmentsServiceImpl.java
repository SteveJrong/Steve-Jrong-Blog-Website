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
package top.sj.service.impl;

import java.util.List;

import top.sj.dao.FileAttachmentsDao;
import top.sj.entity.SjFileAttachments;
import top.sj.service.FileAttachmentsService;

/**
 * 文件附件业务接口的实现类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年10月27日 下午1:06:19
 * Modify User: SteveJrong
 * Modify Date: 2016年10月27日 下午1:06:19
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class FileAttachmentsServiceImpl implements FileAttachmentsService {

	/**
	 * 文件附件接口类型的属性，用于Spring Ioc
	 */
	private FileAttachmentsDao fileAttachmentsDao;
	
	public void setFileAttachmentsDao(FileAttachmentsDao fileAttachmentsDao) {
		this.fileAttachmentsDao = fileAttachmentsDao;
	}

	/**
	 * 根据文章编号获取所有文件附件信息的方法【业务逻辑】
	 */
	@Override
	public List<SjFileAttachments> getAllFilesByArticleIdService(
			Integer articleId) {
		return fileAttachmentsDao.getAllFilesByArticleId(articleId);
	}

	/**
	 * 根据文件附件编号获取文件信息的方法【业务逻辑】
	 */
	@Override
	public SjFileAttachments getFileInfoByFileIdService(Integer fileAttachmentId) {
		return fileAttachmentsDao.getFileInfoByFileId(fileAttachmentId);
	}
}
