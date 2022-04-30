<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	int height = 6;

	for(int i = 1; i <= height; i++) {
		int space = height - i;
		for (int j = 0; j < space; j++) { %>
			&nbsp
			
		<% } %>
	<%  for (int j = 0; j < i ; j++) { %>
		*
	<% } %>
	<br>
<% } %>

</body>
</html>