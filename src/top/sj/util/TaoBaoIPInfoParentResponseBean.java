/*
 * Project Name: SJBlog
 * Class Name: TaoBaoIPInfoParentResponseBean.java
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
package top.sj.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 适用于淘宝IP地址信息工具类响应结果的父辈Bean
 * 
 * Create User: SteveJrong
 * Create Date: 2017年1月19日 22:58:52
 * Modify User: SteveJrong
 * Modify Date: 2017年1月19日 22:58:52
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class TaoBaoIPInfoParentResponseBean implements Serializable{
	private static final long serialVersionUID = -5819897205326181127L;

	/**
	 * 返回的数据属性
	 */
	private TaoBaoIPInfoChildResponseBean data;
	
	/**
	 * 返回的状态码属性
	 */
	private String code;
	
	public TaoBaoIPInfoChildResponseBean getData() {
		return data;
	}
	public void setData(TaoBaoIPInfoChildResponseBean data) {
		this.data = data;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
}
