/*
 * Project Name: SJBlog
 * Class Name: UploadFilesAction.java
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
package top.sj.manage.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import top.sj.common.util.ActionResult;
import top.sj.common.util.Constants;
import top.sj.manage.dto.FileattachmentsTempUploadDTO;
import top.sj.manage.util.FileAttachmentsTempUploadManageUtil;
import top.sj.tool.DateTimeTool;
import top.sj.tool.MD5Tool;
import top.sj.tool.ProjectPropertiesTool;
import top.sj.tool.PropertiesTool;
import top.sj.tool.TimestampTool;

import com.opensymphony.xwork2.Action;

/**
 * 上传文件相关的Action
 * 
 * Create User: SteveJrong
 * Create Date: 2016年10月24日 下午12:53:52
 * Modify User: SteveJrong
 * Modify Date: 2016年10月24日 下午12:53:52
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class UploadFilesAction implements Action, Serializable {
	
	private static final long serialVersionUID = -9075690407791204731L;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UploadFilesAction.class);
	
	/*
	 * 下面的uploadFiles有两点需要注意
	 * 1、必须是List数组
	 * 2、命名必须跟jsp页面中的uploadify的一个参数"fileObjName"一致，否则无法获取到上传的文件
	 */
	public List<File> uploadFiles;
	/*
	 *下面的两个属性为使用Action上传文件所必须的，在前台jsp页面无需做任何操作 
	 */
	public List<String> uploadFilesFileName;
	
	public List<String> uploadFilesContentType;

	/**
	 * 默认执行的方法
	 */
	@Override
	public synchronized String execute() {
		Map<String, Object> map = new HashMap<String, Object>();
		InputStream is = null;
		String fileName = null;
		String uploadPath = null;
		
		try {
			for (int i = 0; i < uploadFiles.size(); i++) {
				try {
					is = new FileInputStream(uploadFiles.get(i));
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
//				String realPath = ServletActionContext.getServletContext().getRealPath("/resources/upload/files").replace("\\", "/");
//				String nowDateFmt = new SimpleDateFormat("yyyyMM").format(new Date(System.currentTimeMillis()));
//				uploadPath = realPath.concat("/").concat(nowDateFmt);
				
				//D:/TestEnvironment/apache-tomcat-7.0.72-windows-x64/apache-tomcat-7.0.72/webapps/SJBlog/resources/upload/files/201611
				
				String localRootUrl = ProjectPropertiesTool.getProjLocalRootUrl(ServletActionContext.getRequest());
				String fileAttachmentUploadRootPath = PropertiesTool.getPropertiesFileAsObject(Constants.CONFIG_OF_BASIC_CONFIGURATIONS.getValue()).get(Constants.DEFAULT_FILE_ATTACHMENTS_UPLOAD_ROOT_PATH.getValue()).toString();
				
				uploadPath = localRootUrl.concat(fileAttachmentUploadRootPath).concat("/").concat(DateTimeTool.getNowDateFormatDateTimeTemplateTwo());
				
				fileName = uploadFilesFileName.get(i);
				File directory = new File(uploadPath);
				if (!directory.exists()) {
					directory.mkdirs();
				}
				File toFile = new File(uploadPath, fileName);
				OutputStream os = null;
				try {
					os = new FileOutputStream(toFile);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				byte[] buffer = new byte[1024];
				int length = 0;
				try {
					while ((length = is.read(buffer)) > 0) {
						os.write(buffer, 0, length);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("result", "failed");
			LOGGER.error(" -- 本次文件上传失败。在："+DateTimeTool.getNowDateFormatDateTimeTemplateOne()+"-- ");
		}

		map.put("result", "success");
		LOGGER.info("本次文件上传成功。在："+DateTimeTool.getNowDateFormatDateTimeTemplateOne()+"-- ");
		
		try {
			addFileAttachmentsCollections(fileName, uploadPath);
			LOGGER.info("文件存入文件附件集合管理工具类中成功。在："+DateTimeTool.getNowDateFormatDateTimeTemplateOne()+"-- ");
		} catch (Exception e) {
			LOGGER.info("文件存入文件附件集合管理工具类中失败。在："+DateTimeTool.getNowDateFormatDateTimeTemplateOne()+"。错误信息为：\n"+e.getMessage()+"-- ");
		}

		return ActionResult.SUCCESS.getType();
	}

	/**
	 * 将当前文件放入文件附件上传的临时管理工具集合中的方法
	 * @param fileName 文件名
	 * @param uploadPath 上传路径
	 */
	private void addFileAttachmentsCollections(String fileName,
			String uploadPath) {
		File uploadedFile = new File(uploadPath, fileName);
		//获取项目名称
		//String projName = ProjectPropertiesTool.getProjName(ServletActionContext.getRequest());
		//LOGGER.info("项目名称："+projName);
		String projName = "ROOT";
		
		//上传成功之后，临时保存至文件附件上传的临时管理工具集合类中
		FileattachmentsTempUploadDTO dto = new FileattachmentsTempUploadDTO();
		dto.setArticleId(null);
		dto.setCreateDate(TimestampTool.convertNowDateToStimeStamp());
		dto.setDownloadCount(0);
		dto.setEnableDownload(true);
		dto.setFileFmt(uploadedFile.getAbsolutePath().substring(uploadedFile.getAbsolutePath().lastIndexOf(".")+1));
		dto.setFilePath(uploadedFile.getAbsolutePath().substring(uploadedFile.getAbsolutePath().indexOf(projName)+projName.length()+1).replace("\\", "/"));
		dto.setId(null);
		dto.setMD5Value(MD5Tool.getFileMD5(uploadedFile));
		dto.setModifyDate(null);
		
		FileAttachmentsTempUploadManageUtil.getFileattachmentsTempUploadDTOs().add(dto);
		for (FileattachmentsTempUploadDTO uploadDTO : FileAttachmentsTempUploadManageUtil.getFileattachmentsTempUploadDTOs()) {
			System.out.println(uploadDTO.getFilePath() + "\t" + uploadDTO.getMD5Value());
		}
	}
}
