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
package top.sj.mobile.service;

import java.io.Serializable;
import java.util.List;

import top.sj.entity.SjArticles;

/**
 * 【移动平台】博文业务接口
 * 
 * Create User: SteveJrong
 * Create Date: 2016年5月23日 下午7:48:04
 * Modify User: SteveJrong
 * Modify Date: 2016年5月23日 下午7:48:04
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public interface ArticlesService extends Serializable {
	/**
	 * 分页获取所有博文信息的方法【抽象业务逻辑】
	 * 
	 * @param pageIndex
	 * @return
	 */
	List<SjArticles> getAllArticlesInfoBySplitPageService(Integer pageIndex);

	/**
	 * 根据博文编号获取博文详情信息的方法【抽象业务逻辑】
	 * 
	 * @param articleId
	 * @return
	 */
	SjArticles getArticleDetailInfoService(Integer articleId);
}
