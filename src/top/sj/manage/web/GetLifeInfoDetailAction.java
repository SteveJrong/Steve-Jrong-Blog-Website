/*
 * Project Name: SJBlog
 * Class Name: GetLifeInfoDetailAction.java
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

import java.io.Serializable;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import top.sj.common.util.ActionResult;
import top.sj.entity.SjLife;
import top.sj.manage.service.LifeService;
import top.sj.manage.util.LifeManageDataGridNode;
import top.sj.tool.TimestampTool;

import com.opensymphony.xwork2.Action;

/**
 * 获取生活段子详情信息相关的Action
 * 
 * Create User: SteveJrong
 * Create Date: 2016年7月23日 下午9:53:26
 * Modify User: SteveJrong
 * Modify Date: 2016年7月23日 下午9:53:26
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class GetLifeInfoDetailAction implements Action, Serializable {

	private static final long serialVersionUID = 6021602706021572745L;

	private Logger LOGGER = LoggerFactory.getLogger(GetLifeInfoDetailAction.class);

	/**
	 * 生活段子业务类型的接口，用于Spring Ioc
	 */
	private LifeService mLifeService;

	/**
	 * 生活段子编号属性
	 */
	private String lifeId;

	/**
	 * 结果集JSON对象
	 */
	private JSONObject jsonDatas;

	public String getLifeId() {
		return lifeId;
	}

	public void setLifeId(String lifeId) {
		this.lifeId = lifeId;
	}

	public JSONObject getJsonDatas() {
		return jsonDatas;
	}

	public void setJsonDatas(JSONObject jsonDatas) {
		this.jsonDatas = jsonDatas;
	}

	public void setmLifeService(LifeService mLifeService) {
		this.mLifeService = mLifeService;
	}

	/**
	 * 默认执行的方法
	 */
	@Override
	public String execute() throws Exception {
		SjLife sjLife = mLifeService.getDetailInfoOfLifeByIdService(Integer
				.valueOf(lifeId));

		jsonDatas = JSONObject.fromObject(new LifeManageDataGridNode(lifeId,
				TimestampTool.toString(sjLife.getLPublishdate()), sjLife
						.getLIpaddress(), sjLife.getLContents()));
		LOGGER.info("Serializabled data is : " + jsonDatas.toString());
		return ActionResult.SUCCESS.getType();
	}
}
