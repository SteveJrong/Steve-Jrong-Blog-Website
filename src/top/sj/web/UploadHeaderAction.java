/*
 * Project Name: SJBlog
 * Class Name: UploadHeaderAction.java
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

import com.opensymphony.xwork2.Action;

import top.sj.common.util.ActionResult;
import top.sj.common.util.Constants;
import top.sj.tool.DateTimeTool;
import top.sj.tool.ProjectPropertiesTool;
import top.sj.tool.PropertiesTool;

/**
 * 上传用户头像相关的Action
 * 
 * Create User: SteveJrong
 * Create Date: 2016年12月3日 下午3:07:07
 * Modify User: SteveJrong
 * Modify Date: 2016年12月3日 下午3:07:07
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class UploadHeaderAction implements Action, Serializable {
	
	private static final long serialVersionUID = 6203766311300285346L;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UploadHeaderAction.class);
	
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
	public String execute() {
//		LOGGER.info(" -- ["+DateTimeTool.getNowDateFormatDateTimeTemplateOne()+"]execute upload header action. -- ");
		
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

				String localRootUrl = ProjectPropertiesTool.getProjLocalRootUrl(ServletActionContext.getRequest());
//				LOGGER.info(" -- localRootUrl is "+localRootUrl+" -- ");
				
				String usersHeaderUploadRootPath = PropertiesTool.getPropertiesFileAsObject(Constants.CONFIG_OF_BASIC_CONFIGURATIONS.getValue()).get(Constants.DEFAULT_USERS_HEADER_UPLOAD_TEMPORARY_FILE_ROOT_PATH.getValue()).toString();
//				LOGGER.info(" -- usersHeaderUploadRootPath is "+usersHeaderUploadRootPath+" -- ");
				
				uploadPath = localRootUrl.concat(usersHeaderUploadRootPath);
//				LOGGER.info(" -- uploadPath is "+uploadPath+" -- ");
				
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
		
		return ActionResult.SUCCESS.getType();
	}
}
