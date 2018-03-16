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
package top.sj.manage.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;
import top.sj.entity.SjArticletypes;
import top.sj.manage.dao.ArticleTypesDao;
import top.sj.manage.service.ArticleTypesService;
import top.sj.manage.util.ArticleTypesManageDataGridNode;

/**
 * 文章类型业务接口的实现类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年3月26日 上午1:30:40
 * Modify User: SteveJrong
 * Modify Date: 2016年3月26日 上午1:30:40
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class ArticleTypesServiceImpl implements ArticleTypesService {

	/**
	 * 文章类型接口属性，用于Spring Ioc
	 */
	private ArticleTypesDao mArticleTypesDao;

	public void setmArticleTypesDao(ArticleTypesDao mArticleTypesDao) {
		this.mArticleTypesDao = mArticleTypesDao;
	}

	/**
	 * 根据文章类型编号获取文章类型信息的方法【业务逻辑】
	 */
	@Override
	public SjArticletypes getSingleArticleTypeInfoByIdService(Integer id) {
		return mArticleTypesDao.getSingleArticleTypeInfoById(id);
	}

	/**
	 * 分页获取所有博文类型信息的方法【业务逻辑】
	 */
	@Override
	public JSONObject getAllArticleTypesInfoService(Integer pageIndex,
			Integer pageSize) {

		List<SjArticletypes> articletypes = mArticleTypesDao
				.getAllArticleTypesInfo(pageIndex, pageSize);

		List<ArticleTypesManageDataGridNode> nodes = new ArrayList<ArticleTypesManageDataGridNode>();

		for (int i = 0; i < articletypes.size(); i++) {
			nodes.add(new ArticleTypesManageDataGridNode(articletypes.get(i)
					.getTId().toString(), articletypes.get(i).getTName()));
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", this.getArticleTypesInfoAllCountOfSplitPageService());
		map.put("rows", nodes);

		return JSONObject.fromObject(map);
	}

	/**
	 * 分页获取所有博文类型信息总数的方法【业务逻辑】
	 */
	@Override
	public Integer getArticleTypesInfoAllCountOfSplitPageService() {
		return mArticleTypesDao.getArticleTypesInfoAllCountOfSplitPage();
	}

	/**
	 * 根据博文类型和名称修改博文类型信息的方法【业务逻辑】
	 */
	@Override
	public Boolean updateArticleTypeInfoByTypeIdAndTypeNameService(Integer id,
			String name) {
		return mArticleTypesDao.updateArticleTypeInfoByTypeIdAndTypeName(id,
				name);
	}

	/**
	 * 根据博文类型编号删除博文类型信息的方法【业务逻辑】
	 */
	@Override
	public Boolean deleteArticleTypeInfoByIdService(Integer id) {
		return mArticleTypesDao.deleteArticleTypeInfoById(id);
	}

	/**
	 * 根据博文类型名称新增博文类型信息的方法【业务逻辑】
	 */
	@Override
	public Boolean addNewArticleTypeInfoService(String typeName) {
		return mArticleTypesDao.addNewArticleTypeInfo(typeName);
	}
}
