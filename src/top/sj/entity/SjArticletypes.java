/*
 * Project Name: SJBlog
 * Class Name: SjArticletypes.java
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
package top.sj.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * 博文类型实体类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年11月14日 下午3:05:16
 * Modify User: SteveJrong
 * Modify Date: 2016年11月14日 下午3:05:16
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class SjArticletypes  implements java.io.Serializable {
	private static final long serialVersionUID = 5133539720117862056L;
	
	/**
	 * 博文类型编号属性
	 */
	private Integer TId;
	
	/**
	 * 博文类型名称属性
	 */
     private String TName;
     
     @SuppressWarnings("rawtypes")
	private Set sjArticleses = new HashSet(0);

    public SjArticletypes() {
    }

    public SjArticletypes(String TName, Set<?> sjArticleses) {
        this.TName = TName;
        this.sjArticleses = sjArticleses;
    }

    public Integer getTId() {
        return this.TId;
    }
    
    public void setTId(Integer TId) {
        this.TId = TId;
    }

    public String getTName() {
        return this.TName;
    }
    
    public void setTName(String TName) {
        this.TName = TName;
    }

    public Set<?> getSjArticleses() {
        return this.sjArticleses;
    }
    
    public void setSjArticleses(Set<?> sjArticleses) {
        this.sjArticleses = sjArticleses;
    }
}