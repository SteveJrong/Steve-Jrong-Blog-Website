/*
 * Project Name: SJBlog
 * Class Name: UploadPicturesAction.java
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
import java.io.PrintWriter;
import java.io.Serializable;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import top.sj.common.util.ActionResult;
import top.sj.common.util.Constants;
import top.sj.tool.DateTimeTool;
import top.sj.tool.ProjectPropertiesTool;
import top.sj.tool.PropertiesTool;

import com.opensymphony.xwork2.Action;

/**
 * 上传图片相关的Action
 * 
 * Create User: SteveJrong
 * Create Date: 2016年6月9日 下午8:43:31
 * Modify User: SteveJrong
 * Modify Date: 2016年6月9日 下午8:43:31
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class UploadPicturesAction implements Action, Serializable {

	private static final long serialVersionUID = 6685226132532179641L;

	private static Logger LOGGER = Logger.getLogger(UploadPicturesAction.class);
	
	/**
	 * 文件属性
	 */
	private File upload;

	/**
	 * 文件类型属性
	 */
	private String uploadContentType;

	/**
	 * 文件名称属性
	 */
	private String uploadFileName;

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	/**
	 * 默认执行的方法
	 * 
	 * @return
	 */
	@Override
	public String execute() {
		Map<String, Object> map = new HashMap<String, Object>();
		
		String httpRootUrl = ProjectPropertiesTool.getProjHttpRootUrl(ServletActionContext.getRequest());
		String localRootUrl = ProjectPropertiesTool.getProjLocalRootUrl(ServletActionContext.getRequest());
		String picUploadRootPath = PropertiesTool.getPropertiesFileAsObject(Constants.CONFIG_OF_BASIC_CONFIGURATIONS.getValue()).get(Constants.DEFAULT_PICTURES_UPLOAD_ROOT_PATH.getValue()).toString();
		
		InputStream is = null;
		String fileName = null;
		String uploadPath = null;
		try {
			try {
				is = new FileInputStream(upload);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			uploadPath = localRootUrl+picUploadRootPath.concat("/").concat(DateTimeTool.getNowDateFormatDateTimeTemplateTwo());
			fileName = java.util.UUID.randomUUID().toString() + new SecureRandom().nextInt(10) + uploadFileName.substring(uploadFileName.lastIndexOf("."));

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
		} catch (Exception e) {
			e.printStackTrace();
			map.put("result", "failed");
			LOGGER.error("本次文件上传失败！");
		}

		map.put("result", "success");
		LOGGER.info("本次文件上传成功！");

		HttpServletResponse response = ServletActionContext.getResponse();

		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String responsePath = httpRootUrl.concat("/").concat(picUploadRootPath).concat("/").concat(DateTimeTool.getNowDateFormatDateTimeTemplateTwo()).concat("/");

		out.write("<script type=\"text/javascript\">");
		out.write("window.parent.CKEDITOR.tools.callFunction("
				+ ServletActionContext.getRequest().getParameter(
						"CKEditorFuncNum") + ",'" + responsePath + fileName
				+ "','')");
		out.write("</script>");
		try {
			out.flush();
			out.close();
		} catch (IllegalStateException e) {
			LOGGER.warn(" -- 上传图片时忽略异IllegalStateException常 --");
		}catch (Exception e) {}
		return ActionResult.SUCCESS.getType();
	}
}
