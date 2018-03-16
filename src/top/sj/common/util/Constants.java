/*
 * Project Name: SJBlog
 * Class Name: Constants.java
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
package top.sj.common.util;

/**
 * Gson工具类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年12月6日 上午10:38:20
 * Modify User: SteveJrong
 * Modify Date: 2016年12月6日 上午10:38:20
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public enum Constants {
	
	SPRING_PROFILES_ACTIVE(ServletContextUtil.getValueByContextParamKey("spring.profiles.active")),
	
	//default root upload temporary file path of users header.
	DEFAULT_USERS_HEADER_UPLOAD_TEMPORARY_FILE_ROOT_PATH("DEFAULT_USERS_HEADER_UPLOAD_TEMPORARY_FILE_ROOT_PATH"),
	
	//default root upload really file path of users header.
	DEFAULT_USERS_HEADER_UPLOAD_REAL_FILE_ROOT_PATH("DEFAULT_USERS_HEADER_UPLOAD_REAL_FILE_ROOT_PATH"),
	
	//default root upload path of file attachments from article.
	DEFAULT_FILE_ATTACHMENTS_UPLOAD_ROOT_PATH("DEFAULT_FILE_ATTACHMENTS_UPLOAD_ROOT_PATH"),
	
	//default root upload path of pictures from article.
	DEFAULT_PICTURES_UPLOAD_ROOT_PATH("DEFAULT_PICTURES_UPLOAD_ROOT_PATH"),
	
	//默认的用户头像静态图片文件的存放相对路径
	//头像图片的上传因没有按照时间来分文件夹，故直接设定了头像图片的上传路径
	DEFAULT_USERS_HEADER_STATIC_PIC_FILE_REALTIVE_PATH("resources/upload/users_header/"),
	
	//默认的Mix Radio音乐ogg文件存放路径
	DEFAULT_MIX_RADIO_MUSIC_OGG_FILE_PATH("DEFAULT_MIX_RADIO_MUSIC_OGG_FILE_PATH"),
	
	//默认的Mix Radio音乐mp3文件存放路径
	DEFAULT_MIX_RADIO_MUSIC_MPEG3_FILE_PATH("DEFAULT_MIX_RADIO_MUSIC_MPEG3_FILE_PATH"),
	
	//默认的请求编码方式
	DEFAULT_REQUEST_ENCODING("text/html; charset=utf-8"),
	
	//UTF-8编码方式
	UTF_8_ENCODING("utf-8"),
	
	//ISO 8859-1编码方式
	ISO8859_1_ENCODING("ISO8859-1"),
	
	//项目基础配置文件
	CONFIG_OF_BASIC_CONFIGURATIONS(SPRING_PROFILES_ACTIVE.getValue() + "/upload.properties"),
	
	//项目Lucene全文索引配置文件
	CONFIG_OF_LUCENE_CONFIGURATIONS(SPRING_PROFILES_ACTIVE.getValue() + "/lucene.properties"),
	
	//普通用户角色
	USER_ROLE_OF_NORMAL("普通用户"),
	
	//用户正常状态
	USER_STATE_OF_NORMAL("正常"),
	
	//用户默认头像文件路径
	USER_HEADER_FILE_PATH_OF_DEFAULT("resources/assets/img/default_header.png"),
	
	//通过消息
	MSG_OF_PASS("通过"),
	
	//主页“个人日记”类型博文过滤
	HOME_FILTER_GeRenRiJi("个人日记")
	;
	
	private String value;
	
	private Constants(String value){
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
