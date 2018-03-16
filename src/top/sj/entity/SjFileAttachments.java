/*
 * Project Name: SJBlog
 * Class Name: SjFileAttachments.java
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
package top.sj.entity;

import java.sql.Timestamp;

/**
 * 博文文件附件实体类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年10月26日 下午5:54:58
 * Modify User: SteveJrong
 * Modify Date: 2016年10月26日 下午5:54:58
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class SjFileAttachments implements java.io.Serializable {
	private static final long serialVersionUID = -8613967359382612863L;
	
	/**
	 * 文件附件编号属性
	 */
	private Integer faId;
	
	private SjArticles sjArticles;
	
	/**
	 * 文件附件路径属性
	 */
	private String faFilePath;
	
	/**
	 * 文件附件格式属性
	 */
	private String faFileFormat;
	
	/**
	 * 文件附件创建时间属性
	 */
	private Timestamp faCreateDate;
	
	/**
	 * 文件附件修改时间属性
	 */
	private Timestamp faModifyDate;
	
	/**
	 * 文件附件MD5值属性
	 */
	private String faMd5Var;
	
	/**
	 * 文件附件下载次数属性
	 */
	private Integer faDowmloadCount;
	
	/**
	 * 是否启用对此文件的下载属性
	 */
	private Boolean faEnableDownload;

	public SjFileAttachments() {
	}

	public SjFileAttachments(SjArticles sjArticles, String faFilePath,
			String faFileFormat, Timestamp faCreateDate, String faMd5Var) {
		this.sjArticles = sjArticles;
		this.faFilePath = faFilePath;
		this.faFileFormat = faFileFormat;
		this.faCreateDate = faCreateDate;
		this.faMd5Var = faMd5Var;
	}

	public SjFileAttachments(SjArticles sjArticles, String faFilePath,
			String faFileFormat, Timestamp faCreateDate,
			Timestamp faModifyDate, String faMd5Var, Integer faDowmloadCount,
			Boolean faEnableDownload) {
		this.sjArticles = sjArticles;
		this.faFilePath = faFilePath;
		this.faFileFormat = faFileFormat;
		this.faCreateDate = faCreateDate;
		this.faModifyDate = faModifyDate;
		this.faMd5Var = faMd5Var;
		this.faDowmloadCount = faDowmloadCount;
		this.faEnableDownload = faEnableDownload;
	}

	public Integer getFaId() {
		return this.faId;
	}

	public void setFaId(Integer faId) {
		this.faId = faId;
	}

	public SjArticles getSjArticles() {
		return this.sjArticles;
	}

	public void setSjArticles(SjArticles sjArticles) {
		this.sjArticles = sjArticles;
	}

	public String getFaFilePath() {
		return this.faFilePath;
	}

	public void setFaFilePath(String faFilePath) {
		this.faFilePath = faFilePath;
	}

	public String getFaFileFormat() {
		return this.faFileFormat;
	}

	public void setFaFileFormat(String faFileFormat) {
		this.faFileFormat = faFileFormat;
	}

	public Timestamp getFaCreateDate() {
		return this.faCreateDate;
	}

	public void setFaCreateDate(Timestamp faCreateDate) {
		this.faCreateDate = faCreateDate;
	}

	public Timestamp getFaModifyDate() {
		return this.faModifyDate;
	}

	public void setFaModifyDate(Timestamp faModifyDate) {
		this.faModifyDate = faModifyDate;
	}

	public String getFaMd5Var() {
		return this.faMd5Var;
	}

	public void setFaMd5Var(String faMd5Var) {
		this.faMd5Var = faMd5Var;
	}

	public Integer getFaDowmloadCount() {
		return this.faDowmloadCount;
	}

	public void setFaDowmloadCount(Integer faDowmloadCount) {
		this.faDowmloadCount = faDowmloadCount;
	}

	public Boolean getFaEnableDownload() {
		return this.faEnableDownload;
	}

	public void setFaEnableDownload(Boolean faEnableDownload) {
		this.faEnableDownload = faEnableDownload;
	}
}