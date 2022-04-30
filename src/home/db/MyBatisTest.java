package home.db;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisTest {

	public static void main(String[] args) {
		
		String resource = "home/db/config.xml";
		InputStream inputStream;

		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

			// 1. SqlSession을 factory로부터 생성
			// SqlSession은 대부분의 JDBC 작업을 대신 처리해주는 객체.
			SqlSession session = sqlSessionFactory.openSession();
			
			// 2. 매퍼 -> sql을 처리해 줄 mapper 클래스를 선택.
			// 매퍼가 선택되면 매퍼의 내용은 MyBatis가 알아서 채워준다.
			ArticleMapper mapper = session.getMapper(ArticleMapper.class);
			
			// 3. MyBatis가 채워준 매퍼를 이용.
//			Article article = mapper.selectArticle(1);
			
			// 게시물 한개 가져오기
//			Article article = mapper.selectArticle(2);
//			
//			System.out.println(article.getTitle());
//			System.out.println(article.getBody());
//			
//			// 게시물 한개 삭제하기
//			mapper.deleteArticle(2);
//			session.commit(); // SqlSession은 기본적으로 autocommit이 꺼져있기 때문에 DB 반영 후 commit을 해야함.
//			
//			// 게시물 여러개 가져오기
			ArrayList<Article> articles = mapper.selectArticleList();
//			for(int i = 0; i < articles.size(); i++) {
//				System.out.println(articles.get(i).getTitle());
//				System.out.println(articles.get(i).getBody());
//				System.out.println("=======================");
//			}
			
			// 여러개의 파라미터를 보낼 때
			// 객체 또는 map을 이용해서 포장한다.
			
			//Article article = new Article(1, "제목6", "내용6", "1", "", 2);
			
			// key : value
			// age : 20
			// name : 홍길동
			// home : 서울
			
//			Map<String, Object> param = new HashMap<>();
//			
//			param.put("title", "제목8");
//			param.put("body", "내용8");
//			param.put("memberId", "1");			
//			
//			mapper.insertArticle(param);
//			session.commit();
			
			
			
			// 10번 게시물의 제목을 aaa, 내용을 bbb로 수정하는 메서드 만들기
			Map<String, Object> param = new HashMap<>();
			param.put("title", "안녕하세요~");
			param.put("body", "반갑습니다~");
			param.put("id", 12);
			
			mapper.updateArticle(param);
			session.commit();
			
			

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
