/*
 * Project Name: SJBlog
 * Class Name: ValidateCodeServlet.java
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
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import top.sj.common.util.JCaptchaBusinessUtil;

/**
 * 用于生成验证码的Servlet
 * 
 * Create User: SteveJrong
 * Create Date: 2016年2月26日 下午6:28:29
 * Modify User: SteveJrong
 * Modify Date: 2016年2月26日 下午6:28:29
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class ValidateCodeServlet extends HttpServlet {
	private static final long serialVersionUID = -4379571661575540752L;

	public ValidateCodeServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		byte[] captChallengeAsJpeg = null;

		ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();

		String captchaId = request.getSession().getId();
		BufferedImage challenge = JCaptchaBusinessUtil.getService()
				.getImageChallengeForID(captchaId, request.getLocale());

		JPEGImageEncoder jpegEncoder = JPEGCodec
				.createJPEGEncoder(jpegOutputStream);
		jpegEncoder.encode(challenge);

		captChallengeAsJpeg = jpegOutputStream.toByteArray();

		response.setHeader("Cache-Control", "no-store");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");
		PrintWriter writer = response.getWriter();
		writer.write(Base64.encodeBase64String(captChallengeAsJpeg));
		writer.flush();
		writer.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	public void init() throws ServletException {
	}
}
