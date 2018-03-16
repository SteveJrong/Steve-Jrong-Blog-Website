/*
 * Project Name: SJBlog
 * Class Name: TestInvokeMobileAction.java
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
package top.sj.mobile.web;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONArray;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import top.sj.common.util.ActionResult;
import top.sj.mobile.responsebeans.TestInvokingResponeBean;
import top.sj.tool.DateTimeTool;

import com.opensymphony.xwork2.Action;

/**
 * 【移动平台】测试调用的Action
 * 
 * Create User: SteveJrong
 * Create Date: 2017年1月18日 15:27:36
 * Modify User: SteveJrong
 * Modify Date: 2017年1月18日 15:27:36
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class TestInvokeMobileAction implements Action, Serializable {
	private static final long serialVersionUID = -2880454104229644542L;
	private static final Logger LOGGER = LoggerFactory.getLogger(TestInvokeMobileAction.class);
	
	/**
	 * 结果集属性
	 */
	private Map<String, Object> responseResult = new HashMap<String, Object>();

	public Map<String, Object> getResponseResult() {
		return responseResult;
	}

	public void setResponseResult(Map<String, Object> responseResult) {
		this.responseResult = responseResult;
	}
	
	/**
	 * 默认执行的方法
	 */
	@Override
	public String execute() throws Exception {
		// 测试地址：http://localhost:8888/SJBlog/mobileInvokingTest.action
		TestInvokingResponeBean responeBean = new TestInvokingResponeBean(DateTimeTool.getNowDateFormatDateTimeTemplateOne());
		LOGGER.info(" -- Invoking date:"+responeBean.getInvokingDate()+" -- ");
		responseResult.put("result", JSONArray.fromObject(responeBean));
		return ActionResult.SUCCESS.getType();
	}
}
