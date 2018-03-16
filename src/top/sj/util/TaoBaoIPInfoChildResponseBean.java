/*
 * Project Name: SJBlog
 * Class Name: TaoBaoIPInfoChildResponseBean.java
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
package top.sj.util;

import java.io.Serializable;

/**
 * 适用于淘宝IP地址信息工具类响应结果的子辈Bean
 * 
 * Create User: SteveJrong
 * Create Date: 2017年1月19日 23:06:03
 * Modify User: SteveJrong
 * Modify Date: 2017年1月19日 23:06:03
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class TaoBaoIPInfoChildResponseBean implements Serializable{
	private static final long serialVersionUID = -4829016282522346104L;
	
	private String country;
	
	private String country_id;
	
	private String area;
	
	private String area_id;
	
	private String region;
	
	private String region_id;
	
	private String city;
	
	private String city_id;
	
	private String county;
	
	private String county_id;
	
	private String isp;
	
	private String isp_id;
	
	private String ip;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountry_id() {
		return country_id;
	}

	public void setCountry_id(String country_id) {
		this.country_id = country_id;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getArea_id() {
		return area_id;
	}

	public void setArea_id(String area_id) {
		this.area_id = area_id;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getRegion_id() {
		return region_id;
	}

	public void setRegion_id(String region_id) {
		this.region_id = region_id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCity_id() {
		return city_id;
	}

	public void setCity_id(String city_id) {
		this.city_id = city_id;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getCounty_id() {
		return county_id;
	}

	public void setCounty_id(String county_id) {
		this.county_id = county_id;
	}

	public String getIsp() {
		return isp;
	}

	public void setIsp(String isp) {
		this.isp = isp;
	}

	public String getIsp_id() {
		return isp_id;
	}

	public void setIsp_id(String isp_id) {
		this.isp_id = isp_id;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
}
