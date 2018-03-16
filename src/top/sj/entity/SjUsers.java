/*
 * Project Name: SJBlog
 * Class Name: SjUsers.java
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
 * 用户实体类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年11月14日 下午3:07:43
 * Modify User: SteveJrong
 * Modify Date: 2016年11月14日 下午3:07:43
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class SjUsers implements java.io.Serializable {
	private static final long serialVersionUID = -1954825281063516433L;
	
	/**
	 * 用户编号属性
	 */
	private Integer UId;
	
	/**
	 * 用户昵称属性
	 */
     private String UNickname;
     
     /**
      * 用户性别属性
      */
     private String UGender;
     
     /**
      * 用户权限属性
      */
     private String URole;
     
     /**
      * 用户年龄属性
      */
     private Integer UAge;
     
     /**
      * 用户登录密码属性
      */
     private String UPwd;
     
     /**
      * 用户安全问题验证答案属性
      */
     private String USecurityquestionanswer;
     
     /**
      * 用户状态属性
      */
     private String UState;
     
     /**
      * 用户等级属性
      */
     private Integer ULevel;
     
     /**
      * 用户创建时间属性
      */
     private Timestamp UCreatetime;
     
     /**
      * 用户最后一次登录时间属性
      */
     private Timestamp ULastlogontime;
     
     /**
      * 用户电子邮件地址属性
      */
     private String UEmail;
     
     /**
      * 用户QQ号码属性
      */
     private Integer UQqnum;
     
     /**
      * 用户省市区属性 
      */
     private String UProvinceandcity;
     
     /**
      * 用户头像属性
      */
     private String UHeader;
     
     @SuppressWarnings("rawtypes")
	private Set<?> sjLeavemessagesesForMReplyId = new HashSet(0);
     @SuppressWarnings("rawtypes")
	private Set<?> sjLeavemessagesesForMUId = new HashSet(0);
     @SuppressWarnings("rawtypes")
	private Set<?> sjLifes = new HashSet(0);
     @SuppressWarnings("rawtypes")
	private Set<?> sjArticleses = new HashSet(0);

    public SjUsers() {
    }

    public SjUsers(Integer uId, String uNickname, String uGender, String uRole, Integer uAge, String uPwd,
			String uSecurityquestionanswer, String uState, Integer uLevel, Timestamp uCreatetime,
			Timestamp uLastlogontime, String uEmail, Integer uQqnum, String uProvinceandcity, String uHeader,
			Set<?> sjLeavemessagesesForMReplyId, Set<?> sjLeavemessagesesForMUId, Set<?> sjLifes, Set<?> sjArticleses) {
		super();
		UId = uId;
		UNickname = uNickname;
		UGender = uGender;
		URole = uRole;
		UAge = uAge;
		UPwd = uPwd;
		USecurityquestionanswer = uSecurityquestionanswer;
		UState = uState;
		ULevel = uLevel;
		UCreatetime = uCreatetime;
		ULastlogontime = uLastlogontime;
		UEmail = uEmail;
		UQqnum = uQqnum;
		UProvinceandcity = uProvinceandcity;
		UHeader = uHeader;
		this.sjLeavemessagesesForMReplyId = sjLeavemessagesesForMReplyId;
		this.sjLeavemessagesesForMUId = sjLeavemessagesesForMUId;
		this.sjLifes = sjLifes;
		this.sjArticleses = sjArticleses;
	}

	public Integer getUId() {
        return this.UId;
    }
    
    public void setUId(Integer UId) {
        this.UId = UId;
    }

    public String getUNickname() {
        return this.UNickname;
    }
    
    public void setUNickname(String UNickname) {
        this.UNickname = UNickname;
    }

    public String getUGender() {
        return this.UGender;
    }
    
    public void setUGender(String UGender) {
        this.UGender = UGender;
    }

    public String getURole() {
        return this.URole;
    }
    
    public void setURole(String URole) {
        this.URole = URole;
    }

    public Integer getUAge() {
        return this.UAge;
    }
    
    public void setUAge(Integer UAge) {
        this.UAge = UAge;
    }

    public String getUPwd() {
        return this.UPwd;
    }
    
    public void setUPwd(String UPwd) {
        this.UPwd = UPwd;
    }

    public String getUSecurityquestionanswer() {
        return this.USecurityquestionanswer;
    }
    
    public void setUSecurityquestionanswer(String USecurityquestionanswer) {
        this.USecurityquestionanswer = USecurityquestionanswer;
    }

    public String getUState() {
        return this.UState;
    }
    
    public void setUState(String UState) {
        this.UState = UState;
    }

    public Integer getULevel() {
        return this.ULevel;
    }
    
    public void setULevel(Integer ULevel) {
        this.ULevel = ULevel;
    }

    public Timestamp getUCreatetime() {
        return this.UCreatetime;
    }
    
    public void setUCreatetime(Timestamp UCreatetime) {
        this.UCreatetime = UCreatetime;
    }

    public Timestamp getULastlogontime() {
        return this.ULastlogontime;
    }
    
    public void setULastlogontime(Timestamp ULastlogontime) {
        this.ULastlogontime = ULastlogontime;
    }

    public String getUEmail() {
        return this.UEmail;
    }
    
    public void setUEmail(String UEmail) {
        this.UEmail = UEmail;
    }

    public Integer getUQqnum() {
        return this.UQqnum;
    }
    
    public void setUQqnum(Integer UQqnum) {
        this.UQqnum = UQqnum;
    }

    public String getUProvinceandcity() {
        return this.UProvinceandcity;
    }
    
    public void setUProvinceandcity(String UProvinceandcity) {
        this.UProvinceandcity = UProvinceandcity;
    }

    public Set<?> getSjLeavemessagesesForMReplyId() {
        return this.sjLeavemessagesesForMReplyId;
    }
    
    public void setSjLeavemessagesesForMReplyId(Set<?> sjLeavemessagesesForMReplyId) {
        this.sjLeavemessagesesForMReplyId = sjLeavemessagesesForMReplyId;
    }

    public Set<?> getSjLeavemessagesesForMUId() {
        return this.sjLeavemessagesesForMUId;
    }
    
    public void setSjLeavemessagesesForMUId(Set<?> sjLeavemessagesesForMUId) {
        this.sjLeavemessagesesForMUId = sjLeavemessagesesForMUId;
    }

    public Set<?> getSjLifes() {
        return this.sjLifes;
    }
    
    public void setSjLifes(Set<?> sjLifes) {
        this.sjLifes = sjLifes;
    }

    public Set<?> getSjArticleses() {
        return this.sjArticleses;
    }
    
    public void setSjArticleses(Set<?> sjArticleses) {
        this.sjArticleses = sjArticleses;
    }

	public String getUHeader() {
		return UHeader;
	}

	public void setUHeader(String uHeader) {
		UHeader = uHeader;
	}
}