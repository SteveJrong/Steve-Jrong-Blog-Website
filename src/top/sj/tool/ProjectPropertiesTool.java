/*
 * Project Name: SJBlog
 * Class Name: ProjectPropertiesTool.java
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
package top.sj.tool;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

/**
 * 项目属性工具类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年10月27日 下午4:34:01
 * Modify User: SteveJrong
 * Modify Date: 2016年10月27日 下午4:34:01
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class ProjectPropertiesTool {
	
	/**
	 * 获取项目HTTP根路径的方法
	 * @param httpServletRequest HttpServletRequest对象
	 * @return
	 */
	public static String getProjHttpRootUrl(HttpServletRequest httpServletRequest) {
		return httpServletRequest.getRequestURL().toString().substring(0,ServletActionContext.getRequest().getRequestURL().toString().lastIndexOf("/"));
	}
	
	/**
	 * 获取项目本地根路径的方法
	 * @param httpServletRequest HttpServletRequest对象
	 * @return
	 */
	public static String getProjLocalRootUrl(HttpServletRequest httpServletRequest) {
		return ServletActionContext.getRequest().getSession().getServletContext().getRealPath("/").replace("\\", "/");
	}
	
	/**
	 * 获取项目名称的方法
	 * @param httpServletRequest HttpServletRequest对象
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static String getProjName(HttpServletRequest httpServletRequest) {
		String realPath = ServletActionContext.getRequest().getRealPath("").replace("\\", "/"); 
		String basePath = realPath.substring(0,realPath.lastIndexOf("/") + realPath.length() - realPath.lastIndexOf("/"));
		String tempProjName = basePath.substring(basePath.lastIndexOf("/"));
		String projName = tempProjName.substring(tempProjName.indexOf("/")+1);
		return projName;
	}
}
