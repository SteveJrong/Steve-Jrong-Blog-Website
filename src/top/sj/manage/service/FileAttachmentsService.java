/*
 * Project Name: SJBlog
 * Class Name: FileAttachmentsService.java
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

import top.sj.entity.SjFileAttachments;

/**
 * 文件附件业务接口
 * 
 * Create User: SteveJrong
 * Create Date: 2016年10月27日 上午9:46:49
 * Modify User: SteveJrong
 * Modify Date: 2016年10月27日 上午9:46:49
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public interface FileAttachmentsService {
	/**
	 * 添加一个新文件附件的方法【抽象业务逻辑】
	 * @param attachments
	 * @return
	 */
	Boolean addNewFileAttachmentService(SjFileAttachments attachments);
}
