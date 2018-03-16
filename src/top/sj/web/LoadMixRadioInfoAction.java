/*
 * Project Name: SJBlog
 * Class Name: LoadMixRadioInfoAction.java
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
package top.sj.web;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.struts2.ServletActionContext;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;
import org.jaudiotagger.tag.datatype.Artwork;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.opensymphony.xwork2.Action;

import net.sf.json.JSONObject;
import sun.misc.BASE64Encoder;
import top.sj.common.util.ActionResult;
import top.sj.common.util.Constants;
import top.sj.common.util.GsonUtil;
import top.sj.common.util.OggTaggerUtil;
import top.sj.dto.MixRadioDTO;
import top.sj.tool.ProjectPropertiesTool;
import top.sj.tool.PropertiesTool;

/**
 * 载入MixRadio模块数据信息相关的Action
 * 
 * Create User: SteveJrong
 * Create Date: 2016年12月9日 上午9:10:15
 * Modify User: SteveJrong
 * Modify Date: 2016年12月9日 上午9:10:15
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class LoadMixRadioInfoAction implements Action, Serializable {

	private static final long serialVersionUID = -6545028590484765392L;

	private static final Logger LOGGER = LoggerFactory.getLogger(LoadMixRadioInfoAction.class);
	
	private OggTaggerUtil oggTaggerUtil = OggTaggerUtil.getInstance();
	
	/**
	 * 结果集JSON对象
	 */
	private String jsonDatas;
	
	public String getJsonDatas() {
		return jsonDatas;
	}

	public void setJsonDatas(String jsonDatas) {
		this.jsonDatas = jsonDatas;
	}

	/**
	 * 默认执行的方法
	 * @throws InvalidAudioFrameException 
	 * @throws ReadOnlyFileException 
	 * @throws TagException 
	 * @throws IOException 
	 * @throws CannotReadException 
	 */
	@Override
	public String execute() throws CannotReadException, IOException, TagException, ReadOnlyFileException, InvalidAudioFrameException {
		List<MixRadioDTO> mixRadioDTOs = new ArrayList<MixRadioDTO>();
		
		File musicOggFileDirectary = new File(ProjectPropertiesTool.getProjLocalRootUrl(ServletActionContext.getRequest()) + PropertiesTool.getPropertiesFileAsObject(Constants.CONFIG_OF_BASIC_CONFIGURATIONS.getValue()).get(Constants.DEFAULT_MIX_RADIO_MUSIC_OGG_FILE_PATH.getValue()).toString());
		if (musicOggFileDirectary.isDirectory() && musicOggFileDirectary.exists()) {
			File[] musicFileList = musicOggFileDirectary.listFiles();
			for (File file : musicFileList) {
				if (file.isFile()) {
					AudioFile audioFile = AudioFileIO.read(file);
					
					MixRadioDTO mixRadioDTO = new MixRadioDTO();
					mixRadioDTO.setArtist(oggTaggerUtil.getArtistByMusicFile(audioFile, file));
					mixRadioDTO.setCover(oggTaggerUtil.getBase64CoverByMusicFile(audioFile, file).toString());
					mixRadioDTO.setDuration(new SimpleDateFormat("mm:ss").format(oggTaggerUtil.getDurationByMusicFile(audioFile, file)));
					mixRadioDTO.setOga(ProjectPropertiesTool.getProjHttpRootUrl(ServletActionContext.getRequest()) + "/" + PropertiesTool.getPropertiesFileAsObject(Constants.CONFIG_OF_BASIC_CONFIGURATIONS.getValue()).get(Constants.DEFAULT_MIX_RADIO_MUSIC_OGG_FILE_PATH.getValue()).toString() + "/" + file.getName());
					mixRadioDTO.setMp3(ProjectPropertiesTool.getProjHttpRootUrl(ServletActionContext.getRequest()) + "/" + PropertiesTool.getPropertiesFileAsObject(Constants.CONFIG_OF_BASIC_CONFIGURATIONS.getValue()).get(Constants.DEFAULT_MIX_RADIO_MUSIC_MPEG3_FILE_PATH.getValue()).toString() + "/" + file.getName().replace("ogg", "mp3"));
					mixRadioDTO.setRating(5);
					mixRadioDTO.setPrice(BigDecimal.valueOf(2.0d));
					mixRadioDTO.setBuy("javascript:regVipToDownloadLosslessMusic();");
					mixRadioDTO.setTitle(oggTaggerUtil.getTitleByMusicFile(audioFile, file));
					
					mixRadioDTOs.add(mixRadioDTO);
				}
			}
		}
		
		//因JSONObject对象处理大数据时性能差，故这里使用Google的Gson组件转换
		jsonDatas = GsonUtil.getInstance().toJson(mixRadioDTOs);
		//LOGGER.info(" -- Json Datas are :" + jsonDatas + " -- ");
		
		return ActionResult.SUCCESS.getType();
	}
}
