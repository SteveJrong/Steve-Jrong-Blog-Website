/*
 * Project Name: SJBlog
 * Class Name: ArticleTypesServiceImpl.java
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
package top.sj.service.impl;

import java.util.List;

import top.sj.dao.ArticleTypesDao;
import top.sj.entity.SjArticletypes;
import top.sj.service.ArticleTypesService;

/**
 * 文章类型接口的实现类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年2月17日 下午6:25:21
 * Modify User: SteveJrong
 * Modify Date: 2016年2月17日 下午6:25:21
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class ArticleTypesServiceImpl implements ArticleTypesService {

	/**
	 * 文章类型接口类型的属性，用于Spring Ioc
	 */
	private ArticleTypesDao articleTypesDao;

	public void setArticleTypesDao(ArticleTypesDao articleTypesDao) {
		this.articleTypesDao = articleTypesDao;
	}

	/**
	 * 获取文章类型信息的方法【业务逻辑】
	 */
	@Override
	public List<SjArticletypes> getArticleTypeInfoService() {
		return articleTypesDao.getArticleTypeInfo();
	}
}
