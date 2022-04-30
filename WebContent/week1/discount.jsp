<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 	int age = 10;
	if (age < 20 || age >= 60) {  %>
	할인대상입니다.
	
<% } else { %>

	할인대상이 아닙니다.
	
<% } %>


</body>
</html>