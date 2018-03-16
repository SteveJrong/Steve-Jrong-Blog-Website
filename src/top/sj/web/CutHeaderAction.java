/*
 * Project Name: SJBlog
 * Class Name: CutHeaderAction.java
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

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.Action;

import net.sf.json.JSONObject;
import top.sj.common.util.ActionResult;
import top.sj.common.util.Constants;
import top.sj.entity.SjUsers;
import top.sj.inputscope.SessionScope;
import top.sj.service.UserService;
import top.sj.tool.ProjectPropertiesTool;
import top.sj.tool.PropertiesTool;

/**
 * 剪切并设置用户头像相关的Action
 * 
 * Create User: SteveJrong
 * Create Date: 2016年12月5日 下午3:22:49
 * Modify User: SteveJrong
 * Modify Date: 2016年12月5日 下午3:22:49
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class CutHeaderAction implements Action, Serializable {
	
	private static final long serialVersionUID = -911247097227224002L;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CutHeaderAction.class);
	
	/**
	 * 选取的图片X轴的坐标属性
	 */
	private Integer imageX;
	
	/**
	 * 选取的图片Y轴的坐标属性
	 */
	private Integer imageY;
	
	/**
	 * 选取的图片宽度属性
	 */
	private Integer imageWidth;
	
	/**
	 * 选取的图片高度属性
	 */
	private Integer imageHeight;
	
	/**
	 * 头像临时图片的名称属性
	 */
	private String tempHeaderFileName;
	
	/**
	 * 用户接口类型的属性，用于Spring Ioc
	 */
	private UserService userService;
	
	/**
	 * 结果集JSON对象
	 */
	private JSONObject jsonDatas;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public Integer getImageX() {
		return imageX;
	}

	public void setImageX(Integer imageX) {
		this.imageX = imageX;
	}

	public Integer getImageY() {
		return imageY;
	}

	public void setImageY(Integer imageY) {
		this.imageY = imageY;
	}

	public Integer getImageWidth() {
		return imageWidth;
	}

	public void setImageWidth(Integer imageWidth) {
		this.imageWidth = imageWidth;
	}

	public Integer getImageHeight() {
		return imageHeight;
	}

	public void setImageHeight(Integer imageHeight) {
		this.imageHeight = imageHeight;
	}
	
	public String getTempHeaderFileName() {
		return tempHeaderFileName;
	}

	public void setTempHeaderFileName(String tempHeaderFileName) {
		this.tempHeaderFileName = tempHeaderFileName;
	}

	public JSONObject getJsonDatas() {
		return jsonDatas;
	}

	public void setJsonDatas(JSONObject jsonDatas) {
		this.jsonDatas = jsonDatas;
	}

	/**
	 * 默认执行的方法
	 * @throws IOException 
	 */
	@Override
	public String execute() throws IOException {
		Map<String, Object> resultMap = new HashMap<String,Object>();
		String UUID = java.util.UUID.randomUUID().toString();
		
		FileInputStream is = null;  
        ImageInputStream iis = null;
        
        try {
			// 读取图片文件
        	String tempFilePath = ProjectPropertiesTool.getProjLocalRootUrl(ServletActionContext.getRequest()).concat(PropertiesTool.getPropertiesFileAsObject(Constants.CONFIG_OF_BASIC_CONFIGURATIONS.getValue()).get(Constants.DEFAULT_USERS_HEADER_UPLOAD_TEMPORARY_FILE_ROOT_PATH.getValue()).toString()).concat("/").concat(tempHeaderFileName);
        	
//        	LOGGER.info(" -- Temp user header file path is: "+tempFilePath+" -- ");
        	
			is = new FileInputStream(tempFilePath);
			/*
			 * 返回包含所有当前已注册 ImageReader 的 Iterator，这些 ImageReader 声称能够解码指定格式。
			 * 参数：formatName - 包含非正式格式名称 . （例如 "jpeg" 或 "tiff"）等 。
			 */
			Iterator<ImageReader> it = ImageIO.getImageReadersByFormatName("jpg");
			ImageReader reader = it.next();
			// 获取图片流
			iis = ImageIO.createImageInputStream(is);
			/*
			 * <p>iis:读取源.true:只向前搜索 </p>.将它标记为 ‘只向前搜索’。
			 * 此设置意味着包含在输入源中的图像将只按顺序读取，可能允许 reader 避免缓存包含与以前已经读取的图像关联的数据的那些输入部分。
			 */
			reader.setInput(iis, true);
			/*
			 * <p>描述如何对流进行解码的类<p>.用于指定如何在输入时从 Java Image I/O
			 * 框架的上下文中的流转换一幅图像或一组图像。用于特定图像格式的插件 将从其 ImageReader 实现的
			 * getDefaultReadParam 方法中返回 ImageReadParam 的实例。
			 */
			ImageReadParam param = reader.getDefaultReadParam();
			
			/*
			 * 图片裁剪区域。Rectangle 指定了坐标空间中的一个区域，通过 Rectangle 对象
			 * 的左上顶点的坐标（x，y）、宽度和高度可以定义这个区域。
			 */
			Rectangle rect = new Rectangle(imageX, imageY, imageWidth, imageHeight);
			
			// 提供一个 BufferedImage，将其用作解码像素数据的目标。
			param.setSourceRegion(rect);
			
			/*
			 * 使用所提供的 ImageReadParam 读取通过索引 imageIndex 指定的对象，并将 它作为一个完整的
			 * BufferedImage 返回。
			 */
			
			BufferedImage bi = reader.read(0, param);
			
			// 保存新图片
			String saveHeaderFilePath = ProjectPropertiesTool.getProjLocalRootUrl(ServletActionContext.getRequest()).concat("/").concat(PropertiesTool.getPropertiesFileAsObject(Constants.CONFIG_OF_BASIC_CONFIGURATIONS.getValue()).get(Constants.DEFAULT_USERS_HEADER_UPLOAD_REAL_FILE_ROOT_PATH.getValue()).toString()).concat("/").concat(UUID).concat(".jpg");
			
//			LOGGER.info(" -- Local project root path is:"+ProjectPropertiesTool.getProjLocalRootUrl(ServletActionContext.getRequest())+" -- ");
//			
//			LOGGER.info(" -- New user header file path is:"+saveHeaderFilePath+" -- ");
			
			ImageIO.write(bi, "jpg", new File(saveHeaderFilePath));
		}catch(Exception e){
//			LOGGER.error(" -- Cut user header error cause is: "+e.getCause()+" -- ");
//			LOGGER.error(" -- Cut user header error message is: "+e.getMessage()+" -- ");
//			LOGGER.error(" -- Cut user header localized message is: "+e.getLocalizedMessage()+" -- ");
//			LOGGER.error(" -- Cut user header suppressed is: "+e.getSuppressed()+" -- ");
			resultMap.put("result", false);
		} finally {
			if (is != null)
				is.close();
			if (iis != null)
				iis.close();
		}
        
        //删除存放于临时文件夹中的当前图片（删除文件的动作必须置于流之外，即有流操作必须关闭流之后才可以删除，否则删除不掉）
		File deleteFile = new File(ProjectPropertiesTool.getProjLocalRootUrl(ServletActionContext.getRequest()).concat("/").concat(PropertiesTool.getPropertiesFileAsObject(Constants.CONFIG_OF_BASIC_CONFIGURATIONS.getValue()).get(Constants.DEFAULT_USERS_HEADER_UPLOAD_TEMPORARY_FILE_ROOT_PATH.getValue()).toString().concat("/").concat(tempHeaderFileName)));
		if (deleteFile.exists()) {
			deleteFile.delete();
		}
		
		SjUsers user = userService.getUserInfoByIdService(SessionScope.getUserEntityInfoOnSessionScope().getUId());
		user.setUHeader(Constants.DEFAULT_USERS_HEADER_STATIC_PIC_FILE_REALTIVE_PATH.getValue().concat(UUID).concat(".jpg"));
		if (userService.updateUserInfoService(user)) {
			//成功后更新Session域中的user对象
			SessionScope.putUserInfoOnSessionScope(user);
			resultMap.put("result", true);
			resultMap.put("datas", user.getUHeader());
		}
		
        jsonDatas = JSONObject.fromObject(resultMap);
        
        LOGGER.info(" -- Result："+jsonDatas+" -- ");
        
		return ActionResult.SUCCESS.getType();
	}
}
