/*
 * Project Name: SJBlog
 * Class Name: SjArticles.java
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
 * 博文实体类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年11月14日 下午3:04:43
 * Modify User: SteveJrong
 * Modify Date: 2016年11月14日 下午3:04:43
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class SjArticles  implements java.io.Serializable {
	 private static final long serialVersionUID = 7683971346677286273L;
	 
	 /**
	  * 博文编号属性
	  */
     private Integer AId;
     
     private SjUsers sjUsers;
     
     private SjArticletypes sjArticletypes;
     
     /**
      * 博文名称属性
      */
     private String AName;
     
     /**
      * 博文创建时间属性
      */
     private Timestamp ACreatedate;
     
     /**
      * 发布时的IP地址属性
      */
     private String AIpaddress;
     
     /**
      * 博文修改时间属性
      */
     private Timestamp AModifydate;
     
     /**
      * 博文浏览量属性
      */
     private Long AReadcount;
     
     /**
      * 是否置顶属性
      */
     private Short AHoldtop;
     
     /**
      * 博文的发布状态属性
      */
     private String AState;
     
     /**
      * 博文关键字属性
      */
     private String ATagkeyword;
     
     /**
      * 博文正文内容属性
      */
     private String ABodycontents;
     
     /**
      * 博文文件附件路径属性（保留属性，暂时弃用）
      */
     private String AAttachfilespath;
     
     /**
      * 博文简略内容属性
      */
     private String ABriefcontents;
     
     /**
      * 发布博文时的浏览器信息属性
      */
     private String ABrowserinfo;
     
     /**
      * 发布博文时的操作系统信息属性
      */
     private String ASysteminfo;
     
     @SuppressWarnings("rawtypes")
	private Set sjLeavemessageses = new HashSet(0);
     @SuppressWarnings("rawtypes")
	private Set sjFileAttachmentses = new HashSet(0);

    public SjArticles() {
    }

    @SuppressWarnings("rawtypes")
	public SjArticles(Integer aId, SjUsers sjUsers,
			SjArticletypes sjArticletypes, String aName, Timestamp aCreatedate,
			String aIpaddress, Timestamp aModifydate, Long aReadcount,
			Short aHoldtop, String aState, String aTagkeyword,
			String aBodycontents, String aAttachfilespath,
			String aBriefcontents, String aBrowserinfo, String aSysteminfo,
			Set sjLeavemessageses, Set sjFileAttachmentses) {
		super();
		AId = aId;
		this.sjUsers = sjUsers;
		this.sjArticletypes = sjArticletypes;
		AName = aName;
		ACreatedate = aCreatedate;
		AIpaddress = aIpaddress;
		AModifydate = aModifydate;
		AReadcount = aReadcount;
		AHoldtop = aHoldtop;
		AState = aState;
		ATagkeyword = aTagkeyword;
		ABodycontents = aBodycontents;
		AAttachfilespath = aAttachfilespath;
		ABriefcontents = aBriefcontents;
		ABrowserinfo = aBrowserinfo;
		ASysteminfo = aSysteminfo;
		this.sjLeavemessageses = sjLeavemessageses;
		this.sjFileAttachmentses = sjFileAttachmentses;
	}

    public Integer getAId() {
        return this.AId;
    }
    
    public void setAId(Integer AId) {
        this.AId = AId;
    }

    public SjUsers getSjUsers() {
        return this.sjUsers;
    }
    
    public void setSjUsers(SjUsers sjUsers) {
        this.sjUsers = sjUsers;
    }

    public SjArticletypes getSjArticletypes() {
        return this.sjArticletypes;
    }
    
    public void setSjArticletypes(SjArticletypes sjArticletypes) {
        this.sjArticletypes = sjArticletypes;
    }

    public String getAName() {
        return this.AName;
    }
    
    public void setAName(String AName) {
        this.AName = AName;
    }

    public Timestamp getACreatedate() {
        return this.ACreatedate;
    }
    
    public void setACreatedate(Timestamp ACreatedate) {
        this.ACreatedate = ACreatedate;
    }

    public String getAIpaddress() {
        return this.AIpaddress;
    }
    
    public void setAIpaddress(String AIpaddress) {
        this.AIpaddress = AIpaddress;
    }

    public Timestamp getAModifydate() {
        return this.AModifydate;
    }
    
    public void setAModifydate(Timestamp AModifydate) {
        this.AModifydate = AModifydate;
    }

    public Long getAReadcount() {
        return this.AReadcount;
    }
    
    public void setAReadcount(Long AReadcount) {
        this.AReadcount = AReadcount;
    }

    public Short getAHoldtop() {
        return this.AHoldtop;
    }
    
    public void setAHoldtop(Short AHoldtop) {
        this.AHoldtop = AHoldtop;
    }

    public String getAState() {
        return this.AState;
    }
    
    public void setAState(String AState) {
        this.AState = AState;
    }

    public String getATagkeyword() {
        return this.ATagkeyword;
    }
    
    public void setATagkeyword(String ATagkeyword) {
        this.ATagkeyword = ATagkeyword;
    }

    public String getABodycontents() {
        return this.ABodycontents;
    }
    
    public void setABodycontents(String ABodycontents) {
        this.ABodycontents = ABodycontents;
    }

    public String getAAttachfilespath() {
        return this.AAttachfilespath;
    }
    
    public void setAAttachfilespath(String AAttachfilespath) {
        this.AAttachfilespath = AAttachfilespath;
    }

    public String getABriefcontents() {
        return this.ABriefcontents;
    }
    
    public void setABriefcontents(String ABriefcontents) {
        this.ABriefcontents = ABriefcontents;
    }

    public String getABrowserinfo() {
        return this.ABrowserinfo;
    }
    
    public void setABrowserinfo(String ABrowserinfo) {
        this.ABrowserinfo = ABrowserinfo;
    }

    public String getASysteminfo() {
        return this.ASysteminfo;
    }
    
    public void setASysteminfo(String ASysteminfo) {
        this.ASysteminfo = ASysteminfo;
    }

    @SuppressWarnings("rawtypes")
	public Set getSjLeavemessageses() {
        return this.sjLeavemessageses;
    }
    
    @SuppressWarnings("rawtypes")
	public void setSjLeavemessageses(Set sjLeavemessageses) {
        this.sjLeavemessageses = sjLeavemessageses;
    }
    
    @SuppressWarnings("rawtypes")
	public Set getSjFileAttachmentses() {
		return this.sjFileAttachmentses;
	}

	@SuppressWarnings("rawtypes")
	public void setSjFileAttachmentses(Set sjFileAttachmentses) {
		this.sjFileAttachmentses = sjFileAttachmentses;
	}
}