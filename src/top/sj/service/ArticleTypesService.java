/*
 * Project Name: SJBlog
 * Class Name: ArticleTypesService.java
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
package top.sj.service;

import java.util.List;

import top.sj.entity.SjArticletypes;

/**
 * 文章类型接口
 * 
 * Create User: SteveJrong
 * Create Date: 2016年2月17日 下午6:25:00
 * Modify User: SteveJrong
 * Modify Date: 2016年2月17日 下午6:25:00
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public interface ArticleTypesService {
	/**
	 * 获取文章类型信息的方法【抽象业务逻辑】
	 * 
	 * 方法描述:
	 * 
	 * @return
	 * @returnType List<SjArticletypes> 创建人： Steve Jrong 创建时间：2016-2-17
	 *             下午6:29:31
	 */
	List<SjArticletypes> getArticleTypeInfoService();
}
