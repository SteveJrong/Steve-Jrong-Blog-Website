/*
 * Project Name: SJBlog
 * Class Name: TestInvokingResponeBean.java
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
package top.sj.mobile.responsebeans;

import java.io.Serializable;

/**
 * 【移动平台】测试调用DTO Bean
 * 
 * Create User: SteveJrong
 * Create Date: 2017年1月18日 15:31:34
 * Modify User: SteveJrong
 * Modify Date: 2017年1月18日 15:31:34
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class TestInvokingResponeBean implements Serializable {
	private static final long serialVersionUID = -3072847105034485409L;
	
	/**
	 * 调用时间属性
	 */
	private String invokingDate;

	public String getInvokingDate() {
		return invokingDate;
	}

	public void setInvokingDate(String invokingDate) {
		this.invokingDate = invokingDate;
	}

	public TestInvokingResponeBean(String invokingDate) {
		this.invokingDate = invokingDate;
	}

	public TestInvokingResponeBean() {
	}
}
