/*
 * Project Name: SJBlog
 * Class Name: LuceneSearchDTO.java
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
package top.sj.dto;

import java.io.Serializable;

/**
 * 适用于Lucene的搜索结果数据传输实体类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年6月12日 下午8:51:24
 * Modify User: SteveJrong
 * Modify Date: 2016年6月12日 下午8:51:24
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class LuceneSearchDTO implements Serializable {
	private static final long serialVersionUID = 7167048030556520533L;

	/**
	 * 主键属性
	 */
	private Integer identity;

	/**
	 * 分析目标属性
	 */
	private String analysisTarget;

	public Integer getIdentity() {
		return identity;
	}

	public void setIdentity(Integer identity) {
		this.identity = identity;
	}

	public String getAnalysisTarget() {
		return analysisTarget;
	}

	public void setAnalysisTarget(String analysisTarget) {
		this.analysisTarget = analysisTarget;
	}

	public LuceneSearchDTO(Integer identity, String analysisTarget) {
		super();
		this.identity = identity;
		this.analysisTarget = analysisTarget;
	}

	public LuceneSearchDTO() {
	}
}
