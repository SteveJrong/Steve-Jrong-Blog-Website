/*
 * Project Name: SJBlog
 * Class Name: FileAttachmentsDao.java
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
package top.sj.dao;

import java.util.List;
import top.sj.entity.SjFileAttachments;

/**
 * 文件附件接口
 * 
 * Create User: SteveJrong
 * Create Date: 2016年10月27日 下午12:57:15
 * Modify User: SteveJrong
 * Modify Date: 2016年10月27日 下午12:57:15
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public interface FileAttachmentsDao {
	/**
	 * 根据文章编号获取所有文件附件信息的方法【抽象方法】
	 * @param articleId
	 * @return
	 */
	List<SjFileAttachments> getAllFilesByArticleId(Integer articleId);
	
	/**
	 * 根据文件附件编号获取文件信息的方法【抽象方法】
	 * @param fileAttachmentId
	 * @return
	 */
	SjFileAttachments getFileInfoByFileId(Integer fileAttachmentId);
}