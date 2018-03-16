/*
 * Project Name: SJBlog
 * Class Name: LuceneSearchUtil.java
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
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.BooleanClause.Occur;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.Formatter;
import org.apache.lucene.search.highlight.Fragmenter;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.InvalidTokenOffsetsException;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.search.highlight.SimpleSpanFragmenter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import top.sj.common.util.Constants;
import top.sj.dto.LuceneSearchDTO;
import top.sj.tool.PropertiesTool;
import top.sj.web.FullTextSearchAction;

/**
 * 适用于Apache Lucene的搜索工具类
 * 
 * Create User: SteveJrong
 * Create Date: 2016年6月11日 下午5:21:54
 * Modify User: SteveJrong
 * Modify Date: 2016年6月11日 下午5:21:54
 * Modify Remark: 
 * 
 * @author SteveJrong
 * @version 1.0
 */
public class LuceneSearchUtil {

	/**
	 * 最大结果集数量
	 */
	private static Integer MAX_SEARCH_RESULT = Integer.MAX_VALUE;

	/**
	 * 单域单条件查询的方法
	 * 
	 * @param primaryKeyByHibernateEntity Hibernate实体中主键对应的属性名称
	 * @param analysisTarget 分析目标，即要分析实体中的哪一列，此列会作为高亮显示的结果列进行分析并输出
	 * @param analysisCondition 分析参数，传入多个查询参数以供分析
	 * @param pageIndex 分页参数 当前第几条开始
	 * @param pageSize 分页参数 每页显示数据条数
	 * 
	 * @return 主键编号和分析的目标列所封装的实体集合
	 * @throws IOException
	 * @throws ParseException
	 * @throws InvalidTokenOffsetsException
	 */
	public static List<LuceneSearchDTO> searchOfSingleAreaAndSingleCondition(
			String primaryKeyByHibernateEntity, String analysisTarget,
			String analysisCondition,Integer pageIndex,Integer pageSize) throws IOException, ParseException,
	InvalidTokenOffsetsException {
		// Directory dir = FSDirectory.open(new File("D:\\lucene"));

		IndexSearcher searcher = new IndexSearcher(LuceneSearchUtil.initLuceneFile());

		QueryParser parser = new QueryParser(Version.LUCENE_30, analysisTarget,
				new StandardAnalyzer(Version.LUCENE_30));

		// 单条件查询
		Query query = parser.parse(analysisCondition);

		TopDocs topDocs = searcher.search(query, MAX_SEARCH_RESULT);

		//		for (int i = start; i < end; i++) {
		//			Document doc = searcher.doc(scoreDocs[i].doc);
		//			System.out.println(String.format(" -- 编号：%s，名称：%s -- ", doc.get("AId"),doc.get("ABriefcontents")));
		//		}

		/**
		 * 高亮显示
		 */
		QueryScorer queryScorer = new QueryScorer(query);
		Fragmenter fragmenter = new SimpleSpanFragmenter(queryScorer);
		Formatter formatter = new SimpleHTMLFormatter("<b>", "<b/>");
		Highlighter highlighter = new Highlighter(formatter, queryScorer);
		highlighter.setTextFragmenter(fragmenter);

		List<LuceneSearchDTO> analysisResults = new ArrayList<LuceneSearchDTO>();

		//数据开始位置
		int start = (pageIndex-1)*pageSize;

		//数据结束位置
		int end = pageIndex*pageSize;
		
		//当前数据的结束位置
		int currentEnd = 0;
		
		if (end % 8 != 0) {
			currentEnd = end % 8;
		}else {
			//如果数据总数小于8，则设置currentEnd的值为数据总数的值
			if (topDocs.scoreDocs.length < 8) {
				currentEnd = topDocs.scoreDocs.length;
				
				//如果end等于8，则设置currentEnd为8
			}else if(end == 8){
				currentEnd = 8;
			
			//如果end的值大于数据总数，则设置currentEnd的值为数据总数的值
			}else if (end > topDocs.scoreDocs.length) {
				currentEnd = topDocs.scoreDocs.length;
				
			//如果end的值小于等于数据总数，则设置currentEnd的值为end的值
			}else if (end <= topDocs.scoreDocs.length) {
				currentEnd = end;
			}
		}
		
		for (int i = start; i < currentEnd; i++) {
			int docId = topDocs.scoreDocs[i].doc;
			Document doc = searcher.doc(docId);
			String attr = highlighter.getBestFragment(new StandardAnalyzer(Version.LUCENE_30),analysisTarget, doc.get(analysisTarget));
			analysisResults.add(new LuceneSearchDTO(Integer.valueOf(doc.get(primaryKeyByHibernateEntity)), attr));
		}
		return analysisResults;
	}

