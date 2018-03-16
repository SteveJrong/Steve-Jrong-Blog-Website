/*
 * Project Name: SJBlog
 * Class Name: ArticleViewsManageUtil.java
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
package top.sj.manage.util;

import java.util.ArrayList;
import java.util.List;

import top.sj.manage.dto.FileattachmentsTempUploadDTO;

/**
 * 文件附件上传时临时保存的管理工具类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年10月9日 下午2:56:01
 * Modify User: SteveJrong
 * Modify Date: 2016年10月9日 下午2:56:01
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class FileAttachmentsTempUploadManageUtil {
	/**
	 * 文章浏览量管理集合属性
	 */
	private static volatile List<FileattachmentsTempUploadDTO> fileattachmentsTempUploadDTOs = new ArrayList<FileattachmentsTempUploadDTO>();

	public static List<FileattachmentsTempUploadDTO> getFileattachmentsTempUploadDTOs() {
		return fileattachmentsTempUploadDTOs;
	}

	public static void setFileattachmentsTempUploadDTOs(
			List<FileattachmentsTempUploadDTO> fileattachmentsTempUploadDTOs) {
		FileAttachmentsTempUploadManageUtil.fileattachmentsTempUploadDTOs = fileattachmentsTempUploadDTOs;
	}
}
