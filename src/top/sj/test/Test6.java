package top.sj.test;

import java.io.IOException;
import java.util.List;

import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.search.highlight.InvalidTokenOffsetsException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import top.sj.dto.LuceneSearchDTO;
import top.sj.entity.SjArticles;
import top.sj.lucene.LuceneIndexesUtil;
import top.sj.lucene.LuceneSearchUtil;
import top.sj.service.ArticlesService;

/**
 * Lucene测试
 * 
 * 项目名称：SJBlog 类名称：Test6.java 类描述：TODO 创建人：Steve Jrong 创建时间：2016-6-12 上午10:14:55
 * 修改人：Steve Jrong 修改时间：2016-6-12 上午10:14:55 修改备注：
 * 
 * @version 1.0 Beta
 */
public class Test6 {
	public static void main(String[] args) throws CorruptIndexException,
			IOException, ParseException, InvalidTokenOffsetsException {
		// new Test6().build();
//		new Test6().search();
	}

	public void build() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		ArticlesService service = (ArticlesService) context
				.getBean("articlesService");
		List<SjArticles> articles = service
				.getArticlesBriefInfoOfTopFiveService();

		String[][] datas = new String[articles.size()][8];

		for (int i = 0; i < articles.size(); i++) {
			datas[i][0] = "AId";
			datas[i][1] = articles.get(i).getAId().toString();
			datas[i][2] = "ABriefcontents";
			datas[i][3] = articles.get(i).getABriefcontents().toString();
			datas[i][4] = "ABodycontents";
			datas[i][5] = articles.get(i).getABodycontents().toString();
			datas[i][6] = "AName";
			datas[i][7] = articles.get(i).getAName().toString();
		}

		try {
			LuceneIndexesUtil.buildFileIndexes(datas);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		System.out.println("索引建立成功！");
	}

//	public void search() throws IOException, ParseException,
//			InvalidTokenOffsetsException {
//		/**
//		 * 单域单条件查询
//		 */
//		System.out
//				.println("************************ 单域单条件查询 ************************");
//		List<LuceneSearchDTO> resultMap = LuceneSearchUtil
//				.searchOfSingleAreaAndSingleCondition("AId", "AName", "Java");
//		for (LuceneSearchDTO luceneSearchDTO : resultMap) {
//			System.out.println(luceneSearchDTO.getIdentity() + "\t"
//					+ luceneSearchDTO.getAnalysisTarget());
//		}
//
//		System.out.println();
//
//		/**
//		 * 单域多条件查询
//		 */
//		System.out
//				.println("************************ 单域多条件查询 ************************");
//		List<LuceneSearchDTO> resultMaps = LuceneSearchUtil
//				.searchOfSingleAreaAndMultiCondition("AId", "ABriefcontents",
//						"框架", "复习");
//		for (LuceneSearchDTO luceneSearchDTO : resultMaps) {
//			System.out.println(luceneSearchDTO.getIdentity() + "\t"
//					+ luceneSearchDTO.getAnalysisTarget());
//		}
//	}
}