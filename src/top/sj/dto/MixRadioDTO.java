/*
 * Project Name: SJBlog
 * Class Name: MixRadioDTO.java
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
import java.math.BigDecimal;

/**
 * MixRadio DTO实体类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年12月9日 上午11:26:34
 * Modify User: SteveJrong
 * Modify Date: 2016年12月9日 上午11:26:34
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class MixRadioDTO implements Serializable {

	private static final long serialVersionUID = -4445452238003029126L;

	/**
	 * 歌曲的Mp3文件路径属性
	 */
	private String mp3;
	
	/**
	 * 歌曲的Ogg文件路径属性
	 */
	private String oga;
	
	/**
	 * 歌曲标题属性
	 */
	private String title;
	
	/**
	 * 歌曲艺术家属性
	 */
	private String artist;
	
	/**
	 * 歌曲分值属性
	 */
	private Integer rating;
	
	/**
	 * 歌曲购买链接属性
	 */
	private String buy;
	
	/**
	 * 歌曲单价属性
	 */
	private BigDecimal price;
	
	/**
	 * 歌曲持续时间属性
	 */
	private String duration;
	
	/**
	 * 歌曲基于Base64的Cover属性
	 */
	private String cover;

	public String getOga() {
		return oga;
	}

	public void setOga(String oga) {
		this.oga = oga;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getBuy() {
		return buy;
	}

	public void setBuy(String buy) {
		this.buy = buy;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getMp3() {
		return mp3;
	}

	public void setMp3(String mp3) {
		this.mp3 = mp3;
	}

	public MixRadioDTO(String mp3,String oga, String title, String artist, Integer rating, String buy, BigDecimal price,
			String duration, String cover) {
		super();
		this.mp3 = mp3;
		this.oga = oga;
		this.title = title;
		this.artist = artist;
		this.rating = rating;
		this.buy = buy;
		this.price = price;
		this.duration = duration;
		this.cover = cover;
	}
	
	public MixRadioDTO() {
	}
}
