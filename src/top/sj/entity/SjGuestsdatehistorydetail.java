/*
 * Project Name: SJBlog
 * Class Name: SjGuestsdatehistorydetail.java
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

import java.sql.Timestamp;

/**
 * 访客时间历史记录详情实体类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年11月14日 下午3:06:18
 * Modify User: SteveJrong
 * Modify Date: 2016年11月14日 下午3:06:18
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class SjGuestsdatehistorydetail  implements java.io.Serializable {
	private static final long serialVersionUID = -5273780301745535650L;
	
	/**
	 * 历史记录详情编号属性
	 */
	private Integer gdId;

	private SjGuestshistory sjGuestshistory;

	/**
	 * 访问时间属性
	 */
	private Timestamp gdVisteddatetime;

    public SjGuestsdatehistorydetail() {
    }

    public SjGuestsdatehistorydetail(SjGuestshistory sjGuestshistory, Timestamp gdVisteddatetime) {
        this.sjGuestshistory = sjGuestshistory;
        this.gdVisteddatetime = gdVisteddatetime;
    }

    public Integer getGdId() {
        return this.gdId;
    }
    
    public void setGdId(Integer gdId) {
        this.gdId = gdId;
    }

    public SjGuestshistory getSjGuestshistory() {
        return this.sjGuestshistory;
    }
    
    public void setSjGuestshistory(SjGuestshistory sjGuestshistory) {
        this.sjGuestshistory = sjGuestshistory;
    }

    public Timestamp getGdVisteddatetime() {
        return this.gdVisteddatetime;
    }
    
    public void setGdVisteddatetime(Timestamp gdVisteddatetime) {
        this.gdVisteddatetime = gdVisteddatetime;
    }
}