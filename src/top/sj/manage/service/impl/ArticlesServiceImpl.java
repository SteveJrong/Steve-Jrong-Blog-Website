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
package top.sj.manage.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;
import top.sj.entity.SjArticles;
import top.sj.entity.SjArticletypes;
import top.sj.manage.dao.ArticlesDao;
import top.sj.manage.service.ArticlesService;
import top.sj.manage.util.ArticlesManageDataGridNode;

/**
 * 文章业务接口的实现类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年11月14日 下午3:27:50
 * Modify User: SteveJrong
 * Modify Date: 2016年11月14日 下午3:27:50
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class ArticlesServiceImpl implements ArticlesService {

	/**
	 * 文章接口类型的属性，用于Spring Ioc
	 */
	private ArticlesDao mArticlesDao;

	public void setmArticlesDao(ArticlesDao mArticlesDao) {
		this.mArticlesDao = mArticlesDao;
	}

	/**
	 * 分页获取文章信息的方法【业务逻辑】
	 */
	@Override
	public JSONObject getArticlesInfoBySplitPageService(Integer pageIndex,
			Integer pageSize) {
		List<SjArticles> articles = mArticlesDao.getArticlesInfoBySplitPage(
				pageIndex, pageSize);

		List<ArticlesManageDataGridNode> gridNodes = new ArrayList<ArticlesManageDataGridNode>();

		for (int i = 0; i < articles.size(); i++) {
			gridNodes.add(new ArticlesManageDataGridNode(articles.get(i).getAId(), articles.get(i).getAName(),new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(articles.get(i).getACreatedate()), articles.get(i).getAModifydate() == null ? "暂无修改时间" : new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(articles.get(i).getAModifydate()),articles.get(i).getSjArticletypes().getTName(), articles.get(i).getSjUsers().getUNickname(),articles.get(i).getABrowserinfo(),articles.get(i).getASysteminfo(),articles.get(i).getSjFileAttachmentses().size(),articles.get(i).getAState(),articles.get(i).getATagkeyword(),articles.get(i).getAIpaddress()));
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", this.getArticlesInfoAllCountOfSplitPageService());
		map.put("rows", gridNodes);

		return JSONObject.fromObject(map);
	}

	/**
	 * 获取分页时文章信息总数的方法【业务逻辑】
	 */
	@Override
	public Integer getArticlesInfoAllCountOfSplitPageService() {
		return mArticlesDao.getArticlesInfoAllCountOfSplitPage();
	}

	/**
	 * 获取所有文章类型信息的方法【业务逻辑】
	 */
	@Override
	public List<SjArticletypes> getArticleTypesInfoService() {
		return mArticlesDao.getArticleTypesInfo();
	}

	/**
	 * 添加新博文信息的方法【业务逻辑】
	 */
	@Override
	public Boolean addNewArticlesInfoService(SjArticles articles) {
		return mArticlesDao.addNewArticlesInfo(articles);
	}

	/**
	 * 根据文章编号删除文章信息的方法【业务逻辑】
	 */
	@Override
	public Boolean delArticleInfoByIdService(Integer id) {
		return mArticlesDao.delArticleInfoById(id);
	}

	/**
	 * 更新文章信息的方法【业务逻辑】
	 */
	@Override
	public Boolean updateArticleInfoService(SjArticles articles) {
		return mArticlesDao.updateArticleInfo(articles);
	}

	/**
	 * 根据文章编号获取文章信息的方法【业务逻辑】
	 */
	@Override
	public SjArticles getArticleInfoByArticleIdService(Integer articleId) {
		return mArticlesDao.getArticleInfoByArticleId(articleId);
	}
}
