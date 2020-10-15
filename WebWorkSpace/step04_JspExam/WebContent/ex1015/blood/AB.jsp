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
String name = request.getParameter("name");
%>

<h3>이름은 <%=name %></h3>
<h3>AB형의 성격은 ab합니다</h3>
</body>
</html>