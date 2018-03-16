/*
 * Project Name: SJBlog
 * Class Name: SjGuestshistory.java
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
import java.util.HashSet;
import java.util.Set;

/**
 * 访客历史记录实体类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年11月14日 下午3:06:41
 * Modify User: SteveJrong
 * Modify Date: 2016年11月14日 下午3:06:41
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class SjGuestshistory  implements java.io.Serializable {
	private static final long serialVersionUID = 9091447560140145366L;
	
	/**
	 * 历史记录编号属性
	 */
	private Integer GId;
	
	/**
	 * 访问的IP地址属性
	 */
     private String GIpaddress;
     
     /**
      * 访客的省市区属性
      */
     private String GProvinceandcity;
     
     /**
      * 访客首次访问时的时间属性
      */
     private Timestamp GFirstvisitordate;
     
     /**
      * 访客最后一次访问时的时间属性
      */
     private Timestamp GLastvisitordate;
     
     @SuppressWarnings("rawtypes")
	private Set sjGuestsdatehistorydetails = new HashSet(0);

     public SjGuestshistory() {
    }

    public SjGuestshistory(String GIpaddress, String GProvinceandcity, Timestamp GFirstvisitordate, Timestamp GLastvisitordate, Set<?> sjGuestsdatehistorydetails) {
        this.GIpaddress = GIpaddress;
        this.GProvinceandcity = GProvinceandcity;
        this.GFirstvisitordate = GFirstvisitordate;
        this.GLastvisitordate = GLastvisitordate;
        this.sjGuestsdatehistorydetails = sjGuestsdatehistorydetails;
    }

    public Integer getGId() {
        return this.GId;
    }
    
    public void setGId(Integer GId) {
        this.GId = GId;
    }

    public String getGIpaddress() {
        return this.GIpaddress;
    }
    
    public void setGIpaddress(String GIpaddress) {
        this.GIpaddress = GIpaddress;
    }

    public String getGProvinceandcity() {
        return this.GProvinceandcity;
    }
    
    public void setGProvinceandcity(String GProvinceandcity) {
        this.GProvinceandcity = GProvinceandcity;
    }

    public Timestamp getGFirstvisitordate() {
        return this.GFirstvisitordate;
    }
    
    public void setGFirstvisitordate(Timestamp GFirstvisitordate) {
        this.GFirstvisitordate = GFirstvisitordate;
    }

    public Timestamp getGLastvisitordate() {
        return this.GLastvisitordate;
    }
    
    public void setGLastvisitordate(Timestamp GLastvisitordate) {
        this.GLastvisitordate = GLastvisitordate;
    }

    @SuppressWarnings("rawtypes")
	public Set getSjGuestsdatehistorydetails() {
        return this.sjGuestsdatehistorydetails;
    }
    
    @SuppressWarnings("rawtypes")
	public void setSjGuestsdatehistorydetails(Set sjGuestsdatehistorydetails) {
        this.sjGuestsdatehistorydetails = sjGuestsdatehistorydetails;
    }
}