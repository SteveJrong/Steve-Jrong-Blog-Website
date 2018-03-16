/*
 * Project Name: SJBlog
 * Class Name: ArticlesService.java
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

import java.util.List;

import net.sf.json.JSONObject;
import top.sj.entity.SjArticles;
import top.sj.entity.SjArticletypes;

/**
 * 文章业务接口
 * 
 * Create User: SteveJrong
 * Create Date: 2016年3月22日 下午10:00:23
 * Modify User: SteveJrong
 * Modify Date: 2016年3月22日 下午10:00:23
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public interface ArticlesService {
	/**
	 * 分页获取文章信息的方法【抽象业务逻辑】
	 * 
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	JSONObject getArticlesInfoBySplitPageService(Integer pageIndex,
			Integer pageSize);

	/**
	 * 获取分页时文章信息总数的方法【抽象业务逻辑】
	 * 
	 * @return
	 */
	Integer getArticlesInfoAllCountOfSplitPageService();

	/**
	 * 获取所有文章类型信息的方法【抽象业务逻辑】
	 * 
	 * @return
	 */
	List<SjArticletypes> getArticleTypesInfoService();

	/**
	 * 添加新博文信息的方法【抽象业务逻辑】
	 * 
	 * @param articles
	 * @return
	 */
	Boolean addNewArticlesInfoService(SjArticles articles);

	/**
	 * 根据文章编号删除文章信息的方法【抽象业务逻辑】
	 * 
	 * @param id
	 * @return
	 */
	Boolean delArticleInfoByIdService(Integer id);
	
	/**
	 * 更新文章信息的方法【抽象业务逻辑】
	 * @param articles
	 * @return
	 */
	Boolean updateArticleInfoService(SjArticles articles);
	
	/**
	 * 根据文章编号获取文章信息的方法【抽象业务逻辑】
	 * @param articleId
	 * @return
	 */
	SjArticles getArticleInfoByArticleIdService(Integer articleId);
}
