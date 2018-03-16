/*
 * Project Name: SJBlog
 * Class Name: LuceneIndexesUtil.java
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
package top.sj.lucene;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Properties;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.SimpleFSDirectory;
import org.apache.lucene.util.Version;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import top.sj.common.util.Constants;
import top.sj.tool.PropertiesTool;

/**
 * 适用于Apache Lucene的索引工具类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年6月11日 下午2:31:14
 * Modify User: SteveJrong
 * Modify Date: 2016年6月11日 下午2:31:14
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class LuceneIndexesUtil {

	private static Logger LOGGER = LoggerFactory.getLogger(LuceneIndexesUtil.class);

	/**
	 * 建立文件索引的方法
	 * 
	 * @param propertiesAndValuesKV
	 *            要建立索引的列名称和列所对应的值得键值对参数
	 * @throws CorruptIndexException
	 * @throws IOException
	 */
	public static <T extends Serializable> void buildFileIndexes(
			String[][] params) throws CorruptIndexException, IOException {
		Properties prop = PropertiesTool
				.getPropertiesFileAsObject(Constants.CONFIG_OF_LUCENE_CONFIGURATIONS.getValue());

		// 索引文件的存放路径
		String indexDir = prop.getProperty("index_location");

		Directory dir = new SimpleFSDirectory(new File(indexDir));

		IndexWriter indexWriter = new IndexWriter(dir, new StandardAnalyzer(
				Version.LUCENE_30), true, IndexWriter.MaxFieldLength.LIMITED);

		for (int i = 0; i < params.length; i++) {
			Document doc = new Document();

			for (int j = 0; j < params[0].length; j += 2) {
				doc.add(new Field(params[i][j], params[i][j + 1].toString(),
						Field.Store.YES, Field.Index.ANALYZED));
			}

			indexWriter.addDocument(doc);
		}

		indexWriter.close();

		LOGGER.info("文档编号：" + indexWriter.numDocs());
		LOGGER.info("使用Lucene建立文件索引完毕！");
	}
}