	/**
	 * 单域多条件查询的方法
	 * 
	 * @param primaryKeyByHibernateEntity Hibernate实体中主键对应的属性名称
	 * @param analysisTarget 分析目标，即要分析实体中的哪一列，此列会作为高亮显示的结果列进行分析并输出
	 * @param pageIndex 分页参数 当前第几条开始
	 * @param pageSize 分页参数 每页显示数据条数
	 * @param analysisConditions 分析参数，传入多个查询参数以供分析。首个参数权重最高，第二个和以后的参数权重都依次递减
	 * @return 主键编号和分析的目标列所封装的实体集合
	 * 
	 * @throws IOException
	 * @throws ParseException
	 * @throws InvalidTokenOffsetsException
	 */
	@SuppressWarnings("resource")
	public static List<LuceneSearchDTO> searchOfSingleAreaAndMultiCondition(
			String primaryKeyByHibernateEntity, String analysisTarget,
			Integer pageIndex,Integer pageSize,
			String... analysisConditions) throws IOException, ParseException,
	InvalidTokenOffsetsException {
		IndexSearcher searcher = new IndexSearcher(LuceneSearchUtil.initLuceneFile());

		QueryParser parser = new QueryParser(Version.LUCENE_30, analysisTarget,
				new StandardAnalyzer(Version.LUCENE_30));

		BooleanQuery query = new BooleanQuery();

		for (int i = 0; i < analysisConditions.length; i++) {
			Query query1 = parser.parse(analysisConditions[i]);
			query.add(query1, i == 0 ? Occur.MUST : Occur.SHOULD);
		}
		TopDocs topDocs = searcher.search(query, MAX_SEARCH_RESULT);

		/**
		 * 高亮显示
		 */
		QueryScorer queryScorer = new QueryScorer(query);
		Fragmenter fragmenter = new SimpleSpanFragmenter(queryScorer);
		Formatter formatter = new SimpleHTMLFormatter("<b>", "<b/>");
		Highlighter highlighter = new Highlighter(formatter, queryScorer);
		highlighter.setTextFragmenter(fragmenter);

		List<LuceneSearchDTO> analysisResults = new ArrayList<LuceneSearchDTO>();

		//数据开始位置
		int start = (pageIndex-1)*pageSize;

		//数据结束位置
		int end = pageIndex*pageSize;
				
		for (int i = start; i < end; i++) {
			int docId = topDocs.scoreDocs[i].doc;
			Document doc = searcher.doc(docId);
			String attr = highlighter
					.getBestFragment(new StandardAnalyzer(Version.LUCENE_30),
							analysisTarget, doc.get(analysisTarget));
			analysisResults.add(new LuceneSearchDTO(Integer.valueOf(doc
					.get(primaryKeyByHibernateEntity)), attr));
		}
		return analysisResults;
	}
	
	/**
	 * 获取搜索结果总数据条数的方法
	 * 
	 * @param type 类型：true表示为多条件搜索，false表示为单条件搜索
	 * @param analysisTarget 分析目标，即要分析实体中的哪一列，此列会作为高亮显示的结果列进行分析并输出
	 * @param analysisConditions 分析参数，传入多个查询参数以供分析。首个参数权重最高，第二个和以后的参数权重都依次递减
	 * @return 总数据条数
	 * 
	 * @throws CorruptIndexException
	 * @throws IOException
	 * @throws ParseException
	 */
	@SuppressWarnings("resource")
	public static Integer searchTotalSize(Boolean type, String analysisTarget, String... analysisConditions) throws CorruptIndexException, IOException, ParseException {
		
		Integer totalSize = 0;
		
		if (type == Boolean.TRUE) {
			//多条件搜索
			IndexSearcher searcher = new IndexSearcher(LuceneSearchUtil.initLuceneFile());

			QueryParser parser = new QueryParser(Version.LUCENE_30, analysisTarget,
					new StandardAnalyzer(Version.LUCENE_30));

			BooleanQuery query = new BooleanQuery();

			for (int i = 0; i < analysisConditions.length; i++) {
				Query query1 = parser.parse(analysisConditions[i]);
				query.add(query1, i == 0 ? Occur.MUST : Occur.SHOULD);
			}
			TopDocs topDocs = searcher.search(query, MAX_SEARCH_RESULT);
			
			totalSize = topDocs.scoreDocs.length;
		}else {
			//单条件搜索
			IndexSearcher searcher = new IndexSearcher(LuceneSearchUtil.initLuceneFile());

			QueryParser parser = new QueryParser(Version.LUCENE_30, analysisTarget, new StandardAnalyzer(Version.LUCENE_30));

			// 单条件查询
			Query query = parser.parse(analysisConditions[0]);

			TopDocs topDocs = searcher.search(query, MAX_SEARCH_RESULT);
			
			totalSize = topDocs.scoreDocs.length;
		}
		
		return totalSize;
	}
	
	/**
	 * 初始化Lucene文件的方法
	 * @return Directory目录对象
	 */
	public static Directory initLuceneFile() {
		String configPath = PropertiesTool.getPropertiesFileAsObject(Constants.CONFIG_OF_LUCENE_CONFIGURATIONS.getValue()).getProperty("index_location");
		Directory dir = null;
		try {
			dir = FSDirectory.open(new File(configPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dir;
	}
}
