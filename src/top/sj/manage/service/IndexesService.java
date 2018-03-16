/*
 * Project Name: SJBlog
 * Class Name: IndexesService.java
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
package top.sj.manage.service;

/**
 * 全文索引业务接口
 * 
 * Create User: SteveJrong
 * Create Date: 2016年6月16日 下午4:29:28
 * Modify User: SteveJrong
 * Modify Date: 2016年6月16日 下午4:29:28
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public interface IndexesService {
	/**
	 * 设置重建全文索引标识符的方法【抽象业务逻辑】
	 * 
	 * @return
	 */
	Boolean setReBuildFullTextIndexesFlagService();
}
