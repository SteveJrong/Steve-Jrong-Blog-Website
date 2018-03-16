/*
 * Project Name: SJBlog
 * Class Name: FileAttachmentsOfArticleDTO.java
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
package top.sj.manage.dto;

import java.io.Serializable;

/**
 * 某博文下所有文件附件数据传输实体类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年10月27日 下午2:33:54
 * Modify User: SteveJrong
 * Modify Date: 2016年10月27日 下午2:33:54
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class FileAttachmentsOfArticleDTO implements Serializable{
	private static final long serialVersionUID = -1823367870719855115L;

	/**
	 * 文件编号属性
	 */
	private Integer fileId;
	
	/**
	 * 文件完整名称属性
	 */
	private String fileFullName;
	
	/**
	 * 文件缩略名称属性
	 */
	private String fileShortName;
	
	/**
	 * 文件MD5值属性
	 */
	private String fileMD5Value;
	
	/**
	 * 文件路径属性
	 */
	private String filePath;
	
	/**
	 * 是否需要短文件名称模式
	 */
	private Boolean needShortMode;
	
	/**
	 * 文件是否存在属性
	 */
	private Boolean fileExists;

	public Integer getFileId() {
		return fileId;
	}

	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	public String getFileFullName() {
		return fileFullName;
	}

	public void setFileFullName(String fileFullName) {
		this.fileFullName = fileFullName;
	}

	public String getFileShortName() {
		return fileShortName;
	}

	public void setFileShortName(String fileShortName) {
		this.fileShortName = fileShortName;
	}

	public String getFileMD5Value() {
		return fileMD5Value;
	}

	public void setFileMD5Value(String fileMD5Value) {
		this.fileMD5Value = fileMD5Value;
	}
	
	public Boolean getFileExists() {
		return fileExists;
	}

	public void setFileExists(Boolean fileExists) {
		this.fileExists = fileExists;
	}
	
	public Boolean getNeedShortMode() {
		return needShortMode;
	}

	public void setNeedShortMode(Boolean needShortMode) {
		this.needShortMode = needShortMode;
	}

	public FileAttachmentsOfArticleDTO(Integer fileId, String fileFullName,
			String fileShortName, String fileMD5Value, String filePath,
			Boolean needShortMode, Boolean fileExists) {
		super();
		this.fileId = fileId;
		this.fileFullName = fileFullName;
		this.fileShortName = fileShortName;
		this.fileMD5Value = fileMD5Value;
		this.filePath = filePath;
		this.needShortMode = needShortMode;
		this.fileExists = fileExists;
	}

	public FileAttachmentsOfArticleDTO() {
	}
}
