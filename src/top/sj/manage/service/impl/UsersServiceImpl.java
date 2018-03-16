/*
 * Project Name: SJBlog
 * Class Name: UsersServiceImpl.java
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

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import top.sj.entity.SjUsers;
import top.sj.manage.dao.UsersDao;
import top.sj.manage.dto.UserManageDataGridNodeDTO;
import top.sj.manage.service.UsersService;
import top.sj.tool.TimestampTool;

/**
 * 用户业务接口的实现类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年3月25日 下午11:21:02
 * Modify User: SteveJrong
 * Modify Date: 2016年3月25日 下午11:21:02
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class UsersServiceImpl implements UsersService {

	/**
	 * 用户接口类型的属性，用于Spring Ioc
	 */
	private UsersDao mUsersDao;

	public void setmUsersDao(UsersDao mUsersDao) {
		this.mUsersDao = mUsersDao;
	}

	/**
	 * 获取所有管理员账户信息的方法【业务逻辑】
	 */
	@Override
	public List<SjUsers> getAllAdminstratorsAccountService() {
		return mUsersDao.getAllAdminstratorsAccount();
	}

	/**
	 * 根据用户编号获取用户信息的方法【业务逻辑】
	 */
	@Override
	public SjUsers getSingleUserInfoByIdService(Integer id) {
		return mUsersDao.getSingleUserInfoById(id);
	}

	/**
	 * 管理员登录后台管理系统的方法【业务逻辑】
	 */
	@Override
	public SjUsers doLoginService(String userName, String pwd) {
		return mUsersDao.doLogin(userName, pwd);
	}

	/**
	 * 根据用户昵称（登录名）获取单个用户信息的方法【业务逻辑】
	 */
	@Override
	public SjUsers getSingleUserInfoByUserNickNameService(String nickName) {
		return mUsersDao.getSingleUserInfoByUserNickName(nickName);
	}

	/**
	 * 分页获取用户信息的方法【业务逻辑】
	 */
	@Override
	public JSONObject getAllUsersInfoBySplitPageService(Integer pageIndex,
			Integer pageSize) {

		List<SjUsers> sjUsers = mUsersDao.getAllUsersInfoBySplitPage(pageIndex,
				pageSize);

		List<UserManageDataGridNodeDTO> users = new ArrayList<UserManageDataGridNodeDTO>();

		for (int i = 0; i < sjUsers.size(); i++) {
			users.add(new UserManageDataGridNodeDTO(sjUsers.get(i).getUId(),
					sjUsers.get(i).getUNickname(), sjUsers.get(i).getUGender(),
					sjUsers.get(i).getURole(), sjUsers.get(i).getUAge(),
					sjUsers.get(i).getUState(), sjUsers.get(i).getULevel(),
					TimestampTool
							.toString(sjUsers.get(i).getUCreatetime()),
					TimestampTool.toString(sjUsers.get(i)
							.getULastlogontime()), sjUsers.get(i).getUEmail(),
					sjUsers.get(i).getUQqnum().toString(), sjUsers.get(i)
							.getUProvinceandcity()));
		}

		Map<String, Object> maps = new HashMap<String, Object>();
		maps.put("total", this.getUsersInfoAllCountOfSplitPageService());
		maps.put("rows", JSONArray.fromObject(users));

		return JSONObject.fromObject(maps);
	}

	/**
	 * 分页获取用户总数的方法【业务逻辑】
	 */
	@Override
	public Integer getUsersInfoAllCountOfSplitPageService() {
		return mUsersDao.getUsersInfoAllCountOfSplitPage();
	}

	/**
	 * 根据用户编号删除用户信息的方法【业务逻辑】
	 */
	@Override
	public Boolean deleteUserInfoByIdService(Integer userId) {
		return mUsersDao.deleteUserInfoById(userId);
	}
}
