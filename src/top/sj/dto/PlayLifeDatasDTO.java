/*
 * Project Name: SJBlog
 * Class Name: MixRadioDTO.java
 * 
 * Copyright © 2011-2017 SteveJrong  All Rights Reserved.
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
package top.sj.dto;

import java.io.Serializable;

/**
 * PlayLife Datas DTO实体类
 * 
 * Create User: SteveJrong
 * Create Date: 2017年5月9日 下午5:37:35
 * Modify User: SteveJrong
 * Modify Date: 2017年5月9日 下午5:37:35
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class PlayLifeDatasDTO implements Serializable {

	private static final long serialVersionUID = -4445452238003029126L;

	/**
	 * 生活段子编号属性
	 */
	private Integer id;
	
	/**
	 * 生活段子发布时间属性
	 */
	private String publishedDate;
	
	/**
	 * 生活段子内容属性
	 */
	private String content;
	
	/**
	 * 生活段子发布时的操作系统信息属性
	 */
	private String systemInfo;
	
	/**
	 * 生活段子发布时的设备信息属性
	 */
	private String deviceinfo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSystemInfo() {
		return systemInfo;
	}

	public void setSystemInfo(String systemInfo) {
		this.systemInfo = systemInfo;
	}

	public String getDeviceinfo() {
		return deviceinfo;
	}

	public void setDeviceinfo(String deviceinfo) {
		this.deviceinfo = deviceinfo;
	}
	

	public String getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(String publishedDate) {
		this.publishedDate = publishedDate;
	}

	public PlayLifeDatasDTO(Integer id, String publishedDate, String content, String systemInfo, String deviceinfo) {
		super();
		this.id = id;
		this.publishedDate = publishedDate;
		this.content = content;
		this.systemInfo = systemInfo;
		this.deviceinfo = deviceinfo;
	}

	public PlayLifeDatasDTO() {
	}
}
