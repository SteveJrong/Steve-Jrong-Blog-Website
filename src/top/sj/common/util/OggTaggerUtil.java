/*
 * Project Name: SJBlog
 * Class Name: JAudioTaggerUtil.java
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
package top.sj.common.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioHeader;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.datatype.Artwork;
import org.jaudiotagger.tag.vorbiscomment.VorbisCommentFieldKey;
import org.jaudiotagger.tag.vorbiscomment.VorbisCommentTag;

import sun.misc.BASE64Encoder;
import top.sj.tool.DateTimeTool;

/**
 * Ogg音频文件标签工具类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年12月9日 上午9:47:25
 * Modify User: SteveJrong
 * Modify Date: 2016年12月9日 上午9:47:25
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class OggTaggerUtil extends JAudioTagger{
	
	private static OggTaggerUtil oggTaggerUtil = null;
	
	/**
	 * 初始化OggTaggerUtil类的方法
	 * @return OggTaggerUtil类的对象
	 */
	public static OggTaggerUtil getInstance() {
		if (oggTaggerUtil == null) {
			synchronized (OggTaggerUtil.class) {
				if (oggTaggerUtil == null) {
					oggTaggerUtil = new OggTaggerUtil();
				}
			}
		}
		return oggTaggerUtil;
	}
	
	/**
	 * 根据Ogg音频文件对象返回Ogg音频文件专辑封面的方法
	 */
	@Override
	public StringBuffer getBase64CoverByMusicFile(AudioFile audioFile, File musicFile) throws IOException {
		StringBuffer sbBase64Format = new StringBuffer("data:image/jpg;base64,");
		
		Tag tag = audioFile.getTag();
		List<Artwork> artworks = tag.getArtworkList();
		for (Artwork artwork : artworks) {
			BufferedImage bufferedImage = artwork.getImage();
			BASE64Encoder base64Encoder = new BASE64Encoder();
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			ImageIO.write(bufferedImage, "jpg", byteArrayOutputStream);
			sbBase64Format.append(base64Encoder.encode(byteArrayOutputStream.toByteArray()));
		}
		return sbBase64Format;
	}

	/**
	 *  根据Ogg音频文件对象返回Ogg音频文件音乐名称的方法
	 */
	@Override
	public String getTitleByMusicFile(AudioFile audioFile, File musicFile) {
		VorbisCommentTag tag = (VorbisCommentTag)audioFile.getTag();
		return tag.getFirst(VorbisCommentFieldKey.TITLE);
	}

	/**
	 * 根据Ogg音频文件对象返回Ogg音频文件艺术家名称的方法
	 */
	@Override
	public String getArtistByMusicFile(AudioFile audioFile, File musicFile) {
		VorbisCommentTag tag = (VorbisCommentTag)audioFile.getTag();
		return tag.getFirst(VorbisCommentFieldKey.ARTIST);
	}

	/**
	 * 根据Ogg音频文件对象返回Ogg音频文件持续时间的方法
	 */
	@Override
	public Date getDurationByMusicFile(AudioFile audioFile, File musicFile) {
		AudioHeader audioHeader = audioFile.getAudioHeader();
		return DateTimeTool.getDateFormatDateTimeTemplateThree(audioHeader.getTrackLength());
	}
}
