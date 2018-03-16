/*
 * Project Name: SJBlog
 * Class Name: MixRadioDTO.java
 * 
 * Copyright © 2011-2017 SteveJrong  All Rights Reserved.
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
package top.sj.dto;

import java.io.Serializable;
import java.util.List;

/**
 * PlayLife DTO实体类
 * 
 * Create User: SteveJrong
 * Create Date: 2017年5月9日 下午4:24:31
 * Modify User: SteveJrong
 * Modify Date: 2017年5月9日 下午4:24:31
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class PlayLifeDTO implements Serializable {

	private static final long serialVersionUID = -4445452238003029126L;

	/**
	 * 生活段子分页属性
	 */
	private PlayLifePaginationDTO playLifePagination;
	
	/**
	 * 生活段子数据属性
	 */
	private List<PlayLifeDatasDTO> playLifeDatas;

	public PlayLifePaginationDTO getPlayLifePagination() {
		return playLifePagination;
	}

	public void setPlayLifePagination(PlayLifePaginationDTO playLifePagination) {
		this.playLifePagination = playLifePagination;
	}

	public List<PlayLifeDatasDTO> getPlayLifeDatas() {
		return playLifeDatas;
	}

	public void setPlayLifeDatas(List<PlayLifeDatasDTO> playLifeDatas) {
		this.playLifeDatas = playLifeDatas;
	}

	public PlayLifeDTO(PlayLifePaginationDTO playLifePagination, List<PlayLifeDatasDTO> playLifeDatas) {
		super();
		this.playLifePagination = playLifePagination;
		this.playLifeDatas = playLifeDatas;
	}
	
	public PlayLifeDTO() {
	}
}
