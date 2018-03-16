/*
 * Project Name: SJBlog
 * Class Name: DownloadFilesAction.java
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
package top.sj.web;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;

import org.apache.struts2.ServletActionContext;

import top.sj.common.util.ActionResult;
import top.sj.common.util.Constants;
import top.sj.entity.SjFileAttachments;
import top.sj.service.FileAttachmentsService;

import com.opensymphony.xwork2.Action;

/**
 * 下载文件相关的Action
 * 
 * Create User: SteveJrong
 * Create Date: 2016年10月27日 下午12:51:27
 * Modify User: SteveJrong
 * Modify Date: 2016年10月27日 下午12:51:27
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class DownloadFilesAction implements Action, Serializable {
	private static final long serialVersionUID = -6671430890599547853L;
	
	/**
	 * 文件编号属性
	 */
	private Integer fileId;
	
	/**
	 * 文件名称属性
	 */
	private String fileName;
	
	/**
	 * 文件附件接口类型的属性，用于Spring Ioc
	 */
	private FileAttachmentsService fileAttachmentsService;
	
	public void setFileAttachmentsService(
			FileAttachmentsService fileAttachmentsService) {
		this.fileAttachmentsService = fileAttachmentsService;
	}

	public Integer getFileId() {
		return fileId;
	}

	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}

	public String getFileName() {
        return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public InputStream getInputStream() throws FileNotFoundException, UnsupportedEncodingException {
		SjFileAttachments fileAttachment = fileAttachmentsService.getFileInfoByFileIdService(fileId);
		String fileAbsoluteUrl = fileAttachment.getFaFilePath();
		fileName = new String(fileAbsoluteUrl.substring(fileAbsoluteUrl.lastIndexOf("/")+1).getBytes(), Constants.ISO8859_1_ENCODING.getValue());
		return ServletActionContext.getServletContext().getResourceAsStream("/".concat(fileAbsoluteUrl));
	}
	
	/**
	 * 默认执行的方法
	 * @throws FileNotFoundException 
	 */
	@Override
	public String execute() throws FileNotFoundException{
		return ActionResult.SUCCESS.getType();
	}
}
