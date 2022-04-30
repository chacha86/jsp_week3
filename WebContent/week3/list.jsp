<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="home.db.ArticleMapper" %>
<%@ page import="java.io.InputStream" %>
<%@ page import="org.apache.ibatis.io.Resources" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactory" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactoryBuilder" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="home.db.Article" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

	ArticleMapper mapper = null;

	String resource = "home/db/config.xml";
	InputStream inputStream;
	
	try {
		inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		mapper = sqlSession.getMapper(ArticleMapper.class);
		
	} catch(Exception e) {
		e.printStackTrace();
	}
	
	ArrayList<Article> articles = mapper.selectArticleList();
	
%>
 
<% for(int i = 0; i < articles.size(); i++) { %>
	제목 : <% out.println(articles.get(i).getTitle()); %>
	내용 : <% out.println(articles.get(i).getBody()); %>
	<br>
<% } %>
</body>
</html>