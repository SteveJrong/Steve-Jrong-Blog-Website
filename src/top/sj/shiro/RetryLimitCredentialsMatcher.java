/*
 * Project Name: SJBlog
 * Class Name: RetryLimitCredentialsMatcher.java
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
package top.sj.shiro;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 用于超时锁定账号的Shiro工具类【已弃用】
 * 
 * Create User: SteveJrong
 * Create Date: 2016年8月24日 下午5:05:58
 * Modify User: SteveJrong
 * Modify Date: 2016年8月24日 下午5:05:58
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class RetryLimitCredentialsMatcher extends HashedCredentialsMatcher {

	private Logger LOGGER = LoggerFactory
			.getLogger(RetryLimitCredentialsMatcher.class);

	private Cache<String, AtomicInteger> passwordRetryCache;

	public void RetryLimitHashedCredentialsMatcher(CacheManager cacheManager) {
		passwordRetryCache = cacheManager.getCache("passwordRetryCache");
	}

	@Override
	public boolean doCredentialsMatch(AuthenticationToken token,
			AuthenticationInfo info) {
		String username = (String) token.getPrincipal();
		AtomicInteger retryCount = passwordRetryCache.get(username);
		if (null == retryCount) {
			retryCount = new AtomicInteger(0);
			passwordRetryCache.put(username, retryCount);
		}
		if (retryCount.incrementAndGet() > 5) {
			LOGGER.warn("username: " + username
					+ " tried to login more than 5 times in period");
			throw new ExcessiveAttemptsException("username: " + username
					+ " tried to login more than 5 times in period");
		}
		boolean matches = super.doCredentialsMatch(token, info);
		if (matches) {
			passwordRetryCache.remove(username);
		}
		return matches;
	}
}
