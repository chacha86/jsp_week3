package home;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import home.db.Article;
import home.db.ArticleMapper;

@WebServlet("/db")
public class DBServlet extends HttpServlet {
 
	ArticleMapper mapper = null;
	
    public DBServlet() {
    	String resource = "home/db/config.xml";
		InputStream inputStream;

		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession session = sqlSessionFactory.openSession();
			mapper = session.getMapper(ArticleMapper.class);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		ArrayList<Article> articles = mapper.selectArticleList();
		
		for( int i = 0; i < articles.size(); i++) {
			out.println("제목 : " + articles.get(i).getTitle());
			out.println("내용 : " + articles.get(i).getBody());
			out.println("<br>");
		}
		
	}

}
