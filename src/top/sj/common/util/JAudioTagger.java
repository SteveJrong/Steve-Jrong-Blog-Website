/*
 * Project Name: SJBlog
 * Class Name: JAudioTagger.java
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

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.jaudiotagger.audio.AudioFile;

/**
 * JAudioTagger抽象类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年12月9日 上午10:19:56
 * Modify User: SteveJrong
 * Modify Date: 2016年12月9日 上午10:19:56
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public abstract class JAudioTagger {
	/**
	 * 根据音频文件对象返回音频文件专辑封面的方法【抽象方法】
	 * @param audioFile
	 * @param musicFile
	 * @return
	 * @throws IOException 
	 */
	public abstract StringBuffer getBase64CoverByMusicFile(AudioFile audioFile,File musicFile) throws IOException;
	
	/**
	 * 根据音频文件对象返回音乐名称的方法【抽象方法】
	 * @param audioFile
	 * @param musicFile
	 * @return
	 */
	public abstract String getTitleByMusicFile(AudioFile audioFile,File musicFile);
	
	/**
	 * 根据音频文件对象返回艺术家名称的方法【抽象方法】
	 * @param audioFile
	 * @param musicFile
	 * @return
	 */
	public abstract String getArtistByMusicFile(AudioFile audioFile,File musicFile);
	
	/**
	 * 根据音频文件对象返回音频文件持续时间的方法【抽象方法】
	 * @param audioFile
	 * @param musicFile
	 * @return
	 */
	public abstract Date getDurationByMusicFile(AudioFile audioFile,File musicFile);
}
