/*
 * Project Name: SJBlog
 * Class Name: ArticleTypesManageDataGridNode.java
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
package top.sj.manage.util;

/**
 * 博文类型信息管理的DataGrid实体类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年3月27日 下午12:53:01
 * Modify User: SteveJrong
 * Modify Date: 2016年3月27日 下午12:53:01
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class ArticleTypesManageDataGridNode {
	/**
	 * 博文类型编号属性
	 */
	private String typeId;

	/**
	 * 博文类型名称属性
	 */
	private String typeName;

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public ArticleTypesManageDataGridNode(String typeId, String typeName) {
		super();
		this.typeId = typeId;
		this.typeName = typeName;
	}

	public ArticleTypesManageDataGridNode() {
	}
}
