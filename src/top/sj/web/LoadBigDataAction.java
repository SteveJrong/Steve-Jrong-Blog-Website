/*
 * Project Name: SJBlog
 * Class Name: LoadBigDataAction.java
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

import java.io.Serializable;

import net.sf.json.JSONObject;
import top.sj.common.util.ActionResult;
import top.sj.service.BigDataService;

import com.opensymphony.xwork2.Action;

/**
 * 载入大数据页面相关的Action
 * 
 * Create User: SteveJrong
 * Create Date: 2016年4月3日 下午2:23:41
 * Modify User: SteveJrong
 * Modify Date: 2016年4月3日 下午2:23:41
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class LoadBigDataAction implements Action, Serializable {

	private static final long serialVersionUID = -6529119076384666296L;

	/**
	 * 大数据业务接口类型的属性，用于Spring Ioc
	 */
	private BigDataService bigDataService;

	public void setBigDataService(BigDataService bigDataService) {
		this.bigDataService = bigDataService;
	}

	/**
	 * 结果集属性
	 */
	private JSONObject jsonDatas;

	public JSONObject getJsonDatas() {
		return jsonDatas;
	}

	public void setJsonDatas(JSONObject jsonDatas) {
		this.jsonDatas = jsonDatas;
	}

	@Override
	public String execute() throws Exception {
		jsonDatas = bigDataService.getThisWeekGuestsVistedInfoService();
		return ActionResult.SUCCESS.getType();
	}
}
