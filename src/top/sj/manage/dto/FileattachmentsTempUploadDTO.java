/*
 * Project Name: SJBlog
 * Class Name: FileattachmentsTempUploadDTO.java
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

import java.sql.Timestamp;

/**
 * 用于文件附件上传时临时保存的传输对象实体类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年10月27日 上午9:52:57
 * Modify User: SteveJrong
 * Modify Date: 2016年10月27日 上午9:52:57
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class FileattachmentsTempUploadDTO {
	/**
	 * 文件附件编号
	 */
	private Integer id;
	
	/**
	 * 文件附件所属的文章编号
	 */
	private Integer articleId;
	
	/**
	 * 文件附件路径
	 */
	private String filePath;
	
	/**
	 * 文件附件格式
	 */
	private String fileFmt;
	
	/**
	 * 文件附件创建时间
	 */
	private Timestamp createDate;
	
	/**
	 * 文件附件修改时间
	 */
	private Timestamp modifyDate;
	
	/**
	 * 文件附件MD5值
	 */
	private String MD5Value;
	
	/**
	 * 文件附件下载次数
	 */
	private Integer DownloadCount;
	
	/**
	 * 是否启用对此文件的下载
	 */
	private Boolean enableDownload;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileFmt() {
		return fileFmt;
	}

	public void setFileFmt(String fileFmt) {
		this.fileFmt = fileFmt;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Timestamp getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Timestamp modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getMD5Value() {
		return MD5Value;
	}

	public void setMD5Value(String mD5Value) {
		MD5Value = mD5Value;
	}

	public Integer getDownloadCount() {
		return DownloadCount;
	}

	public void setDownloadCount(Integer downloadCount) {
		DownloadCount = downloadCount;
	}

	public Boolean getEnableDownload() {
		return enableDownload;
	}

	public void setEnableDownload(Boolean enableDownload) {
		this.enableDownload = enableDownload;
	}

	public FileattachmentsTempUploadDTO(Integer id, Integer articleId, String filePath,
			String fileFmt, Timestamp createDate, Timestamp modifyDate,
			String mD5Value, Integer downloadCount, Boolean enableDownload) {
		super();
		this.id = id;
		this.articleId = articleId;
		this.filePath = filePath;
		this.fileFmt = fileFmt;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		MD5Value = mD5Value;
		DownloadCount = downloadCount;
		this.enableDownload = enableDownload;
	}
	
	public FileattachmentsTempUploadDTO() {
	}
}
