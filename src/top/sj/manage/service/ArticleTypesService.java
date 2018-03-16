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
package top.sj.manage.service;

import net.sf.json.JSONObject;
import top.sj.entity.SjArticletypes;

/**
 * 文章类型业务接口
 * 
 * Create User: SteveJrong
 * Create Date: 2016年3月26日 上午1:29:40
 * Modify User: SteveJrong
 * Modify Date: 2016年3月26日 上午1:29:40
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public interface ArticleTypesService {
	/**
	 * 根据文章类型编号获取文章类型信息的方法【抽象业务逻辑】
	 * 
	 * @param id
	 * @return
	 */
	SjArticletypes getSingleArticleTypeInfoByIdService(Integer id);

	/**
	 * 分页获取所有博文类型信息的方法【抽象业务逻辑】
	 * 
	 * @return
	 */
	JSONObject getAllArticleTypesInfoService(Integer pageIndex, Integer pageSize);

	/**
	 * 分页获取所有博文类型信息总数的方法【抽象业务逻辑】
	 * 
	 * @return
	 */
	Integer getArticleTypesInfoAllCountOfSplitPageService();

	/**
	 * 根据博文类型和名称修改博文类型信息的方法【抽象业务逻辑】
	 * 
	 * @param id
	 * @param name
	 * @return
	 */
	Boolean updateArticleTypeInfoByTypeIdAndTypeNameService(Integer id,
			String name);

	/**
	 * 根据博文类型编号删除博文类型信息的方法【抽象业务逻辑】
	 * 
	 * @param id
	 * @return
	 */
	Boolean deleteArticleTypeInfoByIdService(Integer id);

	/**
	 * 根据博文类型名称新增博文类型信息的方法【抽象业务逻辑】
	 * 
	 * @param typeName
	 * @return
	 */
	Boolean addNewArticleTypeInfoService(String typeName);
}
