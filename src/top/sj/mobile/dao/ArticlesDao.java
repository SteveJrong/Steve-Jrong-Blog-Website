/*
 * Project Name: SJBlog
 * Class Name: ArticlesDao.java
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
package top.sj.mobile.dao;

import java.io.Serializable;
import java.util.List;

import top.sj.entity.SjArticles;

/**
 * 【移动平台】博文接口
 * 
 * Create User: SteveJrong
 * Create Date: 2016年5月23日 下午7:54:53
 * Modify User: SteveJrong
 * Modify Date: 2016年5月23日 下午7:54:53
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public interface ArticlesDao extends Serializable {
	/**
	 * 分页获取所有博文信息的方法【抽象方法】
	 * 
	 * @param pageIndex
	 * @return
	 */
	List<SjArticles> getAllArticlesInfoBySplitPage(Integer pageIndex);
}
