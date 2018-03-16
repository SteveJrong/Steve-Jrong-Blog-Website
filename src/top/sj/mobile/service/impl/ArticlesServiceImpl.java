/*
 * Project Name: SJBlog
 * Class Name: ArticlesServiceImpl.java
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
package top.sj.mobile.service.impl;

import java.io.Serializable;
import java.util.List;

import top.sj.entity.SjArticles;
import top.sj.mobile.dao.ArticlesDao;
import top.sj.mobile.service.ArticlesService;

/**
 * 【移动平台】博文业务接口的实现类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年5月24日 下午4:46:10
 * Modify User: SteveJrong
 * Modify Date: 2016年5月24日 下午4:46:10
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class ArticlesServiceImpl implements ArticlesService, Serializable {

	private static final long serialVersionUID = 5228632794737865037L;

	/**
	 * 博文类型的接口，用于Spring Ioc
	 */
	private ArticlesDao mobileArticlesDao;

	/**
	 * 博文类型的接口，用于Spring Ioc
	 */
	private top.sj.dao.ArticlesDao articlesDao;

	public void setMobileArticlesDao(ArticlesDao mobileArticlesDao) {
		this.mobileArticlesDao = mobileArticlesDao;
	}

	public void setArticlesDao(top.sj.dao.ArticlesDao articlesDao) {
		this.articlesDao = articlesDao;
	}

	/**
	 * 分页获取所有博文信息的方法【业务逻辑】
	 */
	@Override
	public List<SjArticles> getAllArticlesInfoBySplitPageService(
			Integer pageIndex) {
		return mobileArticlesDao.getAllArticlesInfoBySplitPage(pageIndex);
	}

	/**
	 * 根据博文编号获取博文详情信息的方法【业务逻辑】
	 * 
	 * @category 共用top.sj.dao和top.sj.dao.impl包中的逻辑
	 */
	@Override
	public SjArticles getArticleDetailInfoService(Integer articleId) {
		return articlesDao.getArticleDetailByArticleId(articleId);
	}
}
